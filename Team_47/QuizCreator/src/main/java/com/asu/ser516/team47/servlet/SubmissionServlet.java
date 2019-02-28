package com.asu.ser516.team47.servlet;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
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
    private int httpCode = 204;
    private String httpErrorMessage;
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
     * requires the presence of quiz_id, enroll_id, timeTaken, and attempt fields in the form. all integers.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        httpCode = 204;
        httpErrorMessage = "";

        //Mandatory fields to create a submission entry
        Integer quizId = null;
        Integer enrollId = null;
        Date startTime = null;
        Date endTime = null;
        Integer attempt = null;

        List<Integer> choiceIds = new ArrayList<>();

        Enumeration paramNames = request.getParameterNames();
        if (paramNames == null){
            response.sendError(400, "no parameters");
            return;
        }
        //Validate that all necessary fields are present and build ChoiceIds
        while (paramNames.hasMoreElements()) {
            try{
                String paramName = (String) paramNames.nextElement();
                if (paramName.equals("quiz_id")) {
                    quizId = validateInteger(request.getParameter("quiz_id"), response);
                    quiz = new QuizDAOImpl().getQuiz(quizId);
                    if (quiz == null){
                        httpCode = 500;
                        break;
                    }
                } else if (paramName.equals("enroll_id")) {
                    enrollId = validateInteger(request.getParameter("enroll_id"), response);
                    enrollment = new EnrolledDAOImpl().getEnrolled(enrollId);
                    if (enrollment == null){
                        httpCode = 500;
                        break;
                    }
                } else if (paramName.equals("attempt")) {
                    attempt = validateInteger(request.getParameter("attempt"), response);
                    if (attempt <= 0){
                        httpCode = 400;
                        break;
                    }
                } else if (paramName.equals("start_time")) {
                    startTime = validateDate(request.getParameter("start_time"), response);
                    if (startTime == null) {
                        httpCode = 400;
                        break;
                    }
                } else if (paramName.length() >= "choice_fk".length() &&
                        paramName.substring(0, "choice_fk".length()).equals("choice_fk")) {
                    int choiceId = validateInteger(request.getParameter(paramName), response);
                    Choice choice = new ChoiceDAOImpl().getChoice(choiceId);
                    if (choice == null) {
                        httpCode = 500;
                        break;
                    } else {
                        choiceIds.add(choiceId);
                    }
                }
            } catch (NullPointerException npe){
                httpCode = 400;
                return;
            }
        }

        if (httpCode != 204 || quizId == null || enrollId == null || startTime == null
                || attempt == null) {
            if (httpCode == 500) {
                httpErrorMessage = "Server Error";
            }
            response.sendError(httpCode, httpErrorMessage);
            return;
        }

        if (!sendSubmission(quizId, enrollId, startTime, endTime, 0,attempt)){
            response.sendError(500);
            return;
        }
        if (!sendAnswer(choiceIds)){
            response.sendError(500);
            return;
        }
        response.setStatus(httpCode);

        //TODO: call autograder, update score on Submission.
    }

    /**
     * Creates a Submission object based on the data from the parameters and
     * sends it to the database as a new submission table.
     * @param quizID    quiz ID
     * @param enrollID  enrollment ID
     * @param startTime date quiz started
     * @param endTime   date quiz ended
     * @param score     graded quiz score
     * @param attempt   number of attempts
     * @return true if the insertion into database succeeds, otherwise false.
     */
    private boolean sendSubmission(int quizID, int enrollID, Date startTime,
                                  Date endTime, float score, int attempt) {
        boolean hasSucceeded;
        Date today = new Date();

        Submission studentSubmission = new Submission(0, quizID, enrollID,
                startTime, endTime, score, attempt);
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
        ChoiceDAOImpl choiceDAO = new ChoiceDAOImpl();
        return choiceDAO.getChoice(choiceID).getQuestion_fk();
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
            httpCode = 400;
            httpErrorMessage = "Invalid form data";
        } catch (NullPointerException npe) {
            httpCode = 400;
            httpErrorMessage = "Missing form data";
        }
        return null;
    }

    private Date validateDate(String value, HttpServletResponse response) throws IOException {
        try{
            DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
            DateTime dt = formatter.parseDateTime(value);
            return dt;
        } catch (NumberFormatException nfe) {
            httpCode = 400;
            httpErrorMessage = "Invalid form data";
        } catch(NullPointerException npe) {
            httpCode = 400;
            httpErrorMessage = "Missing form data";
        }
        return null;
    }
}