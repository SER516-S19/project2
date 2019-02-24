package servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import bean.Question;

/**
 * @author Naga Sai Krishna
 *
 */

public class FetchQuestionsDB {

	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	final private String host = "localhost";
	final private String user = "root";
	final private String passwd = "";
	Question[] questionArray;

	/**
	 * @return Question Array
	 * @throws Exception
	 */
	public Question[] readDataBase() throws Exception {
		int i = 0;
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Setup the connection with the DB
			connect = DriverManager
					.getConnection("jdbc:mysql://" + host + "/ser516p2?" + "user=" + user + "&password=" + passwd);

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query
			resultSet = statement.executeQuery("select * from question");
			questionArray = new Question[20];
			while (resultSet.next()) {
				String quizId = resultSet.getString("QuizId");
				String questionID = resultSet.getString("QuestionId");
				String questions = resultSet.getString("Questions");
				String options = resultSet.getString("Options");
				String correct = resultSet.getString("CORRECT_ANSWER");
				questionArray[i] = new Question(quizId, questionID, questions, options, correct);
				i++;
			}
			return questionArray;

		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}

	}

	// close the resultSet
	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}

}