package edu.asupoly.ser516.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.asupoly.ser516.model.GradeQuizVO;
import edu.asupoly.ser516.model.QuizVO;

/**
 * Class GradeQuizServlet is a controller 
 * that routes the Professor to Grade Dashboard Page from Professor Home Page.
 * 
 * @author akashkadam
 * @version 1.3
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

		//QuizVO quizVO = (QuizVO) session.getAttribute("quizInfo");
		
		int quizId = Integer.parseInt(session.getAttribute("quizId").toString());
		String quizName = session.getAttribute("quizName").toString();

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
			query = connection.prepareStatement("UPDATE SR\r\n" + 
					"SET SR.[score] = Q.[totalPoints]\r\n" + 
					"FROM [dbo].[StudentResponse] SR\r\n" + 
					"JOIN [dbo].[Questions] Q\r\n" + 
					"ON SR.questionId = Q.questionId\r\n" + 
					"AND SR.answerSelected = Q.actualAnswer\r\n" +
					"Where SR.quizId = ?");
			query.setInt(1,quizId);

			query.executeUpdate();
			
			query = null;
			
			query = connection.prepareStatement("Select sum(score) as score, firstname,lastname, C.[quizTitle] \r\n" + 
					"from StudentResponse A\r\n" + 
					"JOIN UserDetails B\r\n" + 
					"on A.userId = B.userId\r\n" + 
					"JOIN Quiz C\r\n" + 
					"on C.quizId = A.quizId\r\n" + 
					"where A.quizId = ?\r\n" + 
					"group by firstname,lastname, [quizTitle]");
			query.setInt(1,quizId);
			
			ResultSet resultData = query.executeQuery();
			

			List<GradeQuizVO> list = new ArrayList<>();

			while(resultData.next()) {
				int score = resultData.getInt("score");
				String firstName = resultData.getString("firstname");
				String lastName = resultData.getString("lastname"); 
				GradeQuizVO gradeQuiz = new GradeQuizVO(score,firstName,lastName,quizName);
				list.add(gradeQuiz);
			}

			
			session.setAttribute("gradeQuiz", list);
			session.setAttribute("quizName", quizName);

			response.sendRedirect(request.getContextPath()+"/gradeQuiz.ftl");  
		}
		catch(Exception exception) {
			log.info(exception.getMessage());
		}

	}

}
