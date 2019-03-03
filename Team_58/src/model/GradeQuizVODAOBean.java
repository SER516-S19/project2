package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import controller.ProfessorHomeServlet;

/**
 * Class GradeQuizVODAOBean with the following method:
 * 	a. get GradeVO list
 * @author akashkadam
 * @version 1.0
 * 
 */
public class GradeQuizVODAOBean implements GradeQuizVODAO {

private static Logger log = Logger.getLogger(ProfessorHomeServlet.class.getName());
	
	private static Properties dbProperties = new Properties();

	public GradeQuizVODAOBean() throws IOException {
		dbProperties.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("database.properties"));
	}
	
	@Override
	public List<GradeQuizVO> getgradeQuiz(int quizId,String quizName) {

		
		Connection connection = null;
		PreparedStatement query = null;
		ResultSet resultData = null;
		List<GradeQuizVO> list = new ArrayList<>();
		try {
			connection = ConnectionFactory.getConnection();
			
			query = connection.prepareStatement(dbProperties.getProperty("getgradeQuizQuery"));
			query.setInt(1,quizId);

			resultData = query.executeQuery();

			while(resultData.next()) {
				int score = resultData.getInt("score");
				String firstName = resultData.getString("firstname");
				String lastName = resultData.getString("lastname"); 
				GradeQuizVO gradeQuiz = new GradeQuizVO(score,firstName,lastName,quizName);
				list.add(gradeQuiz);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			log.info(e.getMessage());
		}
		
		
		return list;
	
	}

}
