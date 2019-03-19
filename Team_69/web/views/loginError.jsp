<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type='text/css' rel='stylesheet' href='../css/Login.css' />
    <%@ include file = "/header.jsp" %>
    <title>Login Error</title>
</head>
<body>
<p align="center">
    <h3 style="color:blue;text-align:center">Please verify your email address and password</h3>
        <form method="GET">
            <% String pathWebContent = request.getContextPath();%>
            <input class="button" type="submit" name="action" value="Login" formaction="<%=pathWebContent%>/Login" />
        </form>
</p>
</body>
</html>
