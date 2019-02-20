<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!-- TODO:the import path-->
<%@ page language="java" import="com.servlet.*"%>
<!DOCTYPE html>
<html>
<style type = "text/css">

body {
	background:#FAFAD2;
}

#content {
	margin: auto;
    position: absolute;
    top: 50px;
    left: 50px;
    right: 50px;
    bottom: 50px;
    border-style: solid; 
}

#content #title {
	margin: auto;
	position: absolute;
	top: -400px;
    left: 0px;
    right: 340px;
    bottom: 0;
}

#content #instruc{
	width:500px;
	height:200px;
}

#content #instrcu_all{
	position: absolute;
	margin: auto;
	top: 100px;
    left: 200px;
    right: 0;
    bottom: 0;
}

#content #attemp
{
	position: absolute;
	margin: auto;
	top: 400px;
    left: 200px;
    right: 0px;
    bottom: 0px;
}


</style>
<head>
<meta charset="UTF-8">
<title>Instruction</title>
</head>
<body>
<script>
	function changeCheck(){
		document.getElementById("multiAttemps").checked = true;
	}
</script>
<%
	//String title = session.getAttribute("title");
	String title = "TestTitle";
	String instruction = "Testinstruction";
	String type = "Type";
	boolean mulAttemp = true;
%>
<div id = "content">

<input id = "title" type = "text" value="sssssssssss" disabled="disabled">

<div id ="instrcu_all">
<p>Quiz Instruction</p>
<input id = "instruc"type = "text" value="<%=instruction %>" disabled="disabled">
</div>

<label id="attemp">
<input id = "multiAttemps" type="checkbox" checked = "<%=mulAttemp %>" onclick="return false;">
Allow Multiple Attemps
</label>

</div>
</body>
</html>