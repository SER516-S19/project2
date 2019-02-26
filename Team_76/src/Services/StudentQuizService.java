package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import Model.Quiz;

/**
 * retrieve quiz data from mysql database
 * author: Hongfei Ju
 * version: 1.0
 */
public class StudentQuizService {
	private Properties dbProperties = null;
	private Statement stmt = null;
	private Connection conn = null;	
	private String dbname = "ser516p2";
	private String tablename = "quiz";	
	
	public StudentQuizService(){
		try {
		    Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "jhf", "13245768");					
		    conn.setAutoCommit(false);		    
		    dbname = "ser516p2";
		    tablename = "quiz";		    
		} catch (Throwable t) {
		    t.printStackTrace();
		}
	}

	public List<Quiz> list() {
		Date today=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMdd");
		String simpleToday = dateFormat.format(today);		
		ResultSet resultSet = null;
		List<Quiz> quizzes= new LinkedList<>();
		
		try {
			
			stmt = conn.createStatement();
			stmt.executeUpdate("use " + dbname);
			String sql ="SELECT * FROM quiz WHERE status = 'valid' AND DueDate >= "+ simpleToday;
			resultSet = stmt.executeQuery(sql);
			List<String> list = new ArrayList<String>();

			while (resultSet.next()) {
				Quiz quiz = new Quiz();
				quiz.setProfessorId(resultSet.getInt("ProfId"));
				quiz.setQuizId(resultSet.getInt("QuizId"));
				quiz.setQuizStatus(resultSet.getString("status"));
				quiz.setDueDate(resultSet.getDate("DueDate"));
				quiz.setTimeLimit(resultSet.getInt("Timelimit"));
				quiz.setQuizType(resultSet.getString("QuizType"));
				quiz.setQuizTitle(resultSet.getString("quiztitle"));
				quizzes.add(quiz);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
		    try {
		    	if (stmt != null) stmt.close();
		    } catch (SQLException se2) {
		    	se2.printStackTrace();
		    	System.out.println("Not all DB resources freed!");
		    }
		}
		return quizzes;

	}

}
