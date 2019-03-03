<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<<<<<<< HEAD
<<<<<<< HEAD
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
=======
<<<<<<< HEAD
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
=======
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
>>>>>>> origin/master
=======
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
>>>>>>> origin/master
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="js/getQuizList.js" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div id="accordion">
<<<<<<< HEAD
<<<<<<< HEAD
		<%String pathWebcontent = request.getContextPath();%> 
=======
<<<<<<< HEAD

<<<<<<< HEAD
		<div> 
		<center><h1>${requestScope.quizName}</h1></center>
		</div>
		
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
				</div>
	
				<div id="collapse${question[3]}" class="collapse show"
					aria-labelledby="heading${question[3]}" data-parent="#accordion">
					<div class="card-body">
					<c:forEach items="${question[2]}" var="answer">
						<c:choose>
				   			<c:when test="${answer.correctAnswer}">
				   				<p style="color:green"><c:out value="${answer.answer}"></c:out></p>
				   			</c:when>
				   			<c:otherwise>
				     			<p style="color:red"><c:out value="${answer.answer}"></c:out></p>
				   			</c:otherwise>
						</c:choose>
					</c:forEach>
					</div>
				</div>
			</div>
		</c:forEach>

=======
=======
		<%String pathWebcontent = request.getContextPath();%> 
>>>>>>> e816bd85c7f60d681167d6025f653246953cb63e
>>>>>>> origin/master
=======
		<%String pathWebcontent = request.getContextPath();%> 
>>>>>>> origin/master
		<div>
			<center>
				<h3>${requestScope.quizName}</h3>
			</center>
		</div>
		
			<form action="ProfessorController" method="get">
				<input type="hidden" id="flag" name="flag" value="fetchQuizList">
				<input type="submit" value="Go Back"
					class="btn btn-primary" />
			</form>
			<br>

		<c:choose>
			<c:when test="${empty requestScope.queAnsData}">
				<blockquote class="blockquote text-center">
					<p class="mb-0" style="color: red">No Questions added.</p>
				</blockquote>
				<div></div>
				<blockquote class="blockquote text-center">
					<a href="<%=pathWebcontent %>/ProfessorController?flag=professorLanding" class="btn btn-primary">Home</a>
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
								<form action="<%=pathWebcontent %>/ProfessorController" method="post">
									<input id="quesId" name="quesId" value="${question[2][1].question.questionId}" type="hidden">
									<input id="flagOld" name="flagOld" value="<%= request.getParameter("flag") %>" type="hidden">
									<input id="quizName" name="quizName" value="<%= request.getParameter("quizName") %>" type="hidden">
									<input id="quizId" name="quizId" value="${question[2][1].question.quiz.quizId}" type="hidden">
									<button type="submit" value="deleteQuestion" name="flag" class="btn btn-danger" >Delete</button>
									<button type="submit" value="editQuestion" name="flag" class="btn btn-info">Edit</button>
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
		
		
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
=======
>>>>>>> e816bd85c7f60d681167d6025f653246953cb63e
>>>>>>> origin/master
=======
>>>>>>> origin/master
	</div>
</body>
</html>