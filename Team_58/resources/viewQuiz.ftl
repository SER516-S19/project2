<#-- Author: Aditya Samant/Akash Kadam
	View Quiz Page:
	Displays quiz information such as date, instructions, status (graded/ungraded), question information.
	Unscheduled quizzes can be edited and ungraded quizzes can be graded.
	
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
		<div class="navbar">
		  <a method="POST" href="courseDashboard.ftl"> < Course Dashboard</a>
		  <div class="dropdown">
		    <button class="dropbtn">v
		      <i class="fa fa-caret-down"></i>
		    </button>
		    <div class="dropdown-content">
		    	<a href="professorHome.ftl">Home</a>
		    	<a href="login.jsp" name="logoutProfile">Logout</a>
		    </div>
		  </div> 
		</div>
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
    			<input name="question" type="text">
    			<br>
    		Answer:
    			<input name="answer" type="text">
    			<br>
    		Choice One:
    			<input name="one" type="text">
    			<br>
    		Choice Two:
    			<input name="two" type="text">
    			<br>
    		Choice Three:
    			<input name="three" type="text">
    			<br>
    		Points:
    			<input name="points" type="text">
    			<br>
    			<input name= "questId" type="hidden">
    			<br>
    			<input name="Quiz" type="hidden" value=${Session.quizId}>
    			<br><br>
    			<button type="submit" name="submit">Submit</button>
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
				<#if Session.Grade == false && Session.isAfter == false>
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
				   <#if Session.Grade == false && Session.isAfter== false>
					   <td><button name="editButton" value=${qId} onclick="editRow(this.value)">Edit</button></td>
				   </#if>
		        </tr>
	        </#list>
        </table>
       
        
        <#--
        	author: Aditya Samant
        	see src/controller/ViewQuizServlet.java
        -->
        <script>
        	/**
        	* The following script edits a row of the table and sends info to servlet
        	*
        	*
        	* @author Aditya Samant
        	* @version 1.2
        	* @param qId question Id
        	* @see src/controller/ViewQuizServlet.java
        	*/
        	function editRow(qId){
        		try{
	        		document.getElementById("edit").hidden= false;
	        		document.getElementsByName("questId")[0].setAttribute("value", qId);
	        		document.getElementById("table").style.display ="none";
	        		
	  				var row = document.getElementsByTagName("td");
	  				var count = 0;
	  				
	  				//pre-populate
	  				for (var i = 0; i < row.length; i++){
	  					console.log("for");
	  					if(row[i].getAttribute("value") == qId){
	  						console.log("row");
	  						switch(count){
	  							case 0:
	  								document.getElementsByName("question")[0].setAttribute("value", row[i].innerHTML);
	  								break;
	  							case 1:
	  								document.getElementsByName("answer")[0].setAttribute("value", row[i].innerHTML);
	  								break;
	  							case 2:
	  							    document.getElementsByName("one")[0].setAttribute("value", row[i].innerHTML);
	  								break;
	  							case 3:
	  								document.getElementsByName("two")[0].setAttribute("value", row[i].innerHTML);
	  								break;
	  							case 4:
	  								document.getElementsByName("three")[0].setAttribute("value", row[i].innerHTML);
	  								break;
	  							case 5:
	  								document.getElementsByName("points")[0].setAttribute("value",row[i].innerHTML);
	  						
	  						}
	  						count++;
	  					}
					}
	  			}catch(e){
	        		console.log(e.message);
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