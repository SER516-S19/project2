package main.java.edu.asu.ser516.blackBoard.quiz.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import main.java.edu.asu.ser516.blackBoard.quiz.bean.User;
import main.java.edu.asu.ser516.blackBoard.quiz.dao.LoginDAO;

public class LoginControllerServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

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
