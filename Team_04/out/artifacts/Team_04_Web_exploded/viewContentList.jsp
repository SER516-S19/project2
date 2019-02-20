<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII"%>

<%--
  Created by IntelliJ IDEA.
  User: amankaushik,ArchanaMadhavan
  Date: 20/2/19
  Time: 1:53 PM
  To change this template use File | Settings | File Templates.
--%>

<html>
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
            <th>Quiz ID</th>
        </tr>
        <tr>
            <td>
                <c:forEach items="${ids}" var="quizId">
                    Quiz <c:out value="${quizId}"></c:out><br>
                </c:forEach>
            </td>
        </tr>
    </table>
</div>
</body>
</html>