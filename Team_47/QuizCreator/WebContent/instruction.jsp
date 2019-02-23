<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@page import="model.*"%>

<!-- TODO:the import path-->
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="CSS/instruction.css" type="text/css">
<script type="text/javascript"></script>
<% 
	boolean temp = true;
	String mulbutton = "hidden";
	if(temp){
		mulbutton = "button";
	}
	String title = "The maximum time for quiz is 30 minutes.  No partial grading is avaialable";
		
%>
<head>
<meta charset="UTF-8">
<title>Instruction</title>
</head>
<body>
<div class = "content">

<<<<<<< HEAD
<input id = "title" type = "text" value="Quiz 1" disabled="disabled">
=======
	<input id = "title" type = "text" value="Title" disabled="disabled">
>>>>>>> d8b4129278408b13fc8afcd9099ee1d424a0c0d1

	<div class ="instruction_area">
	<p>Quiz Instruction</p>
	<input id = "instruction"type = "text" value="<%=title %>" disabled="disabled">
	</div>

<<<<<<< HEAD

<!--  input id = "mulbtn" type="<%=mulbutton %>" value="retake"> 
<label id="attemp">
<input id = "multiAttemps" type="checkbox" checked = "<%=temp %>" onclick = "return false">
Allow Multiple Attemps
</label>

-->
<input id = "beginbtn" type="button" value="Begin Quiz" onclick='location.href=("questions.jsp")'>
=======
<div class="bottom">

	<label id="attemp">
	<input id = "multiAttemps" type="checkbox" checked = "<%=temp %>" onclick = "return false">
	Allow Multiple Attemps
	</label>
	
	<input id = "mulbtn" type="<%=mulbutton %>" value="retake">
	<input id = "beginbtn" type="button" value="Begin" onclick='location.href=("questions.jsp")'>
</div>
>>>>>>> d8b4129278408b13fc8afcd9099ee1d424a0c0d1

</div>
</body>
</html>