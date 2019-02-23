package edu.asupoly.ser516.model;

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
 * 
 * @author narenkumarkonchada & carnic
 * @version 1.1
 * @date 02/21/2019
 **/

public class QuizDAOBean implements QuizDAO{
	
	private static Properties dbProperties = new Properties();
	
	public QuizDAOBean() throws IOException {
		dbProperties.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("database.properties"));
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
		
		query = connection.prepareStatement(dbProperties.getProperty("getQuizzesForACourse"));
		query.setInt(1, courseId);

		resultData = query.executeQuery();
		
		List<QuizVO> list = new ArrayList<>();
		
		while(resultData.next()) {
			int quizId = resultData.getInt("quizId");
			int assignedTime = resultData.getInt("assignedTime");
			boolean isGraded = resultData.getBoolean("isGraded");
			String quizInstruction = resultData.getString("quizInstruction"); 
			Date quizScheduledDate = resultData.getDate("quizScheduledDate");
			boolean isShuffled = resultData.getBoolean("isShuffled");
			String quizTitle = resultData.getString("quizTitle");
			QuizVO quiz = new QuizVO(quizId, isGraded, assignedTime, quizInstruction, quizScheduledDate, isShuffled, quizTitle);
			list.add(quiz);
		}
		
		return list;
	}

	/**
	 * This method is to create a quiz 
	 *@param request  Request made to server
	 *@param response  Responses from server
	 *
	 * @throws IOException, ServletException
	 */
	
	@Override
	public void creatingQuiz(CreateQuizVO createQuizVO) throws SQLException, ClassNotFoundException {
		
		Connection connection = null;
		PreparedStatement query = null;
		ResultSet resultData = null;
		
		connection = ConnectionFactory.getConnection();
		
		query = connection.prepareStatement(dbProperties.getProperty("postCreateQuiz"));
		query.setInt(1,createQuizVO.getCourseId());
		query.setBoolean(2, false);
		query.setInt(3, createQuizVO.getAssignedTime());
		query.setString(4, createQuizVO.getQuizInstructions());
		query.setString(5, createQuizVO.getQuizScheduledDate());
		query.setBoolean(6, createQuizVO.getIsShuffled());
		query.setString(7, createQuizVO.getQuizTitle());

		query.executeUpdate();

	}
	
	public int gettingQuizId (CreateQuizVO createQuizVO) throws  SQLException, ClassNotFoundException {
		
		Connection connection = null;
		PreparedStatement query = null;
		
		connection = ConnectionFactory.getConnection();
		
		query = connection.prepareStatement(dbProperties.getProperty("getQuizId"));
		
		query.setInt(1, createQuizVO.getCourseId());
		query.setBoolean(2, createQuizVO.getIsGraded());
		query.setInt(3, createQuizVO.getAssignedTime());
		query.setString(4, createQuizVO.getQuizInstructions());
		query.setString(5, createQuizVO.getQuizScheduledDate());
		query.setBoolean(6, createQuizVO.getIsShuffled());
		query.setString(7, createQuizVO.getQuizTitle());

		ResultSet rs = query.executeQuery();
		
		int quizId = 0;
		while (rs.next()) {
			quizId = rs.getInt("quizId");
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
			int quizId = resultData.getInt("quizId");
			int assignedTime = resultData.getInt("assignedTime");
			boolean isGraded = resultData.getBoolean("isGraded");
			String quizInstruction = resultData.getString("quizInstruction"); 
			Date quizScheduledDate = resultData.getDate("quizScheduledDate");
			boolean isShuffled = resultData.getBoolean("isShuffled");
			String quizTitle = resultData.getString("quizTitle");
			QuizVO quiz = new QuizVO(quizId, isGraded, assignedTime, quizInstruction, quizScheduledDate, isShuffled, quizTitle);
			list.add(quiz);
		}
		
		return list;
	}
	
	
}
