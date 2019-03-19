package Team76.Utilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Team76.Database.DatabaseConnection;
import Team76.Entity.QuizEntity;
import Team76.Entity.UserEntity;

/**
 * SER516-Project2 File content- Statistics
 * 
 * @author Nikhila Saini,nsaini3@asu.edu
 * @since 03/15/2019
 *
 **/

public class ProfessorQuizModel {
	private DatabaseConnection connect = null;
	private Connection conn = null;
	private Statement stmt = null;

	public ProfessorQuizModel() {
		try {
			connect = new DatabaseConnection();
			conn = connect.establishConnection();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	public List<QuizEntity> quizList(HttpServletRequest request, HttpServletResponse response) {
		ResultSet resultSet = null;
		List<QuizEntity> quizList = new LinkedList<>();
		UserEntity entity = (UserEntity) request.getSession().getAttribute("user");

		try {
			stmt = conn.createStatement();
			String query = "select * from quiz where ProfId = " + entity.getUserId();
			resultSet = stmt.executeQuery(query);

			while (resultSet.next()) {
				QuizEntity quiz = new QuizEntity();
				quiz.setQuizId(resultSet.getInt("QuizId"));
				quiz.setQuizTitle(resultSet.getString("QuizTitle"));
				quizList.add(quiz);
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
		return quizList;

	}
}
