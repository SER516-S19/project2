<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>
Quiz editor
</title>
<link rel="stylesheet" href="CSS/quizcreator.css" type="text/css"/>
<script src="JS/quizcreator.js"></script>
</head>
<body>
<div id='top'>
<p><a href="loginpage.jsp" class='button' align:"right">logout</a></p>
</div>
<div id='mid'>
<form>
quiz title:</br>
<input type='text' name='title' value='enter the title'size=30></br>
enter instructions:</br>
<input type='text' name='instructions' value='enter instructions'size=30></br>
enter the group of the quiz:</br>
<input type='text' name='group' value='group name' size=30></br>
<div id='div1'>
</div>
<input type='button' onclick='addFields()' value='add question'>
<input type='submit' value='save'>
<input type='button' onclick='summary.html' value='summa'>
</form>
</div>
</body>
</html>