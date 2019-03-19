package quiz.dao.professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import quiz.dao.ConnectionFactory;
import quiz.exceptions.DataAccessException;
import quiz.exceptions.NoDataFoundException;
import quiz.model.professor.QuizModel;

/**
 * A Java class used for Data Access, connecting database to servlets
 * using JDBC
 * 
 * @author (Shefali Anand)
 * @version (1.0)
 * @createDate (19 Feb 2019)
 */
public class QuizDetailsDao {

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

	/* Gets a list of Quizzes created by professor */
	@SuppressWarnings("unchecked")
	public static ArrayList getAll() throws DataAccessException, NoDataFoundException {
		@SuppressWarnings("rawtypes")
		ArrayList rowValues = new ArrayList();

		Connection conn = ConnectionFactory.getConnection();
		ResultSet rs = null;

		String sql = dbProperties.getProperty("SELECTALL_QUIZ");

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				rowValues.add(rs.getString("title"));
			}

			return rowValues;
		} catch (SQLException e) {
			// Aborting the transaction
			e.printStackTrace();
			return rowValues;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(
						"Unable to close resultset, database connection " + "or statement in findByPrimaryKey");
			}
		}
	}

	/* Gets a specific Quiz created by professor, according to the Quiz-title */
	public static QuizModel findByPrimaryKey(String pPrimaryKey) throws DataAccessException, NoDataFoundException {
		Connection conn = ConnectionFactory.getConnection();
		ResultSet rs = null;

		String sql = dbProperties.getProperty("SELECTByPrimaryKey_QUIZ");

		QuizModel pentry = null;

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setString(1, pPrimaryKey);
			rs = preparedStatement.executeQuery();

			if (rs.next()) {
				pentry = new QuizModel(rs.getString("title"), rs.getString("instructions"),
						rs.getString("assignment_group"), rs.getBoolean("isshuffled"), rs.getBoolean("isgraded"),
						rs.getInt("time_limit"), rs.getBoolean("ismultipleattempt"));
			} else {

			}

			return pentry;
		} catch (SQLException e) {
			// Aborting the transaction
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(
						"Unable to close resultset, database connection " + "or statement in findByPrimaryKey");
			}
		}
	}

	/* Insert the quiz which was created by professor into the database */
	public static void insert(QuizModel pValueObject) throws DataAccessException {

		String sql = dbProperties.getProperty("INSERT_QUIZ");

		QuizModel pentry = (QuizModel) pValueObject;
		Connection conn = ConnectionFactory.getConnection();

		PreparedStatement preparedStatement = null;

		try {
			// Populating the prepared statement with data from the value object
			preparedStatement = conn.prepareStatement(sql.toString());

			preparedStatement.setString(1, pentry.getTitle());
			preparedStatement.setString(2, pentry.getInstructions());
			preparedStatement.setString(3, pentry.getAssignmentGroup());
			preparedStatement.setBoolean(4, pentry.getIsShuffled());
			preparedStatement.setBoolean(5, pentry.getIsGraded());
			preparedStatement.setInt(6, pentry.getTimeLimit());
			preparedStatement.setBoolean(7, pentry.getIsMultipleAttempt());

			preparedStatement.execute();
		} catch (SQLException e) {
			// Aborting the transaction
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

	}

	/* Update the quiz according to the quiz features modified by the professor  */
	public void update(QuizModel pValueObject) throws DataAccessException {
		String sql = dbProperties.getProperty("UPDATE_QUIZ");

		QuizModel pentry = (QuizModel) pValueObject;
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;

		try {
			// Populating the prepared statement's parameters
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(7, pentry.getTitle());
			preparedStatement.setString(1, pentry.getInstructions());
			preparedStatement.setString(2, pentry.getAssignmentGroup());
			preparedStatement.setBoolean(3, pentry.getIsShuffled());
			preparedStatement.setBoolean(4, pentry.getIsGraded());
			preparedStatement.setInt(5, pentry.getTimeLimit());
			preparedStatement.setBoolean(6, pentry.getIsMultipleAttempt());

			/*
			 * Checking to see if we were successful in updating the record. If the
			 * queryResult does not equal 1, then we no we have run into an optimistic lock
			 * situation.
			 *
			 */
			int queryResults = preparedStatement.executeUpdate();
			if (queryResults != 1) {

			}
		} catch (SQLException e) {
			// Aborting the transaction
			DataAccessException exc = new DataAccessException("Error in update()", e);
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
				System.out.println("Unable to close resultset, database connection " + "or statement in update()");
			}
		}

	}

	/* Delete the entire quiz, specified by the professor */
	public boolean delete(QuizModel pValueObject) throws DataAccessException {

		String sql = dbProperties.getProperty("DELETE_QUIZ");

		QuizModel pentry = (QuizModel) pValueObject;

		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;

		try {

			// Deleting the record from the table
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, pentry.getTitle());
			preparedStatement.executeUpdate();

			return true;
		} catch (SQLException e) {
			// Aborting the transaction
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			return false;
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println("Unable to close resultset, database connection " + "or statement in delete()");
			}

		}
	}

	/* Gets QuizId of the specified quiz so that that quizId can be used in adding questions */
	public String getQuizId(String quizTitle) {
		String sql = dbProperties.getProperty("SELECT_QUIZID");
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		String quizId = "";
		try {

			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, quizTitle);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				quizId = rs.getString("quiz_id");
			}

		} catch (SQLException e) {
			// Aborting the transaction
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println("Unable to close resultset, database connection " + "or statement in delete()");
			}

		}

		return quizId;
	}
	
	public static String getTimeLimit(String quiz_title) {

		String sql = dbProperties.getProperty("SELECT_TIMELIMIT_IN_QUIZ");
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		String timeLimit = "";
		try {

			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, quiz_title);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				timeLimit = rs.getString("time_limit");
			}

		} catch (SQLException e) {
			// Aborting the transaction
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println("Unable to close resultset, database connection " + "or statement in delete()");
			}

		}

		return timeLimit;
	
		
	}

}
