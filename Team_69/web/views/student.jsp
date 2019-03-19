<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<title>Start your quiz</title>
<%@ include file="../header.jsp"%>
<link type='text/css' rel='stylesheet' href='../css/bootstrap.min.css' />
<link type='text/css' rel='stylesheet' href='../css/studentStyle.css' />
<script type='text/javascript' src='../js/bootstrap.min.js'></script>
<script type='text/javascript' src='../js/student.js'></script>
</head>
<body>
	<div class="container">
		<div id="innerContainer">
			<div class="row" id="quizHead">
				<div class="col-md-6">
					<h1 id="quiz_name"></h1>
				</div>
				<div class="col-md-6">
					<%
						String dateTime = (String) session.getAttribute("startTime");
					%>
					<h4>Started at <%=dateTime%></h4>
				</div>
			</div>
			<h4 id="quiz_instructions" style="text-align:left;"></h4>

			<div id="questionDiv">
				<div id='quiz'></div>
				<div class='button' id='next'>
					<input type="button" class="btn btn-primary" value="Next"/>
				</div>
				<div class='button' id='prev'>
					<input type="button" class="btn btn-primary" value="Previous"/>
				</div>
				<form name="submitForm" id="submitForm" action="" method="POST">
					<input type="hidden" name="data" value="Submit" id="finish" /> <input
						type="hidden" name="action" value="submit" /> <input
						type="button" class="btn btn-success" value="Submit"
						id="submitBtn" />
					<div class="popup-display">
						<div class="popup-content">
							<p>Are you sure you want to submit this quiz?</p>
							<input class="close btn-success" type="submit" value="Yes"
								/> <input class="close btn-danger" type="button"
								value="No" />
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script>
    //script to be executed when the page loads
    $(document).ready(function() {
        $('#submitBtn').hide();
        studentResponseJSON = '<%=session.getAttribute("studentResponseJSON")%>';
			var studentResponseObj = JSON
					.parse(studentResponseJSON);
			if (!studentResponseObj.isPublished) {
				if (confirm("This quiz has not been published yet. Go back")) {
					history.go(-1);
				} else {
					history.go(-1);
				}
				return;
			}
			var hms = studentResponseObj.quizTimeLimit;
			var quizName = studentResponseObj.quizName;
			var quizInstruction = studentResponseObj.quizInstructions;
			document.getElementById("quiz_name").innerHTML = quizName;
			document.getElementById("quiz_instructions").innerHTML = quizInstruction;
			var a = hms.split(':');
			var seconds = (+a[0]) * 60 * 60 + (+a[1]) * 60
					+ (+a[2]);
			setInterval(function() {
				document.getElementById("submitForm").submit();
			}, seconds * 1000);
			displayQuiz(studentResponseObj);
		});

		//method to update JSON from user inputs
		function updateResponseJSON(studentResponseObj, selections) {
			for (var i = 0; i < studentResponseObj.question.length; i++) {
				responseAnswer = [];

				if (selections[i] != null) {
					selections[i]
							.forEach(function(Elem) {
								responseAnswer
										.push(studentResponseObj.question[i].availableAnswers[Elem]);
							});
					studentResponseObj.question[i].responseAnswer = responseAnswer;
				} else
					studentResponseObj.question[i].responseAnswer = [];
			}
			var studentResponse = JSON.stringify(studentResponseObj);

			//ajax call to update the session attribute on the server
			$.ajax({
				url : '',
				type : 'POST',
				data : {
					data : studentResponse,
					action : 'save'
				},
				success : (function() {
					console.log("Saved!!");
				})
			})
			document.getElementById("finish").value = studentResponse;
		}
	</script>
</body>
</html>

