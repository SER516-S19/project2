<%@ page import = "java.util.*, Team76.Controller.*"  %>

<!DOCTYPE html>
<html>
<head>
<title>Grade App</title>

<!-- <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"> -->
</head>

<% 	List<Grade> theGrades = 
					(List <Grade>) request.getAttribute("Grade");
%>

<body>


	<div id="wrapper">
		<div id="header">
			<h2>Grades</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<table>

				<tr>
					<th>Student ID</th>
					<th>Quiz ID</th>
					<th>Quiz Title</th>
					<th>Student Name</th>
					<th>Grade</th>

				</tr>

				//<c:forEach var="tempGrade" items="${Grade }">
				<% for (Grade tempGrade : theGrades) { %>
					<tr>
						<%-- <td>${tempGrade.studentId }</td>
						<td>${tempGrade.quizId }</td>
						<td>${tempGrade.quizTitle}</td>
						<td>${tempGrade.studentName }</td>
						<td>${tempGrade.grade }</td> --%>
						
						<td><%= tempGrade.getStudentID() %></td>
						<td><%= tempGrade.getQuizId() %></td>
						<td><%= tempGrade.getQuiztitle() %></td>
						<td><%= tempGrade.getStudentName() %></td>
						<td><%= tempGrade.getGrade() %></td>
					</tr>
				<% } %>
				//</c:forEach>



			</table>

		</div>

	</div>
</body>
</html>