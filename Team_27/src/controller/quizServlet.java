package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import model.Quiz;
import services.DatabaseConnection;
@SuppressWarnings("serial")
public class quizServlet extends HttpServlet {
    private static Logger log = Logger.getLogger(quizServlet.class.getName());


    public void doPost(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException	{
    	 	PreparedStatement preparedStatement = null;
    		String quizid = req.getParameter("quiz_id");
    		int currpage = Integer.parseInt(req.getParameter("curr_page"));
    		int skip = Integer.parseInt(req.getParameter("skip"));
    		Quiz[] ques = new Quiz[skip];
    		try {
				Connection conn = (Connection) DatabaseConnection.createConnection();
				 String query = "SELECT * FROM questions WHERE quiz_id BETWEEN " + currpage + " AND " + (currpage + skip); //Insert user details into the table 'USERS'
				 preparedStatement = (PreparedStatement) conn.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
				 ResultSet rs = preparedStatement.executeQuery();
				 int i = 0;
				 if(!rs.next()) {
					 return;
				 }
				 while (rs.next()) {
					 
					 
				 }
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    }
	
    public void doGet(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException	{
	res.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED, "GET not supported by this servlet");
    }
}
