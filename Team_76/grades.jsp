<html>
<head>
<title>View Students Grade</title>
</head>
<body>

	<h1>My Grades</h1>

	<br />
	<br /> StudentId:
	<%=request.getParameterValues("StudentId")%>

	<br />
	<br /> QuizId:
	<%=request.getParameterValues("QuizID")%>

	<br />
	<br /> Grade:
	<%=request.getParameterValues("Grade")%>

</body>

</html>