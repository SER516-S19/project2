<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@page import="model.*"%>

<!-- TODO:the import path-->
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="CSS/instruction.css" type="text/css">
<script type="text/javascript" src = "instruction.js"></script>
<% 
	boolean temp = true;
	String mulbutton = "hidden";
	if(temp){
		mulbutton = "button";
	}
	String title = "title";
%>
<head>
<meta charset="UTF-8">
<title>Instruction</title>
</head>
<body>
<div class = "content">

	<input id = "title" type = "text" value="Title" disabled="disabled">

	<div class ="instruction_area">
	<p>Quiz Instruction</p>
	<input id = "instruction"type = "text" value="<%=title %>" disabled="disabled">
	</div>

<div class="bottom">

	<label id="attemp">
	<input id = "multiAttemps" type="checkbox" checked = "<%=temp %>" onclick = "return false">
	Allow Multiple Attemps
	</label>
	
	<input id = "mulbtn" type="<%=mulbutton %>" value="retake">
	<input id = "beginbtn" type="button" value="Begin" onclick='location.href=("questions.jsp")'>
</div>

</div>
</body>
</html>