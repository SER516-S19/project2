<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<style>
	body {
		background: #2d343d;
	}

	.login-style {
		margin: 20px auto;
		width: 300px;
		padding: 30px 25px;
		background: white;
		border: 1px solid #c4c4c4;
	}

	h1.login-title {
		display: block;
		margin: -31px -25px 25px;
		padding-top: 50px !important;
		padding: 35px 30px;
		line-height: 30px;
		font-size: 25px;
		font-weight: 300;
		color: white;
		text-align: center;
		background: #000000;
	}

	.login-input {
		width: 285px;
		height: 50px;
		margin-bottom: 25px;
		padding-left: 10px;
		font-size: 15px;
		background: #fff;
		border: 1px solid #ccc;
		border-radius: 4px;
	}

	.login-input:focus {
		border-color: #6e8095;
		outline: none;	
	}

	.login-button {
		width: 100%;
		height: 50px;
		padding: 0;
		font-size: 20px;
		color: #fff;
		text-align: center;
		background: #720c0c;
		border: 0;
		border-radius: 5px;
		cursor: pointer;
		outline: 0;
	}

	.login-lost {
		text-align: center;
		margin-bottom: 0px;	
	}

	.login-lost a {
		color: #666;
		text-decoration: none;
		font-size: 13px;
	}
	</style>
</head>

<body>
	<h1 class="login-title">QUIZ APPLICATION LOGIN</h1>
	<form class="login-style" action="LoginController" method="post">
		<input type="text" class="login-input" name="uName"
			placeholder="Username" autofocus> <input type="password"
			class="login-input" name="password" placeholder="Password"> 
			<input type="hidden" name="action" value="login"> 
			<input type="submit" value="LOGIN" name="login" class="login-button">
	</form>
</body>

</html>