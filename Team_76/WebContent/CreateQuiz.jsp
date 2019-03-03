<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="Style.css">
<style>
.dropbtn {
	background-color: #720c0c;
	color: white;
	padding: 16px;
	font-size: 16px;
	border: none;
}

.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f1f1f1;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown:hover .dropbtn {
	background-color: #961212;
}
</style>
</head>

<body>
	<%
		String uName = (String) session.getAttribute("uName");
		String isSessionValid = (String) session.getAttribute("validSession");
		if (isSessionValid == null || isSessionValid.isEmpty() || !isSessionValid.equalsIgnoreCase("True")
				|| uName == null || uName.isEmpty()) {
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Cache-Control", "no-store");
			response.setHeader("Pragma", "no-cache");
			response.setDateHeader("Expires", 0);
			session.invalidate();
			response.sendRedirect("Login.jsp");
		}
	%>
	<ul>
		<li><a>DETAILS PAGE</a></li>
		<li><a href="ProfessorDash.jsp">DASHBOARD</a></li>
		<li style="float: right">
			<div style="float: center">
				<form action="LoginController" method="post">
					<input type="hidden" name="action" value="logoff"> <input
						class="logoutonly" type="submit" value="LogOut" class="logout">
				</form>
			</div>
		</li>
	</ul>

	<p>QUIZ TITLE</p>

	<div>
		<form action="ProfessorController" method="post">
			<input type="text" name="quiztitle" required
				placeholder="Input quiztitle">
			<p>QUIZ INSTRUCTIONS</p>
			<textarea name="qinstruct" required rows="20" cols="100"></textarea>
			<p>SELECT THE QUIZ TYPE</p>
			<div class="dropdown">
				<select name="qtype">
					<option class="dropbtn" value="Graded" selected>Graded</option>
					<option class="dropbtn" value="NonGraded">NonGraded</option>
				</select>
			</div>
			<br> <br>
			<div class="otherdetails">
				<input type="radio" name="shuffleAns" required value="Shuffle">Shuffle
				Answers<br>
				<p>OPTIONS
				<p>
					<input type="checkbox" name="timeOp1" value="T1">Timed<br>
					<input type="checkbox" name="timeOp2" value="T2">Not Timed
					(Practice Mode)
			</div>
	</div>
	<br>
	<form action="ProfessorController" method="post">
		<input type="hidden" name="action" value="Continue1"> <input
			type="submit" value="CONTINUE">
	</form>
	<form action="ProfessorController" method="post">
		<input type="hidden" name="action" value="Cancel"> <input
			type="submit" value="CANCEL">
	</form>
	</form>
	</div>
</body>
</html>
