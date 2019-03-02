<%--
  Created by IntelliJ IDEA.
  Modified By: Archana Madhavan
  Date: 18/2/19
  Time: 1:53 PM
  Description: Displays List of Quizzes.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List"%>
<html>
<head>
    <title>view-list</title>
    <style>
        h1{
            padding: 100px 600px 20px;
            color: white;
            font-family: Arial, sans-serif;
            font-size: 32px;
        }
        h2{
            color: cyan;
            font-family: Arial, sans-serif;
        }
        body{
            background-color: #191970;
            border-style: outset;
            border-width: medium;
            border-radius: 10px;
            border-color: cyan;
        }
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 40%;
        }
        td, th {
            border: 1px solid cyan;
            text-align: center;
            padding: 8px;
            color: white;
        }
        tr:nth-child(even) {
            background-color: lightblue;
        }
    </style>
</head>
<body>
<h1>
    View Quiz List
</h1>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2 text-color:cyan>Quiz List</h2></caption>
        <tr>
            <th>Quiz ID</th>
        </tr>
        <tr>
            <td>
                <c:forEach items="${ids}" var="quizId">
                    <a href="./viewContentDetails?quizId=${quizId}">Quiz<c:out value="${quizId}"></c:out></a><br>
                </c:forEach>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
