<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quiz Submitted</title>
<%@ include file = "/header.jsp" %>
</head>
<body>
	Your response has been successfully recorded!! <br/>
	<% int score = (int) session.getAttribute("grade"); 
	if(score ==-1)
		out.println("We are currently processing your grades. Check back later!!");
	else
		out.println("Your score is : "+score);
	%>
	
	<div class="container">
		<div class="row">
			<form class="col-sm-4" method="GET">
				<input class="button" type="submit" name="action" value="Logout" formaction="Login" />
			</form>
		</div>
	</div>
</body>
</html>