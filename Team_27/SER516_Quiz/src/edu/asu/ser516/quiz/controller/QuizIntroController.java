package edu.asu.ser516.quiz.controller;
import java.awt.List;

//import com.mysql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;
import java.sql.Array;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.asu.ser516.quiz.dao.impl.ConnectionFactory;


/**
 * Servlet implementation class QuizIntroController
 */
public class QuizIntroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Properties dbProperties = new Properties();
	static {
		try {
			dbProperties.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("rdbm.properties"));
			Class.forName(dbProperties.getProperty("mysql_jdbcDriver"));
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	/**
	 * @return 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sql = dbProperties.getProperty("SELECT_QUIZ");
		Connection conn = ConnectionFactory.getConnection();
		if (conn == null ) {
			System.out.println("Connection is not set");
		}
		PreparedStatement preparedStatement = null;
		
		try {
			System.out.println("SQL:: " + sql);
			preparedStatement = conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			HttpSession session = request.getSession();
			ArrayList rowValues = new ArrayList();
			while (rs.next()) {
				 rowValues.add(rs.getString("title"));
			}   
			session.setAttribute("rowValues", rowValues);
			
			response.sendRedirect("showQuizes.jsp");
			
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

}
