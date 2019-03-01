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
			if (totalChoices.size() != count) {
				sb.append(",");
			}
		}
		sb.append("}");

		String incorrectAnswer = sb.toString();

		Map<String, String> answerChoices = new HashMap<>();

		String str = questionsVO.getCorrectAnswer();
		String arrOfStr[] = str.split(",");
		for (int i = 0; i < arrOfStr.length; i++) {
			answerChoices.put("correctAnswer" + (i + 1), arrOfStr[i]);
		}

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
			if (answerChoices.size() != count1) {
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

	/**
	 * updateQuestionsTable Update a question entry in the Questions table based on
	 * info obtained from ViewQuiz page.
	 * 
	 * 
	 * @author Aditya Samant
	 * @throws SQLException           error occurs during connecting or updating the
	 *                                information in SQL
	 * @throws ClassNotFoundException for Connection Factory
	 * 
	 * @param question   the question
	 * @param answer     the solution choice
	 * @param wrongOne   wrong answer number one
	 * @param wrongTwo   wrong answer number two
	 * @param wrongThree wrong answer number three
	 * @param points points for the question
	 * @param qId the question ID
	 * @param mcq whether the question is multiple choices or not
	 * 
	 * @see controller/ViewQuizServlet.java
	 * @version 1.1
	 * */
	@SuppressWarnings("unchecked")
	public void updateQuestionsTable(String question, String answer, String wrongOne,
			String wrongTwo, String wrongThree, int points, int qId) throws SQLException, ClassNotFoundException{
		
		Connection connection = null;
		PreparedStatement query = null;
		connection = ConnectionFactory.getConnection();
		
		int mcq = 0;
		
		try {
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("incorrectAnswer1", wrongOne);
			jsonObj.put("incorrectAnswer2", wrongTwo);
			jsonObj.put("incorrectAnswer3", wrongThree);
			
			JSONObject answerObj = new JSONObject();
			if(answerObj.size() == 1) {
				mcq = 1;
			}
			String [] arr = answer.split(", ");

			String temp = null;	
			for (int i = 0; i < arr.length; i++) {
				temp = "correctAnswer"+ Integer.toString(i+1);
				System.out.println("temp1 "+ temp);
				answerObj.put(temp, arr[i]);
			}
			
		    answer = answerObj.toJSONString();



			query = connection.prepareStatement(dbProperties.getProperty("updateQuestionsTable"));
			query.setString(1, question);
			query.setString(2, answer);
			query.setString(3, jsonObj.toJSONString());
			query.setInt(4, points);
			query.setInt(5, mcq);
			query.setInt(6, qId);
			
			query.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
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
	public List<QuestionsVO> getQuestionsInfo(int quizId) throws SQLException, ClassNotFoundException {

		List<QuestionsVO> list = new ArrayList<QuestionsVO>();

		Connection connection = null;
		PreparedStatement query = null;
		ResultSet result = null;

		connection = ConnectionFactory.getConnection();

		query = connection.prepareStatement(dbProperties.getProperty("getQuestionsInfo"));
		query.setInt(1, quizId);
		result = query.executeQuery();
		try {
		    while (result.next()) {
		    	   int questionId = result.getInt("questionId");
	 			   int points = result.getInt("totalPoints");
	 			   String question = result.getString("question");
	 			   
	 			   
	 			   String answer = result.getString("actualAnswer"); 
	 			   String choices = result.getString("totalChoices"); 
	 			   
	 			   JSONParser parser = new JSONParser();
	 			   JSONObject jo = (JSONObject) parser.parse(choices);
	 			   JSONObject jo2 = (JSONObject)parser.parse(answer);
	 			   String temp = "correctAnswer";
	 			 
	 			   StringBuilder ans = new StringBuilder();
	 			  
	 			   for(int i = 1; i <=jo2.size(); i++) {
	 				   
	 				  ans.append((String) jo2.get(temp+Integer.toString(i)));
	 				  
	 				  if(jo2.size() != i) {
	 					  ans.append(", ");
	 				  }
	 			   }
	 			   
	 			   answer = ans.toString();
	 			   
	 			   String choice1 = (String) jo.get("incorrectAnswer1");
	 			   String choice2 = (String) jo.get("incorrectAnswer2");
	 			   String choice3 = (String) jo.get("incorrectAnswer3");
	 			   
	 			   
	 			   QuestionsVO quiz = new QuestionsVO(questionId, points, answer, 
		 					   						choice1, choice2, choice3, question);
		 			   list.add(quiz);
			   }
		}catch(ParseException e) {

			e.printStackTrace();
		}
		return list;
	}
}
