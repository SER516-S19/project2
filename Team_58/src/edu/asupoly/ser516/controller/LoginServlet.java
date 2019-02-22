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
import javax.servlet.http.HttpSession;

import edu.asupoly.ser516.model.UserDAOBean;
import edu.asupoly.ser516.model.UserVO;

/**
 * Login Servlet is a controller that routes the user into
 * professor or student.
 * 
 * @author Aditya Vikram
 * @version 1.3
 * @date 02/22/2019
 **/

public class LoginServlet extends HttpServlet  {
	
	private static Logger log = Logger.getLogger(LoginServlet.class.getName());

	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)  throws ServletException, IOException {
		
	    String userName=req.getParameter("username");  
	    String passWord=req.getParameter("userpass");
	    
	    UserDAOBean userDAOBean = new UserDAOBean();
	    	    
	    List<UserVO> userData = null;
		
	    try {
	    	userData = userDAOBean.getUserInfo(userName, passWord);
		} catch (ClassNotFoundException | SQLException e) {
			log.info(e.getMessage());
		}
	    
	    if(userData.isEmpty()) {
	    	req.setAttribute("setMessage", "Incorrect Credentials");
	    	RequestDispatcher rd=req.getRequestDispatcher("/login.jsp");
			rd.forward(req,res);
	    }
	    
	    if(!userData.get(0).isStudent()){
	    	req.setAttribute("UserVO", userData.get(0));
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
