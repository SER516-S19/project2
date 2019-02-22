<!-- 
Freemarker page to display createQuestion page
@authour Trupti / @author Aditya
@version 1.2
@date 02/22/2019
 -->

<html>
<head>
</head>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.js"></script>
    <script type="text/javascript">
    $(document).ready(function() {
      $("#questionForm").validate({
        messages: {

            question: "Please add Question",
            correctAnswer: "Please add the correct answer",
            incorrectAnswer1: "Please add the incorrect answer 1",
            incorrectAnswer2: "Please add the incorrect answer 2",
            incorrectAnswer3: "Please add the incorrect answer 3",
            totalPoints: {required: "Please add question points", number:"Please enter a number"}
           
 
        },
        rules: {
          question: "required",
          totalPoints: {required:true, number: true,},
          correctAnswer: "required",
          incorrectAnswer1: "required",
          incorrectAnswer2: "required",
          incorrectAnswer3: "required",
        },
      });
    });
  </script>
	<body>
		<form action="createQuestions" id="questionForm" method="POST">
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
		</form>
		
		<form action="createQuestions" id = "goToDashboard" method="POST">
			<input type="submit" formaction="courseDashboard.ftl" formmethod="POST" value="Go to dashboard">
		</form>
	</body>
</html>