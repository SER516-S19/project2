package edu.asu.ser516.quiz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.asu.ser516.quiz.exceptions.DataAccessException;
import edu.asu.ser516.quiz.model.Question;

public class QuestionsDaoBean {

	private static Properties dbProperties = new Properties();
	static {
		try {
			dbProperties.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("rdbm.properties"));
			Class.forName(dbProperties.getProperty("mysql_jdbcDriver"));
		} catch (Throwable t) {
			t.printStackTrace();
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

			preparedStatement.setString(1, questionEntry.getQuestion());
			preparedStatement.setString(2, questionEntry.getOptionA());
			preparedStatement.setString(3, questionEntry.getOptionB());
			preparedStatement.setString(4, questionEntry.getOptionC());
			preparedStatement.setString(5, questionEntry.getOptionD());
			preparedStatement.setBoolean(6, questionEntry.getIsOptionACorrect());
			preparedStatement.setBoolean(7, questionEntry.getIsOptionBCorrect());
			preparedStatement.setBoolean(8, questionEntry.getIsOptionCCorrect());
			preparedStatement.setBoolean(9, questionEntry.getIsOptionDCorrect());
			preparedStatement.setString(10, questionEntry.getPoints() + "");
			preparedStatement.setBoolean(11, questionEntry.getIsMultipleAnswer());

			preparedStatement.execute();
		} catch (SQLException e) {
			/* Aborting the transaction */
			e.printStackTrace();
			DataAccessException exc = new DataAccessException("Error in insert()", e);
			try {
				conn.rollback();
			} catch (SQLException e2) {
				throw new DataAccessException("Error rolling back during recovery, nested exception has original error", exc);
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
}
