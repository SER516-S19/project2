package Team76.Controller;

import java.sql.*;

/**
 * SER516-Project2 File content- Insert the Values into Database
 * 
 * @author Nikhila Saini,nsaini3@asu.edu
 * @since 02/19/2019
 *
 **/

public class DatabaseQuestions {

	public void databaseConnect(String question, String options, String answer) throws Exception {
		String query = "INSERT INTO Question (QuestionId,Questions,Options,CORRECT_ANSWER) VALUES (' 3 ','" + question
				+ " ' , '" + options + " ' , ' " + answer + " ') ";
		String user = "root";
		String password = "pass123";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ser516p2?useSSL=false", user,
				password);
		PreparedStatement pstmt = con.prepareStatement(query);
		int result = pstmt.executeUpdate();

		con.close();
	}

}
