<%--
  Created by IntelliJ IDEA.
  User: saksh
  Date: 3/1/2019
  Time: 5:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List"%>
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
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Quiz List</h2></caption>
        <tr>
            <th>Quiz ID</th>
        </tr>
        <tr>
            <td>
                <c:forEach items="${studentIds}" var="studentId">
                    <a href="viewContentDetails.jsp?quizId=${studentId}">Quiz<c:out value="${studentId}"></c:out></a><br>
                </c:forEach>
            </td>
        </tr>
    </table>
</div>
<%--<table>
  <tr><th>Quizzes</th></tr>
  <tr><th><a href="./viewContentDetails.jsp">Quiz #1</a></th></tr>
  <tr><th><a href="./viewContentDetails.jsp">Quiz #2</a></th></tr>
  <tr><th><a href="./viewContentDetails.jsp">Quiz #3</a></th></tr>
  <tr><th><a href="./viewContentDetails.jsp">Quiz #4</a></th></tr>
  <tr><th><a href="./viewContentDetails.jsp">Quiz #5</a></th></tr>
</table>--%>
</body>
</html>
