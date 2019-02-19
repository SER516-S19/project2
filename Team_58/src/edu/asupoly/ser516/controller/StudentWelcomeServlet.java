package edu.asupoly.ser516.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FormServlet", urlPatterns = "/studentWelcome")
public class StudentWelcomeServlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
    {
        
    }
}

