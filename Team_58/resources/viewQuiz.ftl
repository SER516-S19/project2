<#-- Author: Aditya Samant
	Renders viewQuiz page which displays questions of a particular quiz along with quiz information
	An edit button is present next to each question that allows professor to edit ungraded quiz questions 
	that have not passed the schedule date. 
	version: 1.1
  -->
<html>
	<style>
		table, th, td {
		  border: 1px solid black;
		  border-collapse: collapse;
		}
		th, td {
		  padding: 5px;
		  text-align: left;    
		}
	</style>
	<body>
		<h1>
		   Title: ${Session.quizInfo.getQuizTitle()}
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
				   <#if Session.Grade == false>
				   <td><button>edit</button></td>
				   </#if>
	            </tr>
	        </#list>
        </table>
        <#if Session.Grade == false && Session.isAfter == true>
        	<form action="gradeQuiz" method="POST">
	        	<input type="hidden" value=${Session.quizInfo}/>
	        	<button type="submit">Grade Quiz</button>
        	</form>
        </#if>
	</body>
</html>