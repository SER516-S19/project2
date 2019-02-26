package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Class QuestionsDAOBean is a class that comes after create quiz Page
 * 
 * @author trupti khatavkar
 * @version 1.2
 * @date 02/26/2019
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

		Map<String, String> answerChoices = new HashMap<>();

		String str = questionsVO.getCorrectAnswer();
		String arrOfStr[] = str.split(",");
		System.out.println(arrOfStr.length);
		for (int i = 0; i < arrOfStr.length; i++) {
			answerChoices.put("correctAnswer" + (i + 1), arrOfStr[i]);
		}

		for (String key : answerChoices.values()) {
			System.out.println(key);
		}
		System.out.println(answerChoices.size());
		StringBuilder sb1 = new StringBuilder();
		sb1.append("{");
		int count1 = 0;
		for (Map.Entry<String, String> entry1 : answerChoices.entrySet()) {
			sb1.append("\"");
			sb1.append(entry1.getKey());
			sb1.append("\"");
			sb1.append(":");
			sb1.append("\"");
			sb1.append(entry1.getValue());
			sb1.append("\"");
			count1++;
			if (answerChoices.size() - 1 != count1) {
				sb1.append(",");
			}
		}
		sb1.append("}");

		String correctAnswers = sb1.toString();

		Connection connection = null;
		PreparedStatement query = null;

		connection = ConnectionFactory.getConnection();
		try {
			query = connection.prepareStatement(dbProperties.getProperty("postQuestions"));
			query.setInt(1, questionsVO.getQuizId());
			query.setString(2, questionsVO.getQuestion());
			query.setString(3, correctAnswers);
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
}
