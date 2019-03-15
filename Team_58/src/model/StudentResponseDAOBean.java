package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import controller.ProfessorHomeServlet;
/**
 * Class StudentResponseDAOBean with the following method:
 * 	a. update studentResponse score based on quizId after grade quiz command
 * @author akashkadam
 * @version 1.0
 * 
 */
public class StudentResponseDAOBean implements StudentResponseDAO {

	private static Logger log = Logger.getLogger(ProfessorHomeServlet.class.getName());
	
	private static Properties dbProperties = new Properties();

	public StudentResponseDAOBean() throws IOException {
		dbProperties.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("database.properties"));
	}
	@Override
	public void updateStudentResponse(int quizId) {


		Connection connection = null;
		PreparedStatement query = null;

		try {
			
			connection = ConnectionFactory.getConnection();
			query = connection.prepareStatement(dbProperties.getProperty("updateStudentResponse"));
			query.setInt(1,quizId);
			query.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			log.info(e.getMessage());
		}
	}
	
	@Override
	public void InsertQuizAnswers(int courseId , int quizId ,int userId , int questionId , String answerSelected , int score)   {
		Connection connection = null;
		PreparedStatement query = null;
		ResultSet resultData = null;
		
		
		try {
		connection = ConnectionFactory.getConnection();
		query = connection.prepareStatement(dbProperties.getProperty("inserStudentResponse"));
		
		query.setInt(1, courseId);
		query.setInt(2, quizId);
		query.setInt(3, userId);
		query.setInt(4, questionId);
		query.setString(5, answerSelected);
		query.setInt(6, score);
		query.executeUpdate();
	}
	catch (ClassNotFoundException | SQLException e) {
		log.info(e.getMessage());
		}
	}

	public List<StudentResponseVO> getStudentListFromQuizIdQuestionId(int quizId, int questionId) {

		Connection connection = null;
		PreparedStatement query = null;
		ResultSet resultData = null;
		List<StudentResponseVO> list = new ArrayList<>();
		try {
			connection = ConnectionFactory.getConnection();
			
			query = connection.prepareStatement(dbProperties.getProperty("getStudentQuery"));
			query.setInt(1,quizId);
			query.setInt(2, questionId);

			resultData = query.executeQuery();

			while(resultData.next()) {
				int userId = resultData.getInt("userId");
				String answerSelected = resultData.getString("answerSelected");
				StudentResponseVO student = new StudentResponseVO(userId,answerSelected);
				list.add(student);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			log.info(e.getMessage());
		}
		
		
		return list;
	
	
	}
	
	@Override
	public void updateStudentResponse(int quizId, int questionId, int userId,int score) {

		Connection connection = null;
		PreparedStatement query = null;

		try {
			connection = ConnectionFactory.getConnection();
			query = connection.prepareStatement(dbProperties.getProperty("updateStudentResponseForScore"));
			query.setInt(1,score);
			query.setInt(2,quizId);
			query.setInt(3,userId );
			query.setInt(4,questionId);
			query.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			log.info(e.getMessage());
		}
	}
}


