<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quiz Submitted</title>
<%@ include file="../header.jsp"%>
<link type='text/css' rel='stylesheet' href='../css/bootstrap.min.css' />
<link type='text/css' rel='stylesheet' href='../css/studentStyle.css' />
<script type='text/javascript' src='../js/bootstrap.min.js'></script>
</head>
<body>


	<div class="container">
		<h2>Your response has been successfully recorded!!</h2>
		<div class="innerContainer">
			<%
					float score = (float) session.getAttribute("grade");
					if (score == -1)
						out.println("<h4>We are currently processing your grades. Check back later!!</h4>");
					else
						out.println("<h4>Your score is : <b>" + score + "</b></h4>");
			%>
				<form class="col-sm-4" method="GET">
					<%
						String pathWebContent = request.getContextPath();
					%>
					<input id="logoutBtn" class="btn btn-primary" type="submit" name="action"
						value="Logout" formaction="<%=pathWebContent%>/Login" />
				</form>
		</div>
	</div>
</body>
</html>