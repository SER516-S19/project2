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
			  <input type="submit" value="Start">  
			</form> 
	</body>
</body>
</html>