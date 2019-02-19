package edu.asupoly.ser516.controller;

import java.io.IOException;
import java.util.List;

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
	    
	    System.out.println(userName+" "+passWord);
	    
	    UserDaoBean udb = new UserDaoBean();
	    
	    List<UserVO> data = null;
		try {
			data = udb.validateAndGet(userName, passWord);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    boolean isStudent = data.get(0).isStudent();
	    
	    System.out.println(data.get(0).getFirstname());
	    System.out.println(isStudent);
	    
	    if(data!=null && !isStudent){
	    	req.setAttribute("UserVO", udb);
			/*
			 * RequestDispatcher rd=req.getRequestDispatcher("professorHome");
			 * rd.forward(req,res);
			 */ 
	    }    
	    else{  
	        System.out.print("Sorry username or password error");  
			/*
			 * RequestDispatcher rd=req.getRequestDispatcher("index.html"); rd.include(req,
			 * res);
			 */  
	    }  
	}
}
