package com.asu.ser516.team47.servlet;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.asu.ser516.team47.database.*;
import com.asu.ser516.team47.utils.ServletValidation;
import com.asu.ser516.team47.utils.JSONRequestParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 * This servlet is called when a student submits a quiz
 *
 * @author Amit Pandey
 * @author Qianru "Ruby" Zhao
 * @author David Lahtinen
 * @author John Alden
 *
 * @version 1.1
 * @since 2019-28-02
 */
public class SubmissionServlet extends HttpServlet {

    private int submissionID = 0;
    private int httpCode = 204;
    private String httpErrorMessage;
    private String url = "jdbc:sqlite:schema.db";
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
     * requires the presence of quiz_id, enroll_id, start_time, and attempt fields in the form.
     * All integers except Timestamps start_time and optional end_time
     * created with manouti's answer on
     * https://stackoverflow.com/questions/24371957/iterate-through-jsonobject-from-root-in-json-simple as a reference.
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
        JSONObject requestForm;
        
        //Mandatory fields to create a submission entry
        Integer quizId = null;
        Integer enrollId = null;
        Date startTime = null;
        Integer attempt = null;

        //Mandatory field to update a submission entry
        Date endTime = null;

        Boolean isInitial = null;

        List<Integer> choiceIds = new ArrayList<>();

        //Check if json form can be read.
        try {
            requestForm = JSONRequestParser.getJsonFromRequest(request);
        } catch (IOException | ParseException | ClassCastException ex){
            response.sendError(400, "Problem reading form.");
            return;
        }

        // No guarantee of parameter order, specifically looking for initial field
        while(paramNames.hasMoreElements()) {
            try{
                String paramName = (String) paramNames.nextElement();
                if (paramName.equals("initial")) {
                    isInitial = validateInitial(request.getParameter("initial"), response);
                    if (isInitial == null) {
                        httpCode = 400;
                        return;
                    }
                }
            } catch (NullPointerException npe){
                httpCode = 400;
                return;
            }
        }

        //Validate that all necessary fields are present and build ChoiceId array
        try {
            isInitial = ((Boolean)requestForm.get("initial")).booleanValue();
            quizId =  ((Number)requestForm.get("quiz_id")).intValue();
            quiz = new QuizDAOImpl().getQuiz(quizId);
            if (quiz == null) {
                httpCode = 500;
            }
            enrollId = ((Number)requestForm.get("enrolled_id")).intValue();
            enrollment = new EnrolledDAOImpl().getEnrolled(enrollId);
            if (enrollment == null) {
                httpCode = 500;
            }
            startTime = validateDate(request.getParameter("start_time"), response);
            if (startTime == null) {
                httpCode = 400;
            }
            if (!isInitial){
                endTime = validateDate(request.getParameter("end_time"), response);
                if (endTime == null) {
                    httpCode = 400;
                }
            }
            if (!isInTime(quizId, startTime, endTime) && !isInitial) {
                httpCode = 400;
                httpErrorMessage = "Quiz taken outside of allowed time period";
            }
            JSONArray jsonChoices = (JSONArray) requestForm.get("choices");
            choiceIds = ServletValidation.buildAndValidateStudentChoiceList(jsonChoices, quizId);
        } catch (ClassCastException cce){
            response.sendError(400, "Some field is wrong data type.");
            cce.printStackTrace();
            return;
        } catch (NullPointerException npe){
            response.sendError(400, "Some field is missing.");
            return;
        }

        //check that all fields are present and no error has occurred
        if (httpCode != 204 || quizId == null || enrollId == null || startTime == null) {
            if (httpCode == 500) {
                httpErrorMessage = "Error Loading parameters";
            }
            response.sendError(httpCode, httpErrorMessage);
            return;
        }

        if (!sendSubmission(quizId, enrollId, startTime, endTime, 0, attempt)){
            response.sendError(500);
            return;
        }
        if (!sendAnswer(choiceIds)){
            response.sendError(500);
            return;
        }

        if(isLateSubmission(quizId)) {
            response.sendError(401, "Your submission was past the due date");
        }

        response.setStatus(httpCode);
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

            boolean wasSubmitted = submitter.insertAnswer(new Answer(0, submissionID, questionID, choiceID));

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
     * isLateSubmission
     * Checks if submission for a quiz is overdue
     * @param quizId the id of the quiz the submission is for
     * @return true if late, false if submission is not late
     */
    private boolean isLateSubmission(int quizId) {
        // Get due date of the quiz
        QuizDAOImpl quizDAO = new QuizDAOImpl();
        Quiz quizInfo = quizDAO.getQuiz(quizId);
        Date quizSubmissionDate = quizInfo.getDate_close();

        // Get current date
        Calendar cal = Calendar.getInstance();
        Date currentDate = cal.getTime();

        // Format current date to same format as java.sql.Date
        String dateFormat = "yyyy-MM-dd";
        SimpleDateFormat dbDateFormat = new SimpleDateFormat(dateFormat);
        String todayDate = dbDateFormat.format(currentDate);

        // If the current date is > the quiz submission date, the quiz was submitted late
        if (todayDate.compareTo(quizSubmissionDate.toString()) > 0) {
            return true;
        }
        return false;
    }

    private Boolean validateInitial(String value, HttpServletResponse response) throws IOException {
        try {
            return Boolean.parseBoolean(value);
        } catch (NullPointerException npe) {
            httpCode = 400;
            httpErrorMessage = "Missing form data";
        }
        return null;
    }

    /**
     * Checks whether the date that the student took the quiz is valid, including whether the
     * form data is invalid or missing, and returns a formatted date.
     * @param value     form data to be parsed
     * @param response  servlet response to be sent back
     * @return a Date object with the correct formatting
     * @throws IOException
     */
    private Date validateDate(String value, HttpServletResponse response) throws IOException {
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            Date dt = (Date) formatter.parse(value);
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

    /**
     * Checks whether the student took the quiz within the given time limit.
     * @param quizID    ID of the quiz being taken
     * @param start     Date and time when the quiz was started
     * @param end       Date and time when the quiz was finished
     * @return true if the student took less time than the time limit, false otherwise.
     */
    private boolean isInTime(int quizID, Date start, Date end) {
        QuizDAOImpl quizDAO = new QuizDAOImpl();
        Quiz quiz = quizDAO.getQuiz(quizID);

        int timeLimit = quiz.getTime_limit() * 60000; //time_limit comes as min
        int timeTaken = (int)(end.getTime() - start.getTime()); //getTime is in ms

        return timeTaken < timeLimit;
    }
}
