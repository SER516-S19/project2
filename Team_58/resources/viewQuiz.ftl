<#-- Author: Aditya Samant/Akash Kadam
	Renders viewQuiz page which displays question information such as question description, answer possible choices and points
	 of a particular quiz along with quiz information such as quiz name, quiz status, scheduled date and total points
	An edit button shows up next to each question that allows professor to edit ungraded quiz questions 
	that have not passed the schedule date. 
	Ungraded quizzes also show the grade quiz button that transfers professor to grade quiz page for grading.
	
	version: 1.4
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
    	<div id="edit" hidden>
    		<form action="viewQuiz" method="POST">
    		Question:
    			<input name="question" type="text" />
    			<br>
    		Answer:
    			<input name="answer" type="text" />
    			<br>
    		Choice One:
    			<input name="one" type="text" />
    			<br>
    		Choice Two:
    			<input name="two" type="text"/>
    			<br>
    		Choice Three:
    			<input name="three" type="text" />
    			<br>
    		Points:
    			<input name="points" type="text" />
    			<br>
    			<input name= "quizId" type="hidden" />
    			<br><br>
    			
    			<input name="Submit" type="submit"/>
    		</form>
    	</div>
		<table id="table">
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
	        <#assign question = questions.getQuestion()>
	        <#assign ans = questions.getCorrectAnswer()>
	        <#assign choiceOne = questions.getIncorrectAnswer1()>
	        <#assign choiceTwo = questions.getIncorrectAnswer2()>
	        <#assign choiceThree = questions.getIncorrectAnswer3()>
	        <#assign pts = questions.getTotalPoints()>
		     	 <tr>
		           <td contenteditable="false" value=${qId}>${question}</td>
				   <td contenteditable="false" value=${qId}>${ans}</td>
				   <td contenteditable="false" value=${qId}>${choiceOne}</td>
				   <td contenteditable="false" value=${qId}>${choiceTwo}</td>
				   <td contenteditable="false" value=${qId}>${choiceThree}</td>
				   <td contenteditable="false" value=${qId}>${pts}</td>
				   <#if Session.Grade == false>
					   <td><button name="editButton" onclick="editRow(this.value);" value=${qId}>Edit</button></td>
				   </#if>
		        </tr>
	        </#list>
        </table>
       
        
        <#--
        	The following script edits a row of the table and updates the database with the question.
        	author: Aditya Samant
        -->
        <script type="text/javascript">
        	function editRow(qId){
        		document.getElementById("edit").hidden= false;
        		
  				var row = document.getElementsByTagName("td");
  				var count = 0;
  				
  				for (var i = 0; i < row.length; i++){
  				
  					if(row[i].value == qId){
  						switch(count){
  							
  							case 0:
  								console.log(row[i].innerHTML);
  								document.getElementsByName("question")[0].setAttribute("value", row[i]);
  								break;
  							case 1:
  								console.log(row[i].innerHTML);
  								document.getElementsByName("answer")[0].setAttribute("value", row[i]);
  								break;
  							case 2:
  								console.log(row[i].innerHTML);
  							    document.getElementsByName("one")[0].setAttribute("value", row[i]);
  								break;
  							case 3:
  								console.log(row[i].innerHTML);
  								document.getElementsByName("two")[0].setAttribute("value, row[i]);
  								break;
  							case 4:
  								console.log(row[i].innerHTML);
  								document.getElementsByName("three")[0].setAttribute("value", row[i]);
  								break;
  							case 5:
  								console.log(row[i].innerHTML);
  								document.getElementsByName("points")[0].setAttribute("value",row[i]);
  						
  						}
  						count++;
  					}
  				
  				}
  				
  				//document.getElementById("table").style.display ="none";
        		document.getElementsByName("quizId")[0].setAttribute("value", qId);
  				
        	
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