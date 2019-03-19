<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Team76.Entity.QuizEntity"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<style>
.logoutonly {
	margin-left: 350px !important;
}

ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover {
	background-color: #111;
}

input[type=submit] {
	width: 20%;
	background-color: #720c0c;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #961212;
}

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
	<div style="overflow: scroll; height: 90%; max-height: 500px">
		<%
			String uName = (String) session.getAttribute("uName");
			String isSessionValid = (String) session.getAttribute("validSession");
			if (isSessionValid == null || isSessionValid.isEmpty() || !isSessionValid.equalsIgnoreCase("True")
					|| uName == null || uName.isEmpty()) {
				response.sendRedirect("Login.jsp");
			}
			QuizEntity entity = (QuizEntity) session.getAttribute("quiz");
		%>
		<h3>Review Page</h3>
		<%=entity.getQuizTitle()%>
		<div class="form-group">
			<table border="1">

				<%
					int loopVar = 0;
					int size = entity.getQuestionsList().size();

					for (loopVar = 0; loopVar < size; loopVar++) {
				%>
				<tr>
					<td>Questions : <%=entity.getQuestionsList().get(loopVar).getQuestion()%></td>
				</tr>
				<tr>
					<td>Option 1 : <%=entity.getQuestionsList().get(loopVar).getOption1()%>
					</td>
				</tr>
				<tr>
					<td>option 2: <%=entity.getQuestionsList().get(loopVar).getOption2()%></td>
				</tr>
				<tr>
					<td>option 3: <%=entity.getQuestionsList().get(loopVar).getOption3()%></td>
				</tr>
				<tr>
					<td>Option 4: <%=entity.getQuestionsList().get(loopVar).getOption4()%></td>
				</tr>
				<tr>
					<td>Correct option <%=entity.getQuestionsList().get(loopVar).getAnswer()%></td>
				</tr>
				<tr>
					<td>Marks <%=entity.getQuestionsList().get(loopVar).getMarks()%>
					</td>
				</tr></tr><%}%>
			</table>
			<form action="ProfessorController" method="post">
				<input type="hidden" name="action" value="ReviewSubmit"> <input
					class="btn btn-primary" type="submit" name="ReviewSubmit"
					value="Submit Button">
			</form>
		
			
		</div>
</body>
</html>