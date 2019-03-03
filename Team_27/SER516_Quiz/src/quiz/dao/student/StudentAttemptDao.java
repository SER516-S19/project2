package quiz.dao.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ArrayList;

import quiz.dao.ConnectionFactory;
import quiz.exceptions.DataAccessException;
import quiz.model.professor.QuizAttempt;
import src.quiz.dao.professor.String;
import src.quiz.dao.professor.SuppressWarnings;

/**
 * StudentAttemptDao returns and stores all the attempted answers in the database
 * 
 * @author Manisha Miriyala, Sumanth
 * @version (1.0)
 */
public class StudentAttemptDao {

	private static Properties dbProperties = new Properties();
		static {
			try {
				dbProperties.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("rdbm.properties"));
				Class.forName(dbProperties.getProperty("mysql_jdbcDriver"));
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}
	public static ArrayList<QuizAttempt> getAnswers() throws DataAccessException {
	// @SuppressWarnings("rawtypes") 
		ArrayList<QuizAttempt> entireRow = new ArrayList<QuizAttempt>();

		Connection conn = ConnectionFactory.getConnection();
		ResultSet rs = null;
		String sql = dbProperties.getProperty("SELECT_ANSWERS_IN_QUIZ");
		try {
			/* Updating the preparedstatement with the answers attempted by student */
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				entireRow.add(rs.getRow());
			}
			return entireRow;
		} catch (SQLException e) {
			/* Transaction is aborted*/
			e.printStackTrace();
			return entireRow;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(
						"Unable to close resultset, database connection ");
			}
		}
	}
}
