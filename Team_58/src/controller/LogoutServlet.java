package controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * StudentHome is a servlet controlling the home page for students
 * 
 * @author Joshua Drumm
 * @version 1.0
 * @date 02/28/2019
 **/

@WebServlet(name = "Logout", urlPatterns = "/Logout")
public class LogoutServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		session.invalidate();
		try {
			res.sendRedirect("login.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
