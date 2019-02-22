<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src = "js/myquizzes.js"></script>
<title>My Quizzes</title>
</head>
<body>

	<table width="60%" border="1">
		<thead>
			<tr>
				<td>Quiz No.</td>
				<td>Quiz Instruction</td>
			</tr>
		</thead>
		<tbody>
<%= QuizList.createQuizSelectTable() %>
		</tbody>
	</table>

</body>
</html>