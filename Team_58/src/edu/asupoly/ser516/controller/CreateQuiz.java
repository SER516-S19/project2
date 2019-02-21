package edu.asupoly.ser516.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.asupoly.ser516.model.CourseVO;

public class CreateQuiz extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
        	String quizTitle = request.getParameter("quizTitle");
        	String quizInstructions = request.getParameter("quizInstructions");
        	String scheduledDate = request.getParameter("scheduledDate");
        	int assignedTime = Integer.parseInt(request.getParameter("assignedTime"));
        	int isGraded = Integer.parseInt(request.getParameter("isGraded"));
        	int isShuffled = Integer.parseInt(request.getParameter("isShuffled"));
        	//int courseId = Integer.parseInt(request.getParameter("courseId"));
        	
        	System.out.println("Quiz Title : " + quizTitle);
        	System.out.println("Quiz Instructions : " + quizInstructions);
        	System.out.println("Quiz Duration : " + assignedTime);
        	System.out.println("Is it graded? " + isGraded);
        	System.out.println("Shuffle questions? " + isShuffled);
        	System.out.println("Quiz Scheduled date " + scheduledDate);
        	
        	CourseVO obj = (CourseVO) request.getAttribute("CourseVO");
    		HttpSession session = request.getSession();
    		session.setAttribute("courseId", obj.getCourseId());
    		System.out.println("courseId: "+session.getAttribute("courseId"));
        	
    		
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
    				+ "quizInstructions, quizScheduledDate, isShuffled, quizTitle)"
    				+ " values (?,?,?,?,?,?,?)");
    		query.setInt(1,obj.getCourseId());
    		
    		query.executeQuery();
    		
    		//System.out.println(request.getContextPath()+"/creatQuiz.ftl");
    		
    		response.sendRedirect(request.getContextPath()+"/creatQuestions.ftl"); 
    		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	}
	
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
            	
		
		/*try {
            	String quizTitle = request.getParameter("quizTitle");
            	String quizInstructions = request.getParameter("quizInstructions");
            	String scheduledDate = request.getParameter("scheduledDate");
            	int assignedTime = Integer.parseInt(request.getParameter("assignedTime"));
            	int isGraded = Integer.parseInt(request.getParameter("isGraded"));
            	int isShuffled = Integer.parseInt(request.getParameter("isShuffled"));
            	//int courseId = Integer.parseInt(request.getParameter("courseId"));
            	
            	System.out.println("Quiz Title : " + quizTitle);
            	System.out.println("Quiz Instructions : " + quizInstructions);
            	System.out.println("Quiz Duration : " + assignedTime);
            	System.out.println("Is it graded? " + isGraded);
            	System.out.println("Shuffle questions? " + isShuffled);
            	System.out.println("Quiz Scheduled date " + scheduledDate);
            	
            	CourseVO obj = (CourseVO) request.getAttribute("CourseVO");
        		HttpSession session = request.getSession();
        		session.setAttribute("courseId", obj.getCourseId());
        		System.out.println("courseId: "+session.getAttribute("courseId"));
            	
        		
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
        				+ "quizInstructions, quizScheduledDate, isShuffled, quizTitle)"
        				+ " values (?,?,?,?,?,?,?)");
        		query.setInt(1,obj.getCourseId());
        		
        		query.executeQuery();
        		
        		System.out.println(request.getContextPath()+"/creatQuiz.ftl");
        		
        		response.sendRedirect(request.getContextPath()+"/creatQuiz.ftl"); 
        		
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
            	
            }
}
