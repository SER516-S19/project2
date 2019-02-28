<%@page import="org.apache.catalina.Session"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page import="org.json.simple.JSONObject"%>
<html>
<head>
<% 
	JSONArray choiceArray = new JSONArray();
	JSONArray questionsArray = new JSONArray();
	JSONObject question =new JSONObject();	
	JSONObject quizCreation=new JSONObject();
	
	int totalpoint = 0;
	String[] questions = request.getParameterValues("question");
	
	for(int i = 0;i<questions.length;i++){
		String[] choices = request.getParameterValues("choice"+i);
		String[] contents = request.getParameterValues("questioncontent"+i);
		for(int j=0;j<choices.length;j++){
			JSONObject choice=new JSONObject();
			choice.put("correct", choices[j]);
			choice.put("content", contents[j]);
			System.out.println("c:"+choices[j]+"content:"+contents[j]);
			choiceArray.add(choice);
		}
		String point = request.getParameter("points"+i);
		question.put("points", Float.parseFloat(point));
		if(choices.length>1){
			question.put("quesType", "MA");
		} else {
			question.put("quesType", "MC");
		}
		question.put("content", questions[i]);
		
		totalpoint += Integer.parseInt(point);
		questionsArray.add(question);
	}

	String title = request.getParameter("title");
	String course_id = request.getParameter("courseid");
	String instructions = request.getParameter("instructions");
	String temp = request.getParameter("shuffle");
	boolean shuffle = false;
	if(temp.equals("1")){
		shuffle = true;
		System.out.println(shuffle);
	}
	String quiz_group = request.getParameter("group");
	String time_limit = request.getParameter("timelimit");
	String data_open = request.getParameter("data_open");
	String data_close = request.getParameter("data_close");
	String quiz_type = request.getParameter("quiz_type");
	System.out.println(quiz_type);
	String attemps = request.getParameter("attemps");

	quizCreation.put("title",title);
	quizCreation.put("course_id",course_id);
	quizCreation.put("instructions",instructions);
	quizCreation.put("time_limit",time_limit);
	quizCreation.put("date_open",data_open);
	quizCreation.put("date_close",data_close);
	quizCreation.put("quiz_group",quiz_group);
	quizCreation.put("total_points",totalpoint);
	quizCreation.put("questions",questionsArray);
	
	session.setAttribute("quizCreation", quizCreation);
%>
<title>Summary Page</title>
</head>
<body style="background-color:Silver;">
<h5><center>Summary Of Quiz created</centre><h5>
<label>List of Questions: </label>
<br>
<br>
<label class="Question1">
1. Quiz question 1
</label>


<br>
<label class="Question2">
2. Quiz question 2
</label>
<br>
<label class="Question3">
3. Quiz question 3
</label>
<br>
<label class="Question4">
4. Quiz question 4
</label>
<br>
<label class="Question5">
5. Quiz question 5
</label>
<br>
<label class="Question6">
6. Quiz question 6
</label>
<br>
<label class="Question7">
7. Quiz question 7
</label>
<br>
<label class="Question8">
8. Quiz question 8
</label>
<br>
<label class="Question9">
9. Quiz question 9
</label>
<br>
<label class="Question10">
10. Quiz question 10
</label>
<br>


<br>





<input id = "beginbtn" type="button" value="Dashbaord" onclick='location.href=("dashboard_professor.jsp")'>


</body>
</html>