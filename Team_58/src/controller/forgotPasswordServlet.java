/*
Servlet for user to reset password
@authour Vaibhav Bhasin
@version 2.0
@date 02/27/2019
*/

package controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CourseDAOBean;
import model.CourseVO;
import model.UserDAO;
import model.UserDAOBean;
import model.UserVO;

@WebServlet(name = "forgotPassword", urlPatterns = "/forgotpassword")
public class forgotPasswordServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		try {
			res.sendRedirect(req.getContextPath() + "/forgotpassword.jsp");
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String userName	= (String) req.getParameter("username");										//get user details for password change
		String pass = (String) req.getParameter("newPassword");											//set new password
	
		UserDAOBean update = new UserDAOBean();
		try {
			update.updatePassword(userName, pass);														//call update password method 
			res.sendRedirect(req.getContextPath() + "/login.jsp");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
