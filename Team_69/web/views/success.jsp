<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quiz Submitted</title>
<link type='text/css' rel='stylesheet' href='../css/studentStyle.css' />
<link type='text/css' rel='stylesheet' href='../css/bootstrap.min.css' />
<script type='text/javascript'
	src='https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js'></script>
<script type='text/javascript' src='../js/bootstrap.min.js'></script>
<script type='text/javascript' src='../js/student.js'></script>
</head>
<body>
	Your response has been successfully recorded!!
	<div class="container">
		<div class="row">
			<form class="col-sm-4" method="GET">
				<input class="button" type="submit" name="action" value="Logout" formaction="/Login" />
			</form>
		</div>
	</div>
</body>
</html>