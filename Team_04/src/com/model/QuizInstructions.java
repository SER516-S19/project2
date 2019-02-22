package com.model;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QuizInstructions extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String view = "";
        view = "/Instructions.jsp";

        request.getRequestDispatcher(view).forward(request, response);

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.sendError(405, "HTTP POST METHOD CANNOT BE CALLED BY THE INSTRUCTIONS SERVLET...");
    }
}
