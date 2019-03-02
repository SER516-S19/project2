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
	Your score is : <%out.println(session.getAttribute("grade")); %>
	<div class="container">
		<div class="row">
			<form class="col-sm-4" method="GET">
				<input class="button" type="submit" name="action" value="Logout" formaction="/Login" />
			</form>
		</div>
	</div>
</body>
</html>