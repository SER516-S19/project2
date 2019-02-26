package com.asu.ser516.team47.servlet;


import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This servlet is called when a student submits a quiz
 *
 * @author Cecilia La Place
 * @version 1.0
 * @since 2019-25-02
 */
@WebServlet(name = "StatsServlet")
public class StatsServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        out.write("hello from a stats servlet".getBytes());
        out.flush();
        out.close();
    }
}
