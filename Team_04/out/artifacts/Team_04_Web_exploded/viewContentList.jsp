<%@ page import="content.creator.ContentList" %><%--
  Created by IntelliJ IDEA.
  User: amankaushik
  Date: 18/2/19
  Time: 1:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%

    ContentList contents = (ContentList)request.getAttribute("question");
%>
<head>

    <title>view-list</title>
</head>
<body>
<h1>
    View Quiz List
</h1>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Quiz List</h2></caption>
        <tr>
            <th>Question Number</th>
            <th>Question type</th>
            <th>Question Description</th>
            <th>Answer Choices</th>
            <th>Correct Answer</th>
        </tr>

            <tr>
                <td><%=contents.getQuestion_id()%></td>
                <td><%=contents.getQuestion_type()%></td>
                <td><%=contents.getQuestion_description()%></td>
                <td><%=contents.getAns_description()%>/></td>
                <td><%=contents.isCorrect()%></td>
            </tr>

    </table>
</div>
</body>
</html>
