<%-- 
  - Author(s): Krishna Chandu Akula, Yu-Ting Tsao, Venkata Sai Ram Eadala
  - Date: 2019/2/18
  - Description: Login page for both the professor and students.
  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="js/validatelogin.js"></script>
<link rel="stylesheet" href="CSS/login_Style.css" />
<link rel="icon" type="image/png" href="favicon.png" />
<title>Blackboard Login</title>
</head>
<body>
	<div class="Options">
		<form>
			<input type="radio" name="hello" class="rd2" value="Student" checked>Student
			<input type="radio" name="hello" class="rd1" value="Professor">
			Professor
		</form>
	</div>
	<div class="login-page">
		<div class="form">
			<form class="login-form" action="LoginServlet" method="POST" class="form" id="loginForm">
				<h3>Login</h3>
					<input type="text" placeholder="username" id="email" required />
					<input type="password" placeholder="password" id="password" required />
					<button type="submit" id="btnlogin" onClick="onBtnClick()">login</button>
			</form>
		</div>
	</div>
</body>
</html>