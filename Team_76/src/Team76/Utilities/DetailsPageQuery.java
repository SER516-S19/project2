package Team76.Utilities;
/**SER516-Project2
*  Inserts values into DB
*  @author Janani Anand, 
*  @since 02/19/2019
*/

import java.sql.Connection;
import java.sql.PreparedStatement;

import Team76.Database.DatabaseConnection;

public class DetailsPageQuery {
	DatabaseConnection connect = new DatabaseConnection();

	public void databaseConnect(String quiztitle, String qinstruct, String qtype) throws Exception {

		Connection con = connect.establishConnection();
		String query = "INSERT INTO quiz (quiztitle, qinstruct, qtype) VALUES (' " + quiztitle + " ' , ' " + qinstruct
				+ " ' , ' " + qtype + " ' )";

		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.executeUpdate();
		con.close();
	}

}
