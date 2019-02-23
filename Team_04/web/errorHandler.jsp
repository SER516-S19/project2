<%--
  Created by IntelliJ IDEA.
  User: ankita
  Date: 2/23/2019
  Time: 12:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <style>
        body{
            background: #4a154b;
        }
        .errMsg
        {
            text-align: center;
            color:white;
            margin-top:5%;
        }
    </style>
</head>
<body>
<%
    String errorMessage = "";
    if(request.getAttribute("errorResponse").toString().equalsIgnoreCase("400")) {
        errorMessage = "BAD REQUEST ...RETRY AGAIN.!";
    }
%>
<h1 class="errMsg"><%=errorMessage%></h1>
</body>
</html>
