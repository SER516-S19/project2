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
        .panel {
            align: center;
            margin-right: -15px;
            margin-left: -15px;
            margin: 0;
            padding: 0;
            border: 0;
            font-size: 100%;
            vertical-align: baseline;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translateX(-50%) translateY(-50%);
        }

        table {
            font-family: CircularPro, "Helvetica Neue", Helvetica, "Segoe UI", Tahoma, Arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
            background-color: dimgrey;
            color: whitesmoke;
            vertical-align: baseline;
        }
        tr:nth-child(even) {
            background-color: #8a154b;
            color: white;
        }
        td {
            text-align: left;
            padding: 1%;
        }
        th {
            text-align: center;
            padding: 8px;
        }
        .wrapper {
            align-items: center;
            justify-content: center;
            display: flex;
            align: center;
            font-size: 100%;
            vertical-align: baseline;
        }
        .inTable {
            align-items: center;
            justify-content: center;
            padding-top: 10px;
        }
        body {
            background-color: #4a154b;
        }

        h1 {
            text-align: center;
            color: white;
            font-size: 64px;
            padding-left: 20px;
            font-family: CircularPro, "Helvetica Neue", Helvetica, "Segoe UI", Tahoma, Arial, sans-serif;
        }
        h3 {
            text-align: center;
            color: white;
            font-size: 36px;
            padding-top: 20px;
            font-family: CircularPro, "Helvetica Neue", Helvetica, "Segoe UI", Tahoma, Arial, sans-serif;
        }
    </style>
</head>
<body>
    <%
        float classAvg = (float) request.getAttribute("classavg");
        int studentStrength = (int) request.getAttribute("studentStrength");
        float highestScore = (float) request.getAttribute("highestScore");
        int quizId = (int) request.getAttribute("quizId");
        %>

    <div class="panel">
        <h1> STATISTICS FOR QUIZ <span><%=quizId%></span></h1>
        <div class="wrapper">
            <table class="inTable">
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
    </div>
</body>
</html>
