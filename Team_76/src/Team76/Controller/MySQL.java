package Team76.Controller;

import java.sql.*;

/**
* SER-516 Software Agility
* Retrieves the grade of the selected student from the DataBase
* @author Manikanta Chintakunta, mchintak@asu.edu
* @version 1.0
* @since 02-15-19
*/

public class MySQL {
/* The database connection to our JSP page
 * @param holds the query to be retrieved from the database
 */
	public void connection(String quiztitle, String studentName) throws Exception {
		String query = "SELECT * FROM grade WHERE studentName= '" + studentName + " ' and quiztitle = ' " + quiztitle +" ' ";
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ser516p2?useSSL=false", "root", "Manikanta.2");
				Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery(query);
				while (rs.next()) {
					String grade = rs.getString("grade");
					System.out.println("Grade is: " + grade);
				}
				con.close();
	}	 
}