
<%--
 - Author(s): Krishna Chandu Akula
 - Description: Displays questions and answers of quiz.
 - 				student can answer the questions and submit the quiz.
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.asu.ser516.team47.database.*"%>
    <%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="CSS/questions.css" type="text/css"/>
<title>Sample Question Style</title>
</head>
<form>
<body style="background-color:#FFF8DC">
	<div class="head-section">
	<h2>Quiz 1</h2>
	<% java.text.DateFormat df = new java.text.SimpleDateFormat("MMM dd 'at' hh:mm a"); %>
	<h5>Started: <%= df.format(new java.util.Date()) %> </h5>
	<h2>Quiz Instructions</h2>
	</div>
	<%

    Cookie[] cookies = request.getCookies();
    Cookie cookie = null;
    String 	enrolled_id = "";
    String user_name ="";
    for (int i = 0; i < cookies.length; i++) {
        cookie = cookies[i];
        if(cookie.getName().equals("session-user")){
        	user_name = cookie.getValue();
        	break;
        }
        
     }
    if(user_name.length()>0){
     List<Enrolled> enrolled=new EnrolledDAOImpl().getStudentEnrollment(user_name);
     if(enrolled.size()>0)
     enrolled_id=String.valueOf(enrolled.get(0).getEnrolled_id());
     else
     	enrolled_id = "1";
    }
    else{
    	enrolled_id = "1";
    }
  	Object quizid =  request.getSession().getAttribute("quizid");
	String quizid1= String.valueOf(quizid);
  	
	String 	enrolled_id1  = String.valueOf(enrolled_id);
	String HTMLContent = "";
	String content="";
 	StringBuilder buf = new StringBuilder();
 	List<Question> questionList=new QuestionDAOImpl().getQuizQuestions(Integer.parseInt(quizid1));

	for(int i=0;i<questionList.size();i++){
		buf.append(String.format(
	 			"<div class=\"question-board\">"));
		Question ques=questionList.get(i);
		List<Choice> choiceList = new ChoiceDAOImpl().getQuestionChoices(ques.getQuestion_id());
		buf.append(String.format(
	 			"<div class=\"question-top-area\">"+
				"<h3 class=\"question_num\">Question"+"%s"+"</h3>"+
				"<h4>%s pts</h4>"+
			"</div>"+
	 			"<div class=\"question-title\""+" id=q-"+"%s>"+
				"%s"+"</div>",String.valueOf(i+1),String.valueOf(ques.getPoints()),String.valueOf(i+1),ques.getContent()));

		buf.append(String.format("<div class=\"selection-area\">"));
	 	 content=ques.getContent();
	 	for(int j=0;j<choiceList.size();j++){
	 		Choice choiceval= choiceList.get(j);


	 	buf.append(String.format(

				"<input type=\"checkbox\" name=\"myAnswer\" value=\"%s\">"+
						"<label  class=\"option1\">%s"+
				"</label>"+"<hr>"
                ,String.valueOf(choiceval.getChoice_id()),choiceval.getContent()));
			}
	 	buf.append("</div>");
	 	buf.append("</div>");

	}

	String html = buf.toString();

	 %>
	 	<%=html
	 	%>


	<!--  <div style="height:60px; display: flex; align-items: right; justify-content: center;">
		<a href="#" class="rainbow-button" alt="Next" id="nextQ1"></a>
	</div>
	<div style="top:100px;height:60px; display: flex; align-items: left; justify-content:right;">
		<a href="#" class="rainbow-button" alt="Previous" id="prevQ1"></a>  -->
	</div>
		<button  type="button" onClick="execAjax(<%= quizid1%>,<%=enrolled_id %>)" class="nextQ" style="background-color:#13110;margin:0 0 0 700px;height:50px;width:200px;bottom:300px;left:300px">Submit</button>
	</form>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	  <script src="js/question.js"></script>

</body>
</html>
