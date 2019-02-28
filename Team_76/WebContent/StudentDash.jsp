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
    <div style="float: right">
        <form align="right" action="LoginController" method="post">
            <input type="hidden" name="action" value="logoff">
            <inputtype="submit" value="LogOut" class="logout">
        </form>
    </div>
	<h1>Student DashBoard</h1>
	<form class="action" action="StudentController" method="get">
		<input type="hidden" name="action" value="AttemptQuiz">
		<input type="submit" value="Attempt Quiz">
	</form>
	<form class="action" action="StudentController" method="get">
		<input type="hidden" name="action" value="ViewGrade">
		<input type="submit" value="View Grade">
	</form>
</body>
</html>