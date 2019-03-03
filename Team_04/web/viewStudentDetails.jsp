<%@ page import="java.util.List" %>
<%@ page import="content.creator.dao.QuizResultDAO" %><%--
  User: sakshi
  Date: 3/1/2019
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2> <%="Student Details"%></h2>

<table>
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
        <td>Total No of Quizzes</td>
        <td>${totalQuizzes}</td>
        <td>TotalScore ${score}</td>
    </tr>
</table>
<a href="./studentList">Back</a>
</body>
</html>
