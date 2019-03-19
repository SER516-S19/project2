<!DOCTYPE html>
<html>
<head>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>
	<%@page import="Team76.Entity.GradeEntity"%>
	<%@page import="java.util.List"%>
	<%
		String uName = (String) session.getAttribute("uName");
		String isSessionValid = (String) session.getAttribute("validSession");
		if (isSessionValid == null || isSessionValid.isEmpty() || !isSessionValid.equalsIgnoreCase("True")
				|| uName == null || uName.isEmpty()) {
			response.sendRedirect("Login.jsp");
		}
		List<GradeEntity> grades = (List) session.getAttribute("grades");
	%>
	<div>
		<form align="right" action="LoginController" method="post">
			<input type="hidden" name="action" value="logoff"> <input
				class="logout" type="submit" value="LogOut" class="logout">
		</form>
	</div>

	<h2>VIEW STUDENT GRADES QUIZ WISE</h2>

	<table>
		<tr>
			<th>QUIZ TITLE</th>
			<th>GRADE</th>
		</tr>
		<%
			for (GradeEntity grade : grades) {
		%>
		<tr>
			<td><%=grade.getQuizTitle()%></td>
			<td><%=grade.getGrade()%></td>
		</tr>
		<%
			}
		%>
	</table>
	<form action="StudentController" method="post">
			<input type="hidden" name="action" value="DashBoard"> <input
				class="logout" type="submit" value="Go To DashBoard" >
		</form>
</body>