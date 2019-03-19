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
 @authour Shivam Verma
 @version 1.2
 @date 02/28/2019
--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creating Charts with Data from a Database - fusioncharts.com</title>
        <script type="text/javascript" src="//cdn.fusioncharts.com/fusioncharts/latest/fusioncharts.js"></script>
        <script type="text/javascript" src="//cdn.fusioncharts.com/fusioncharts/latest/themes/fusioncharts.theme.zune.js"></script>
    </head>
    <body>
    <div id = "chartC1"></div>
    <div id = "chartC2"></div>
    <div id = "chartC3"></div>
    <div id = "chartC4"></div>
         
<%     
    /**
      Establish Connection with Database  
    */
    Connection conn1 = null;    
    conn1 = ConnectionFactory.getConnection();
    
    Gson gson = new Gson();
    
    ResourceBundle resource = ResourceBundle.getBundle("database");
    
    int courseId = (int) session.getAttribute("courseId");
    
    
    	
    PreparedStatement preparedStatement1 = conn1.prepareStatement(resource.getString("getStatsForTopTenStudents"));
	preparedStatement1.setInt(1, courseId);
    
    ResultSet rs1 = preparedStatement1.executeQuery();
    
    // The 'chartobj' map object holds the chart attributes and data.
    Map<String, String> chartobj1 = new HashMap<String, String>();

    chartobj1.put("caption", "Top 10 student scores");
    chartobj1.put("showValues", "0");
    chartobj1.put("theme", "zune");
    chartobj1.put("xAxisName", "Students");
    chartobj1.put("yAxisName", "Scores");

    // Push the data into the array using map object.
    ArrayList arrData1 = new ArrayList();
    while(rs1.next()) {
        Map<String, String> hashMap1 = new HashMap<String, String>();
        hashMap1.put("label", rs1.getString("username"));
        hashMap1.put("value", String.valueOf(rs1.getInt("score")));
        arrData1.add(hashMap1);
    }

    //close the connection.
    rs1.close();
    preparedStatement1.close();
    conn1.close();

    //create 'dataMap' map object to make a complete FC datasource.
     Map<String, String> dataMap1 = new LinkedHashMap<String, String>();
    /*
        gson.toJson() the data to retrieve the string containing the
        JSON representation of the data in the array.
    */
     dataMap1.put("chart", gson.toJson(chartobj1));
     dataMap1.put("data", gson.toJson(arrData1));

    FusionCharts columnChart1= new FusionCharts(
                //type of chart
                "column2d",
                //unique chart ID
                "chart1",
                //width and height of the chart
                "800","400",
                //div ID of the chart container
                "chartC1",
                //data format
                "json",
                //data source
                gson.toJson(dataMap1)
            );
            
    
    Connection conn2 = null;    
    conn2 = ConnectionFactory.getConnection();
    
    // Execute the query
    PreparedStatement preparedStatement2 = conn2.prepareStatement(resource.getString("getAverageMarksInQuiz"));
	preparedStatement2.setInt(1, courseId);
   
 	ResultSet rs2 = preparedStatement2.executeQuery();

 	Map<String, String> chartobj2 = new HashMap<String, String>();

    chartobj2.put("caption", "Average Score in Quiz");
    chartobj2.put("showValues", "0");
    chartobj2.put("theme", "zune");
    chartobj2.put("xAxisName", "Quiz");
    chartobj2.put("yAxisName", "Scores");
 	
 	ArrayList arrData2 = new ArrayList();
 	
 	while(rs2.next()) {
        Map<String, String> hashMap2 = new HashMap<String, String>();
        	hashMap2.put("label", rs2.getString("quizTitle"));
        	hashMap2.put("value", String.valueOf(rs2.getInt("avgScore")));
        	arrData2.add(hashMap2);
    }
    
    Map<String, String> dataMap2 = new LinkedHashMap<String, String>();
    /*
        gson.toJson() the data to retrieve the string containing the
        JSON representation of the data in the array.
    */
     dataMap2.put("chart", gson.toJson(chartobj2));
     dataMap2.put("data", gson.toJson(arrData2));

    FusionCharts columnChart2= new FusionCharts(
                //type of chart
                "column2d",
                //unique chart ID
                "chart2",
                //width and height of the chart
                "800","400",
                //div ID of the chart container
                "chartC2",
                //data format
                "json",
                //data source
                gson.toJson(dataMap2)
            );
            
       rs2.close();
       preparedStatement2.close();
       conn2.close();
%>

<!--    Step 5: Render the chart    -->
<%=columnChart1.render()%>
            
<%=columnChart2.render()%>
       
    </body>
</html>