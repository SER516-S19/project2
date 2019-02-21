<html>
	<head>
		<title>${Session.Name}</title>
	</head>
	<body>
		<h1>Status: <# if ${Session.Grade} ==0> 
                        Ungraded

					<# else>
						Graded
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
			   <td>${Session.QuizQuestions.getAnswer()}</td>
			   <td>${Session.QuizQuestions.getChoices()}</td>
			   <td>${Session.QuizQuestions.getPoints()}</td>
            </tr>
        </#list>
	
	</body>
</html>