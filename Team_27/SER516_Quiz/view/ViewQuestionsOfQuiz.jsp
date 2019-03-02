<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="quiz.model.professor.Question"%>
<%@page import="quiz.model.professor.QuizModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%--
  JSP page that display questions of the quiz
  @author (Sarthak Tiwari)
  @version (1.0)
  @createDate 28 Feb 2019
--%>
<!DOCTYPE html>
<html>

<head>
	<title>
		Quizlet - View Questions
	</title>
	<link rel="stylesheet" type="text/css" href="addQuestionscss/addQuestionsStyles.css">
	<link rel="stylesheet" type="text/css"
		href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/cosmo/bootstrap.min.css">
	<link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
		integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>
	</br>
	</br>
	<div class="pageheader">
		<p>Quizlet - View Questions</p>
	</div>
	</br>
	<div class="formstyle">
		<div id="QuestionContainer">
			<%-- Display saved questions fetched by controller --%>
			<%
				ArrayList<Question> questions = (ArrayList) session.getAttribute("questions");
				int i = 1;
								
				while (i <= questions.size())
				{
			%>
			<div id="question<%=i%>">
				Question <%=i%>: <br /><br />
				<textarea name="question<%=i%>" rows="5" cols="80"><%=questions.get(i-1).getQuestion()%></textarea>
				<br />
				Points: <input type="number" style="width:40px; text-align: center" name="PointsForQues<%=i%>"
					value="<%=questions.get(i-1).getPoints()%>" />
				<input type="checkbox" name="isMultipleAnswerQues<%=i%>" value="True"
					<%=questions.get(i-1).getIsMultipleAnswer()?"checked":""%> /> Is Multiple Answer
				<hr />
				<div class="tablestyle">
					<table>
						<tr>
							<td>
								Option A: &nbsp;
							</td>
							<td>
								<input type="checkbox" name="isOptionACorrectForQues<%=i%>" value="True"
									<%=questions.get(i-1).getIsOptionACorrect()?"checked":""%> /> Correct
								Answer &nbsp;
							</td>
							<td>
								<input type="text" name="OptionAForQues<%=i%>"
									value="<%=questions.get(i-1).getOptionA()%>" />
							</td>
						</tr>

						<tr>
							<td>
								Option B:
							</td>
							<td>
								<input type="checkbox" name="isOptionBCorrectForQues<%=i%>" value="True"
									<%=questions.get(i-1).getIsOptionBCorrect()?"checked":""%> /> Correct
								Answer
							</td>
							<td>
								<input type="text" name="OptionBForQues<%=i%>"
									value="<%=questions.get(i-1).getOptionB()%>" />
							</td>
						</tr>

						<tr>
							<td>
								Option C:
							</td>
							<td>
								<input type="checkbox" name="isOptionCCorrectForQues<%=i%>" value="True"
									<%=questions.get(i-1).getIsOptionCCorrect()?"checked":""%> /> Correct
								Answer
							</td>
							<td>
								<input type="text" name="OptionCForQues<%=i%>"
									value="<%=questions.get(i-1).getOptionC()%>" />
							</td>
						</tr>

						<tr>
							<td>
								Option D:
							</td>
							<td>
								<input type="checkbox" name="isOptionDCorrectForQues<%=i%>" value="True"
									<%=questions.get(i-1).getIsOptionDCorrect()?"checked":""%> /> Correct
								Answer
							</td>
							<td>
								<input type="text" name="OptionDForQues<%=i%>"
									value="<%=questions.get(i-1).getOptionD()%>" />
							</td>
						</tr>
					</table>
				</div>
				<hr />
			</div>
			<%
				i++;
				}
			%>
		</div>
	</div>

	<table>
		<tr>
			<td>
				<form action="/Quiz/getQuiz" class="formstyle">
					<input type="submit" value="Go back to Quiz List" />
				</form>
			</td>
			<td>
				<form action="/Quiz/QuizAction" class="formstyle" method="POST">
					<input type="hidden" id="selectedQuiz" name="selectedQuiz" value="<%=session.getAttribute("quizTitle")%>">
					<button type="submit" name="actonToPerform" id="update" value="update" class="btn btn-warning">
						<i class="fas fa-pen"></i> Update Quiz
					</button>
				</form>
			</td>
		</tr>
	</table>
</body>

</html>