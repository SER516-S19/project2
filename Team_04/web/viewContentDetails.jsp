<%--
  Created by IntelliJ IDEA.
  User: amankaushik
  Date: 18/2/19
  Time: 2:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="content.creator.dao.QuizContentDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>view-details</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
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
<h2> <%="Quiz"%></h2>
<table>
    <tr>
        <th>Question Number</th>
        <th>Questions</th>
        <th>Options</th>
        <th>Score</th>
    </tr>

    <%
        Map<Integer, List<String>> answers= (Map<Integer, List<String>>) request.getAttribute("answers");
        List<QuizContentDAO> questionList=(ArrayList<QuizContentDAO>)request.getAttribute("questions");
        int count = 0;
        Boolean flag;
        for(QuizContentDAO question:questionList){
            flag = true ? count % answers.size() == 0 : false;
    %>
    <tr>

        <td><%=question.getQuesId()%></td>
        <td><%=question.getQuesDesc()%></td>
        <td><%=question.getMaxScore()%></td></tr>
        <tr>



    </tr>
    <%
            count++;

        }%>
</table>
</body>
</html>
