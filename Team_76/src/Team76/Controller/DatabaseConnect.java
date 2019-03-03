package Team76.Controller;
/**SER516-Project2
*  Inserts values into DB
*  @author Janani Anand, 
*  @since 02/19/2019
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseConnect {

	public void databaseConnect(String quiztitle, String qinstruct, String qtype) throws Exception {
		
        String query = "INSERT INTO quiz (quiztitle, qinstruct, qtype) VALUES (' " + quiztitle + " ' , ' " + qinstruct
				+ " ' , ' " + qtype + " ' )";
	    
	    String user = "root";
	    String password = "pass123";
	    
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ser516p2?useSSL=false",user,password);

	    PreparedStatement pstmt = con.prepareStatement(query);
	    int result = pstmt.executeUpdate(); 
	    con.close();		
	}

}
