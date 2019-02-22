package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
public class abcServlet extends HttpServlet {
    private static Logger log = Logger.getLogger(abcServlet.class.getName());


    public void doPost(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException	{
    	System.out.println("yo");
        res.setContentType("text/html");
        PrintWriter out= res.getWriter();
        out.println("<HTML><HEAD><TITLE>Lab 1 Solution</TITLE></HEAD><BODY>");
        out.println("WELCOME TO abcSERVLET");
            out.println("</BODY></HTML>");

    }
	
    public void doGet(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException	{
	res.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED, "GET not supported by this servlet");
    }
}
