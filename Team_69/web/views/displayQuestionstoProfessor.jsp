<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="js/getQuizList.js" type="text/javascript"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div id="accordion">

		<div>
			<center>
				<h3>${requestScope.quizName}</h3>
			</center>
		</div>

		<c:choose>
			<c:when test="${empty requestScope.queAnsData}">
				<blockquote class="blockquote text-center">
					<p class="mb-0" style="color: red">No Questions added.</p>
				</blockquote>
				<div></div>
				<blockquote class="blockquote text-center">
				<%
									String pathWebcontent = request.getContextPath();
								%> 
					<a href="<%=pathWebcontent %>/views/professorLanding.jsp">Home Page </a>
				</blockquote>

			</c:when>
			<c:otherwise>

				<c:forEach items="${requestScope.queAnsData}" var="question">
					<div class="card">
						<div class="card-header" id="heading${question[3]}">
							<h5 class="mb-0">
								<button class="btn btn-link" data-toggle="collapse"
									data-target="#collapse${question[3]}" aria-expanded="true"
									aria-controls="collapse${question[3]}">
									<c:out value="${question[0]}"></c:out>
								</button>
							</h5>
							
							<c:choose>
							<c:when test="${question[2][1].question.quiz.isPublished eq false}">
								<form action="../Team_69/ProfessorController" method="post">
									<input id="quesId" name="quesId" value="${question[2][1].question.questionId}" type="hidden">
									<input id="flagOld" name="flagOld" value="<%= request.getParameter("flag") %>" type="hidden">
									<!-- <input id="quizId" name="quizId" value="<%= request.getParameter("id") %>" type="hidden"> -->
									<input id="quizName" name="quizName" value="<%= request.getParameter("quizName") %>" type="hidden">
									<input id="quizId" name="quizId" value="${question[2][1].question.quiz.quizId}" type="hidden">
									<button type="submit" value="deleteQuestion" name="flag" class="btn btn-primary" >Delete</button>
									<button type="submit" value="editQuestion" name="flag" class="btn btn-primary">Edit</button>
								</form>	
							</c:when>
							<c:otherwise>
							</c:otherwise>
						</c:choose>
					</div>

						<div id="collapse${question[3]}" class="collapse show"
							aria-labelledby="heading${question[3]}" data-parent="#accordion">
							<div class="card-body">
								<c:forEach items="${question[2]}" var="answer">
									<c:choose>
										<c:when test="${answer.correctAnswer}">
											<p style="color: green">
												<c:out value="${answer.answer}"></c:out>
											</p>
										</c:when>
										<c:otherwise>
											<p style="color: red">
												<c:out value="${answer.answer}"></c:out>
											</p>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</div>
						</div>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>


</body>
</html>