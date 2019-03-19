<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quizzes Posted</title>
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="row" align="center">
		<div class="col-md-12 details">
			<h2>Professor Details</h2>
			<hr>
		</div>
	</div>

	<div class="row" align="center">
		<div class="col-md-4 img"></div>
		<div class="col-md-2 img">
			<img width="200" height="200"
				src="http://www.amu.edu.my/wp-content/uploads/elementor/thumbs/human-icon-png-1901-nsw3vzn062myxv2c5um7jhue1g4pne8ojuq0c2wpyo.png"
				class="img-rounded">
		</div>
		<div class="col-md-3 details">
			<blockquote>
				<br>
				<h5>Professor ${sessionScope.userName}</h5>
				<small><cite title="Source Title">Arizona State	University<i class="icon-map-marker"></i>
				</cite></small>
			</blockquote>
			<p>
				${sessionScope.userEmail}<br> www.asu.edu.com <br>
			</p>
		</div>
		<div class="col-md-3 details">
			<a href="<%=request.getContextPath() %>/ProfessorController?flag=logout" class="btn btn-primary">Logout</a>
			<br>
		</div>
	</div>

	<div class="row" align="center">
		<div class="col-md-12 details">
			<hr>
			<h4>Select one to proceed</h4>
			<hr>
		</div>
	</div>
	<div class="row" align="center">
		<div class="col-md-12 details">
			<form action="ProfessorController" method="get">
				<input type="hidden" id="flag" name="flag" value="fetchQuizList">
				<input type="submit" value="Display Quiz List" class="btn btn-primary" style="width: 60%;" />
			</form>
			<br> <br> <a href="views/quizDetails.jsp"	class="btn btn-primary" style="width: 60%;">Create New Quiz </a>
		</div>
	</div>
</body>
</html>
