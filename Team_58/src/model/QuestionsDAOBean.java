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
 * @author Aditya Samant
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
	 * @throws IOException
	 * @throws ServletException
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

	@Override
	public List<displayQuestionsVO> getQuestionsForQuiz(int quizID) throws SQLException, ClassNotFoundException, ParseException{
		
		Connection connection = null;
		PreparedStatement query = null;
		ResultSet resultData = null;
		
		connection = ConnectionFactory.getConnection();
		query = connection.prepareStatement(dbProperties.getProperty("getQuizQuestions"));
		query.setInt(1, quizID);
		resultData = query.executeQuery();
		List<displayQuestionsVO> list = new ArrayList<>();
		
		while(resultData.next()){
			int totalPoints = resultData.getInt("totalPoints");
			String question = resultData.getString("question");
			String answers = resultData.getString("actualAnswer");
			String choices = resultData.getString("totalChoices");
			int qid = resultData.getInt("questionId");
			
			JSONParser parser = new JSONParser();
			JSONObject incorrectJO = (JSONObject) parser.parse(choices);
			JSONObject correctJO = (JSONObject) parser.parse(answers);
			
			List<String> incorrectAnswers = new ArrayList();
			List<String> correctAnswers = new ArrayList();
			
			int i = 1;
			String choice = (String) incorrectJO.get("incorrectAnswer" + i);
			while(choice != null){
				incorrectAnswers.add(choice);
				i++;
				choice = (String) incorrectJO.get("incorrectAnswer" + i);
			}
			
			i = 1;
			choice = (String) correctJO.get("correctAnswer" + i);
			while(choice != null){
				correctAnswers.add(choice);
				i++;
				choice = (String) correctJO.get("correctAnswer" + i);
			}
			displayQuestionsVO displayquestionVO = new displayQuestionsVO(qid, totalPoints, correctAnswers, incorrectAnswers, question);
			list.add(displayquestionVO);
		}
		return list;
	}

	/**
	 * Update a question entry in the Questions table based on info obtained from ViewQuiz page.
	 *
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 * 
	 * @param question 
	 * @param answer    
	 * @param wrongOne   
	 * @param wrongTwo  
	 * @param wrongThree
	 * @param points 
	 * @param qId question id
	 * @param mcq 
	 * 
	 * @see controller/ViewQuizServlet.java
	 * 
	 * @version 1.2
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
	 * The following method retrieves information and creates a list of Question objects.
	 * 
	 * @param quizId 
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws ParseException         
	 * 
	 * @return list 
	 */
	@Override
	public List<QuestionsVO> getQuestionsInfo(int quizId) throws SQLException, ClassNotFoundException{

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
	 			   
	 			   String choice1 = (String) jo.get("incorrectAnswer1");
	 			   String choice2 = (String) jo.get("incorrectAnswer2");
	 			   String choice3 = (String) jo.get("incorrectAnswer3");
	 			   
	 			   QuestionsVO quiz = new QuestionsVO(questionId, points, answer, choice1, choice2, choice3, question);
		 		   list.add(quiz);
			   }
		}catch(ParseException e) {
			e.printStackTrace();
		}catch(Exception ex) { //others
			ex.printStackTrace();
		}
		return list;	
	}
	
	@Override
	public List<displayQuestionsVO> getStudentQuestionsForInfo(int quizID)
			throws SQLException, ClassNotFoundException, ParseException {
		// TODO Auto-generated method stub
		return null;
	}	
}

