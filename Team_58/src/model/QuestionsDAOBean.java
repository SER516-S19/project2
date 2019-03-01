package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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

	@Override
	public List<QuestionsVO> getQuestionsForQuiz(int quizID) throws SQLException, ClassNotFoundException, ParseException
	{
		Connection connection = null;
		PreparedStatement query = null;
		ResultSet resultData = null;
		
		connection = ConnectionFactory.getConnection();
		
		query = connection.prepareStatement(dbProperties.getProperty("getQuizQuestions"));
		query.setInt(1, quizID);

		resultData = query.executeQuery();
		
		List<QuestionsVO> list = new ArrayList<>();
		
		while(resultData.next())
		{
			int totalPoints = resultData.getInt("totalPoints");
			String question = resultData.getString("question");
			String answer = resultData.getString("actualAnswer");
			String choices = resultData.getString("totalChoices");
			
			JSONParser parser = new JSONParser();
			JSONObject jo = (JSONObject) parser.parse(choices);
			
			String choice1 = (String) jo.get("incorrectAnswer1");
			String choice2 = (String) jo.get("incorrectAnswer2");
			String choice3 = (String) jo.get("incorrectAnswer3");
			
			QuestionsVO questionVO = new QuestionsVO(quizID, totalPoints, answer, choice1, choice2, choice3, question);
			list.add(questionVO);
		}
		
		return list;
	}
}