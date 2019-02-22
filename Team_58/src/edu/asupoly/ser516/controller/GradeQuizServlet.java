package edu.asupoly.ser516.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.asupoly.ser516.model.QuizVO;

/**
 * Class GradeQuizServlet is a controller 
 * that routes the Professor to Grade Dashboard Page from Professor Home Page.
 * 
 * @author akashkadam
 * @version 1.1
 **/
public class GradeQuizServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(ProfessorHomeServlet.class.getName());

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {



		HttpSession session = request.getSession();
		HashMap<Integer, String> quizMap = (HashMap<Integer,String>)session.getAttribute("quizMap");

		int quizId = Integer.parseInt(request.getParameter("Quiz"));

		String quizName = quizMap.get(quizId);

		session.setAttribute("quizName",quizName);
		session.setAttribute("quizId", quizId);


		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			String hostName = "showtimefinder.database.windows.net"; // update me
			String dbName = "ser516_db"; // update me
			String user = "scrum_mates@showtimefinder"; // update me
			String password = "Azure@Cloud"; // update me
			String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
					+ "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
			Connection connection = null;
			connection = DriverManager.getConnection(url);
			String schema;
			schema = connection.getSchema();
			System.out.println("Successful connection - Schema: " + schema);


			PreparedStatement query;
			query = connection.prepareStatement("select * from [dbo].[StudenrResponse] where quizId = ?");
			query.setInt(1,quizId);

			ResultSet resultData = query.executeQuery();

			List<QuizVO> list = new ArrayList<>();

			while(resultData.next()) {
				int assignedTime = resultData.getInt("assignedTime");
				boolean isGraded = resultData.getBoolean("isGraded");
				String quizInstruction = resultData.getString("quizInstruction"); 
				Date quizScheduledDate = resultData.getDate("quizScheduledDate");
				boolean isShuffled = resultData.getBoolean("isShuffled");
				String quizTitle = resultData.getString("quizTitle");
				QuizVO quiz = new QuizVO(quizId, isGraded, assignedTime, quizInstruction, quizScheduledDate, isShuffled, quizTitle);
				list.add(quiz);
			}

			HashMap<Integer, String> quiz = new HashMap<>();
			for(int i=0;i<list.size();i++)
				quiz.put(list.get(i).getQuizId(), list.get(i).getQuizTitle());

			session.setAttribute("QuizHashMap", quiz);

			response.sendRedirect(request.getContextPath()+"/gradeQuiz.ftl");  
		}
		catch(Exception exception) {
			log.info(exception.getMessage());
		}

	}

}
