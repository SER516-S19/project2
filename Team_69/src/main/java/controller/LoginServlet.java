package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Question;
import bean.User;
import dao.LoginDAO;
import dao.QuizDAO;

public class LoginServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setStatus(200);
        QuizDAO quizDAO = new QuizDAO();
        List<String> quizNames = quizDAO.fetchAllQuizName();
        req.setAttribute("quizNames",quizNames);
        getServletContext().getRequestDispatcher("/views/StudentLanding.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("userName");
        String password = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        String email = request.getParameter("email");



        try {
            LoginDAO loginDAO = new LoginDAO();
            User student;
            if(password2.equals(password)) {
                student = new User(userName, "Student", email, password2);
            }else {
                student = new User(userName, "Student", email, "defaultPass");
            }
            System.out.println("Here...."+student);
            loginDAO.addUser(student);

            response.sendRedirect("Success.jsp");
        } catch (Exception e) {

            e.printStackTrace();
        }

    }
}
