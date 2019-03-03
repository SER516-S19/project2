<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h3>Welcome! Please login.</h3>
	<form action="LoginController" method="post">
		<table>
			<tr>
				<td>UserName:</td>
				<td><input type="text" name="uName" aria-hidden="true"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"></td>
			<tr>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
		<input type="hidden" name="action" value="login">
	</form>
</body>
</html>