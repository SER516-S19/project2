package Team76.Utilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Team76.Database.DatabaseConnection;
import Team76.Entity.QuizEntity;

/*
 * retrieve quiz info from mysql database
 * author: Janani Anand
 * version: 3.1
 */

public class QuizInstructModel {
	private DatabaseConnection connect = null;
	private Connection conn = null;	
	private Statement stmt = null;
	
	public QuizInstructModel(){
		try {
			connect = new DatabaseConnection();
			conn = connect.establishConnection();
		} catch (Throwable t) {
		    t.printStackTrace();
		}
	}

	public QuizEntity getQuiz(String quizId) {	
		ResultSet resultSet = null;		
		QuizEntity quiztaken = new QuizEntity();
		try {
			stmt = conn.createStatement();
			String sql ="SELECT * FROM quiz WHERE QuizId="+quizId;
			resultSet = stmt.executeQuery(sql);		
			while (resultSet.next()) {
				quiztaken.setProfessorId(resultSet.getInt("ProfId"));
				quiztaken.setQuizId(resultSet.getInt("QuizId"));
				quiztaken.setQuizStatus(resultSet.getString("status"));
				quiztaken.setDueDate(resultSet.getDate("DueDate"));
				quiztaken.setTimeLimit(resultSet.getInt("Timelimit"));
				quiztaken.setQuizType(resultSet.getString("QuizType"));
				quiztaken.setQuizTitle(resultSet.getString("quiztitle"));
				quiztaken.setQuizInstruct(resultSet.getString("qinstruct"));
				System.out.println(quiztaken.getQuizInstruct());
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
		return quiztaken;

	}

}