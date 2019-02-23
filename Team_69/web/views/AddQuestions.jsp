<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Questions</title>
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
    <textarea name="question" rows="6" cols="50" required>
    </textarea>
	<br>
	<br>
	Answer?:
	<input type="checkbox" name="options" value="option1">
	<br>
    <label for="option1">Option 1: </label>
    <textarea type="text" name="option1" rows="2" cols="50" required>
	</textarea>
	<br>

	Answer?:
	<input type="checkbox" name="options" value="option2">
	<br>
    <label for="option2">Option 2: </label>
    <textarea type="text" name="option2" rows="2" cols="50" required>
    </textarea>
    <br>
    
    Answer?:
    <input type="checkbox" name="options" value="option3">
	<br>
    <label for="option3">Option 3: </label>
    <textarea type="text" name="option3" rows="2" cols="50">
    </textarea>
    <br>
    
    Answer?:
    <input type="checkbox" name="options" value="option4">
	<br>
    <label for="option4">Option 4: </label>
    <textarea type="text" name="option4" rows="2" cols="50">
	</textarea>
	<br>
	<br>
	<br>
	
<%
String quizType = (String) session.getAttribute("quizType");
if(("G").equals(quizType)){
	out.write("Enter points : ");
	out.write("<input type=\"number\" name=\"points\" required>");
}
%>
	<br>
	<br>
	<input type="submit" name="flag" value="Add Next Question"/>
	<input type="submit" name="flag" value="Save and Exit"/>
	<input type="submit" name="flag" value="Verify Questions"/>
	
	<%
	out.write("</form>");
	%>
</body>
</html>