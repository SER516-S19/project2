package edu.asupoly.ser516.model;

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
 * Implements ViewQuiz interface and establishes connection between
 * database and Servlet.
 * 
 *  @see edu.asupoly.ser516.controller/ViewQuizServlet.java
 *  @see resources/viewQuiz.ftl
 * 	@author Aditya Samant
 * 	@version 1.0
 * 	@date 02/22/2019
 */
public class ViewQuizDAOBean implements ViewQuizDAO {

	private static Properties dbProperties = new Properties();
	
	public ViewQuizDAOBean() throws IOException {
		dbProperties.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("database.properties"));
	}
	
	/**
	 * Makes a connection to the database via ConnectionFactory to gain information about quiz
	 * and returns a custom quiz object to be used by ViewQuizServlet.java
	 * 
	 * @param quizId the id of the quiz that is being retrieved, is primary key.
	 * @throws SQLException in case of database error
	 * @throws ClassNotFoundException in case referencing class does not exist
	 * @return quiz A quiz object with necessary information to display on viewQuiz page
	 * */
	@Override
	public QuizVO getQuizInfo(int quizId) throws SQLException, ClassNotFoundException {
		//return object
	    QuizVO quiz = null;
				
		Connection connection = null;
		PreparedStatement query = null;
		ResultSet result = null;
		
		connection = ConnectionFactory.getConnection();
		
		query = connection.prepareStatement(dbProperties.getProperty("getQuizInfo"));
		query.setInt(1, quizId);
		result = query.executeQuery();
		
		//Initialize Quiz Information
	    String quizName = "";
	    String instruction = "";
	    Date scheduledDate = new Date(0);
	    boolean graded = true;
		
		try {
			
			if(result.next()) {
				
				quizName = result.getString("quizTitle");
				instruction = result.getString("quizInstruction");
				scheduledDate = result.getDate("quizScheduledDate");
			    graded = result.getBoolean("isGraded"); 
			}
			quiz = new QuizVO(quizName, instruction, scheduledDate, graded);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return quiz;
	}
	
	/**
	 * The following method connects with the SQL database via ConnectionFactory and
	 * retrieves information and parses it to appropriate formats prior to creating a list
	 * of Question objects.
	 * 
	 * @param quizId the id of the quiz whose questions are being retrieved
	 * @throws SQLException  in case errors exist in the database connection
	 * @throws ClassNotFoundException in class referenced is not found
	 * @throws ParseException in case string cannot be parsed to JSON
	 * 
	 * @return list a list of questions with relevant information used to display on view quiz page.
	 * */
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
	 			   
	 			   //Values read as strings but actually JSON
	 			   String answer = result.getString("actualAnswer"); 
	 			   String choices = result.getString("totalChoices"); 
	 			   
	 			   JSONParser parser = new JSONParser();
	 			   JSONObject jo = (JSONObject) parser.parse(choices);
	 			   //JSONObject jo2 = (JSONObject) parser.parse(answer);
	 			   
	 			   String choice1 = (String) jo.get("incorrectAnswer1");
	 			   String choice2 = (String) jo.get("incorrectAnswer2");
	 			   String choice3 = (String) jo.get("incorrectAnswer3");
	 			   //String ans = (String) jo2.get("CORRECT");
	 			   
	 			   QuestionsVO quiz = new QuestionsVO(questionId, points, question, answer, choice1, choice2, choice3);
	 			   list.add(quiz);
			   }
		}catch(ParseException e) {
			e.printStackTrace();
		}
		return list;
	}

}
