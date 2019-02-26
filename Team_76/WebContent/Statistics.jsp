<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Statistics</title>
</head>
<body>
	<%
        String uName = (String) session.getAttribute("uName");
        String isSessionValid = (String) session.getAttribute("validSession");
        if (isSessionValid == null || isSessionValid.isEmpty() || !isSessionValid.equalsIgnoreCase("True")
                || uName == null || uName.isEmpty()) {
            response.sendRedirect("Login.jsp");
        }
    %>
    <div style="float: right">
        <form align="right" action="LoginController" method="post">
            <input type="hidden" name="action" value="logoff"> <input
                type="submit" value="LogOut" class="logout">
        </form>
    </div>
<h1>View Statistics here.</h1>
</body>
</html>
