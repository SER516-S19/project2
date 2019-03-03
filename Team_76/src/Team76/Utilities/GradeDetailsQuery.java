package Team76.Utilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Team76.Database.DatabaseConnection;

/**
 * SER-516 Software Agility Retrieves the grade of the selected student from the
 * DataBase
 * 
 * @author Manikanta Chintakunta, mchintak@asu.edu
 * @version 1.0
 * @since 02-15-19
 */

public class GradeDetailsQuery {
	/*
	 * The database connection to our JSP page
	 * 
	 * @param1 quiztitle holds the title of the quiz
	 * 
	 * @param2 studentName holds the name of the student
	 */
	DatabaseConnection connect = new DatabaseConnection();

	public void connection(String quiztitle, String studentName) throws Exception {
		Connection con = connect.establishConnection();
		String query = "SELECT * FROM grade WHERE studentName= '" + studentName + " ' and quiztitle = ' " + quiztitle
				+ " ' ";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(query);
		while (rs.next()) {
			rs.getString("grade");
		}
		con.close();
	}
}