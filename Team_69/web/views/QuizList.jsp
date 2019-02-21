<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quizzes Posted</title>
</head>
<body>
<h3>Select a quiz to view its contents</h3>

	<form action="../ProfessorController" method="get">
		<input type="hidden" id="flag" name="flag" value="fetchQuizList">
	    <input type="submit" value="Display Quiz List" />
	</form>
	

</body>
</html>
