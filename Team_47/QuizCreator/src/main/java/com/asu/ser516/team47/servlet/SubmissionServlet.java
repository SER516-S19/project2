package com.asu.ser516.team47.servlet;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "SubmissionServlet")
public class SubmissionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        out.write("hello from a servlet".getBytes());
        out.flush();
        out.close();
    }

    @Override
    void doPost(HttpServletRequest request , HttpServletResponse response){
        String htmlCode = "204";
        String htmlMessage;
        //Mandatory fields to create a submission entry
        String quizIdField;
        String enrollIdField;
        String timetaken;
        String attempt;

        Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()){
            String paramName = (String)paramNames.nextElement();
            if (paramName.equals("quiz_id")){

            } else if (paramName.equals("enroll_id")){

            } else if (paramName.equals("attempt")){

            } else if (paramName.equals("timeTaken")){

            } else if (paramName.length() >= "choice_fk".length()){}
        }
    }
}