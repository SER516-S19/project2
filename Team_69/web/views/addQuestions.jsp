<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Questions</title>
</head>
<body>

<form method="Post" action="../ProfessorController">
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
	
	Enter points : 
	<input type="number" name="points" required>
	<br>
	<br>
	<input type="submit" name="flag" value="Add Next Question"/>
	<input type="submit" name="flag" value="Save and Exit"/>
	<%String pathWebcontent=request.getContextPath();%>
	<a href="<%=pathWebcontent %>/ProfessorController?flag=viewQuiz&id=${quiz.quizId}&quizName=${quiz.quizName}">View Quiz</a>
	
	
</form>
</body>
</html>