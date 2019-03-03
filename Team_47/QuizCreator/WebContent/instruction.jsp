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


<input id = "title" type = "text" value="Quiz 1" disabled="disabled">

	<div class ="instruction_area">
	<p>Quiz Instruction</p>
	<input id = "instruction"type = "text" value="<%=title %>" disabled="disabled">
	</div>



<!--  input id = "mulbtn" type="<%=mulbutton %>" value="retake">
<label id="attemp">
<input id = "multiAttemps" type="checkbox" checked = "<%=temp %>" onclick = "return false">
Allow Multiple Attemps
</label>
<input id = "beginbtn" type="button" value="Begin Quiz" onclick='location.href=("questions.jsp")'>
<input id = "mulbtn" type="<%=mulbutton %>" value="retake">
<label id="attemp">
	<!-- nput id = "multiAttemps" type="checkbox" checked = "<%=temp %>" onclick = "return false">
	Allow Multiple Attemps
	</label -->

	


<div class="bottom">

	
	<input id = "beginbtn" type="button" value="Begin Quiz" onclick='location.href=("questions.jsp")'>
</div>

</div>
</body>
</html>
