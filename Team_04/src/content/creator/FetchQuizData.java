package content.creator;

//import java.sql.DriverManager;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hari Krishnan Puthiya Veetil
 */
public class FetchQuizData {

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

    public List<Integer> getQuizList() {

        List<Integer> list = Arrays.asList(11, 12, 13);

        // String sql = "SELECT DISTINCT quiz_id FROM quiz_content";

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