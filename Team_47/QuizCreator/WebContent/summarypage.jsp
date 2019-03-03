<%@page import="com.asu.ser516.team47.database.*"%>
<%@page import="java.util.*"%>
<%--
 - Author(s): Jiayan Wang
 - Date: 2019/3/1
 - Description: Show all quiz information.
 --%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/summary.css">
<%
	QuizDAOImpl quizDAO = new QuizDAOImpl();
	QuestionDAOImpl questionDAO = new QuestionDAOImpl();
	ChoiceDAOImpl choiceDAO = new ChoiceDAOImpl();
	//test-case
	//get quiz id from previous page
	int quiz_id = Integer.parseInt(request.getParameter("quizId"));
	Quiz quiz = quizDAO.getQuiz(quiz_id);
	String quiz_title = quiz.getTitle();
	List<Question> questions = questionDAO.getQuizQuestions(quiz.getQuiz_id());
%>
<title>Summary Page</title>
</head>
<body style="background-color: White;">

	<h2><center>Summary Of Quiz created</center></h2>
	<form action="quizstat.jsp" method="POST">
		<input type="text" name="Quiz_title" value=<%=quiz_title%> hidden=true>
		<input type="text" name="Quiz_id" value=<%=quiz_id%> hidden=true>	
		<center><input type="submit" name="Submit" value="<%= quiz_title%> Stat"></center>
	</form>
	<div>
		<%
			//create information of the quiz
			out.print("<h7><center> Quiz title: " + quiz.getTitle() + "</center></h7>");
			out.print("<p><center> Quiz instruction: " + quiz.getInstructions() + "</center></p>");
			out.print("<p><center> quiz_group: " + quiz.getQuiz_group() + "</center></p>");
			out.print("<p><center> Shuffled: " + quiz.isShuffle() + "</center></p>");
			out.print("<p><center> Time_limit: " + quiz.getTime_limit() + "</center></p>");
			out.print("<p><center> Date_open: " + quiz.getDate_open().toString() + "</center></p>");
			out.print("<p><center> Date_close: " + quiz.getDate_close().toString() + "</center></p>");
			out.print("<p><center> Quiz_type: " + quiz.getQuiz_type() + "</center></p>");
			out.print("<p><center> Attemps: " + quiz.getAttempts() + "</center></p>");
			out.print("<p><center> total_points: " + quiz.getTotal_points() + "</center></p>");
			out.print("<br><br>");
			//create all questions in this quiz
			for (int i = 0; i < questions.size(); i++) {
				int num = i + 1;
				out.print("<div id='questions'>");
				out.print("<h8><center><b> Question " + num + " : <br>" + questions.get(i).getContent()
						+ "</b></center></h7>");
				out.print("<p><center> <b>Question type: <span id='red'>" + questions.get(i).getQuesType()
						+ "</span></b></center></p>");
				//get choices based on the question id
				List<Choice> choices = choiceDAO.getQuestionChoices(questions.get(i).getQuestion_id());
				out.print("<div id='choices'>");
				//create all choices of this question.
				for (int j = 0; j < choices.size(); j++) {
					char option = (char) (j + '0' + 17);
					String checked = "";
					if(choices.get(j).isCorrect()){
						checked = "checked";
					}
					out.print("<p>");
					out.print("<label>");
					out.print("<input type='checkbox' "+ checked +"  onclick='return false' >");
					out.print("<span>" + option + " :" + choices.get(j).getContent()+"</span>");
					out.print("</label>");
					out.print("</p>");
					//out.print("<input type='checkbox' "+ checked +"><label><center>"
					//+ option + " :" + choices.get(j).getContent() + " </center></label>");
				}
				out.print("</div>");
				out.print("<p><center><b> Points: <span id='red'>" + questions.get(i).getPoints()
						+ "</span></b></center></p><br>");
				out.print("</div>");
				out.print("<br>");

			}
		%>
		<br> <br>
	</div>
	<input id="beginbtn" type="button" value="Dashbaord" onclick='location.href=("dashboard_professor.jsp")'>
</body>
</html>
