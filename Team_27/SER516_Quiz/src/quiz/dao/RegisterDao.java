package quiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import quiz.model.User;

/**
 * A Java class used for storing user details in the database
 * using JDBC
 * 
 * @author (Palak Chugh),(Yuti Desai)
 * @version (1.0)
 * @createDate (26 Feb 2019)
 */

public class RegisterDao {
	
	private static Properties dbProperties = new Properties();
	static {
		try {
			dbProperties.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("rdbm.properties"));
			Class.forName(dbProperties.getProperty("mysql_jdbcDriver"));
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
	
	 public String registerUser(User registerBean)
	 {
	 String fullName = registerBean.getFullName();
	 String email = registerBean.getEmail();
	 String userName = registerBean.getUserName();
	 String user_type = registerBean.getUserType();
	 String password = registerBean.getPassword();
	 Connection con = null;
	 PreparedStatement preparedStatement = null;
	 
	 try
	 {
	con = ConnectionFactory.getConnection();
	 String query = "insert into login_authentication(fullname,email,username,password,user_type) values (?,?,?,?,?)";
	 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
	 preparedStatement.setString(1, fullName);
	 preparedStatement.setString(2, email);
	 preparedStatement.setString(3, userName);
	 preparedStatement.setString(5, user_type);
	 preparedStatement.setString(4, password);
	 
	 int i= preparedStatement.executeUpdate();
	 
	 if (i!=0)  //Just to ensure data has been inserted into the database
	 return "SUCCESS"; 
	 }
	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 
	 return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
	 }
}
