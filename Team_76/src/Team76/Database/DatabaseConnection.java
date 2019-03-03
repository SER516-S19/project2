package Team76.Database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * SER516-Project2 File content - Connection to MySQL Database
 * 
 * @author Nikhila Saini,nsaini3@asu.edu
 * @since 02/19/2019
 *
 **/

public class DatabaseConnection {

	public Connection establishConnection() throws Exception {
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = null;
		String connectionUrl = "jdbc:mysql://127.0.0.1:3306/ser516p2v2?allowPublicKeyRetrieval=true&useSSL=false";
		// jdbc:mysql://127.0.0.1:3306/?user=root
		String userid = "root";
		String password = "pass123"; /* local MSQL pswdJ */

		connection = DriverManager.getConnection(connectionUrl, userid, password);
		return connection;
	}
}
