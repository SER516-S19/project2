<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="Style.css">
<title>Insert title here</title>
</head>
<body>
	<%@page import="Team76.Entity.QuizEntity"%>
	<%@page import="Team76.Database.DatabaseConnection"%>
	<%@page import="java.sql.Connection"%>
	<%@page import="java.sql.*"%>
	<%@page import="Team76.Entity.UserEntity"%>

	<%@page import="Team76.Entity.GradeEntity"%>

	<%@page import="java.util.List"%>
	<h1 align="center">
		<font><strong>Student Grades</strong></font>
	</h1>
	<table align="center" cellpadding="5" cellspacing="5" border="1">
		<tr></tr>
		<tr bgcolor="orange">
			<td><b>Student Name</b></td>
			<td><b>Grade</b></td>

		</tr>

		<%
      List<GradeEntity> gradeList =  (List) session.getAttribute("gradeList");
    		for(GradeEntity g: gradeList){

      %>
		<td><%= g.getStudentName()%></td>
		<td><%= g.getGrade()%></td>
		</tr>
		<%
			}
    		%>
	</table>

	<br />


	<table align="center" cellpadding="5" cellspacing="5" border="1">
		<h2 align="center">Highest and Lowest Grades</h2>
		<tr bgcolor="orange">
			<td><b>Student Name</b></td>
			<td><b>Grade</b></td>

		</tr>

		<%
      List<GradeEntity> maxMin =  (List) session.getAttribute("maxMin");
    		for(GradeEntity m: maxMin){

      %>
		<td><%= m.getStudentName()%></td>
		<td><%= m.getGrade()%></td>
		</tr>
		<%
			}
    		%>
	</table>

				<form action="ProfessorController" method="post">
					<input type="hidden" name="action" value="viewStatisticsBack">
					<input type="submit" style="float: right; width: auto" value="Back">
				</form>
</body>
</html>