package project3;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


/**
 * @author Sai Vinay Ganagadharabhatla
 */

public class FetchQuizDetails {
	private String ques, option_a, option_b, option_c, option_d;
	private int score;
	// private Connection connect() {
    // String url = "url";
    // Connection con = null;
    // try {
    // con = DriverManager.getConnection(url);
    // } catch (SQLException e) {
    // System.out.println(e.getMessage());
    // }
    // return con;
    // }
	
	public List getQuizDetails(int id) {
		
		List<String> list = Arrays.asList("1", "a", "b", "c", "d", "6");
		//String sql = "SELECT * FROM quiz_content where quiz_id=id";
		// try (Connection con = this.connect();
        // Statement stm = con.createStatement();
        // ResultSet rs = stm.executeQuery(sql)) {
        // while (rs.next()) {
        // list.add(rs.getInt("quiz_id"));
        // }
        // } catch (SQLException e) {
        // System.out.println(e.getMessage());
        // }
		return list;
	}
}




