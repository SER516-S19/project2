package quiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import quiz.exceptions.DataAccessException;
import quiz.model.User;

/**
 * A Java class used for storing user details in the database
 * using JDBC
 * 
 * @author (Palak Chugh),(Yuti Desai), (Lakshmi Kala Pedarla)
 * @version (1.0)
 * @createDate (26 Feb 2019)
 */

public class UserDao {

	private static Properties dbProperties = new Properties();
	static {
		try {
			dbProperties.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("rdbm.properties"));
			Class.forName(dbProperties.getProperty("mysql_jdbcDriver"));
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	/**
	 * Find login information by username.
	 * 
	 * @param username enter in the textbox
	 * @return the login information
	 * @throws DataAccessException
	 */
	public User findByUsername(String username) throws DataAccessException {
		String sql = dbProperties.getProperty("SELECT_BY_USERNAME");
		User login = new User();
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			/* Populating the prepared statement with data from the value object */
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				login.setUserName(resultSet.getString("username"));
				login.setPassword(resultSet.getString("password"));
				login.setUserType(resultSet.getString("user_type"));
			}

		} catch (SQLException e) {
			/* Aborting the transaction */
			e.printStackTrace();
			DataAccessException exc = new DataAccessException("Error in insert()", e);
			try {
				conn.rollback();
			} catch (SQLException e2) {
				throw new DataAccessException("Error rolling back during recovery, nested exception has original error",
						exc);
			}
			throw exc;
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println("Unable to close resultset, database connection " + "or statement in insert()");
			}
		}

		return login;
	}

	/* Function used to insert details of registered user in the database
	 */
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
