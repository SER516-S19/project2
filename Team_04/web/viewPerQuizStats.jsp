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
</head>
<body>
    <%
        float classAvg = (float) request.getAttribute("classavg");
        int studentStrength = (int) request.getAttribute("studentStrength");
        float highestScore = (float) request.getAttribute("highestScore");
        %>
    <h3> Average Score For Quiz is : </h3> <h4><span><%=classAvg%></span></h4>
    <h3> Strength of Quiz is : </h3> <h4><span><%=studentStrength%></span></h4>
    <h3> Highest Score of Quiz is : </h3> <h4><span><%=highestScore%></span></h4>
</body>
</html>
