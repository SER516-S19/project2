package Team76.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import Team76.Entity.QuizEntity;

public class StudentInsertQuery {

	private DatabaseConnection con;
	private Connection connect;

	public StudentInsertQuery() throws Exception {
		con = new DatabaseConnection();
		connect = con.establishConnection();
	}

	public void answerEntry(int studentId, int questionId, int quizId, int marks, String answer) throws Exception {

		String query = "INSERT INTO answer_table VALUES(?,?,?,?,?)";
		PreparedStatement statement = connect.prepareStatement(query);
		statement.setInt(1, studentId);
		statement.setInt(2, quizId);
		statement.setInt(3, questionId);
		statement.setString(4, answer);
		statement.setInt(5, marks);
		statement.executeUpdate();
	}

	public String[] getSolution(int questionId) throws SQLException {
		String solution[] = new String[2];
		String query = "Select marks,CORRECT_ANSWER from question where questionId=?";
		PreparedStatement statement = connect.prepareStatement(query);
		statement.setInt(1, questionId);
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			solution[0] = Integer.toString(rs.getInt(1));
			solution[1] = rs.getString(2);
		}
		return solution;
	}

	public String getQuizName(int quizId) throws SQLException {

		String query = "Select QuizTitle from quiz where QuizId=?";
		String quizTitle = "";
		PreparedStatement statement = connect.prepareStatement(query);
		statement.setInt(1, quizId);
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			quizTitle = rs.getString(1);
		}
		return quizTitle;

	}

	public String getStudentName(int studentId) throws SQLException {
		String query = "Select name from user where id=?";
		String studentName = "";
		PreparedStatement statement = connect.prepareStatement(query);
		statement.setInt(1, studentId);
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			studentName = rs.getString(1);
		}
		return studentName;
	}

	public int getGrade(int quizId, int studentId) throws SQLException {
		String query = "Select sum(marks) as total from answer_table where studentId=? and quizId=?";
		int grade = 0;
		PreparedStatement statement = connect.prepareStatement(query);
		statement.setInt(1, studentId);
		statement.setInt(2, quizId);
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			grade = rs.getInt(1);
		}
		return grade;
	}

	public void gradeEntry(int studentId, int quizId, String quizTitle, String studentName, int grade)
			throws SQLException {

		String query = "INSERT INTO grade VALUES(?,?,?,?,?)";
		PreparedStatement statement = connect.prepareStatement(query);
		statement.setInt(1, studentId);
		statement.setInt(2, quizId);
		statement.setString(3, quizTitle);
		statement.setString(4, studentName);
		statement.setInt(5, grade);
		statement.executeUpdate();
	}

	public void connectionClose() throws SQLException {
		connect.close();

	}
}
