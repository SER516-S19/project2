<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Dashboard</title>
<link rel="stylesheet" type="text/css" href="css/StudentDash.css">
</head>
<body>
	<%
        String uName = (String) session.getAttribute("uName");
        String isSessionValid = (String) session.getAttribute("validSession");
        if (isSessionValid == null || isSessionValid.isEmpty() || !isSessionValid.equalsIgnoreCase("True") || uName == null || uName.isEmpty()) {
            response.sendRedirect("Login.jsp");
        }
	%>
    <div>
        <form align="right" action="LoginController" method="post">
            <input type="hidden" name="action" value="logoff">
            <input class="logout" type="submit" value="LogOut" class="logout">
        </form>
    </div>
	<h1>Student DashBoard</h1>
	<form class="action" action="StudentController" method="post">
		<input type="hidden" name="action" value="ViewQuiz">
		<input class="option" type="submit" value="View Quiz">
	</form>
	<form class="action" action="StudentController" method="post">
		<input type="hidden" name="action" value="ViewGrade">
		<input class="option" type="submit" value="View Grade">
	</form>
</body>
</html>