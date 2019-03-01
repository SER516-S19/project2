<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="com.google.gson.*" %>
<%@page import="controller.FusionCharts" %>
<%@page import="java.sql.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creating Charts with Data from a Database - fusioncharts.com</title>

        <script type="text/javascript" src="//cdn.fusioncharts.com/fusioncharts/latest/fusioncharts.js"></script>
    </head>
    <body>
         <div id="chart">
         </div>
         
<%
   String hostName = "showtimefinder.database.windows.net";              // MySQl host
   String user = "scrum_mates@showtimefinder";                      // MySQL username
   String password = "Azure@Cloud";                          // MySQL password
   String dbName = "ser516_db";      // MySQL database name

    // Establish a connection to the database
    //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
            + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        
    Connection con = null;
	con = DriverManager.getConnection(url);
    
            Gson gson = new Gson();


            // Form the SQL query that returns the top 10 most populous countries
            String sql="SELECT top 10 userId, score FROM dbo.StudentResponse ORDER BY score DESC";

            // Execute the query
            PreparedStatement pt=con.prepareStatement(sql);
            ResultSet rs=pt.executeQuery();

            // The 'chartobj' map object holds the chart attributes and data.
            Map<String, String> chartobj = new HashMap<String, String>();

            chartobj.put("caption", "Top 10 student scores");
            chartobj.put("showValues", "0");
            chartobj.put("theme", "zune");

            // Push the data into the array using map object.
            ArrayList arrData = new ArrayList();
            while(rs.next()) {
                Map<String, Integer> lv = new HashMap<String, Integer>();
                lv.put("label", rs.getInt("userId"));
                lv.put("value", rs.getInt("score"));
                arrData.add(lv);
            }

            //close the connection.
            rs.close();

            //create 'dataMap' map object to make a complete FC datasource.
             Map<String, String> dataMap = new LinkedHashMap<String, String>();
        /*
            gson.toJson() the data to retrieve the string containing the
            JSON representation of the data in the array.
        */
             dataMap.put("chart", gson.toJson(chartobj));
             dataMap.put("data", gson.toJson(arrData));

            FusionCharts columnChart= new FusionCharts(
                        //type of chart
                        "column2d",
                        //unique chart ID
                        "chart1",
                        //width and height of the chart
                        "700","400",
                        //div ID of the chart container
                        "chart",
                        //data format
                        "json",
                        //data source
                        gson.toJson(dataMap)
                    );

%>

<!--    Step 5: Render the chart    -->
            <%=columnChart.render()%>
    </body>
</html>