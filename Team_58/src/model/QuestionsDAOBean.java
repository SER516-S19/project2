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
import java.util.logging.Logger;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import controller.DisplayQuizServlet;

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

		Map<String, String> incorrectChoices = new HashMap<>();
		Map<String, String> correctChoices = new HashMap<>();

		for(int i = 0; i < questionsVO.getIncorrectAnswers().size(); i++)
		{
			String wrongAnswer = questionsVO.getIncorrectAnswers().get(i);
			incorrectChoices.put("incorrectAnswer" + (i + 1), wrongAnswer);
		}
		
		for(int i = 0; i < questionsVO.getCorrectAnswers().size(); i++)
		{
			String rightAnswer = questionsVO.getCorrectAnswers().get(i);
			correctChoices.put("correctAnswer" + (i + 1), rightAnswer);
		}

		StringBuilder sb = new StringBuilder();
		sb.append("{");
		int count = 0;
		for (Map.Entry<String, String> entry : incorrectChoices.entrySet()) {
			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\"");
			sb.append(":");
			sb.append("\"");
			sb.append(entry.getValue());
			sb.append("\"");
			count++;
			if (incorrectChoices.size() - 1 != count) {
				sb.append(",");
			}
		}
		sb.append("}");

		String incorrectAnswers = sb.toString();
		
		sb = new StringBuilder();
		sb.append("{");
		count = 0;
		for (Map.Entry<String, String> entry : correctChoices.entrySet()) {
			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\"");
			sb.append(":");
			sb.append("\"");
			sb.append(entry.getValue());
			sb.append("\"");
			count++;
			if (correctChoices.size() - 1 != count) {
				sb.append(",");
			}
		}
		sb.append("}");

		String correctAnswers = sb.toString();

		Connection connection = null;
		PreparedStatement query = null;

		connection = ConnectionFactory.getConnection();
		try {
			query = connection.prepareStatement(dbProperties.getProperty("postQuestions"));
			query.setInt(1, questionsVO.getQuizId());
			query.setString(2, questionsVO.getQuestion());
			query.setString(3, correctAnswers);
			query.setString(4, incorrectAnswers);
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
			String answers = resultData.getString("actualAnswer");
			String choices = resultData.getString("totalChoices");
			
			JSONParser parser = new JSONParser();
			JSONObject incorrectJO = (JSONObject) parser.parse(choices);
			JSONObject correctJO = (JSONObject) parser.parse(answers);
			
			List<String> incorrectAnswers = new ArrayList(3);
			List<String> correctAnswers = new ArrayList(3);
			
			int i = 1;
			String choice = (String) incorrectJO.get("incorrectAnswer" + i);
			while(choice != null)
			{
				incorrectAnswers.add(choice);
				i++;
				choice = (String) incorrectJO.get("incorrectAnswer" + i);
			}
			
			i = 1;
			choice = (String) correctJO.get("correctAnswer" + i);
			while(choice != null)
			{
				correctAnswers.add(choice);
				i++;
				choice = (String) correctJO.get("correctAnswer" + i);
			}
			
			QuestionsVO questionVO = new QuestionsVO(quizID, totalPoints, correctAnswers, incorrectAnswers, question);
			list.add(questionVO);
		}
		
		return list;
	}
}