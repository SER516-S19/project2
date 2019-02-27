<%-- 
  - Author(s): Yu-Ting Tsao
  - Date: 2019/2/20
  - Description: List all quizzes that can be taken by student.
  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="CSS/myquizzes.css" type="text/css" />
<script type="text/javascript" src="js/myquizzes.js"></script>
<title>My Quizzes</title>
</head>
<body>
	<div id="top">
		<a href="login.jsp" class="btn btn-default btn-sm"> <span
			class="glyphicon glyphicon-log-out"></span> Log out
		</a>
	</div>
	<div class="table-title">
		<h3>Quiz Summary</h3>
	</div>
	<div>
		<table class="table-fill" id="tableId">
			<thead>
				<tr>
					<th class="text-left">Quiz No.</th>
					<th class="text-left">Quiz Instruction</th>
				</tr>
			</thead>
			<tbody class="table-hover">
				<%=QuizList.createQuizSelectTable()%>
			</tbody>
		</table>
	</div>
</body>