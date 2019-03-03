<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="CSS/myquizzes.css" type="text/css"/>
<script type="text/javascript" src="js/myquizzes.js"></script>
<div id='top'>
<p><a href="index.html" class='button' align:"right">Logout</a></p>
</div>

<title>My Quizzes</title>
</head>
<body>
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
