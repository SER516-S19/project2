package edu.asu.ser516.quiz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.asu.ser516.quiz.dao.impl.QuizDetailsDao;
import edu.asu.ser516.quiz.model.QuizModel;

/**
 * Servlet implementation class Main
 */

public class QuizActionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private static QuizDetailsDao quizDetailsDao = null;

    public void init(ServletConfig config) throws ServletException {
	// if you forget this your getServletContext() will get a NPE! 
	super.init(config);
	
		quizDetailsDao = new QuizDetailsDao();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
	    response.getWriter().append("Served at: ").append(request.getContextPath());
	    
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/project2_team27","root","root");
		Statement stmt = con.createStatement();
		
		//Delete actions here
		String strActionToPerform = request.getParameter("actonToPerform");
		if(strActionToPerform.equalsIgnoreCase("delete")) {
			stmt.executeUpdate(buildSqlQuery(request,response));
			System.out.println("Quiz Deleted successfully!");
			redirectToShowQuizes(request,response);
		}
        
		else if(strActionToPerform.equalsIgnoreCase("go")) {
			
			goToQuizes(request,response);
		}
		else if(strActionToPerform.equalsIgnoreCase("update")) {
		
		}
		else if(strActionToPerform.equalsIgnoreCase("add")) {
			request.getRequestDispatcher("CreateQuiz.html").forward(request, response);
		}
		
		
	} 
	catch (ClassNotFoundException e) {
		e.printStackTrace();
	
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	}
	
	// Function that returns the result of the delete query
	private String buildSqlQuery(HttpServletRequest request, HttpServletResponse response) {
		String param1=(String)request.getParameter("selectedQuiz");
		String sQL = "delete from quiz where title='"+param1+"'";
		System.out.println(param1);
		return sQL;
	}
	
	// Function that redirects to Quiz Detail page
	private void goToQuizes(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		String param1=(String)request.getParameter("selectedQuiz");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/project2_team27","root","root");
		String sql = "SELECT title, instructions, assignment_group, isshuffled, isgraded, time_limit, ismultipleattempt FROM quiz WHERE title=?";
		PreparedStatement ps = ((java.sql.Connection) con).prepareStatement(sql);
		 ps.setString(1, param1);
		ResultSet rs= ps.executeQuery();
		
	    while(rs.next())
	    { 
	    QuizModel quizModel;
		try {
			quizModel = QuizDetailsDao.findByPrimaryKey(rs.getString(1));
			request.setAttribute("model", quizModel);
			//response.sendRedirect("ViewQuiz.jsp");
			request.getRequestDispatcher("ViewQuiz.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    }
	    
	    }
		
		

	// function to update the quizzes from the database
	private void redirectToShowQuizes(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/project2_team27","root","root");
		PreparedStatement ps = ((java.sql.Connection) con).prepareStatement("SELECT quiz_id, title FROM quiz");
		ResultSet rs= ps.executeQuery();	
		HttpSession session = request.getSession();
		ArrayList rowValues = new ArrayList();
		Object[] objects;
		while (rs.next()) {
			 rowValues.add(rs.getString("title"));
		}
	    
		session.setAttribute("rowValues", rowValues);
		
		response.sendRedirect("showQuizes.jsp");
		
	}
}
