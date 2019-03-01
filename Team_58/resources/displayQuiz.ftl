<html>
<head>
    <title>QUIZ</title>
</head>
<body>
	<table>
    <form action="DisplayQuizSubmit" method="POST">
    <#list Session.QuestionsVO as question>
	    <h3 align="center">
	        Question: ${question.getQuestion()}
	    </h3>
	    <h5 align="center">
	        Total Points: <i>${question.getTotalPoints()}</i>
	    </h5>	
		            
	    <h3 align="center">
	        <input type="radio" name= "questionId" /> ${question.getCorrectAnswer()}
	    </h3>
	    <h3 align="center">
	        <input type="radio" name= "questionId" /> ${question.getIncorrectAnswer1()}
	    </h3>
		<h3 align="center">
	        <input type="radio" name= "questionId" /> ${question.getIncorrectAnswer2()}
	    </h3>
	    <h3 align="center">
	         <input type="radio" name= "questionId" /> ${question.getIncorrectAnswer3()}
	    </h3>
    </#list>
    <input type = "submit" value = "Submit"/>
    </form>
    </table>
</body>
</html>