<%--
  Created by IntelliJ IDEA.
  User: 14807
  Date: 2/23/2019
  Time: 12:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<%
    String errorMessage = "";
    if(request.getAttribute("errorResponse").toString().equalsIgnoreCase("400")) {
        errorMessage = "BAD REQUEST ...RETRY AGAIN.!";
    }
%>
<h2><%=errorMessage%></h2>
</body>
</html>
