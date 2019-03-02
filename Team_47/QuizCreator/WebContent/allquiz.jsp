<html lang="en-US">
	<head>
		<title>All Quizzes</title>
		<meta id="request-method" name="request-method" content="GET">
		<meta name="author" content="Meng-Ze Chen">
		<meta name="copyright" content="© 2019 Meng-Ze Chen. All Rights Reserved.">
		<meta name="keywords" content="Quizzes Overview">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<%@ page import="com.asu.ser516.team47.database.*" %>
		<%@ page import="java.util.List" %>
	</head>
	<body>
		<div>
			<% 
				QuizDAO quizDAO = new QuizDAOImpl();
				List<Quiz> quizzes = quizDAO.getAllQuizzes();
				int quizSize = quizzes.size();

				for (int i=0; i<quizSize; ++i) {
					int quizIdx = i+1;
					int quizID = quizzes.get(i).getQuiz_id();
			%>
				<form action="quizstat.jsp" method="POST">
					<h1> Quiz <%= quizIdx%> </h1>
					<input type="text" name="Quiz_number" value=<%=quizIdx%> hidden=true>
					<input type="text" name="Quiz_id" value=<%=quizID%> hidden=true>
					<input type="submit" name="Submit" value="Quiz <%= quizIdx%> Stat">
				</form>							  
			<%} %>
		</div>

	</body>
</html>
