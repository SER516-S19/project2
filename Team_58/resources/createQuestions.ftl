<html>

<head>
</head>
	<body>
		<form action="createQuestions" method="POST">
			<h1>Enter your questions and answers</h1><br>
		  	Question:<br>
  			<input type="text" name="question">
  			<br><br>
  			Correct Answer:<br>
  			<input type="text" name="correctAnswer">
  			<br><br>
  			Incorrect Answer 1:<br>
  			<input type="text" name="incorrectAnswer1">
  			<br><br>
  			Incorrect Answer 2:<br>
  			<input type="text" name="incorrectAnswer2">
  			<br><br>
  			Incorrect Answer 3:<br>
  			<input type="text" name="incorrectAnswer3">
  			<br><br>
  			Total Points:<br>
  			<input type="text" name="totalPoints">
  			<br><br>
  			<input type="radio" name="isMCQ" checked>Multiple Answers
  			<br><br>
  			<input type="radio" name="isMCQ">Single Answer
  			<br><br>
  			<input type="submit" value="Add more Questions/ Submit">
  			<input type="submit" formaction="courseDashboard.ftl" formmethod="POST" value="Go to dashboard">
		</form>
	</body>
</html>