package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.LoginServices;
import services.StudentServices;

/**
 * Controller class for handling Login requests
 *
 * @author : Jahnvi Rai
 * @version : 1.0
 * @since : 02/19/2019
 */

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet{
    /**
     * Handles the get request to the login page
     *
     * @param request
     * @param response
     */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        response.setContentType("text/html");
        response.setStatus(200);
        String action = request.getParameter("action");
        if(action.equals("Logout")) {
            request.getSession().invalidate();
            getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
        }
        else if(action.equals("Login")){
            getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
        }
    }

    /**
     * Handles get request coming to the login page  and redirect the user
     * to correct view based on user type
     *
     * @param request
     * @param response
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setStatus(200);
        LoginServices loginServices = new LoginServices();
        String userEmail =  request.getParameter("userEmail");
        String userPassword = request.getParameter("userPassword");
        boolean status = loginServices.validateUserPassword(userEmail,userPassword);
        HttpSession session = request.getSession();
        if(status) {
            String userType = loginServices.checkUserType(userEmail);
            int userId = loginServices.fetchUserId(userEmail);
            session.setAttribute("userId", userId);
            if (userType.equalsIgnoreCase("Student")) {
                StudentServices studentServices = new StudentServices();
                List<String> quizNames = studentServices.fetchAllQuizNames();
                List<Integer> quizIds = studentServices.fetchAllQuizIds(quizNames);
                List<String> quizStatus = studentServices.fetchQuizStatus(quizNames,userId);
                session.setAttribute("quizNames", quizNames);
                session.setAttribute("quizStatus", quizStatus);
                session.setAttribute("quizIds", quizIds);
                getServletContext().getRequestDispatcher("/views/studentLanding.jsp").forward(request, response);
            } else {
            	String userName = loginServices.fetchUserName(userEmail);
            	session.setAttribute("userName", userName);
            	session.setAttribute("userEmail", userEmail);
                getServletContext().getRequestDispatcher("/views/professorLanding.jsp").forward(request, response);
            }
        }
        else {
            getServletContext().getRequestDispatcher("/views/loginError.jsp").forward(request,response);
        }

    }
}
