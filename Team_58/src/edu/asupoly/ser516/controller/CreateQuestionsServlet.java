package edu.asupoly.ser516.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.asupoly.ser516.model.CreateQuizVO;

/**
 * Class CreateQuestionServlet Servlet is a controller that routes the user to
 * Create Questions after Create Quiz.
 * 
 * @author trupti
 * @version 1.0
 * @date 02/20/2019
 **/
public class CreateQuestionsServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

		try {

			String question = req.getParameter("question");
			String correctAnswer = req.getParameter("correctAnswer");
			String incorrectAnswer1 = req.getParameter("incorrectAnswer1");
			String incorrectAnswer2 = req.getParameter("incorrectAnswer2");
			String incorrectAnswer3 = req.getParameter("incorrectAnswer3");
			int totalPoints = Integer.parseInt(req.getParameter("totalPoints"));
			Boolean isMCQ = Boolean.valueOf(req.getParameter("isMCQ"));

			Map<String, String> totalChoices = new HashMap<>();

			totalChoices.put("incorrectAnswer1", incorrectAnswer1);
			totalChoices.put("incorrectAnswer2", incorrectAnswer2);
			totalChoices.put("incorrectAnswer3", incorrectAnswer3);

			StringBuilder sb = new StringBuilder();
			sb.append("{");
			int count = 0;
			for (Map.Entry<String, String> entry : totalChoices.entrySet()) {
				sb.append("\"");
				sb.append(entry.getKey());
				sb.append("\"");
				sb.append(":");
				sb.append("\"");
				sb.append(entry.getValue());
				sb.append("\"");
				count++;
				if (totalChoices.size() - 1 != count) {
					sb.append(",");
				}
			}
			sb.append("}");

			String incorrectAnswer = sb.toString();

			System.out.println("question: " + question);
			System.out.println("question: " + correctAnswer);
			System.out.println("question: " + incorrectAnswer1);

			HttpSession session = req.getSession();
			int quizId = (int) session.getAttribute("quizId");

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			String hostName = "showtimefinder.database.windows.net"; // update me
			String dbName = "ser516_db"; // update me
			String user = "scrum_mates@showtimefinder"; // update me
			String password = "Azure@Cloud"; // update me
			String url = String.format(
					"jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
							+ "hostNameInCertificate=*.database.windows.net;loginTimeout=30;",
					hostName, dbName, user, password);
			Connection connection = null;
			connection = DriverManager.getConnection(url);
			String schema;
			schema = connection.getSchema();
			System.out.println("Successful connection - Schema: " + schema);

			PreparedStatement query;
			query = connection.prepareStatement("INSERT INTO [dbo].[Questions] ([quizId]" + "           ,[question]"
					+ "           ,[actualAnswer]" + "           ,[totalChoices]" + "           ,[totalPoints]"
					+ "           ,[isMCQ]) VALUES (?,?,?,?,?,?)");
			query.setInt(1, quizId);
			query.setString(2, question);
			query.setString(3, correctAnswer);
			query.setString(4, incorrectAnswer);
			query.setInt(5, totalPoints);
			query.setBoolean(6, isMCQ);

			query.executeUpdate();

			res.sendRedirect(req.getContextPath() + "/createQuestions.ftl");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
