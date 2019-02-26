package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.json.simple.JSONObject;
/**
 * Class QuestionsDAOBean is a class that comes after create quiz Page
 * 
 * @author trupti khatavkar
 * @version 1.1
 * @date 02/22/2019
 **/

public class QuestionsDAOBean implements QuestionsDAO {

	private static Properties dbProperties = new Properties();

	public QuestionsDAOBean() {
		try {
			dbProperties.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("database.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to insert questions and answers to create quiz.
	 * 
	 * @param questionsVO object of QuestionsVO to set values
	 * @throws IOException, ServletException
	 *
	 */
	@Override
	public void insertingQuestions(QuestionsVO questionsVO) throws SQLException, ClassNotFoundException {

		Map<String, String> totalChoices = new HashMap<>();

		totalChoices.put("incorrectAnswer1", questionsVO.getIncorrectAnswer1());
		totalChoices.put("incorrectAnswer2", questionsVO.getIncorrectAnswer2());
		totalChoices.put("incorrectAnswer3", questionsVO.getIncorrectAnswer3());

		StringBuilder sb = new StringBuilder();
		sb.append("{");
		int count = 0;
		for (Map.Entry<String, String> entry : totalChoices.entrySet()) {
			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\"");
			sb.append(":");
			sb.append("\"");
			sb.append(entry.getValue());
			sb.append("\"");
			count++;
			if (totalChoices.size() - 1 != count) {
				sb.append(",");
			}
		}
		sb.append("}");

		String incorrectAnswer = sb.toString();

		Connection connection = null;
		PreparedStatement query = null;

		connection = ConnectionFactory.getConnection();
		try {
			query = connection.prepareStatement(dbProperties.getProperty("postQuestions"));
			query.setInt(1, questionsVO.getQuizId());
			query.setString(2, questionsVO.getQuestion());
			query.setString(3, questionsVO.getCorrectAnswer());
			query.setString(4, incorrectAnswer);
			query.setInt(5, questionsVO.getTotalPoints());
			query.setBoolean(6, questionsVO.isMCQ());

			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			query = null;
			connection = null;
		}

	}
	
	/**
	 * updateQuestionsTable
	 * Update a question entry in the Questions table based on info obtained from ViewQuiz page.
	 * 
	 * 
	 * @author Aditya Samant
	 * @throws SQLException error occurs during connecting or updating the information in SQL 
	 * @throws ClassNotFoundException for Connection Factory
	 * 
	 * @param question the question
	 * @param answer the solution choice
	 * @param wrongOne wrong answer number one
	 * @param wrongTwo wrong answer number two
	 * @param wrongThree wrong answer number three
	 * @param points points for the question
	 * @param qId the question ID
	 * 
	 * @see controller/ViewQuizServlet.java
	 * @verson 1.0
	 * */
	public void updateQuestionsTable(String question, String answer, String wrongOne,
			String wrongTwo, String wrongThree, int points, int qId) throws SQLException, ClassNotFoundException{
		Connection connection = null;
		PreparedStatement query = null;
		connection = ConnectionFactory.getConnection();
		
		try {
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("incorrectAnswer1", wrongOne);
			jsonObj.put("incorrectAnswer2", wrongTwo);
			jsonObj.put("incorrectAnswer3", wrongThree);
			
			query = connection.prepareStatement(dbProperties.getProperty("updateQuestionsTable"));
			query.setString(1, question);
			query.setString(2, answer);
			query.setString(3, jsonObj.toJSONString());
			query.setInt(4, points);
			query.setInt(5, qId);
			
			query.executeQuery();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
