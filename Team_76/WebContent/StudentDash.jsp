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
		if (isSessionValid == null || isSessionValid.isEmpty() || !isSessionValid.equalsIgnoreCase("True")
				|| uName == null || uName.isEmpty()) {
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Cache-Control", "no-store");
			response.setHeader("Pragma", "no-cache");
			response.setDateHeader("Expires", 0);
			session.invalidate();
			response.sendRedirect("Login.jsp");
		}
	%>
	<div>
		<form align="right" action="LoginController" method="post">
			<input type="hidden" name="action" value="logoff"> <input
				class="logout" type="submit" value="LogOut" class="logout">
		</form>
	</div>
	<h1>Student DashBoard</h1>
	<form class="action" action="StudentController" method="get">
		<input type="hidden" name="action" value="AttemptQuiz"> <input
			class="option" type="submit" value="Attempt Quiz">
	</form>
	<form class="action" action="StudentController" method="get">
		<input type="hidden" name="action" value="ViewGrade"> <input
			class="option" type="submit" value="View Grade">
	</form>
</body>
</html>