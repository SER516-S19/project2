package com.search;
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

//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * Servlet implementation class SearchServ
 */
public class SearchServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @return 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// System.out.print("here");
		
		response.getWriter();
		try {
			PrintWriter out = response.getWriter();
			//String id= request.getParameter("id");
			//String title=request.getParameter("title");
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project2?useSSL=false","root","Newyork12*");  
			PreparedStatement ps = ((java.sql.Connection) con).prepareStatement("SELECT quiz_id, title FROM quiz");
			ResultSet rs= ps.executeQuery();	
			HttpSession session = request.getSession();
			//ArrayList listid = new ArrayList();
			ArrayList rowValues = new ArrayList();
			Object[] objects;
			while (rs.next()) {
				 rowValues.add(rs.getString("title"));
			}   
			//objects = rowValues.toArray(); 
			//for (Object obj : objects) 
				//out.println(obj + " "); 
		    
			session.setAttribute("rowValues", rowValues);
			
			response.sendRedirect("showQuizes.jsp");
			
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
		
	}

}
