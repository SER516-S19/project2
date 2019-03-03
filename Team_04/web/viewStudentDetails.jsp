<%@ page import="java.util.List" %>
<%@ page import="content.creator.dao.QuizResultDAO" %><%--
  User: sakshi
  Date: 3/1/2019
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        h1{
            padding: 100px 600px 20px;
            color: white;
            font-family: Arial, sans-serif;
            font-size: 32px;
        }
        h2{
            text-align: center;
            color: cyan;
            font-family: Arial, sans-serif;
        }
        body{
            background-color: #4a154b;
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
<h2> <%="Student Details"%></h2>

<table align="center">
    <tr>
        <th>Quiz ID</th>
        <th>Attempt ID</th>
        <th>Score</th>
    </tr>

    <%
        List<QuizResultDAO> studentDataList = (List<QuizResultDAO> )request.getAttribute("studentDetails");

        int studentid = (int) request.getAttribute("studentid");

        for (QuizResultDAO studentResponse: studentDataList) {


    %>
    <tr>

        <td><%=studentResponse.getQuizId()%></td>
        <td><%=studentResponse.getAttemptId()%></td>
        <td><%=studentResponse.getFinalScore()%></td></tr>



    <%

        }
    %>
    <tr>
        <td>Total No of Quizzes: ${totalQuizzes}</td>
        <td></td>
        <td>TotalScore: ${score}</td>
    </tr>
</table>
<a href="./studentList">Back</a>
</body>
</html>
