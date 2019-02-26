package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ConnectionFactory;
import model.QuestionsVO;
import java.sql.PreparedStatement;
import javax.servlet.annotation.WebServlet;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;

/*
 *  @Author: Jainish Soni
 *  @Version: 1.1
 *  @Date: 02/25/2019
 */

/*
 * DisplayQuizServlet class is created to display the question of a quiz to the
 * student.
 */
public class DisplayQuizServlet extends HttpServlet {
	/*
	 * This method will establish the connection with the database and will fetch
	 * every detail to display the quiz for a student.
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		try {
			int quizId = Integer.parseInt(req.getParameter("quizId"));
			List<QuestionsVO> list = new ArrayList<QuestionsVO>();
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			String hostName = "showtimefinder.database.windows.net";
			String dbName = "ser516_db";
			String user = "scrum_mates@showtimefinder";
			String password = "Azure@Cloud";
			String url = String.format(
					"jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
							+ "hostNameInCertificate=*.database.windows.net;loginTimeout=30;",
					hostName, dbName, user, password);
			Connection connection = DriverManager.getConnection(url);
			String schema = connection.getSchema();
			System.out.println("Successful connection - Schema: " + schema);

			PreparedStatement query = connection
					.prepareStatement("select * from [dbo].[questions] where quizId = ?");
			query.setInt(1, quizId);
			ResultSet questionSet = query.executeQuery();
			QuestionsVO questionsVO = null;

			while (questionSet.next()) {
				int questionId = questionSet.getInt("questionId");
				int quizID = questionSet.getInt("quizId");
				int totalPoints = questionSet.getInt("totalPoints");
				String question = questionSet.getString("question");
				String answer = questionSet.getString("actualAnswer");
				String choices = questionSet.getString("totalChoices");

				JSONParser parser = new JSONParser();
				JSONObject jo = (JSONObject) parser.parse(choices);

				String choice1 = (String) jo.get("incorrectAnswer1");
				String choice2 = (String) jo.get("incorrectAnswer2");
				String choice3 = (String) jo.get("incorrectAnswer3");

				questionsVO = new QuestionsVO(questionId, totalPoints, answer, choice1, choice2, choice3, question);
				
				list.add(questionsVO);
			}
			
			HttpSession session = req.getSession();
			
			session.setAttribute("list", list);
			
			res.sendRedirect(req.getContextPath() + "/DisplayQuizServlet.ftl");
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) {

	}
}