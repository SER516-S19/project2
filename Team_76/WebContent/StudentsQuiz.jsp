<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Dashboard</title>
<link rel="stylesheet" type="text/css" href="css/StudentsQuiz.css">
</head>
<body>
	<%@page import="Model.Quiz"%>
	<%@page import="java.util.List"%>
<%
        String uName = (String) session.getAttribute("uName");
        String isSessionValid = (String) session.getAttribute("validSession");
        if (isSessionValid == null || isSessionValid.isEmpty() || !isSessionValid.equalsIgnoreCase("True")
                || uName == null || uName.isEmpty()) {
            response.sendRedirect("Login.jsp");
        }
    %>    
	<h2 align="center"><font><strong>Available Quizzes</strong></font></h2>
	<table align="center" cellpadding="5" cellspacing="5" border="1">
	<tr></tr>
	<tr bgcolor="orange">
		<td><b>Quiz Title</b></td>
		<td><b>Due Date</b></td>
		<td><b>Time Limit</b></td>
		<td><b>Quiz Type</b></td>
	</tr>
	<%
		List<Quiz> quizzes = (List) session.getAttribute("quizzes");
		try{ 
			for(Quiz q: quizzes){
	%>
	<tr bgcolor="yellow">
		<td><%=q.getQuizTitle() %></td>
		<td><%=q.getDueDate() %></td>
		<td><%=q.getTimeLimit() %></td>
		<td><%=q.getQuizType() %></td>
		<td>
        	<form action="StudentController" method="get">
				<input type="hidden" name="action" value="StartQuiz">
				<input type="hidden" name="quizId" value="<%=q.getQuizId()%>">
				<input type="submit" value="Start">
			</form>
    	</td>
	</tr>

	<%
			}
		} catch (Exception e) {
			e.printStackTrace();
			}
	%>
</table>
</body>
</html>