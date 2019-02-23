<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!-- TODO:the import path-->
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="css/Instruction.css" type="text/css">
<script type="text/javascript" src = "instruction.js"></script>

<head>
<meta charset="UTF-8">
<title>Instruction</title>
</head>
<body>
<%
	//String title = session.getAttribute("title");
	String title = "TestTitle";
	String instruction = "Testinstruction";
	String type = "Type";
	boolean mulAttemp = true;
	String mulbutton = "button";
%>
<div id = "content">

<input id = "title" type = "text" value="Title" disabled="disabled">

<div id ="instrcu_all">
<p>Quiz Instruction</p>
<input id = "instruc"type = "text" value="<%=instruction %>" disabled="disabled">
</div>

<label id="attemp">
<input id = "multiAttemps" type="checkbox" checked = "<%=mulAttemp %>" onclick = "return false">
Allow Multiple Attemps
</label>

<input id = "mulbtn" type="<%=mulbutton %>" value="retake">
<input id = "beginbtn" type="button" value="Begin" onclick='location.href=("questions.jsp")'>

</div>
</body>
</html>