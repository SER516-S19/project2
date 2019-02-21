<html>

	<style type="text/css">
		body{
			background-color:#EEEEEE;
			text-align: center;
			font-size: 125%;
			color: #3F4851;
			font-family:Tahoma, Ubuntu, sans-serif;
			}
	</style>
	<body>
	<h1> Create Quiz here </h1>
		<form action="createQuiz" method = "POST">
			  Enter Quiz title :<br>
			  <input type="text" name="quizTitle">
			  <br><br>
			  Enter Quiz Duration :<br>
			  <input type="text" name="assignedTime">
			  <br><br>
			  <br>
			  Enter Quiz Date :<br>
			  <input type="text" name="date">
			  <input type="text" name="month">
			  <input type="text" name="year">
			  <br><br>
			  Enter Quiz Instructions :<br>
			  <input type="text" name="quizInstructions"
			  <br>
			  <br>
			  Choose if graded
			  <br>
			  <input type="radio" name="isGraded" checked> graded<br>
			  <input type="radio" name="isGraded"> not graded<br>
			  <br>
			  Choose if you want to shuffle
			  <br>
			  <input type="radio" name="isShuffled" checked> shuffle<br>
			  <input type="radio" name="isShuffled"> dont shuffle<br>
			  <br><br>
			  <input type="submit" value="Submit">  
			</form> 
	</body>
</html>