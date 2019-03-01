<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="com.google.gson.*" %>
<%@page import="controller.FusionCharts" %>
<%@page import="java.sql.*" %>
<%@page import="java.sql.Connection" %>
<%@ page import="model.ConnectionFactory" %>
<%@ page import="java.util.Properties" %>
<%@ page import = "java.util.ResourceBundle" %>

<%-- 
This file is for rendering the statistics graphs 
 
 @author narenkumarkonchada
 @author Aditya Vikram
 @version 1.1
 @date 02/28/2019
--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creating Charts with Data from a Database - fusioncharts.com</title>

        <script type="text/javascript" src="//cdn.fusioncharts.com/fusioncharts/latest/fusioncharts.js"></script>
    </head>
    <body">
         <div id="chart">
         </div>
         
<%     
    /**
      Establish Connection with Database  
    */
    Connection connection = null;    
    connection = ConnectionFactory.getConnection();
    
    Gson gson = new Gson();
     ResourceBundle resource = ResourceBundle.getBundle("database");

    // Form the SQL query that returns the top 10 most populous countries
    String sql=resource.getString("getStatsForTopTenStudents");

    // Execute the query
    PreparedStatement pt=connection.prepareStatement(sql);
    ResultSet rs=pt.executeQuery();

    // The 'chartobj' map object holds the chart attributes and data.
    Map<String, String> chartobj = new HashMap<String, String>();

    chartobj.put("caption", "Top 10 student scores");
    chartobj.put("showValues", "0");
    chartobj.put("theme", "fusion");
    chartobj.put("xAxisName", "Students");
    chartobj.put("yAxisName", "Scores");

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
                "800","400",
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