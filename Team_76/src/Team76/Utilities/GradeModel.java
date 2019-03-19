package Team76.Utilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Team76.Database.DatabaseConnection;
import Team76.Entity.GradeEntity;

/**
 * @author Janani Anand, janans3@asu.edu This class fetches the student details
 *         and sends it in a session
 */
public class GradeModel {

	private DatabaseConnection databaseConnection = null;
	private Connection connection = null;
	private Statement statement = null;

		  
	private ResultSet resultSet = null;

	public GradeModel() {

		try {
			databaseConnection = new DatabaseConnection();
			connection = databaseConnection.establishConnection();
		} catch (Throwable throwable) {

			throwable.printStackTrace();
		}
	}

	public List<GradeEntity> getGrade(int studentId) {
		List<GradeEntity> grades= new ArrayList<>();
		try {
			statement = connection.createStatement();
			String sql = "SELECT * FROM grade WHERE studentID =" + studentId;
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				GradeEntity grade = new GradeEntity();
				grade.setStudentId(resultSet.getInt("studentID"));
				grade.setQuizId(resultSet.getInt("QuizId"));
				grade.setQuizTitle(resultSet.getString("quiztitle"));
				grade.setStudentName(resultSet.getString("studentName"));
				grade.setGrade(resultSet.getString("grade"));
				grades.add(grade);
			}
			statement.close();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return grades;

	}
}
