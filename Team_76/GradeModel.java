package Team76.Utilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Team76.Database.DatabaseConnection;
import Team76.Entity.GradeEntity;



/**
 * The class GradeModel is utility of grade sql database
 * @author Hsin-Jung Lee
 * Version: 3
 */
public class GradeModel {

	private DatabaseConnection databaseConnection = null;
	private Connection connection = null;
	private Statement statement = null;
	private String dataBase = "";
	private ResultSet resultSet = null;
	
	public GradeModel(){
		
		try {
			databaseConnection = new DatabaseConnection();
			connection = databaseConnection.establishConnection();
			dataBase = "ser516p2";
		} catch (Throwable throwable ) {
			
			throwable.printStackTrace();
		}
	}
	
	public GradeEntity getGrade(String studentId) {
		
		GradeEntity grade = new GradeEntity();
		try {
			statement = connection.createStatement();
			statement.executeUpdate("USE" + dataBase);
			String sql = "SELECT * FROM grade WHERE studentID =" + studentId;
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				grade.setStudentId(resultSet.getInt("studentID"));
				grade.setQuizId(resultSet.getInt("QuizId"));
				grade.setQuizTitle(resultSet.getString("quiztitle"));
				grade.setStudentName(resultSet.getString("studentName"));
				grade.setGrade(resultSet.getString("grade"));
				System.out.println(grade.getGrade());
				close (statement);
			}
		} catch (SQLException exception ) {
			exception.printStackTrace();
		} 
		return grade;
		
	}

	private void close( Statement statement) {
		try {
			
			if (statement != null) {
				statement.close();
			}
			
		} catch (SQLException sqlexception) {
			sqlexception.printStackTrace();
			System.out.println("Not all database close!");
		}
	}
}


