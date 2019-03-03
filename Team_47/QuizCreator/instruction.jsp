<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@page import="model.*"%>
<%--
 - Author(s): Bhavana Vakkalagadda
 - Description: Displays Quiz information and instructions and  student can start quiz.
 --%>
<!-- TODO:the import path-->
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="CSS/instruction.css" type="text/css">
<script type="text/javascript"></script>

<head>
<meta charset="UTF-8">
<title>Instruction</title>
</head>
<body style="background-color:#FFF8DC">
<div class = "content">
<%@ page import="com.asu.ser516.team47.database.*"%>
    <%@ page import="java.util.List"%>


	
	<%
Object quizid =  request.getSession().getAttribute("quizid");	
	String quizid1= String.valueOf(quizid) ;  
	
  	Object enrolled_id =  request.getSession().getAttribute("enrolled_id");	
	String enrolled_id1  =  String.valueOf(enrolled_id);
	String HTMLContent = "";
	String content="";
 	StringBuilder buf = new StringBuilder();
 	
 	Quiz quiz=new QuizDAOImpl().getQuiz(Integer.valueOf(enrolled_id1));
 	buf.append(String.format( 	
 			"<div class=\"question-top-area\">"+
 		 			"<div class=\"question-title\""+

 							"<h2>Quiz Title:%s</h2>"+
 							"<h3>Quiz Points:%s</h3>"+
 		 					"<h3>Quiz Group:%s</h3>"+
					"</div>"+
			"</div>"	+
 	"<div class =\"instruction_area\">"+
	"<p>Quiz Instruction</p>"+
	"<input id = \"instruction\" type = \"text\" value=\"%s\" disabled=\"disabled\">"+
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
request.getSession().setAttribute("quizid",quizid1);
request.getSession().setAttribute("enrolled_id",enrolled_id1);
%>   
<%=html%>
 <div class="bottom">
 <input id = "beginbtn" type="button" value="Begin Quiz" onclick='location.href=("questions.jsp")'>
</div>
</div>
</body>
</html>
