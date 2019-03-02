<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Login</title>
<%@ include file="/header.jsp"%>
</head>
<body>
	<div class="container">
		<h2 style="color: blue; text-align: center">Welcome to Quiz
			Portal!!</h2>
		<form id="loginForm" action="Login" method="POST">
			<div class="row">
				<label class="col-sm-2" for="Email"><b>UserEmail</b></label> <input
					class="col-sm-4" type="text" placeholder="Enter your email"
					name="userEmail" id="Email" required><br>
			</div>
			<label for="password"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="userPassword" id="password"
				required><br>

			<button id="submitBtn" type="submit">Login</button>
		</form>
	</div>
</body>
</html>
