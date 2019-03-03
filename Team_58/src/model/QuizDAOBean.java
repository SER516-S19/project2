package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * Class QuizDAOBean is a class that comes after Professor Home Page 
 * and Course Dashboard page 
 * 
 * @author narenkumarkonchada & carnic
 * @version 1.2
 * @date 02/22/2019
 **/

public class QuizDAOBean implements QuizDAO{
	
	private static Properties dbProperties = new Properties();
	
	public QuizDAOBean() {
		
		try {
			dbProperties.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("database.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This method is to get the list of all Quizzes 
	 *@param request  Request made to server
	 *@param response  Responses from server
	 *
	 * @throws IOException, ServletException
	 */
	
	@Override
	public List<QuizVO> getQuizzesForCourse(int courseId) throws SQLException, ClassNotFoundException {
		
		Connection connection = null;
		PreparedStatement query = null;
		ResultSet resultData = null;
		
		connection = ConnectionFactory.getConnection();
		List<QuizVO> list = new ArrayList<>();
				
		try{
			query = connection.prepareStatement(dbProperties.getProperty("getQuizzesForACourse"));
			query.setInt(1, courseId);
	
			resultData = query.executeQuery();
			
			while(resultData.next()) {
				int courseID = resultData.getInt("courseId");
				int quizId = resultData.getInt("quizId");
				int assignedTime = resultData.getInt("assignedTime");
				boolean isGraded = resultData.getBoolean("isGraded");
				String quizInstruction = resultData.getString("quizInstruction"); 
				Date quizScheduledDate = resultData.getDate("quizScheduledDate");
				boolean isShuffled = resultData.getBoolean("isShuffled");
				String quizTitle = resultData.getString("quizTitle");

				QuizVO quiz = new QuizVO(courseID, quizId, isGraded, assignedTime, quizInstruction, quizScheduledDate, isShuffled, quizTitle);

				list.add(quiz);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			resultData = null;
			query = null;
			connection = null;
		}
		return list;
	}

	/**
	 * This method is to create a quiz
	 * Insert quiz details into quiz table 
	 *@param QuizVO object to insert values
	 *
	 * @throws SQLException, ClassNotFoundException
	 */
	

	public void insertingQuizDetails(QuizVO quizVO) throws SQLException, ClassNotFoundException {

		
		Connection connection = null;
		PreparedStatement query = null;
		ResultSet resultData = null;
		
		connection = ConnectionFactory.getConnection();
		
		try{       
			query = connection.prepareStatement(dbProperties.getProperty("postCreateQuiz"));
			query.setInt(1,quizVO.getCourseId());
			query.setBoolean(2, false);
			query.setInt(3, quizVO.getAssignedTime());
			query.setString(4, quizVO.getQuizInstruction());
			java.util.Date uDate = new java.util.Date();
			uDate = quizVO.getQuizScheduledDate();
			java.sql.Date sDate = convertUtilToSql(uDate);
			query.setDate(5, sDate);
			query.setBoolean(6, quizVO.isShuffled());
			query.setString(7, quizVO.getQuizTitle());
			query.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			resultData = null;
			query = null;
			connection = null;
		}
	}
	
	/**
	 * This method is to convert java date Object to SQL date object 
	 * @param uDate
	 * @return sDate
	 */
	
	private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
	
	/**
	 * This method is to retrieve quiz id from db
	 *@param QuizVO object to retrieve value 
	 *
	 * @throws ClassNotFoundException, ServletException
	 */
	
	public int gettingQuizId (QuizVO quizVO) throws  SQLException, ClassNotFoundException {

		
		Connection connection = null;
		PreparedStatement query = null;
		connection = ConnectionFactory.getConnection();
		int quizId = 0;
		ResultSet rs = null;
		
		try {
			query = connection.prepareStatement(dbProperties.getProperty("getQuizId"));
			query.setInt(1,quizVO.getCourseId());
			query.setBoolean(2, false);
			query.setInt(3, quizVO.getAssignedTime());
			query.setString(4, quizVO.getQuizInstruction());
			java.util.Date uDate = new java.util.Date();
			uDate = quizVO.getQuizScheduledDate();
			java.sql.Date sDate = convertUtilToSql(uDate);
			query.setDate(5, sDate);
			query.setBoolean(6, quizVO.isShuffled());
			query.setString(7, quizVO.getQuizTitle());
			rs = query.executeQuery();
			
			while (rs.next()) {
				quizId = rs.getInt("quizId");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			rs = null;
			query = null;
			connection = null;
		}
		return quizId;
	}

	@Override
	public List<QuizVO> getQuizzesForStudent(UserVO student) throws SQLException, ClassNotFoundException {
		
		Connection connection = null;
		PreparedStatement query = null;
		ResultSet resultData = null;
		
		connection = ConnectionFactory.getConnection();
		
		query = connection.prepareStatement(dbProperties.getProperty("getQuizzesForStudent"));
		query.setInt(1, student.getUserId());

		resultData = query.executeQuery();
		
		List<QuizVO> list = new ArrayList<>();
		
		while(resultData.next()) {

			int courseID = resultData.getInt("courseId");
			int quizId = resultData.getInt("quizId");
			int assignedTime = resultData.getInt("assignedTime");
			boolean isGraded = resultData.getBoolean("isGraded");
			String quizInstruction = resultData.getString("quizInstruction"); 
			Date quizScheduledDate = resultData.getDate("quizScheduledDate");
			boolean isShuffled = resultData.getBoolean("isShuffled");
			String quizTitle = resultData.getString("quizTitle");

			QuizVO quiz = new QuizVO(courseID, quizId, isGraded, assignedTime, quizInstruction, quizScheduledDate, isShuffled, quizTitle);
			list.add(quiz);
		}
		
		return list;
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

}