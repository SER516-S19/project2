<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script type=”text/javascript” src=”bootstrap/js/bootstrap.min.js”></script>
<title>Page for obtaining Professor Details</title>
</head>
<body>
	<script type="text/javascript" src="../js/fetchProffesorData.js"></script>
	<script type="text/javascript">
	validateTimeCheckbox(elem)
</script>

	<form action="../ProfessorController" method="post">
		<div class="form-group">
			<label for="FormQuizName">Enter Quiz Name:</label>
			<textarea class="form-control" id="name" name="name" rows="1"
				required></textarea>
			<br> 
			<label for="FormQuizName">Enter Quiz Instructions:</label>
			<textarea class="form-control" name="instructions" id="instructions" rows="3"></textarea>
			<br>

			<table border="0">
				<tr>
					<td width="200px">Quiz Type :</td>
					<td width="800px"><select name="quiz_type" required>
						<option value="G">Graded Quiz</option>
						<option value="U">Ungraded Quiz</option>
					</select></td>
				</tr>
				<tr>
					<td>Assignment Group :</td>
					<td><select name="assignment_group" required>
						<option value="Q">Quizzes</option>
						<option value="A">Assignment</option>
					</select></td>
				</tr>
				<tr>
					<td></td>
					<td><b> Options </b></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="checkbox" name="shuffle" value="shuffle">Shuffle Answers<br></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="checkbox" name="time_limit"
						value="time_limit" onchange="validateTimeCheckbox(this);">Time
						Limit <input type="number" id="hours" name="hours" value=""
						min="0" readonly> Hours <input type="number" id="minutes"
						name="minutes" value="" min="0" max="60" readonly> Minutes
					</td>
				</tr>
			</table>
		</div>
		<input type="hidden" id="flag" name="flag" value="InsertQuizDetails">
		<button type="submit" class="btn btn-primary"
			onclick="javascript:checkBoxStatus(myCheckBox)">Submit</button>
	</form>
</body>
</html>