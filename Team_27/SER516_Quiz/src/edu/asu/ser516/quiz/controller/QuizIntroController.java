package edu.asu.ser516.quiz.controller;
import java.awt.List;

//import com.mysql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Array;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.asu.ser516.quiz.dao.impl.QuizDetailsDao;
import edu.asu.ser516.quiz.exceptions.DataAccessException;
import edu.asu.ser516.quiz.exceptions.NoDataFoundException;

//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * Servlet implementation class QuizIntroController
 */
public class QuizIntroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @return 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ArrayList rowValues = new ArrayList();
		try {
			rowValues = QuizDetailsDao.getAll();
		} catch (NoDataFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getSession().setAttribute("rowValues", rowValues);
		
		response.sendRedirect("showQuizes.jsp");
		
		
	}

}
