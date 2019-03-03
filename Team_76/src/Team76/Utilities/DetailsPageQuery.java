package Team76.Utilities;
/**SER516-Project2
*  Inserts values into DB
*  @author Janani Anand, 
*  @since 02/19/2019
*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Team76.Database.DatabaseConnection;

public class DetailsPageQuery {
	DatabaseConnection connect = new DatabaseConnection();

	public void databaseConnect(String quiztitle, String qinstruct, String qtype, String shuffleAns, String clockType) throws Exception {
		Connection con = connect.establishConnection();

		Statement statement = con.createStatement();
		String selectQuery= "select * from quiz where quizId=(select max(quizid) from quiz)";
		ResultSet rs = statement.executeQuery(selectQuery);
		int id;
		while (rs.next()) {
			id = Integer.parseInt(rs.getString("QuizId"));
			System.out.println("QuizID is" +id);
			id = (id*100)+1;
			
			String query = "INSERT INTO quiz ( ProfId, QuizId, Status, DueDate,Timelimit, QuizTitle, Qinstruct, Quiztype, ShuffleAns, OptionSelected) VALUES ( 1 , " + id + " , '', '2019-03-21', 0 ,' " + quiztitle + " '  , ' " + qinstruct+ " ' , ' " + qtype + " ' , ' " + shuffleAns + " ', ' " + clockType + " '  )";
			PreparedStatement pstmt = con.prepareStatement(query);
			System.out.println(query);
			pstmt.executeUpdate();
			
		}
		
		con.close();
	}

}
