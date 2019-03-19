package Team76.Utilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Team76.Database.DatabaseConnection;
import Team76.Entity.GradeEntity;

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

	public List<GradeEntity> getMaxMin(List<GradeEntity> gradeList) {
		ResultSet resultSet = null;
		List<GradeEntity> gradeMaxMin = new ArrayList<>();
		GradeEntity maxGrade,minGrade;
		maxGrade=gradeList.get(0);
		minGrade=gradeList.get(0);
		int max = Integer.parseInt(maxGrade.getGrade());
		int min = Integer.parseInt(minGrade.getGrade());
		for(GradeEntity entity:gradeList) {
			
			int compare = Integer.parseInt(entity.getGrade());
			if(compare >= max ) {
				maxGrade=entity;
			}
			if(compare < min) {
				minGrade=entity;
			}
			
		}
		gradeMaxMin.add(maxGrade);
		gradeMaxMin.add(minGrade);
		return gradeMaxMin;

	}

}
