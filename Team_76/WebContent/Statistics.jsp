<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="Style.css">
<title>Statistics</title>
<style>
.dropbtn {
	background-color: #720c0c;
	color: white;
	padding: 16px;
	font-size: 16px;
	border: none;
}

.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f1f1f1;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown:hover .dropbtn {
	background-color: #961212;
}
</style>
</head>

<body>
	<%@page import="Team76.Entity.QuizEntity"%>
	<%@page import="Team76.Database.DatabaseConnection"%>
	<%@page import="java.sql.Connection"%>
	<%@page import="java.sql.*"%>
	<%@page import="Team76.Entity.UserEntity"%>
	<%@page import="java.util.ArrayList"%>
	<%@page import="java.util.List"%>
	<%@page import="java.util.LinkedList"%>

	<%
			String uName = (String) session.getAttribute("uName");
			String isSessionValid = (String) session.getAttribute("validSession");
			if (isSessionValid == null || isSessionValid.isEmpty() || !isSessionValid.equalsIgnoreCase("True") || uName == null || uName.isEmpty()) {
				response.sendRedirect("Login.jsp");
			}
		%>

	<ul>
		<li><a href="ProfessorDash.jsp">DASHBOARD</a></li>
		<li style="float: right">
			<div style="float: center">
				<form action="LoginController" method="post">
					<input type="hidden" name="action" value="logoff"> <input
						class="logoutonly" type="submit" value="LogOut" class="logout">
				</form>
			</div>
		</li>
	</ul>

	<h1>View Statistics here.</h1>
	<h1 align="center">
		<font><strong>Available Quizzes</strong></font>
	</h1>
	<table align="center" cellpadding="5" cellspacing="5" border="1">
		<tr></tr>
		<tr bgcolor="orange">
			<td><b>Quiz Title </b></td>
		</tr>


		<%
		List<QuizEntity> quizList = (List) session.getAttribute("quizList");
			try{ 
		for(QuizEntity q: quizList){
	%>
		<tr>
			<td align="center"><%=q.getQuizTitle() %></td>
			<td>
				<form action="ProfessorController" method="post">
					<input type="hidden" name="action" value="viewStatistics">
					<input type="hidden" name="quizId" value="<%=q.getQuizId()%>">
					<input type="submit" style="width: auto" value="View Statistics">
				</form>
			</td>
		</tr>

		<%
			}
		} catch (Exception e) {
			e.printStackTrace();
			}
	%>
	
</body>
</html>