<%@page import="com.asu.ser516.team47.database.*"%>
<%@page import="java.util.*"%>
<html>
<head>
<%
	QuizDAOImpl quizDAO = new QuizDAOImpl();
	QuestionDAOImpl questionDAO = new QuestionDAOImpl();
	ChoiceDAOImpl choiceDAO = new ChoiceDAOImpl();
	//get quiz id from previous page
	int quiz_id = Integer.parseInt(request.getParameter("quiz_id"));
	System.out.println(quiz_id);
	Quiz quiz = quizDAO.getQuiz(quiz_id);
	List<Question> questions =  questionDAO.getQuizQuestions(quiz.getQuiz_id());
%>
<title>Summary Page</title>
</head>
<body style="background-color:Silver;">
<h5><center>Summary Of Quiz created</center></h5>
<br>
<%
	out.print("<h7><center> Quiz title: " + quiz.getTitle() + "</center></h7><br>");
	out.print("<p><center> Quiz instruction: " + quiz.getInstructions() + "</center></p><br>");
	out.print("<p><center> quiz_group: " + quiz.getQuiz_group() + "</center></p><br>");
	out.print("<p><center> Shuffled: " + quiz.isShuffle() + "</center></p><br>");
	out.print("<p><center> Time_limit: " + quiz.getTime_limit()+ "</center></p><br>");
	out.print("<p><center> Date_open: " + quiz.getDate_open().toString()+ "</center></p><br>");
	out.print("<p><center> Date_close: " + quiz.getDate_close().toString()+ "</center></p><br>");
	out.print("<p><center> Quiz_type: " + quiz.getQuiz_type()+ "</center></p><br>");
	out.print("<p><center> Attemps: " + quiz.getAttempts()+ "</center></p><br>");
	out.print("<p><center> total_points: " + quiz.getTotal_points()+ "</center></p><br>");
	out.print("<br><br><br>");
	
	for(int i=1; i<=questions.size();i++){
		out.print("<h8><center> Question " +i+" : <br>"+ questions.get(i).getContent() + "</center></h7><br>");
		out.print("<p><center> Question type: " + questions.get(i).getQuesType()+ "</center></p><br><br>");
		//get choices based on the question id
		List<Choice> choices = choiceDAO.getQuestionChoices(questions.get(i).getQuestion_id());
		for(int j=0;j<choices.size();j++){
			char option = (char)(j + '0' + 16);
			out.print("<p><center>"+ option +" :"+ choices.get(j).getContent()+" </center></p><br>");
		}
		out.print("<p><center> Points: " + questions.get(i).getPoints()+ "</center></p><br><br>");
		out.print("<br><br>");
		
	}
%>
<br>
<br>

<br>


<br>





<input id = "beginbtn" type="button" value="Dashbaord" onclick='location.href=("dashboard_professor.jsp")'>


</body>
</html>