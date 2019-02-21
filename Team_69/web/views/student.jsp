<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Student View</title>
	<link href="../css/static/bootstrap.min.css" rel="stylesheet">
	<link href="../css/static/studentStyle.css" rel="stylesheet">
	<script src="../js/static/jquery.min.js"></script>
	<script src="../js/static/bootstrap.min.js"></script>
	<script src="../js/student.js"></script>
</head>
<body>
	<div class="container">
		<div class="question" id="q_1">
			<p>Full Question</p>
			<table class="table table-bordered">
				<tbody>
					<tr>
						<td><input type="radio" name="ans1" value="answer1">
							Answer1</td>
					</tr>
					<tr>
						<td><input type="radio" name="ans1" value="answer2">
							Answer2</td>
					</tr>
					<tr>
						<td><input type="radio" name="ans1" value="answer3">
							Answer3</td>
					</tr>
					<tr>
						<td><input type="radio" name="ans1" value="answer4">
							Answer4</td>
					</tr>
				</tbody>
			</table>
		</div>

		<div class="question" id="q_2">
			<p>Full Question2</p>
			<table class="table table-bordered">
				<tbody>
					<tr>
						<td><input type="radio" name="ans2" value="answer1">
							Answer1</td>
					</tr>
					<tr>
						<td><input type="radio" name="ans2" value="answer2">
							Answer2</td>
					</tr>
					<tr>
						<td><input type="radio" name="ans2" value="answer3">
							Answer3</td>
					</tr>
					<tr>
						<td><input type="radio" name="ans2" value="answer4">
							Answer4</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	
	<div class="submitDiv">
		<button type="button" onclick="submitQuiz()" class="btn btn-primary">Submit</button>
	</div>
	<script>
	$(document).ready(function() {
		var autoSaveInterval = setInterval(autoSave, 2000);
	});
	
	function autoSave(){
		console.log("Saved!");
		
		var questionContainers = $(".question");
		for(var i = 0; i<questionContainers.length; i++){
			var questionID = questionContainers[i].id;
			var ansElems = questionContainers[i].getElementsByTagName("input");
			for(var j = 0; j<ansElems.length; j++){
				if(ansElems[j].checked){
					console.log(questionID + ": " + ansElems[j].value);
					//Save in session or temp Table?
				}
			}
		}
	}
	
	function submitQuiz(){
		autoSave();
		//Send session data to controller
	}
	</script>
</body>
</html>