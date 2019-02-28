<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page import="org.json.simple.JSONObject"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>
Quiz editor
</title>
<link rel="stylesheet" href="CSS/quizcreator.css" type="text/css"/>
<script src="js/quizcreator.js"></script>

</head>

<body>
<div id='top'>
<p><a href="loginpage.jsp" class='button' align:"right">logout</a></p>
</div>
<div id='mid'>
<form action="summarypage.jsp">
quiz title:<br>
<input type='text' name='title' value='enter the title'size=30><br>
course id:<br>
<input type='text' name='courseid' value='course id' size=30><br>
enter instructions:<br>
<input type='text' name='instructions' value='enter instructions'size=30><br>
enter the group of the quiz:<br>
<input type='text' name='group' value='group name' size=30><br>
shuffle:
<input type='checkbox' value='' onclick="hid.value=this.checked?1:0;alert(hid.value)" size=30><br>
<input type=hidden value=0 name="shuffle">
time limit:<br>
<input type='text' name='timelimit' value='time limit number of seconds' size=30><br>
data open:<br>
<input type='text' name='data_open' value='open time of this quiz' size=30><br>
data close:<br>
<input type='text' name='data_close' value='close time of this quiz' size=30><br>
quiz type:<br>

<select name="quiz_type">
<option value="quiz">quiz</option>
<option value="survey">survey</option>
</select>
<br>
attemps:<br>
<input type='text' name='attemps' value='attemps' size=30><br>

<div id='div1'>
</div>
<br><br>
<input type='button' onclick='addFields()' value='add question'>
<input id = "beginbtn" type="submit" value="Submit">

</form>
</div>
</body>
</html>
