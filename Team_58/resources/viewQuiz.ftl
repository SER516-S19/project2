<html>
	<head>
		<title>${Session.Name}</title>
	</head>
	<body>
		<h1>Status: <#if Session.Grade == 0> 
                        <p>Ungraded </p>
					<#else>
						<p>Graded</p>
					</#if>
		</h1>
		<h2> 
			Scheduled Time: ${Session.Schedule}
		</h2>
        <p> ${Session.Directions}
        </p>

        <# list Session.QuizQuestions as questions>
            <tr>
               <td>${Session.QuizQuestions.getQuestion()}</td>
			   <td>${Session.QuizQuestions.getCorrectAnswer()}</td>
			   <td>${Session.QuizQuestions.getIncorrectAnswer1()}</td>
			   <td>${Session.QuizQuestions.getIncorrectAnswer2()}</td>
			   <td>${Session.QuizQuestions.getIncorrectAnswer3()}</td>
			   <td>${Session.QuizQuestions.getTotalPoints()}</td>
            </tr>
        </# list>
	
	</body>
</html>