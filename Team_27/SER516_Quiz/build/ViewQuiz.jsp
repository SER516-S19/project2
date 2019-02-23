<%@page import="edu.asu.ser516.quiz.model.QuizDetails"%> 

<html>
	<head>
		<title>Quiz!</title>
		<link rel="stylesheet" type="text/css" href="css/styles.css">
		<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">

	</head>
	<body>
		<div class="form_div">
			<div id="quizheadbaner">
				<h2 id = "quizhead">Quiz Details</h2>
			</div>
	<form action="/Quiz/createQuiz" method="POST" id = "quizDetails">
	            <table>
    			<tr>
        		<td>
        		<% 
        		
        		QuizDetails mod = (QuizDetails)request.getAttribute("model"); 
        		
        		String html_tags = "</td>\r\n" + 
        				"                		\r\n" + 
        				"            			</tr>\r\n" + 
        				"        				</table>\r\n" + 
        				"        				<h2>Quiz Details</h2>\r\n" + 
        				"        				<label for=\"title\">Quiz Title: </label>\r\n" + 
        				"        				<input type=\"text\" name=\"title\" value= "+mod.getTitle()+" readonly>\r\n" + 
        				"        				<br>\r\n" + 
        				"        				<br>\r\n" + 
        				"        				<label for=\"instructions\">Instructions: </label>\r\n" + 
        				"        				<br>\r\n" + 
        				"        				<br>\r\n" + 
        				"        				<textarea name=\"instructions\" rows=\"10\" cols=\"30\" form=\"quizDetails\" readonly>"+mod.getInstructions()+"</textarea>\r\n" + 
        				"        				<br>\r\n" + 
        				"        				<br>\r\n" + 
        				"        				<br>\r\n" + 
        				"        				<label for=\"assignmentGroup\">Assignment Group: </label>\r\n" + 
        				"        				<input type=\"text\" name=\"assignmentGroup\" value="+ mod.getAssignmentGroup()+" readonly>\r\n" + 
        				"        				<br>\r\n" ;
        				if (mod.getIsGraded()==true)
        					html_tags += "<input type=\"checkbox\" name=\"graded\" value=\"true\" disabled= \"disabled\" checked> Graded\r\n";
        				else	
        					html_tags += "<input type=\"checkbox\" name=\"graded\" value=\"true\" disabled= \"disabled\"> Graded\r\n";
        				
        				html_tags+="          				<br>\r\n" + 
        				"          				<br>\r\n" ;
        				if(mod.getIsShuffled()==true)
        					html_tags += "<input type=\"checkbox\" name=\"shuffled\" value=\"true\" disabled= \"disabled\" checked >Shuffle answers \r\n";
        				else
        					html_tags += "<input type=\"checkbox\" name=\"shuffled\" value=\"true\"disabled= \"disabled\" >Shuffle answers \r\n";
        						
        					html_tags += "<br>\r\n" + 
        	 
        				"          				<br>\r\n" + 
        				"          				<label for=\"timeLimit\">Time Limit (in minutes): </label>\r\n" + 
        				"          				<input type=\"text\" name=\"timeLimit\" value="+ mod.getTimeLimit()+" readonly>\r\n" + 
        				"          				<br>\r\n";
        				if(mod.getIsMultipleAttempt() ==true)
        					html_tags+= "<input type=\"checkbox\" name=\"multipleAttempt\" value=\"true\" disabled= \"disabled\" checked >Multiple Attempts\r\n";
        					else
        						html_tags+= "<input type=\"checkbox\" name=\"multipleAttempt\" value=\"true\" disabled= \"disabled\">Multiple Attempts\r\n";
        						
        				html_tags+="     				<br>\r\n" + 
        				"          				<br>\r\n" + 
        				"          				<br>";
        			out.print(html_tags);
        			
        			%>
        			
        		 
  				<input type="submit" name="Action" value="View Questions"/> 
			</form>
		</div>
	</body>
</html>