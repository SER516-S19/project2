<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%
	String dateTime = (String) session.getAttribute("startTime");
%>
<!DOCTYPE html>
<html>
<head>
	<title>Start your quiz</title>
	<link type='text/css' rel='stylesheet' href='../css/studentStyle.css' />
	<link rel="stylesheet" type="text/css"
		  href="https://fonts.googleapis.com/css?family=Open Sans" />
	<script type='text/javascript'
			src='https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js'></script>
	<script type='text/javascript' src='../js/student.js'></script>
</head>
<body>
<div id='container'>
	<div id = "ridge">
		<p id="quiz_name"></p>
	</div>
	<div>
		<p>Started at <%=dateTime %></p>
	</div>
	<div>
		<p id = "quiz_instructions" align = "left"></p>
	</div>

	<br />
	<div id='quiz'></div>
	<div class='button' id='next'>
		<a href='#'>Next</a>
	</div>
	<div class='button' id='prev'>
		<a href='#'>Prev</a>
	</div>
	<form name="submitForm" id="submitForm" action="" method="POST">
		<input type="hidden" name="data" value="Submit" id="finish" />
		<input type="submit" value="Submit" id="submitBtn"/>
	</form>
	</button>
</div>

</body>
</html>
