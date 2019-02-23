<%--
  Created by IntelliJ IDEA.
  User: amankaushik
  Date: 18/2/19
  Time: 1:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>view-list</title>
    <style>
      table {
        font-family: arial, sans-serif;
        border-collapse: collapse;
        width: 40%;
      }
      
      td, th {
        border: 1px solid #dddddd;
        text-align: left;
        padding: 8px;
      }
      
      tr:nth-child(even) {
        background-color: #dddddd;
      }
      </style>
</head>
<body>
<h1>
    View Quiz List
</h1>
<table>
  <tr><th>Quizzes</th></tr>
  <tr><th><a href="./viewContentDetails.jsp">Quiz #1</a></th></tr>
  <tr><th><a href="./viewContentDetails.jsp">Quiz #2</a></th></tr>
  <tr><th><a href="./viewContentDetails.jsp">Quiz #3</a></th></tr>
  <tr><th><a href="./viewContentDetails.jsp">Quiz #4</a></th></tr>
  <tr><th><a href="./viewContentDetails.jsp">Quiz #5</a></th></tr>
</table>
</body>
</html>
