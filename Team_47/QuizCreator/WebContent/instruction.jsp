<%--
 - Author(s): Yu-Ting Tsao, Bhavana vakkalagadda
 - Description: Displays instruction page and quiz info before start of quiz .
 --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ page import="org.team47.database.*"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="CSS/instruction.css" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script src="js/question.js"></script>
<%
	boolean temp = true;
	String mulbutton = "hidden";
	if(temp){
		mulbutton = "button";
	}
	String title = "The maximum time for quiz is 30 minutes.  No partial grading is avaialable";
%>
<head>
<meta charset="UTF-8">
<title>Instruction</title>
</head>
<body style="background-color:#FFF8DC">
<div class = "content">
	<%
	String quizId=request.getParameter("quizId");
	Object quizid =  request.getSession().getAttribute("quizid");	
	String quizid1= String.valueOf(quizid) ;  
	String HTMLContent = "";
	String content="";
 	StringBuilder buf = new StringBuilder();
 	
 	Quiz quiz=new QuizDAOImpl().getQuiz(Integer.valueOf(quizId));
 	buf.append(String.format( 	
 			"<div class=\"question-top-area\">"+
 		 	"<div class=\"question-title\""+
 			"<h2>Quiz Title: %s </h2>"+
 			"<hr>"+
 			"<h3>Quiz Points: %s </h3>"+
 		 	"<h3>Quiz Group: %s </h3>"+
			"</div>"+
			"</div>"+
 			"<div top=100px; class =\"instruction_area\">"+
			"<p style=\"margin-top: 160px;\">Quiz Instructions</p>"+
			"<input id = \"instruction\" type = \"text\" value=\"1) "+ 
			"%s\"style=\"height:50px;width:600px;\" disabled=\"disabled\">"+
			"</input>"+
			"</div>"+
     		"<div class=\"bottom\">"+
			"</div>",quiz.getTitle(),
			String.valueOf(quiz.getTotal_points()),
	 		quiz.getQuiz_group(),
			quiz.getInstructions()
 		 	));
	String html = buf.toString();
	%>
<% 
Cookie[] cookies = request.getCookies();
Cookie cookie = null;
String enrolled_id = "";
String user_name = "";
for (int i = 0; i < cookies.length; i++) {
	cookie = cookies[i];
	if (cookie.getName().equals("session-user")) {
		user_name = cookie.getValue();
		break;
	}
}
if (user_name.length() > 0) {
	List<Enrolled> enrolled = new EnrolledDAOImpl().getStudentEnrollment(user_name);
	if (enrolled.size() > 0)
		enrolled_id = String.valueOf(enrolled.get(0).getEnrolled_id());
	else
		enrolled_id = "1";
} else {
	enrolled_id = "1";
}
request.getSession().setAttribute("quizid",quizId);
request.getSession().setAttribute("enrolled_id","1");
%>   
<%=html%>
 <div >
 <button onclick="execAjaxOnBegin(<%=quizid1%>,<%=enrolled_id%>)">
Click here to Begin Quiz 
 </button>
</div>
</div>
</body>
</html>
