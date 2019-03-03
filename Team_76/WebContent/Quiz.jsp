<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quiz</title>
</head>
<body>
	<%@page import="Team76.Entity.Questions"%>
	<%@page import="java.util.List"%>
	<%
		String uName = (String) session.getAttribute("uName");
		String isSessionValid = (String) session.getAttribute("validSession");
		if (isSessionValid == null || isSessionValid.isEmpty() || !isSessionValid.equalsIgnoreCase("True")
				|| uName == null || uName.isEmpty()) {
			response.sendRedirect("Login.jsp");
		}
		List<Questions> questionArray;
		questionArray = (List) session.getAttribute("Question");
	%>
	<div>
		<form align="right" action="LoginController" method="post">
			<input type="hidden" name="action" value="logoff"> <input
				class="logout" type="submit" value="LogOut" class="logout">
		</form>
	</div>
	<form action="StudentController" method="GET">
		<div class="container">
			<div class="row" align="center">
				<div class="col-md"></div>
				<div class="col-md">
					<div class="form-check ">
						<%
							for (Questions que : questionArray) {
								String[] options = que.getOptions().split(",", 0);
						%>
						<h3><%=que.getQuestions()%></h3>
						<label for="<%=que.getQuestionId() + "a"%>"
							class="btn btn-outline-dark btn-block"><input
							type="radio" value="1" name="<%="options"+ que.getQuestionId()%>"
							id="<%=que.getQuestionId() + "a"%>" required> <%=options[0]%></label>
						<label for="<%=que.getQuestionId() + "b"%>"
							class="btn btn-outline-dark btn-block"><input
							type="radio" value="2" name="<%="options"+ que.getQuestionId()%>"
							id="<%=que.getQuestionId() + "b"%>" required> <%=options[1]%></label>
						<label for="<%=que.getQuestionId() + "c"%>"
							class="btn btn-outline-dark btn-block"><input
							type="radio" value="3" name="<%="options"+ que.getQuestionId()%>"
							id="<%=que.getQuestionId() + "c"%>" required> <%=options[2]%></label>
						<label for="<%=que.getQuestionId() + "d"%>"
							class="btn btn-outline-dark btn-block"><input
							type="radio" value="4" name="<%="options"+ que.getQuestionId()%>"
							id="<%=que.getQuestionId() + "d"%>" required> <%=options[3]%></label>
						<%
							}
						%>
					</div>
					<div class="row" style="margin: 15px;">
						<div class="col">
						<input type ="hidden" name = "action" value = "SubmitQuiz">
							<input type="submit" style="margin-left: 20px"
								class="btn btn-success btn-block">Submit</button>
						</div>
					</div>
				</div>
				<div class="col-md"></div>
			</div>
		</div>

	</form>
</body>
</html>