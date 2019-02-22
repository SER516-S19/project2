<#-- Author: Aditya Samant
	Renders viewQuiz page which displays questions of a particular quiz along with quiz information
	An edit button is present next to each question that allows professor to edit ungraded quiz questions 
	that have not passed the schedule date. 
	version: 1.0
  -->
<html>
	<body>
		<h1>
		   Title: ${Session.Name}
		</h1>
		<h2>
		
		Status: <#if Session.Grade == false> 
                        Ungraded
					<#else>
						Graded
					</#if>
		</h2>
		<h3> 
			Scheduled Time: ${Session.Schedule}
		</h3>
        <h4> 
        	Instruction: ${Session.Directions}
        </h4>
        
        <#--<# assign question = Sessions.QuizQuestions.getQuestion() />
        <# assign answer = Sessions.QuizQuestions.getCorrectAnswer() />
        <# assign wrongOne = Sessions.QuizQuestions.getIncorrectAnswer1() />
        <# assign wrongTwo = Sessions.QuizQuestions.getIncorrectAnswer2() />
        <# assign wrongThree = Sessions.QuizQuestions.getIncorrectAnswer3() />
        <# assign points = Sessions.QuizQuestions.getTotalPoints() />-->
		<table>
			<tr>
				<th>Question</th>
				<th>Answer</th>
				<th>Choice1</th>
				<th>Choice2</th>
				<th>Choice3</th>
				<th>Points</th>
				<#if Session.Grade == false>
				<#assign editButton = 0>
					<th>Edit</th>
				</#if>
			</tr>
	        <#list Session.QuizQuestions as questions>
	            <tr>
	               <td>${questions.getQuestion()}</td>
				   <td>${questions.getCorrectAnswer()}</td>
				   <td>${questions.getIncorrectAnswer1()}</td>
				   <td>${questions.getIncorrectAnswer2()}</td>
				   <td>${questions.getIncorrectAnswer3()}</td>
				   <td>${questions.getTotalPoints()}</td>
	            </tr>
	        </#list>
        </table>
	</body>
</html>