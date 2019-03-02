<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Login</title>
<%@ include file="../header.jsp"%>
</head>
<body>
	<div class="container">
		<h2 class="bold">Welcome to Quiz Portal!!</h2>
		<form id="loginForm" class="form-group" action="Login" method="POST">
			<label for="Email"><b>Login Email *</b></label> <input type="text"
				class="form-control" placeholder="Enter your email"
				name="userEmail" id="Email" required><br>

			<label for="password"><b>Password *</b></label><br> <input
				type="password" class="form-control" placeholder="Enter Password"
				name="userPassword" id="password" required><br><br>
					
			<input class="btn-primary btn-lg" id="loginBtn" type="submit"
				value="Login" />
		</form>
	</div>
</body>
</html>