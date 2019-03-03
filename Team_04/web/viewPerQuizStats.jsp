<%--
  Created by IntelliJ IDEA.
  User: amankaushik
  Date: 1/3/19
  Time: 10:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Quiz Level Statistics</title>
    <style>
        h1   {
            color: midnightblue;}
        body {background-color: lightgrey;}
        .element-center {
            align: center;
            margin: 0;
            padding: 0;
            border: 0;
            font-size: 100%;
            vertical-align: baseline;
            position: absolute;
            top: 20%;
            left: 50%;
            transform: translateX(-50%) translateY(-50%);
        }
        tr:nth-child(even) {background-color: #f2f2f2;}
        tr:nth-child(odd) {background-color: lavender;}
    </style>
</head>
<body>
    <%
        float classAvg = (float) request.getAttribute("classavg");
        int studentStrength = (int) request.getAttribute("studentStrength");
        float highestScore = (float) request.getAttribute("highestScore");
        int quizId = (int) request.getAttribute("quizId");
        %>

    <div class="element-center">
    <h1> STATISTICS FOR QUIZ <span><%=quizId%></span></h1>
    <table>
        <tr>
            <td>Average Score For Quiz is :</td>
            <td><span><%=classAvg%></span></td>
        </tr>
        <tr>
            <td> Strength of Quiz is : </td>
            <td><%=studentStrength%></td>
        </tr>
        <tr>
            <td>Highest Score of Quiz is :</td>
            <td><%=highestScore%></td>
        </tr>
    </table>
    </div>
</body>
</html>
