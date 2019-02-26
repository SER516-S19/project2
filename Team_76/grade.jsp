<%@page import="java.sql.*"%>

<!--This file shows student grade;
Author: Hsin-Jung Lee
Version: 6  -->
<%
	String userID = request.getParameter("userID");
	String driver = "com.mysql.jdbc.driver";
	String url = "jdbc:mysql://localhost:3306/";
	String database = "ser516p2";
	String user = "root";
	String password = "1hsinjung!";
	try {
		Class.forName(driver);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
%>
<html>
<head>
<title>View Students Grade</title>
</head>
<body>

	<h1>My Grades</h1>

	<table border="5">
		<tr>
			<td>studentID</td>
			<td>QuizId</td>
			<td>quiztitle</td>
			<td>studentName</td>
			<td>grade</td>
		</tr>
		<%
			try {
				connection = DriverManager.getConnection(url + database, user, password);
				statement = connection.createStatement();
				String sql = "SELECT * FROM grade;";
				resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
		%>
		<tr>
			<td><%=resultSet.getString("studentID")%></td>
			<td><%=resultSet.getString("QuizId")%></td>
			<td><%=resultSet.getString("quiztitle")%></td>
			<td><%=resultSet.getString("studentName")%></td>
			<td><%=resultSet.getString("grade")%></td>
		</tr>
		<%
			}
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		%>
	</table>
	<br />
	<br />
	<input type="submit" value="Back" />

</body>

</html>