package com.asu.ser516.team47.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import com.asu.ser516.team47.database.*;

/**
 * This servlet is called when a student submits a quiz
 *
 * @author Amit Pandey
 * @author Qianru "Ruby" Zhao
 * @author David Lahtinen
 * @author John Alden
 *
 * @version 1.0
 * @since 2019-22-02
 */
@WebServlet(name = "SubmissionServlet")
public class SubmissionServlet extends HttpServlet {

    private int submissionID = 0;
    private int htmlCode = 204;
    private String htmlMessage;
    private Quiz quiz;
    private Enrolled enrollment;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        out.write("hello from a servlet".getBytes());
        out.flush();
        out.close();
    }

    /**
     * The endpoint for a quiz submission
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        htmlCode = 204;
        htmlMessage = "";

        //Mandatory fields to create a submission entry
        Integer quizId = null;
        Integer enrollId = null;
        Integer timeTaken = null;
        Integer attempt = null;

        List<Integer> choiceIds = new ArrayList<>();

        //Validate that all necessary fields are present and build ChoiceIds
        Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            try{
                String paramName = (String) paramNames.nextElement();
                if (paramName.equals("quiz_id")) {
                    quizId = validateInteger(request.getParameter("quiz_id"), response);
                    quiz = new QuizDAOImpl().getQuiz(quizId);
                    if (quiz == null){
                        response.sendError(500);
                    }
                } else if (paramName.equals("enroll_id")) {
                    enrollId = validateInteger(request.getParameter("enroll_id"), response);
                    enrollment = new EnrolledDAOImpl().getEnrolled(enrollId);
                    if (enrollment == null){
                        htmlCode = 500;
                        break;
                    }
                } else if (paramName.equals("attempt")) {
                    attempt = validateInteger(request.getParameter("attempt"), response);
                } else if (paramName.equals("timeTaken")) {
                    timeTaken = validateInteger(request.getParameter("timeTaken"), response);
                } else if (paramName.length() >= "choice_fk".length()) {
                    int choiceId = validateInteger(request.getParameter(paramName), response);
                    Choice choice = new ChoiceDAOImpl().getChoice(choiceId);
                    if (choice != null) {
                        htmlCode = 500;
                        break;
                    } else {
                        choiceIds.add(choiceId);
                    }
                }
            } catch (NullPointerException npe){
                //If this line executes, an error code has already been sent from validateInteger().
                return;
            }
        }

        if (htmlCode != 204 || quizId == null || enrollId == null || timeTaken == null
                || attempt == null) {
            if (htmlCode == 500) {
                htmlMessage = "Server Error";
            }
            response.sendError(htmlCode, htmlMessage);
            return;
        }
        if (!sendSubmission(quizId, enrollId, timeTaken, 0, attempt)){
            response.sendError(500);
            return;
        }
        if (!sendAnswer(choiceIds)){
            response.sendError(500);
            return;
        }

        response.setStatus(htmlCode);

        //TODO: call autograder, update score on Submission.
    }

    /**
     * Creates a Submission object based on the data from the parameters and
     * sends it to the database as a new submission table.
     * @param quizID    quiz ID
     * @param enrollID  enrollment ID
     * @param time      time the quiz was taken
     * @param score     graded quiz score
     * @param attempt   number of attempts
     * @return true if the insertion into database succeeds, otherwise false.
     */
    private boolean sendSubmission(int quizID, int enrollID, int time,
                                  float score, int attempt) {
        boolean hasSucceeded;
        Date today = new Date();

        Submission studentSubmission = new Submission(0, quizID, enrollID,
                time, today, score, attempt);
        SubmissionDAOImpl submitter = new SubmissionDAOImpl();

        hasSucceeded = submitter.insertSubmission(studentSubmission);
        submissionID = studentSubmission.getSubmission_id();

        return hasSucceeded;
    }

    /**
     * Retrieves a list of choice IDs from the servlet and creates Answer objects
     * that are passed into the database.
     * @param choiceList    list of choice IDs
     * @return true if submission was fully successful, false if a submission failed
     */
    private boolean sendAnswer(List<Integer> choiceList) {
        boolean hasSucceeded = true;
        int idCount = choiceList.size();
        AnswerDAOImpl submitter = new AnswerDAOImpl();

        for(int i = 0; i < idCount; i++) {
            int choiceID = choiceList.get(i).intValue();
            int questionID = getQuestionID(choiceID);

            boolean wasSubmitted = submitter.insertAnswer(new Answer(0,
                    submissionID, questionID, choiceID));

            if(!wasSubmitted)
                hasSucceeded = false;
        }

        return hasSucceeded;
    }

    /**
     * Retrieves the question ID related to the choice ID provided in the arguments
     * by querying the database.
     * @param choiceID  choice ID being searched on
     * @return int ID of the question associated with the choice ID
     */
    private int getQuestionID(int choiceID) {
        String url = "jdbc:sqlite:schema.db";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int result;

        try {
            conn = DriverManager.getConnection(url);
            stmt = conn.prepareStatement("select ques_fk from choices where choice_id = ?");
            stmt.setInt(1, choiceID);
            rs = stmt.executeQuery();
            result = rs.getInt("ques_fk");
        }
        catch (Exception se) {
            se.printStackTrace();
            return 0;
        }
        finally {
            try {
                if (rs != null) { rs.close();}
                if (stmt != null) { stmt.close();}
                if (conn != null) { conn.close();}
            } catch (Exception e) { e.printStackTrace(); }
        }

        return result;
    }

    /**
     * Checks if parameter can be converted to integer. If not, sends an error.
     * @param value the value to be validated
     * @param response http response through which to send errors
     * @return null if invalid input, a valid int otherwise
     * @throws IOException sends an error if parameter cannot be reported
     */
    private Integer validateInteger(String value, HttpServletResponse response) throws IOException {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException nfe) {
            response.sendError(400, "Invalid form data");
        } catch (NullPointerException npe) {
            response.sendError(400, "Missing form data");
        }
        return null;
    }
}