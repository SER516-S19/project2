package edu.asu.ser516.quiz.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Main
 */
@WebServlet("/DeleteQuizController")
public class DeleteQuizController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String param1=(String)request.getParameter("select");
		String sQL = "delete from quiz where title="+param1;
		System.out.println(param1);
		PrintWriter out=response.getWriter();
	    response.getWriter().append("Served at: ").append(request.getContextPath());
	    
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/project2_team27","root","Ser516");
		Statement stmt = con.createStatement();
		stmt.executeUpdate("delete from quiz where title='QUIZ-04'");
		System.out.println("Quiz Deleted successfully!");
		
		//response.sendRedirect("/showQuizes.jsp");
		//String nextJSP = "/showQuizes.jsp";
		//RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		//dispatcher.forward(request,response);
		request.getRequestDispatcher("/showQuizes.jsp").forward(request, response);
		
	} 
	catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
	}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
