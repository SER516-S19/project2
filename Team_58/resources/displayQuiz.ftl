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
						<#list question.getCorrectAnswers() as correctAnswer>
								<input type="checkbox" name="" value="">${correctAnswer}<br>
						</#list>
					</h3>
					
					<h3 align="center">
						<#list question.getIncorrectAnswers() as incorrectAnswer>
							<input type="checkbox" name="" value="">${incorrectAnswer}<br>
						</#list>
					</h3>
			    </#list>
		    	<input type = "submit" value = "Submit"/>
		    </form>
	    </table>
	</body>
</html>