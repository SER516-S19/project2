<html>
<head>
    <title>QUIZ</title>
</head>
<body>
<form action="DisplayQuizInstructionsServlet" method="GET">
        <p>${Session.QuizVO.getQuizInstruction()()} </p>
</form>
	<body>
	<h1> Submit Quiz here </h1>
		<form action="DisplayQuizServlet" method = "POST">	
			  <input type="submit" value="Submit">  
			</form> 
	</body>
</body>
</html>