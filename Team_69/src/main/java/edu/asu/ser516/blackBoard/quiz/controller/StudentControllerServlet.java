package edu.asu.ser516.blackBoard.quiz.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class StudentControllerServlet {

	private final static String SUBMIT_ACTION = "submit";

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String studentId = (String) session.getAttribute("user_id");
		String action = request.getParameter("action");

		//Servlet Action on quiz submission
		if(action.equals(SUBMIT_ACTION)) {
			try {
				response.sendRedirect("Success.jsp");
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}
}