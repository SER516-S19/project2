<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String str = "../ProfessorController";
if(request.getAttribute("profnavigate") != null){
	str = (String) request.getAttribute("profnavigate");
}
out.write("<form method=\"Post\" action=" + str +">");
%>
    <p>Please add the question.</p>
	
	Question:
    <textarea name="question" rows="4" cols="50" required>
    </textarea>
	<br>
	<br>
    <label for="option1">Option 1</label>
    <input type="text" name="option1" required>
	<br>

    <label for="option2">Option 2</label>
    <input type="text" name="option2" required>
    <br>
    <label for="option3">Option 3</label>
    <input type="text" name="option3">
    <br>
    <label for="option4">Option 4</label>
    <input type="text" name="option4">
	<br>
	<br>
	<br>
	
	<input type="submit" name="flag" value="addQuestion"/>
	
	<%
	out.write("</form>");
	%>



</body>
</html>