package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Implements ViewQuiz interface and establishes connection between database and
 * Servlet.
 * 
 * @see edu.asupoly.ser516.controller/ViewQuizServlet.java
 * @see resources/viewQuiz.ftl
 * @author Aditya Samant
 * @author akashkadam
 * @version 1.1
 * @date 02/22/2019
 */
public class ViewQuizDAOBean implements ViewQuizDAO {

	private static Properties dbProperties = new Properties();

	public ViewQuizDAOBean() throws IOException {
		dbProperties.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("database.properties"));
	}

	/**
	 * Makes a connection to the database via ConnectionFactory to gain information
	 * about quiz and returns a custom quiz object to be used by
	 * ViewQuizServlet.java
	 * 
	 * @param quizId the id of the quiz that is being retrieved, is primary key.
	 * @throws SQLException           in case of database error
	 * @throws ClassNotFoundException in case referencing class does not exist
	 * @return quiz A quiz object with necessary information to display on viewQuiz
	 *         page
	 */
	@Override
	public QuizVO getQuizInfo(int quizId) throws SQLException, ClassNotFoundException {

		QuizVO quiz = null;
		Connection connection = null;
		PreparedStatement query = null;
		ResultSet result = null;

		connection = ConnectionFactory.getConnection();
		query = connection.prepareStatement(dbProperties.getProperty("getQuizInfo"));
		query.setInt(1, quizId);
		result = query.executeQuery();

		String quizName = "";
		String instruction = "";
		Date scheduledDate = new Date(0);
		boolean graded = true;

		try {
			if (result.next()) {
				quizName = result.getString("quizTitle");
				instruction = result.getString("quizInstruction");
				scheduledDate = result.getDate("quizScheduledDate");
				graded = result.getBoolean("isGraded");
			}
			quiz = new QuizVO(quizName, instruction, scheduledDate, graded);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return quiz;
	}

	/**
	 * The following method connects with the SQL database via ConnectionFactory and
	 * retrieves information and parses it to appropriate formats prior to creating
	 * a list of Question objects.
	 * 
	 * @param quizId the id of the quiz whose questions are being retrieved
	 * @throws SQLException           in case errors exist in the database
	 *                                connection
	 * @throws ClassNotFoundException in class referenced is not found
	 * @throws ParseException         in case string cannot be parsed to JSON
	 * 
	 * @return list a list of questions with relevant information used to display on
	 *         view quiz page.
	 */
	@Override
	public List<DisplayQuestionsVO> getStudentQuestionsInfo(int quizId)
			throws SQLException, ClassNotFoundException, ParseException {

		Connection connection = null;
		PreparedStatement query = null;
		ResultSet resultData = null;

		connection = ConnectionFactory.getConnection();
		query = connection.prepareStatement(dbProperties.getProperty("getQuizQuestions"));
		query.setInt(1, quizId);
		resultData = query.executeQuery();

		List<DisplayQuestionsVO> list = new ArrayList<>();

		while (resultData.next()) {

			int totalPoints = resultData.getInt("totalPoints");
			String question = resultData.getString("question");
			String answers = resultData.getString("actualAnswer");
			String choices = resultData.getString("totalChoices");

			JSONParser parser = new JSONParser();
			JSONObject incorrectJO = (JSONObject) parser.parse(choices);
			JSONObject correctJO = (JSONObject) parser.parse(answers);

			List<String> incorrectAnswers = new ArrayList(3);
			List<String> correctAnswers = new ArrayList(3);

			int i = 1;
			String choice = (String) incorrectJO.get("incorrectAnswer" + i);
			while (choice != null) {

				incorrectAnswers.add(choice);
				i++;
				choice = (String) incorrectJO.get("incorrectAnswer" + i);
			}
			i = 1;
			choice = (String) correctJO.get("correctAnswer" + i);
			while (choice != null) {

				correctAnswers.add(choice);
				i++;
				choice = (String) correctJO.get("correctAnswer" + i);
			}
			DisplayQuestionsVO displayquestionVO = new DisplayQuestionsVO(quizId, totalPoints, correctAnswers,
					incorrectAnswers, question);
			list.add(displayquestionVO);
		}
		return list;
	}

	@Override
	public List<QuestionVO> getQuestionsInfo(int quizId) throws SQLException, ClassNotFoundException, ParseException {
		// TODO Auto-generated method stub
		return null;
	}
}
