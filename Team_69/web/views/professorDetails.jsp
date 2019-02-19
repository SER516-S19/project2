<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script type=”text/javascript” src=”bootstrap/js/bootstrap.min.js”></script>
<title>Insert title here</title>
</head>
<body>
<form action="../ProffessorController" method="post">
  <div class="form-group">
  <label for="FormQuizName">Enter Quiz Name:</label>
  <textarea class="form-control" id="name" rows="1"></textarea>
   <br>
    
    <div class="form-group">
    <label for="FormQuizName">Enter Quiz Instructions:</label>
    <textarea class="form-control" id="instructions" rows="3"></textarea>
    <br>

    
<table border = "0">
  <tr>
    <td width="200px">Quiz Type : </td>
    <td width="800px">
    	<select name="quiz_type">
		  <option value="G">Graded Quiz</option>
		  <option value="U">Ungraded Quiz</option>
		</select>
    </td>
  </tr>
  <tr>
    <td>Assignment Group : </td>
    <td>
    	<select name="assignment_group">
		  <option value="G">Quizzes</option>
		  <option value="U">Assignment</option>
		</select>
    </td>
  </tr>
  <tr>
    <td></td>
    <td>
    	<b> Options </b>
    </td>
  </tr>
  
  <tr>
    <td></td>
    <td>
    	<input type="checkbox" name="shuffle" value="shuffle">Shuffle Answers<br>
    </td>
  </tr>
  
  <tr>
    <td></td>
    <td>
    	<input type="checkbox" name="time_limit" value="time_limit">Time Limit
		<input type="text" name="minutes" value=""> Minutes
    </td>
  </tr>
  
  
  <tr>
    <td></td>
    <td>
    	<input type="checkbox" name="attempts" value="attempts">Allow Multiple Attempts<br>
    </td>
  </tr>
  
</table>
    
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
  <input type="hidden" id="flag" name="flag" value="InsertProfDetails">
</form>
</body>
</html>