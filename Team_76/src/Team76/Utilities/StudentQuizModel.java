package Team76.Utilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import Team76.Database.DatabaseConnection;
import Team76.Entity.QuizEntity;

/**
 * retrieve quiz data from mysql database
 * author: Hongfei Ju version: 1.1
 */
public class StudentQuizModel {
	private DatabaseConnection connect = null;
	private Connection conn = null;
	private Statement stmt = null;
	private String dbname = "ser516p2";

	public StudentQuizModel() {
		try {
			connect = new DatabaseConnection();
			conn = connect.establishConnection();
			dbname = "ser516p2";
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	public List<QuizEntity> list() {
		Date today = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String simpleToday = dateFormat.format(today);
		ResultSet resultSet = null;
		List<QuizEntity> quizzes = new LinkedList<>();
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate("use " + dbname);
			String sql = "SELECT * FROM quiz WHERE status = 'valid' AND DueDate >= " + simpleToday;
			resultSet = stmt.executeQuery(sql);
			while (resultSet.next()) {
				QuizEntity quiz = new QuizEntity();
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
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
				se2.printStackTrace();
				System.out.println("Not all DB resources freed!");
			}
		}
		return quizzes;
	}

}
