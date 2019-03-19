<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
p {
  text-align: center;
  font-size: 60px;
}
</style>
<meta charset="ISO-8859-1">
<title>Quiz</title>
</head>
<body>

	<%@page import="Team76.Entity.Questions"%>
	<%@page import="java.util.List"%>
	<%
		String uName = (String) session.getAttribute("uName");
		String isSessionValid = (String) session.getAttribute("validSession");
		if (isSessionValid == null || isSessionValid.isEmpty() || !isSessionValid.equalsIgnoreCase("True")
				|| uName == null || uName.isEmpty()) {
			response.sendRedirect("Login.jsp");
		}
		List<Questions> questionArray;
		questionArray = (List) session.getAttribute("Question");
		String quizId = (String)session.getAttribute("quizId");
	%>
	<div>
		<form align="right" action="LoginController" method="post">
			<input type="hidden" name="action" value="logoff"> <input
				class="logout" type="submit" value="LogOut" class="logout">
		</form>
	</div>
	
<p id="demo"></p>




	<form name="Quiz" action="StudentController" method="GET">
		<div class="container">
			<div class="row" align="center">
				<div class="col-md"></div>
				<div class="col-md">
					<div class="form-check ">
						<%
							for (Questions que : questionArray) {
								String[] options = que.getOptions().split(",", 0);
						%>
						
						<h3><%=que.getQuestions()%></h3>
						<label for="<%=que.getQuestionId() + "a"%>"
							class="btn btn-outline-dark btn-block"><input
							type="radio" value="<%=options[0]%>" name="<%=que.getQuestionId()%>"
							id="<%=que.getQuestionId() + "a"%>" required> <%=options[0]%></label>
						<label for="<%=que.getQuestionId() + "b"%>"
							class="btn btn-outline-dark btn-block"><input
							type="radio" value="<%=options[1]%>" name="<%=que.getQuestionId()%>"
							id="<%=que.getQuestionId() + "b"%>" required> <%=options[1]%></label>
						<label for="<%=que.getQuestionId() + "c"%>"
							class="btn btn-outline-dark btn-block"><input
							type="radio" value="<%=options[2]%>" name="<%=que.getQuestionId()%>"
							id="<%=que.getQuestionId() + "c"%>" required> <%=options[2]%></label>
						<label for="<%=que.getQuestionId() + "d"%>"
							class="btn btn-outline-dark btn-block"><input
							type="radio" value="<%=options[3]%>" name="<%=que.getQuestionId()%>"
							id="<%=que.getQuestionId() + "d"%>" required> <%=options[3]%></label>
						<%
							}
						%>
					</div>
					<div class="row" style="margin: 15px;">
						<div class="col">
							<input type="submit" style="margin-left: 20px"
								class="btn btn-success btn-block" value="Submit Quiz"></input> <input
								type="hidden" name="action" value="SubmitQuiz">
							
						</div>
					</div>
				</div>
				<div class="col-md"></div>
			</div>
		</div>
<%session.setAttribute("questions", questionArray);
  session.setAttribute("quizId",quizId);%>
	</form>
	
	<script>
// Set the date we're counting down to
var min= <%=session.getAttribute("timeLimit")%>;
var countDownDate = new Date().getTime();
countDownDate = countDownDate + (min * 60 * 1000);
// Update the count down every 1 second
var x = setInterval(function() {
  // Get todays date and time
  var now = new Date().getTime();
    
  // Find the distance between now and the count down date
  var distance = countDownDate - now;
    
  // Time calculations for days, hours, minutes and seconds
  var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
  var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
  var seconds = Math.floor((distance % (1000 * 60)) / 1000);
    
  // Output the result in an element with id="demo"
  document.getElementById("demo").innerHTML = hours + "h "
  + minutes + "m " + seconds + "s ";
    
  // If the count down is over, write some text 
  if (distance < 0) {
    clearInterval(x);
    document.getElementById("demo").innerHTML = "EXPIRED";
    alert("Time Up");
    document.Quiz.submit();
  }
}, 1000);
</script>

</body>
</html>