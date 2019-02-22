package edu.asupoly.ser516.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.asupoly.ser516.model.UserDaoBean;
import edu.asupoly.ser516.model.UserVO;

public class LoginServlet extends HttpServlet  {

	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)  throws ServletException, IOException {
		
	    String userName=req.getParameter("username");  
	    String passWord=req.getParameter("userpass");
	    
	    UserDaoBean udb = new UserDaoBean();
	    
	    List<UserVO> data = null;
		
	    try {
			data = udb.validateAndGet(userName, passWord);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	    
	    if(data.size()!=0 && !data.get(0).isStudent()){
	    	req.setAttribute("UserVO", data.get(0));
			RequestDispatcher rd=req.getRequestDispatcher("/professorHome");
			rd.forward(req,res);
	    }    
	    else{  
	    	/**
	    	 *  Call Student Profile HomePage
	    	 */
	    }  
	}
}
