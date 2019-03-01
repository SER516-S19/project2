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
<link rel="stylesheet" href="CSS/loginstyle.css" />
<link rel="icon" type="image/png" href="favicon.png" />
<title>Blackboard Login</title>
</head>
<body>
<form class="login-form" id="loginForm">
	<div class="login-page">
		<div class="form">
			<h2>Blackboard Login</h2>
				<input type="text" placeholder="username" id="username" required /> 
				<input type="password" placeholder="password" id="password" required />
				<!-- Servlet Version
				<input id="sub" type="submit" value="LOGIN" formmethod="post" formaction="/login" onsubmit="loginCheck()">
				-->
				<button type="submit" id="btnlogin" onclick="loginCheck()">login</button>	
			</div>
    	<div class="radio-group">
    		<input type="radio" name="identity" class="rd2" value="Student" checked>
			<label for="student">Student </label>
			<input type="radio" name="identity" class="rd1" value="Professor">
			<label for="professor">Professor </label>
    	</div>
	</div>
</form>
</body>
</html>