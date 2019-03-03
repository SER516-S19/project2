package quiz.dao.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import quiz.dao.ConnectionFactory;
import quiz.exceptions.DataAccessException;
import quiz.model.login.Login;

/**
 * This dao is used to fetch the user login information from the
 * login_authentication table.
 * 
 * @author Lakshmi Kala Pedarla
 * @version (1.0)
 */
public class LoginDao {

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
	 * @param username the username
	 * @return the login information
	 * @throws DataAccessException
	 */
	public Login findByUsername(String username) throws DataAccessException {
		String sql = dbProperties.getProperty("SELECT_BY_USERNAME");
		Login login = new Login();
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			/* Populating the prepared statement with data from the value object */
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				login.setUsername(resultSet.getString("username"));
				login.setPassword(resultSet.getString("password"));
				login.setUsertype(resultSet.getString("user_type"));
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
}
