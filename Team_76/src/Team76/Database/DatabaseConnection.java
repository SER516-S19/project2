package Team76.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnection {

	public Connection establishConnection() throws Exception {
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
			} catch (ClassNotFoundException e) {
			e.printStackTrace();
			}
		Connection connection = null;	
		String connectionUrl = "jdbc:mysql://localhost:3306/ser516p2?useSSL=false";
		String userid = "root";
		String password = "pass123";
		connection = DriverManager.getConnection(connectionUrl, userid, password);
		return connection;
	}
}
