<html>
<head>

<%--
 - Author(s): Suraj Atmakuri
 - Description: Display submission result.
 --%>
<title>Result Page</title>
</head>
 <%@ page import="org.team47database.*"%>
    <%@ page import="java.util.List"%>
    
<body style="background-color:#FFF8DC">
<%
	
	
  	Object quizid =  request.getSession().getAttribute("quizid");	
	String quizid1= String.valueOf(quizid) ;  
	
  	Object enrolled_id =  request.getSession().getAttribute("enrolled_id");	
	String enrolled_id1  =  String.valueOf(enrolled_id);
	String HTMLContent = "";
	String content="";
 	StringBuilder buf = new StringBuilder();
 	
 	List<Submission> submissionlist=new SubmissionDAOImpl().getEnrolledSubmissions(Integer.valueOf(enrolled_id1));
	 
	for(int i=0;i<submissionlist.size();i++){
		buf.append(String.format(
	 			"<div class=\"question-board\">"));
		Submission submission=submissionlist.get(i);
		buf.append(String.format(
	 			"<div class=\"question-top-area\">"+
	 					"<h3 class=\"question_num\">Attempt- "+"%s"+"</h3>"+
				"<h3> Score: %s pts</h4>"+
			"</div>"+
				"</div>",String.valueOf(i),String.valueOf(submission.getScore())));
		
	 	
	}
	
	String html = buf.toString();

	 %>
	 	
<h5><center>Score Report For All Submissions Sorted By Date</centre><h5>
<frameset>
<%=html%>
<br>
<br>
<form action="myquizzes.jsp">
<input id = "beginbtn" type="submit" value="Dashboard">
</form>

</frameset>
</body>
</html>