package quiz.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quiz.dao.UserDao;
import quiz.model.User;

/**
 * The Servlet controls when an new user registers in the application.
 * 
 * @author (Palak Chugh), (Yuti Desai)
 * @version (1.0)
 * @createDate 25 Feb 2019
 */

/*
 * Servlet implementation class RegisterController
 */
public class RegisterController extends HttpServlet {


	private static final long serialVersionUID = 1L;

	public RegisterController() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Copying all the input parameters in to local variables
		String fullName = request.getParameter("fullname");
		String email = request.getParameter("email");
		String user_type = request.getParameter("user_type");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		User registerBean = new User();
		//Using Java Beans - An easiest way to play with group of related data
		registerBean.setFullName(fullName);
		registerBean.setEmail(email);
		registerBean.setUserName(userName);
		registerBean.setUserType(user_type);
		registerBean.setPassword(password); 

		UserDao registerDao = new UserDao();

		//The core Logic of the Registration application is present here. We are going to insert user data in to the database.
		String userRegistered = registerDao.registerUser(registerBean);
		if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		{
			request.getSession().setAttribute("regMessage", "success");
			request.getRequestDispatcher("./login.jsp").forward(request, response);
		}
		else   //On Failure, display a meaningful message to the User.
		{
			request.getSession().setAttribute("errMessage", userRegistered);
			request.getRequestDispatcher("/Register.jsp").forward(request, response);

		}
	}
}