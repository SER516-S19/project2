<html>
<head>
    <title>QUIZ</title>
</head>
<body>
<form action="DisplayQuizInstructionServlet" method="GET">
        <p>${Session.QuizVO.getQuizInstruction()} </p>
</form>
	<body>
	<h1> Start Quiz here </h1>
		<form action="DisplayQuiz" method = "GET">	
			<input type="hidden" name="questionId" value="1">
			<input type="submit" value="Start">
		</form> 
	</body>
</body>
</html>