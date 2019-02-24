<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%--
  JSP page that display list of saved quizes with options such as Go to quiz, delete quiz, 
  update quiz and add more quizes
--%>
<!DOCTYPE html>
<html>
<head>
<head>
<link rel="stylesheet" type="text/css"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/cosmo/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Josefin+Sans"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
	background-color: #F7F7F7;
}

.header {
	padding: 5px;
	text-align: center;
	background: transparent;
	color: #000000;
	font-size: 50px;
	font-family: 'Josefin Sans', sans-serif;
}
</style>
</head>
<meta charset="ISO-8859-1">
<title>Quiz!</title>
</head>
<body>
	</div>
	</br>
	</br>
	<div class="header">
		<p>My quizes!</p>
	</div>
	<br />
	<br />
	<div class="container-fluid">
		<!-- <div class="form-row text-center"> -->
		<div class="form-group">
			<form name="add_name" id="add_name" action="/Quiz/QuizAction"
				method="POST">
				<div class="table-responsive">
					<div class="d-flex justify-content-center">
						<table class="table table-bordered" id="dynamic_field"
							style="width: 650px">
							<tr>
								<td><button type="submit" name="actonToPerform" id="add"
										class="btn btn-success" value="add">
										<i class="fas fa-plus"></i> Click Here to Add More Quiz options
									</button></td>
							</tr>
							<tr>
								<td>
									<%-- Display saved quizes list fetched by controller --%>
									<%
										ArrayList rowValues = (ArrayList) session.getAttribute("rowValues");

										int i = 0;
									%> <select id="mySelect" name="selectedQuiz" />
									<option>---------------------SELECT--------------------</option>
									<%
										while (i < rowValues.size())

										{
									%>
									<option value="<%=rowValues.get(i)%>" /><%=rowValues.get(i)%>
									<%
										i++;
										}
									%>

								</td>
								<td><button type="submit" name="actonToPerform" id="go"
										value="go" class="btn btn-primary">
										<i class="fas fa-arrow-right"></i> Go To Quiz
									</button></td>
								<td><button type="submit" name="actonToPerform" id="delete"
										value="delete" class="btn btn-danger">
										<i class="fas fa-trash-alt">Delete</i>
									</button></td>
								<td><button type="submit" name="actonToPerform" id="update"
										value="update" class="btn btn-warning">
										<i class="fas fa-pen"></i> Update
									</button></td>
							</tr>
						</table>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>