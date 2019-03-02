<%@page import="com.asu.ser516.team47.database.*"%>
<%@page import="java.util.*"%>
<html>
<head>
<%
	QuizDAOImpl quizDAO = new QuizDAOImpl();
	QuestionDAOImpl questionDAO = new QuestionDAOImpl();
	ChoiceDAOImpl choiceDAO = new ChoiceDAOImpl();
	//test-case
	int quiz_id = 1;
	//get quiz id from previous page
	//int quiz_id = Integer.parseInt(request.getParameter("quiz_id"));
	System.out.println(quiz_id);
	Quiz quiz = quizDAO.getQuiz(quiz_id);
	System.out.println(quiz);
	List<Question> questions =  questionDAO.getQuizQuestions(quiz.getQuiz_id());
%>
<title>Summary Page</title>
</head>
<body style="background-color:Silver;">
<h2><center>Summary Of Quiz created</center></h2>
<%
	out.print("<h7><center> Quiz title: " + quiz.getTitle() + "</center></h7>");
	out.print("<p><center> Quiz instruction: " + quiz.getInstructions() + "</center></p>");
	out.print("<p><center> quiz_group: " + quiz.getQuiz_group() + "</center></p>");
	out.print("<p><center> Shuffled: " + quiz.isShuffle() + "</center></p>");
	out.print("<p><center> Time_limit: " + quiz.getTime_limit()+ "</center></p>");
	out.print("<p><center> Date_open: " + quiz.getDate_open().toString()+ "</center></p>");
	out.print("<p><center> Date_close: " + quiz.getDate_close().toString()+ "</center></p>");
	out.print("<p><center> Quiz_type: " + quiz.getQuiz_type()+ "</center></p>");
	out.print("<p><center> Attemps: " + quiz.getAttempts()+ "</center></p>");
	out.print("<p><center> total_points: " + quiz.getTotal_points()+ "</center></p>");
	out.print("<br><br>");
	
	for(int i=0; i<questions.size();i++){
		int num = i+1;
		out.print("<h8><center><b> Question " +num+" : <br>"+ questions.get(i).getContent() + "</b></center></h7>");
		out.print("<p><center> <b>Question type: " + questions.get(i).getQuesType()+ "</b></center></p><br>");
		//get choices based on the question id
		List<Choice> choices = choiceDAO.getQuestionChoices(questions.get(i).getQuestion_id());
		for(int j=0;j<choices.size();j++){
			char option = (char)(j + '0' + 17);
			out.print("<p><center>"+ option +" :"+ choices.get(j).getContent()+" </center></p>");
		}
		out.print("<p><center><b> Points: " + questions.get(i).getPoints()+ "</b></center></p><br>");
		out.print("<br>");
		
	}
%>
<br>
<br>

<br>


<br>





<input id = "beginbtn" type="button" value="Dashbaord" onclick='location.href=("dashboard_professor.jsp")'>


</body>
</html>