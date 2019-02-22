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
 * @author narenkumarkonchada
 * @version 1.0
 * @date 02/21/2019
 **/

public class QuizDAOBean implements QuizDAO{
	
	private static Properties dbProperties = new Properties();
	
	public QuizDAOBean() throws IOException {
		dbProperties.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("database.properties"));
	}

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
	
}
