<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Grades</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css" href="Style.css">

<style>
input[type=text], select {
	width: 40%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}
</style>
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
	<ul>
		<li><a href="ProfessorDash.jsp" class="w3-bar-item">DASHBOARD</a></li>
		<li style="float: right">
		<div style="float: center">
			<form action="LoginController" method="post">
				<input type="hidden" name="action" value="logoff"> <input
					class="logoutonly" type="submit" value="LogOut" class="logout">
			</form>
			</div>
		</li>
	</ul>

	<h3>Grades</h3>
	<div>
		<form action="ProfessorController" method="GET">
			<label for="qTitle">Quiz Title</label>
			<div>
				<input type="text" id="qTitle" name="quiztitle"
					placeholder="quiz title..."> <select id="qtitle"
					name="quiztitle">
					<option value="q1">Quiz-1</option>
					<option value="q2">Quiz-2</option>
					<option value="q3">Quiz-3</option>
				</select>
			</div>
			<div>
				<label for="sName">Student Name</label> <input type="text"
					id="sName" name="studentName" placeholder="student name...">
			</div>
			<label for="grade">Grade</label>
			<textarea rows="1" cols="4"></textarea>
			<div>
				<input type="hidden" name="action" value="ProfessorDash"> <input
					type="submit" value="Back"> <input type="hidden"
					name="action" value="ViewGrades"> <input type="submit"
					value="Ok">
			</div>
		</form>
	</div>
</body>
</html>