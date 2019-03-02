<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="Style.css">
<style>
body {
	font-family: Arial;
}

.tab {
	overflow: hidden;
	border: 1px solid #ccc;
	background-color: #f1f1f1;
}

.tab button {
	background-color: inherit;
	float: left;
	border: none;
	outline: none;
	cursor: pointer;
	padding: 14px 16px;
	transition: 0.3s;
	font-size: 17px;
}

.tab button:hover {
	background-color: #ddd;
}

.tab button.active {
	background-color: #ccc;
}

.tabcontent {
	display: none;
	padding: 6px 12px;
	border: 1px solid #ccc;
	border-top: none;
}
</style>
</head>
<body>
	<%
        String uName = (String) session.getAttribute("uName");
        String isSessionValid = (String) session.getAttribute("validSession");
        if (isSessionValid == null || isSessionValid.isEmpty() || !isSessionValid.equalsIgnoreCase("True")
                || uName == null || uName.isEmpty()) {
            response.sendRedirect("Login.jsp");
        }
    %>
	<ul>
		<li><a href="ProfessorDash.jsp">DASHBOARD</a></li>
		<li style="float:right">
			<div style="float: center">
				<form action="LoginController" method="post">
					<input type="hidden" name="action" value="logoff"> <input
						class="logoutonly" type="submit" value="LogOut" class="logout">
				</form>
			</div>
		</li>
	</ul>
	<form action="ProfessorController" method="post">
		<div class="form-group">
			<label for="q1">Question:</label> <input type="text"
				class="form-control" name="question" id="q1"
				placeholder="Enter your question">
		</div>
		<div class="form-group">
			<label for="a1">Answer1:</label> <input type="text"
				class="form-control" name="option1" id="a1"
				placeholder="Enter option1">
		</div>
		<div class="form-group">
			<label for="a2">Answer2:</label> <input type="text"
				class="form-control" name="option2" id="a2"
				placeholder="Enter option2">
		</div>
		<div class="form-group">
			<label for="a3">Answer3:</label> <input type="text"
				class="form-control" name="option3" id="a3"
				placeholder="Enter  option3">
		</div>
		<div class="form-group">
			<label for="a4">Answer4:</label> <input type="text"
				class="form-control" name="option4" id="a4"
				placeholder="Enter option4">
		</div>
		<div class="form-group">
			<label for="a5">Correct Answer:</label> <input type="text"
				class="form-control" name="correctanswer" id="a5"
				placeholder="Enter correct answer">
		</div>
		<div class="form-group">
			<label for="a6">Marks:</label> <input type="text"
				class="form-control" name="marks" id="a6" placeholder="Enter Marks">
		</div>
		<form action="ProfessorController" method="post">
			<input type="hidden" name="action" value="Continue"> <input
				class="btn btn-primary" type="submit" name="Continue"
				value="Continue">
		</form>
		<br/>
		<form action="ProfessorController" method="post">
			<input type="hidden" name="action" value="Submit"> 
			<input class="btn btn-primary" type="submit" name="Submit" value="Submit">
		</form>
	</form>
</body>
</html>
