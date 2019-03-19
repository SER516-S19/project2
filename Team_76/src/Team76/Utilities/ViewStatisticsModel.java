package Team76.Utilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import Team76.Database.DatabaseConnection;
import Team76.Entity.GradeEntity;
import Team76.Entity.QuizEntity;

/**
 * SER516-Project2 File content- Statistics
 * 
 * @author Nikhila Saini,nsaini3@asu.edu
 * @since 03/15/2019
 *
 **/

public class ViewStatisticsModel {
	private DatabaseConnection connect = null;
	private Connection conn = null;
	private Statement stmt = null;

	public ViewStatisticsModel() {
		try {
			connect = new DatabaseConnection();
			conn = connect.establishConnection();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	public List<GradeEntity> getQuiz(String quizId) {
		ResultSet resultSet = null;
		List<GradeEntity> gradeList = new LinkedList<>();

		try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM grade WHERE QuizId=" + quizId;
			resultSet = stmt.executeQuery(sql);
			while (resultSet.next()) {
				GradeEntity statisticsList = new GradeEntity();
				statisticsList.setQuizId(resultSet.getInt("QuizId"));
				statisticsList.setQuizTitle(resultSet.getString("quiztitle"));
				statisticsList.setStudentName(resultSet.getString("studentName"));
				statisticsList.setGrade(resultSet.getString("grade"));
				gradeList.add(statisticsList);
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
		return gradeList;

	}

	public List<GradeEntity> getMaxMin(String quizId) {
		ResultSet resultSet = null;
		List<GradeEntity> gradeMaxMin = new LinkedList<>();

		try {
			stmt = conn.createStatement();

			String sql = "select * from grade where grade = ( select max(grade) from grade ) and QuizId=" + quizId
					+ " union all " + " select * from grade where grade = ( select min(grade) from grade ) and QuizId="
					+ quizId;

			resultSet = stmt.executeQuery(sql);
			while (resultSet.next()) {
				GradeEntity maxMin = new GradeEntity();
				maxMin.setQuizId(resultSet.getInt("QuizId"));
				maxMin.setStudentName(resultSet.getString("studentName"));
				maxMin.setGrade(resultSet.getString("grade"));
				gradeMaxMin.add(maxMin);
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
		return gradeMaxMin;

	}

}
