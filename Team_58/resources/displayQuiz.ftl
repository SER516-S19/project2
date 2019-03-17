<!-- 
Freemarker page for Quiz, Timer, Quiz Submission
@authour Subhradeep Biswas & Jainish Soni
@version 1.5
@date 03/17/2019
 -->

<html>
	<head>
	    <title>QUIZ</title>
	</head>
	<body>

		<h1 align="center" id="timer"></h1>	
		<p>
		<table>
		    <form id="quizForm" action="SubmitQuizServlet" onsubmit="return SaveSubmit();" method="POST">
			    <#list Session.displayQuestionsVO as question>
				    <h3 align="center">
				        Question: ${question.getQuestion()}
				    </h3>
				    <h5 align="center">
				        Total Points: <i>${question.getTotalPoints()}</i>
				    </h5>	
					
					<h3 align="center">
						<#list question.getCorrectAnswers() as correctAnswer>
								<input type="checkbox" name=${question.getqId()}  value="">${correctAnswer}<br>
						</#list>
						<#list question.getIncorrectAnswers() as incorrectAnswer>
							<input type="checkbox" name=${question.getqId()}  value="">${incorrectAnswer}<br>
						</#list>
					</h3>
			    </#list>
			    
				<input type="submit" value="Save and Submit"/>
						
				<script rel="javascript" type="text/javascript" href="js/jquery-1.11.3.min.js">
			
				function SaveSubmit() { 
					document.getElementById("timer").innerHTML = "";
					var sessionList = [<#list Session.displayQuestionsVO as question>${question.getqId()},</#list>] ;           
					var checkd;
					var listLength = sessionList.length;
	    			
	    			for (var j = 0; j < listLength; j++) {
	        			checkd = 0;
						for (i = 0; i < document.getElementsByName(sessionList[j]).length; i++) {
							if (document.getElementsByName(sessionList[j])[i].checked) {
								checkd = 1;
							}        
						}
						
						if (checkd === 0)
						{
							alert("You have not answered all the question");
							return false;
						}	
					}
					return true;				
				}
				
				</script>
	    	</form>
	    </table>
	    </p>
	    	    		 				
		<script>
			var countDownDate = new Date().getTime() + (30 * 60 * 1000);
			var x = setInterval(function() {
				var now = new Date().getTime();
				var distance = countDownDate - now;
				
				var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
				var seconds = Math.floor((distance % (1000 * 60)) / 1000);
				
				document.getElementById("timer").innerHTML = minutes + "m " + seconds + "s ";
				
				if (distance < 0) {
					clearInterval(x);
					document.quizForm.submit();
				}
			}, 1000);
		</script>
		 
	</body>
</html>
