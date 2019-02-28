package Team76.Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

	public Connection establishConnection() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ser516p2?useSSL=false", "root",
				"pass123");
		return con;
	}
}
