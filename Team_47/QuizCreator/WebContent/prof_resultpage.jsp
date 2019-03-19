<%-- 
  - Author(s): Yu-Ting Tsao
  - Date: 2019/3/14
  - Description: Show a report of a quiz.
  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Result Page</title>
</head>
<body style="background-color: Silver;">
	<div style="text-align: center;">
		<h2 style="text-align: center;">Core Report</h2>
		<label>Quiz 1 </label><br> 
		<label class="noOfTotal">Total Number of students: 7 </label><br>
		<label>No.of.students attempted : </label> 
		<label class="noOfans"> 4 </label><br> 
		<label>No.of.students scored greater than 90% : </label>
		<label class="noOfUnans"> 2 </label><br>
		<label>No.of.students scored greater than 50% : </label>
		<label class="noOfUnans"> 3 </label><br><br>
		<form action="dashboard_professor.jsp">
			<input id="beginbtn" type="submit" value="Dashboard">
		</form>
	</div>
</body>
</html>
