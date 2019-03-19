package quiz.dao.professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import quiz.dao.ConnectionFactory;
import quiz.exceptions.DataAccessException;
import quiz.model.professor.Question;

/**
 * This Dao will store all the parameters of Questions in the database
 * 
 * @author Sarthak Tiwari, Bijayalaxmi Panda
 * @version (1.0)
 */

public class QuestionsDao {

	private static Properties dbProperties = new Properties();
	static {
		try {
			dbProperties.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("rdbm.properties"));
			Class.forName(dbProperties.getProperty("mysql_jdbcDriver"));
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	public static void removeAllQuestionsFromQuiz(Integer quizID) throws DataAccessException {

		String sql = dbProperties.getProperty("DELETE_ALL_QUESTIONS_IN_QUIZ");

		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;

		try {
			/* Populating the prepared statement with data from the value object */
			preparedStatement = conn.prepareStatement(sql.toString());

			preparedStatement.setInt(1, quizID);

			preparedStatement.execute();



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
	}

	public static void insert(Question pValueObject) throws DataAccessException {
		String sql = dbProperties.getProperty("INSERT_QUESTION");

		Question questionEntry = (Question) pValueObject;
		Connection conn = ConnectionFactory.getConnection();

		PreparedStatement preparedStatement = null;

		try {
			/* Populating the prepared statement with data from the value object */
			preparedStatement = conn.prepareStatement(sql.toString());

			preparedStatement.setString(1, questionEntry.getQuizId() + "");
			preparedStatement.setString(2, questionEntry.getQuestion());
			preparedStatement.setString(3, questionEntry.getOptionA());
			preparedStatement.setBoolean(4, questionEntry.getIsOptionACorrect());
			preparedStatement.setString(5, questionEntry.getOptionB());
			preparedStatement.setBoolean(6, questionEntry.getIsOptionBCorrect());
			preparedStatement.setString(7, questionEntry.getOptionC());
			preparedStatement.setBoolean(8, questionEntry.getIsOptionCCorrect());
			preparedStatement.setString(9, questionEntry.getOptionD());
			preparedStatement.setBoolean(10, questionEntry.getIsOptionDCorrect());
			preparedStatement.setString(11, questionEntry.getPoints() + "");
			preparedStatement.setBoolean(12, questionEntry.getIsMultipleAnswer());

			preparedStatement.execute();
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
	}

	public static ArrayList<Question> getQuestions(Integer quizID) throws DataAccessException {
		String sql = dbProperties.getProperty("SELECT_QUESTIONS_BY_QUIZ");

		ArrayList<Question> questions = null;

		Connection conn = ConnectionFactory.getConnection();

		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		try {
			/* Populating the prepared statement with data from the value object */
			preparedStatement = conn.prepareStatement(sql.toString());

			preparedStatement.setInt(1, quizID);

			rs = preparedStatement.executeQuery();
			questions = new ArrayList<Question>();
			Question tmp = null;
			while (rs.next()) {
				tmp = new Question(rs.getString("quiz_id"), rs.getString("question"), rs.getString("option1"),
						rs.getString("option2"), rs.getString("option3"), rs.getString("option4"),
						rs.getBoolean("isOption1Correct"), rs.getBoolean("isOption2Correct"),
						rs.getBoolean("isOption3Correct"), rs.getBoolean("isOption4Correct"), rs.getString("points"),
						rs.getBoolean("isMultipleAnswer"));

				questions.add(tmp);
			}
		} catch (SQLException e) {
			/* Aborting the transaction */
			e.printStackTrace();
			DataAccessException exc = new DataAccessException("Error in select()", e);
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
				System.out.println("Unable to close resultset, database connection " + "or statement in select()");
			}
		}

		return questions;
	}
}
