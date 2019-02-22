<#-- Author: Aditya Samant
	Renders viewQuiz page which displays question information such as question description, answer possible choices and points
	 of a particular quiz along with quiz information such as quiz name, quiz status, scheduled date and total points
	An edit button shows up next to each question that allows professor to edit ungraded quiz questions 
	that have not passed the schedule date. 
	Ungraded quizzes also show the grade quiz button that transfers professor to grade quiz page for grading.
	 
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
		<form action="courseDashboard.ftl" method="POST">
	        	<button type="submit">Return to Dashboard</button>
        	</form>
		<h1>
		   TITLE: ${Session.Name}
		</h1>
		<h3>
		   TOTAL POINTS: ${Session.Total}
		</h3>
		<h3>
		STATUS: <#if Session.Grade == false> 
                        Ungraded
					<#else>
						Graded
					</#if>
		</h3>
		<h3> 
			SCHEDULED DATE: ${Session.Schedule}
		</h3>
        <h4> 
        	${Session.Directions}
        </h4>
		<table id ="table">
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
	               <td contenteditable="false">${questions.getQuestion()}</td>
				   <td contenteditable="false">${questions.getCorrectAnswer()}</td>
				   <td contenteditable="false">${questions.getIncorrectAnswer1()}</td>
				   <td contenteditable="false">${questions.getIncorrectAnswer2()}</td>
				   <td contenteditable="false">${questions.getIncorrectAnswer3()}</td>
				   <td contenteditable="false">${questions.getTotalPoints()}</td>
				   <#if Session.Grade == false>
				   		<td><button id=	qid? onclick="editRow(this.id); value= ">edit</button></td>
				   </#if>
	            </tr>
	        </#list>
        </table>
        <script>
       		function editRow(){
       			var table = document.getElementById("table");
       			var button = document.getElementsByClassName("editButton");
       			
       			
       			
       		}
        </script>
        <#if Session.Grade == false && Session.isAfter == true>
        	<form action="gradeQuiz" method="POST">
	        	<input type="hidden" value=${Session.Name}/>
	        	<input type="hidden" value=${Session.Id}/>
	        	<button type="submit">Grade Quiz</button>
        	</form>
        </#if>
	</body>
</html>