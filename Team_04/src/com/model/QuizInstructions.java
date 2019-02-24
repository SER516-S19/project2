/*
 * Classname : QuizInstructions
 * Version : 1.0
 * Author: Harika Kolli
 * Date : 02-13-2019
 */

package com.model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The {@code QuizInstructions} class fetches instructions for the quiz.s
 *  @author Harika Kolli
 */
public class QuizInstructions extends HttpServlet {
    /**
     * Executes the fetch type from Instruction page
     * @code doGet to perform fetch operations
     * @Instructions renders the instruction page
     * @return collection of view {Instructions}
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String view = "";
        view = "/Instructions.jsp";
        request.getRequestDispatcher(view).forward(request, response);

    }
    /**
     * Executes the response from the database
     * @code doPost to perform response operations
     * @param response used to post the error message
     * @return error message
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.sendError(405, "HTTP POST METHOD CANNOT BE CALLED BY THE INSTRUCTIONS SERVLET...");
    }
}
