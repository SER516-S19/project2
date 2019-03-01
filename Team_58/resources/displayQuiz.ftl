<html>
<head>
    <title>QUIZ</title>
</head>
<body>
    <h1 align="center" style="text-decoration-color: black">QUIZ</h1>
    
    <p id="timer"></p>


	
	    <form action="DisplayQuizServlet" method="GET">
	        
			<#list Session.list as user>           
	                <h3 align="center">
	                    Question: ${user.getQuestion()}
	                </h3>
	                <h5 align="center">
	                    Total Points: <i>${user.getTotalPoints()}</i>
	                </h5>

	                <h3 align="center">
	                    <input type="radio" name= ${user.getqId()} value=${user.getCorrectAnswer()} /> ${user.getCorrectAnswer()}
	                </h3>
	                <h3 align="center">
	                    <input type="radio" name= ${user.getqId()} value=${user.getIncorrectAnswer1()} /> ${user.getIncorrectAnswer1()}
	                </h3>
	            	<h3 align="center">
	                    <input type="radio" name= ${user.getqId()} value=${user.getIncorrectAnswer2()}/> ${user.getIncorrectAnswer2()}
	                </h3>
	                <h3 align="center">
	                     <input type="radio" name= ${user.getqId()} value=${user.getIncorrectAnswer3()}/> ${user.getIncorrectAnswer3()}
	                </h3>
			</#list>	      
			
			
			<input type="button" value="Save and Submit"  onClick="SaveSubmit();"/>
			
			<script rel="javascript" type="text/javascript" href="js/jquery-1.11.3.min.js">
		
			function SaveSubmit() { 
				var sessionList = [<#list Session.list as user>${user.getqId()},</#list>] ;           
				
				var jsonData = {};
				
				var listLength = sessionList.length;
    			
    			for (var j = 0; j < listLength; j++) {
        			var radio_q1_val = "";

					for (i = 0; i < document.getElementsByName(sessionList[j]).length; i++) {
						if (document.getElementsByName(sessionList[j])[i].checked) {
							radio_q1_val = document.getElementsByName(sessionList[j])[i].value; 
							jsonData[sessionList[j]] = radio_q1_val;  
							
						}        
					}
					
					if (radio_q1_val === "")
					{
						alert("You have not answered all the question");
						return;
					}
					
				}
				
				alert("Going to Submit Quiz");
				
			}
			
			</script>

      
	    </form>
	        

						
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
			document.getElementById("timer").innerHTML = "EXPIRED";
		  }
		}, 1000);
		</script>
		
		 
</body>
</html>