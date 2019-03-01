<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="quiz.model.professor.Question"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%--
  JSP page that display questions of the quiz so that they can be updated
  @author (Sarthak Tiwari)
  @version (1.0)
  @createDate 28 Feb 2019
--%>
<!DOCTYPE html>
<html>

<head>
	<title>
		Quizlet - Update Questions
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
	<style>

	</style>
	<script type='text/javascript'>
		function addAnotherQuestion() {
			// Container <div> where dynamic content will be placed
			var container = document.getElementById("QuestionContainer");

			if (typeof addAnotherQuestion.counter == 'undefined') {
				<% ArrayList<Question> questions = (ArrayList) session.getAttribute("questions"); %>
				addAnotherQuestion.counter = <%=questions.size()%>;
			}
			addAnotherQuestion.counter++;

			var questionDiv = document.createElement("div");
			questionDiv.innerHTML = "<div id=\"question" + addAnotherQuestion.counter + "\">Question " + addAnotherQuestion.counter + ": <br /><br />" +
				"<textarea name=\"question" + addAnotherQuestion.counter + "\" rows=\"5\" cols=\"80\" placeholder=\"Enter your question here ! \"></textarea> <br />" +
				"Points: <input type=\"number\" style=\"width:40px; text-align: center\" name=\"PointsForQues" + addAnotherQuestion.counter + "\" value=\"1\" />" +
				"<input type=\"checkbox\" name=\"isMultipleAnswerQues" + addAnotherQuestion.counter + "\" value=\"True\" /> Is Multiple Answer <hr />" +
				"<div class=\"tablestyle\">" +
				"<table><tr><td>Option A:</td>" +
				"<td><input type=\"checkbox\" name=\"isOptionACorrectForQues" + addAnotherQuestion.counter + "\" value=\"True\" /> Correct Answer</td>" +
				"<td><input type=\"text\" name=\"OptionAForQues" + addAnotherQuestion.counter + "\" placeholder=\"Enter Option A\" /></td></tr>" +
				"<tr><td>Option B:</td>" +
				"<td><input type=\"checkbox\" name=\"isOptionBCorrectForQues" + addAnotherQuestion.counter + "\" value=\"True\" /> Correct Answer</td>" +
				"<td><input type=\"text\" name=\"OptionBForQues" + addAnotherQuestion.counter + "\" placeholder=\"Enter Option B\" /></td></tr>" +
				"<tr><td>Option C:</td>" +
				"<td><input type=\"checkbox\" name=\"isOptionCCorrectForQues" + addAnotherQuestion.counter + "\" value=\"True\" /> Correct Answer</td>" +
				"<td><input type=\"text\" name=\"OptionCForQues" + addAnotherQuestion.counter + "\" placeholder=\"Enter Option C\" /></td></tr>" +
				"<tr><td>Option D:</td>" +
				"<td><input type=\"checkbox\" name=\"isOptionDCorrectForQues" + addAnotherQuestion.counter + "\" value=\"True\" /> Correct Answer</td>" +
				"<td><input type=\"text\" name=\"OptionDForQues" + addAnotherQuestion.counter + "\" placeholder=\"Enter Option D\" /></td></tr>" +
				"<tr><td colspan=\"3\"><input type=\"button\" value=\"Remove Question\" onclick=\"removeQuestion(" + addAnotherQuestion.counter + ")\"/></td></tr>" +
				"</table></div><hr/></div>"

			container.appendChild(questionDiv);
		}

		function removeQuestion(i) {
			var element = document.getElementById("question" + i);
			element.parentNode.removeChild(element);
		}
	</script>
</head>

<body>
	</br>
	</br>
	<div class="pageheader">
		<p>Quizlet - Add Questions</p>
	</div>
	</br>
	<div class="formstyle">
		<form action="/Quiz/submitQuiz" method="POST" id="quizQuestionsDetailsForm">
			<div id="QuestionContainer">
				<%-- Display saved questions fetched by controller --%>
				<%
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
							<tr>
								<td colspan="3">
									<input type="button" value="Remove Question" onclick="removeQuestion(<%=i%>)" />
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
			<input type="button" class="btn btn-success" value="Add Another Question" onclick="addAnotherQuestion()" />
			<input type="submit" class="btn btn-info" value="Update Question(s)" />
		</form>
	</div>
</body>

</html>