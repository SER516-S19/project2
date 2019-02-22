package edu.asupoly.ser516.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Class CreateQuiz Servlet is a controller that routes the user to Create Quiz
 * after Course Dashboard.
 * 
 * @author carnic
 * @version 1.1
 * @date 02/21/2019
 **/

public class CreateQuizServlet extends HttpServlet {

	/**
	 * This method is to get CreateQuiz UI page 
	 *@param request  Request made to server
	 *@param response  Responses from server
	 *
	 * @throws IOException
	 */
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.sendRedirect(request.getContextPath() + "/createQuiz.ftl");	
	}
	
	/**
	 * This method is to post CreateQuiz 
	 *@param request  Request made to server
	 *@param response  Responses from server
	 *
	 * @throws IOException, ServletException
	 */

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		try {
        	String quizTitle = request.getParameter("quizTitle");
        	String quizInstructions = request.getParameter("quizInstructions");
        	String quizScheduledDate = request.getParameter("quizScheduledDate");
        	int assignedTime = Integer.parseInt(request.getParameter("assignedTime"));
        	boolean isShuffled = Boolean.valueOf(request.getParameter("isShuffled"));
        	
    		HttpSession session = request.getSession();
    		int courseId = (int) session.getAttribute("courseId");
    		
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
    		query = connection.prepareStatement("insert into [dbo].[Quiz] (courseId, isGraded, assignedTime,"
    				+ "quizInstruction, quizScheduledDate, isShuffled, quizTitle)"
    				+ " values (?,?,?,?,?,?,?)");
    		query.setInt(1,courseId);
    		query.setBoolean(2, false);
    		query.setInt(3, assignedTime);
    		query.setString(4, quizInstructions);
    		query.setString(5, quizScheduledDate);
    		query.setBoolean(6, isShuffled);
    		query.setString(7, quizTitle);
    		
    		query.executeUpdate();
    		
    		System.out.println(request.getContextPath()+"/creatQuiz.ftl");
    		
    		request.getRequestDispatcher("/createQuestions.ftl").forward(request, response);
    		PreparedStatement stmt = connection.prepareStatement("select quizId from dbo.Quiz "
					+ "where courseId = ? and isGraded = ? " + "and assignedTime = ? and " + "quizInstruction = ? and "
					+ "quizScheduledDate = ? and isShuffled = ? and " + "quizTitle = ?");
			stmt.setInt(1, courseId);
			stmt.setBoolean(2, false);
			stmt.setInt(3, assignedTime);
			stmt.setString(4, quizInstructions);
			stmt.setString(5, quizScheduledDate);
			stmt.setBoolean(6, isShuffled);
			stmt.setString(7, quizTitle);

			ResultSet rs = stmt.executeQuery();
			int quizId = 0;
			while (rs.next()) {
				quizId = rs.getInt("quizId");
			}
			session.setAttribute("quizId", quizId);
			response.sendRedirect(request.getContextPath() + "/createQuestions.ftl");
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
