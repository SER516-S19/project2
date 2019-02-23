package quiz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * This factory returns connections based on which source is responsible for a
 * given object (table).
 */
public class ConnectionFactory {
	// This holds properties
	private static Properties dbProperties = new Properties();

	static {
		try {
			dbProperties.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("rdbm.properties"));
			Class.forName(dbProperties.getProperty("mysql_jdbcDriver"));
		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
		}
	}

	// We can and should replace with a Connection pool
	public static final Connection getConnection() {
		// throws DataAccessException {

		String driverURL = dbProperties.getProperty("mysql_jdbcURL");
		String dbUser = dbProperties.getProperty("mysql_jdbcUser");
		String dbPass = dbProperties.getProperty("mysql_jdbcPwd");
		try {
			return DriverManager.getConnection(driverURL, dbUser, dbPass);
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return null;
	}
}
