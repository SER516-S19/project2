package Team76.Utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Team76.Database.DatabaseConnection;

/**
 * SER516-Project2 File content- Insert the Values into Database
 * 
 * @author Nikhila Saini,nsaini3@asu.edu
 * @since 02/19/2019
 *
 **/

public class QuestionPageQuery {
	DatabaseConnection connect = new DatabaseConnection();

	public void databaseConnect(String question, String options, String answer) throws Exception {
		Connection con = connect.establishConnection();
		String query = "INSERT INTO Question (QuestionId,Questions,Options,CORRECT_ANSWER) VALUES (' 3 ','" + question
				+ " ' , '" + options + " ' , ' " + answer + " ') ";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.executeUpdate();

		con.close();
	}

}
