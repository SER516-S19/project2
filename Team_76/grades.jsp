<%@page import="java.sql.*"%>
<%
	String userId = request.getParameter("user");
	String driver = "com.mysql.jdbc.driver";
	String url = "jdbc:mysql://localhost:3306";
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
			<td>StudentId</td>
			<td>QuizId</td>
			<td>Grade</td>
		</tr>
		<%
			try {
				connection = DriverManager.getConnection(url + database, user, password);
				statement = connection.createStatement();
				String sql = "SELECT * FROM student";
				resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
		%>
		<tr>
			<td><%=resultSet.getString("StudentId")%></td>
			<td><%=resultSet.getString("QuizId")%></td>
			<td><%=resultSet.getString("Grade")%></td>
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