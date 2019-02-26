<#-- Author: Aditya Samant/Akash Kadam
	Renders viewQuiz page which displays question information such as question description, answer possible choices and points
	 of a particular quiz along with quiz information such as quiz name, quiz status, scheduled date and total points
	An edit button shows up next to each question that allows professor to edit ungraded quiz questions 
	that have not passed the schedule date. 
	Ungraded quizzes also show the grade quiz button that transfers professor to grade quiz page for grading.
	 
	version: 1.3
  -->
<html>
	<head>
	<#include "stylesheet.css">
	</head>
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
	        	<button type="submit">Course Dashboard</button>
        	</form>
		<h1 class="fontColor">
		   TITLE: ${Session.quizName}
		</h1>
	<div class="box">
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
	        <#assign qId = questions.getqId()>
	            <tr>
	               <td contenteditable="false" value=${qId}>${questions.getQuestion()}</td>
				   <td contenteditable="false" value=${qId}>${questions.getCorrectAnswer()}</td>
				   <td contenteditable="false" value=${qId}>${questions.getIncorrectAnswer1()}</td>
				   <td contenteditable="false" value=${qId}>${questions.getIncorrectAnswer2()}</td>
				   <td contenteditable="false" value=${qId}>${questions.getIncorrectAnswer3()}</td>
				   <td contenteditable="false" value=${qId}>${questions.getTotalPoints()}</td>
				   <#if Session.Grade == false>
				   		<td id=${qId}><button name="edit" onclick="editRow(this.value);" value=${qId}>Edit</button></td>
				   </#if>
	            </tr>
	        </#list>
        </table>
        
        <#--
        	The following script edits a row of the table and updates the database with the question.
        	author: Aditya Samant
        -->
        <script>
       		function editRow(qId){
       			var row = document.getElementsByTagName("td");
       		    var button = document.getElementsByName("edit");
       		
       			for (var i = 0; i < button.length; i++){
       				if(button[i].getAttribute("value") == qId){
       					button[i].innerHTML = "Submit";
       					button[i].setAttribute("type", "submit");
       					button[i].setAttribute("onclick", "submitEdit(this.value);");
       					button[i].setAttribute("id", qId);
       				}
       			}
       			
       			
       			for(var j= 0; j < row.length; j++){
       				if(row[j].getAttribute("value") == qId){
       					row[j].setAttribute("contenteditable", "true");
       				}
       			}
       		}
       		
       		function submitEdit(qId){
       			var row = document.getElementsByTagName("td");
       			var question, answer, wrong1, wrong2, wrong3, pts, count;
       			count = 0;
       			
       			
       			for(var j = 0; j < row.length; j++){
       				if(row[j].getAttribute("value") == qId){
       					row[j].setAttribute("contenteditable", "false");
       					switch(count){
       						case 0:
       							question = row[j].innerHTML;
       							break;
       						case 1:
       							answer = row[j].innerHTML;
       							break;
       						case 2:
       							wrong1 = row[j].innerHTML;
       							break;
       						case 3:
       							wrong2 = row[j].innerHTML;
       							break;
       						case 4:
       							wrong3 = row[j].innerHTML;
       							break;
       						case 5:
       							pts = row[j].innerHTML;
       					
       					}
       					count++;
       				}
       			}		
       		}
        </script>
        <#if Session.Grade == false && Session.isAfter == true>
        	<form action="gradeQuiz" method="POST">
	        	<input type="hidden" value=${Session.quizName}/>
	        	<input type="hidden" value=${Session.quizId}/>
	        	<button class="button" type="submit">Grade Quiz</button>
        	</form>
        </#if>
        </div>
	</body>
	
</html>