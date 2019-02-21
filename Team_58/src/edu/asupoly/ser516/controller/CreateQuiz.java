package edu.asupoly.ser516.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.asupoly.ser516.model.CourseVO;

public class CreateQuiz extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect(request.getContextPath()+"/createQuiz.ftl"); 
	}
	
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
            	
		
		try {
        	String quizTitle = request.getParameter("quizTitle");
        	String quizInstructions = request.getParameter("quizInstructions");
        	int year = Integer.parseInt(request.getParameter("year"));
        	int month = Integer.parseInt(request.getParameter("month"));
        	int day = Integer.parseInt(request.getParameter("date"));
        	
        	@SuppressWarnings("deprecation")
			Date quizScheduledDate = new Date(year, month, day);
     
            
        	int assignedTime = Integer.parseInt(request.getParameter("assignedTime"));
        	boolean isShuffled = Boolean.valueOf(request.getParameter("isShuffled"));
        	//int courseId = Integer.parseInt(request.getParameter("courseId"));
        	
        	System.out.println("Quiz Title : " + quizTitle);
        	System.out.println("Quiz Instructions : " + quizInstructions);
        	System.out.println("Quiz Duration : " + assignedTime);
        	System.out.println("Shuffle questions? " + isShuffled);
        	//System.out.println("Quiz Scheduled date " + scheduledDate);
        	
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
    		query.setDate(5, quizScheduledDate);
    		query.setBoolean(6, isShuffled);
    		query.setString(7, quizTitle);
    		
    		query.executeUpdate();
    		
    		System.out.println(request.getContextPath()+"/creatQuiz.ftl");
    		
    		request.getRequestDispatcher("/createQuestions").forward(request, response);
    		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
            	
            }
}
