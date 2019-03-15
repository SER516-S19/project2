package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Class ConnectionFactory to get connection object to establish database connection.
 * Home after login.
 * 
 * @author shivamverma
 * @version 1.1
 * @date 03/14/2019
 */
public class ConnectionFactory {
	
	/**
	 * Get database connection after reading values from database.properties file
	 */
	private static Properties dbProperties = new Properties();
	
	static {
		try {
			dbProperties.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("database.properties"));
			Class.forName(dbProperties.getProperty("sqlDriver"));
		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
		}
	}
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		
		System.out.println("in getconnection");
		
        	String hostName = dbProperties.getProperty("hostname");
	        String dbName = dbProperties.getProperty("dbName");
        	String user = dbProperties.getProperty("userName");
	        String password = dbProperties.getProperty("password"); 
        	String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
            		+ "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        
	        Connection connection = null;
		connection = DriverManager.getConnection(url);
		return connection;
	}
}
