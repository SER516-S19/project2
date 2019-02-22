package edu.asupoly.ser516.model;

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
 * @version 1.0
 * @date 02/22/2019
 **/

public class QuestionsDAOBean implements QuestionsDAO {

	private static Properties dbProperties = new Properties();

	public QuestionsDAOBean() throws IOException {
		dbProperties.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("database.properties"));
	}

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
		// int resultData;

		connection = ConnectionFactory.getConnection();

		query = connection.prepareStatement(dbProperties.getProperty("postQuestions"));
		query.setInt(1, questionsVO.getQuizId());
		query.setString(2, questionsVO.getQuestion());
		query.setString(3, questionsVO.getCorrectAnswer());
		query.setString(4, incorrectAnswer);
		query.setString(5, questionsVO.getTotalPoints());
		query.setBoolean(6, questionsVO.isMCQ());

		query.executeUpdate();

	}

}
