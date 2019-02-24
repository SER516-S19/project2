<html lang="en-US">
	<head>
		<title>All Quizzes</title>
		<meta id="request-method" name="request-method" content="GET">
		<meta name="author" content="Meng-Ze Chen">
		<meta name="copyright" content="© 2019 Meng-Ze Chen. All Rights Reserved.">
		<meta name="keywords" content="Quizzes Overview">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
	</head>
	<body>
		<div>
			<% 
				int quizSize = 5;
				for (int i=0; i<quizSize; ++i) {
					int quizIdx = i+1;
			%>
			<form action="quizstat.jsp" method="POST">
				<h1> Quiz <%= quizIdx%> </h1>
				<input type="submit" name="q<%= quizIdx%>Stat" value="Quiz <%= quizIdx%> Stat">
			</form>							  
			<%} %>
		</form>
		</div>

	</body>
</html>
