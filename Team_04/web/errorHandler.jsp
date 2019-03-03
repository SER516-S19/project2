<%--
  Created by IntelliJ IDEA.
  User: ankita
  Date: 2/23/2019
  Time: 12:29 AM
  View for errors
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <style>
        body{
            background: #8C1D40
        ;
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
        errorMessage = "Bad Request... Retry Again...!";
    }
    if(request.getAttribute("errorResponse").toString().equalsIgnoreCase("loginFailed")) {
        errorMessage = "Login Failed  ...Retry Again...!";
    }


%>
<h1 class="errMsg"><%=errorMessage%></h1>
</body>
</html>
