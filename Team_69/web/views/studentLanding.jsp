<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<<<<<<< HEAD
=======
<<<<<<< HEAD
<%--
  Created by IntelliJ IDEA.
  User: jahnvi
  Date: 2/19/19
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
	<title>Student</title>
	<link href="../css/static/bootstrap.min.css" rel="stylesheet">
	<script src="../js/static/jquery.min.js"></script>
	<script src="../js/static/bootstrap.min.js"></script>
</head>
<body>
	<%
    List<String> quizNames = (ArrayList<String>) request.getAttribute("quizNames");
    List<String> quizStatus = (ArrayList<String>) request.getAttribute("quizStatus");
    List<Integer> quizIds = (ArrayList<Integer>) request.getAttribute("quizIds");
%>
	<h2>Quiz</h2>
	<form method="GET" >
		<div class="container">
			<table class="table table-bordered">
				<%session.setAttribute("action","load");
				if(quizNames.size()==0){ %>
                <p align="center">
				<h3> No quizzes are created by the professor!! </h3>
                </p>
                <%
                } else {  %>

                <p align="center">
				<h3> You have following quizzes for the course!! <br> </h3>
                </p>
				<%
            for( int i =0;i<quizNames.size();i++){
        %>
				<tr>
					<td><%=quizNames.get(i)%> <a href="student/?id=<%=quizIds.get(i)%>">Click here
							to start the quiz</a></td>
                    <td><%=quizStatus.get(i)%></td>
				</tr>

				<%
            }}
        %>
			</table>
		</div>
	</form>
</body>
</html>
=======
>>>>>>> origin/master
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
	<title>Student Home</title>
	<%@ include file="../header.jsp"%>
	<script type='text/javascript'
			src='https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js'></script>
</head>
<body>
<%
	List<String> quizNames = (ArrayList<String>) request.getSession().getAttribute("quizNames");
	List<String> quizStatus = (ArrayList<String>) request.getSession().getAttribute("quizStatus");
	List<Integer> quizIds = (ArrayList<Integer>) request.getSession().getAttribute("quizIds");
%>
<div class="container">
	<h2>Quiz</h2>
	<form method="GET">
		<table id="quizTable" class="table table-bordered">
			<%
				session.setAttribute("action", "load");
				if (quizNames.size() == 0) {
			%>
			<p align="center">
			<h3>No quizzes are created by the professor!!</h3>
			</p>
			<%
			} else {
			%>

			<p align="center">
			<h3>
				You have following quizzes for the course!! <br>
			</h3>
			</p>
			<%
				for (int i = 0; i < quizNames.size(); i++) {
			%>
			<tr>
				<td><%=quizNames.get(i)%> <a id="quizURLRow<%=i%>" href="student/?id=<%=quizIds.get(i)%>">Click here
					to start the quiz</a></td>
				<td id="quizStatus<%=i%>"><%=quizStatus.get(i)%></td>
			</tr>

			<%
					}
				}
			%>
		</table>
	</form>
	<style>
		a {
			position: relative;
			display: inline-block;
			margin-top: 20px;
		}
		a[title]:hover:after {
			content: attr(title);
			color:#ff0509;
			position: absolute;
			top: -100%;
			left: 0;
		}
	</style>
</div>
</body>
</html>
<script type="text/javascript">
	// checking if the quiz has been answered or not.
	$(document)
			.ready(
					function() {
						var rowCount = $('#quizTable tr').length;
						for (var i = 0; i < rowCount; i++) {
							if (document.getElementById("quizStatus" + i).innerHTML == "Answered") {
								document.getElementById("quizURLRow" + i).href = "javascript: void(0)";
								document.getElementById("quizURLRow"+i).title = "Quiz already answered";
							}
						}
					});
</script>

<<<<<<< HEAD
=======
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
>>>>>>> origin/master
