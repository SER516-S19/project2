<%--
  Created by IntelliJ IDEA.
  Modified by: Archana Madhavan
  Date: 28/2/19
  Description: Displays the quiz details for quiz selected.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<html>
<head>
    <title>Quiz details</title>
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

    </style>
</head>
<body>
<a href="./list">Back</a>
<h2> <%="Quiz Details"%></h2>

<table>
    <tr>
        <th>Question Number</th>
        <th>Questions</th>
        <th>Score</th>
    </tr>

    <%
        Map<Integer, List<String>> answers= (Map<Integer, List<String>>) request.getAttribute("answers");
        Map<Integer, Map<String, String>> questionList=(HashMap)request.getAttribute("questions");

        for(Integer quesId:questionList.keySet()){
    %>
    <tr>
        <td><%=quesId%></td>
        <td><%=questionList.get(quesId).get("desc")%></td>
        <td><%=questionList.get(quesId).get("score")%></td>
    </tr>


    <tr>
        <%
            for(String answer: answers.get(quesId)) {
        %>
        <td></td>
        <td>
            <ul>
                <li><%=answer%></li>
            </ul>
        </td>
        <td></td>
    </tr>

      <%
      }
    }
    %>
</table>

<form action="delete" method="POST">
    <input type="hidden" id="quizId" value="${quizId}">
    <input type="submit" value="Delete">
</form>

</body>
</html>
