package edu.asupoly.ser516.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.asupoly.ser516.model.CreateQuizVO;
import jdk.nashorn.internal.parser.JSONParser;

public class CreateQuestionsServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) {

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
			List<String> totalChoices = new ArrayList<>();

			totalChoices.add(incorrectAnswer1);
			totalChoices.add(incorrectAnswer2);
			totalChoices.add(incorrectAnswer3);

			System.out.println("question: " + question);
			System.out.println("question: " + correctAnswer);
			System.out.println("question: " + incorrectAnswer1);

			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(totalChoices);

			CreateQuizVO obj = (CreateQuizVO) req.getAttribute("CreateQuizVO");
			HttpSession session = req.getSession();
			session.setAttribute("QuizId", obj.getQuizId());

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
			query.setInt(1, obj.getQuizId());
			query.setString(2, question);
			query.setString(3, correctAnswer);
			query.setString(4, incorrectAnswer1);
			query.setInt(5, totalPoints);
			query.setBoolean(6, isMCQ);

			query.executeUpdate();

			res.sendRedirect(req.getContextPath() + "/professorHome.ftl");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
