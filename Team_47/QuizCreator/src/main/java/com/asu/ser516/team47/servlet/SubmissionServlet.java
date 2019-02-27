package com.asu.ser516.team47.servlet;

import java.io.IOException;
import java.util.*;
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

@WebServlet(name = "SubmissionServlet")
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
     * requires the presence of quiz_id, enroll_id, timeTaken, and attempt fields in the form. all integers.
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
        ServletValidation validation = new ServletValidation();

        //Mandatory fields to create a submission entry
        Integer quizId = null;
        Integer enrollId = null;
        Integer attempt;
        Integer timeTaken;

        List<Integer> choiceIds = new ArrayList<>();

        //Check if json form can be read.
        try {
            requestForm = JSONRequestParser.getJsonFromRequest(request);
        } catch (IOException ioe){
            response.sendError(400, "Problem reading form.");
            return;
        } catch (ParseException pe){
            response.sendError(400, "Problem parsing form.");
            return;
        } catch (ClassCastException cce){
            response.sendError(400, "Problem parsing form. Are you sure you sent an object and not an array?");
            return;
        }

        //Validate that all necessary fields are present and build ChoiceId array
        try {
            for (Iterator it = requestForm.keySet().iterator(); it.hasNext(); ) {
                String paramName = (String) it.next();
                if (paramName.equals("quiz_id")) {
                    quizId = (Integer) requestForm.get("quiz_id");
                    quiz = new QuizDAOImpl().getQuiz(quizId);
                    if (quiz == null) {
                        httpCode = 500;
                        break;
                    }
                } else if (paramName.equals("enrolled_id")) {
                    enrollId = (Integer)requestForm.get("enrolled_id");
                    enrollment = new EnrolledDAOImpl().getEnrolled(enrollId);
                    if (enrollment == null) {
                        httpCode = 500;
                        break;
                    }
                } else if (paramName.equals("choices")) {
                    JSONArray jsonChoices = (JSONArray) requestForm.get("choices");

                    int choiceId = validateInteger((String) requestForm.get(paramName), response);
                } else if (paramName.equals("attempt")) {
                    attempt = validateInteger(request.getParameter("attempt"), response);
                    if (attempt <= 0){
                        httpCode = 400;
                        break;
                    }
                    if (!validation.validAttempt(quizId, attempt.intValue())) {
                        httpCode = 400;
                        httpErrorMessage = "Submission exceeds attempt limit";
                        break;
                    }
                } else if (paramName.equals("timeTaken")) {
                    timeTaken = validateInteger(request.getParameter("timeTaken"), response);
                    if (timeTaken <= 0) {
                        httpCode = 400;
                        break;
                    }
                } else if (paramName.equals("choices")) {
                    JSONArray jsonChoices = (JSONArray) requestForm.get("choices");

                    int choiceId = validateInteger((String) requestForm.get(paramName), response);
                    Choice choice = new ChoiceDAOImpl().getChoice(choiceId);
                    if (choice == null) {
                        httpCode = 500;
                        break;
                    } else {
                        choiceIds.add(choiceId);
                    }
                }
            }
        } catch (ClassCastException cce){
            response.sendError(400, "Some field is wrong data type.");
            return;
        }

        //check that all fields are present and no error has occurred
        if (httpCode != 204 || quizId == null || enrollId == null) {
            if (httpCode == 500) {
                httpErrorMessage = "Server Error";
            }
            response.sendError(httpCode, httpErrorMessage);
            return;
        }

        //TODO: Call function to check if time limit is passed.
        if (!sendSubmission(quizId, enrollId, 1, 0, 0)){
            response.sendError(500);
            return;
        }
        if (!sendAnswer(choiceIds)){
            response.sendError(500);
            return;
        }
        response.setStatus(httpCode);
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
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int result;

        try {
            conn = DriverManager.getConnection(url);
            stmt = conn.prepareStatement("select question_fk from choices where choice_id = ?");
            stmt.setInt(1, choiceID);
            rs = stmt.executeQuery();
            result = rs.getInt("question_fk");
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
            httpCode = 400;
            httpErrorMessage = "Invalid form data";
        } catch (NullPointerException npe) {
            httpCode = 400;
            httpErrorMessage = "Missing form data";
        }
        return null;
    }

    /**
     * Check if array of choices is valid.
     * @param jsonChoices A json array of choice Ids
     * @return null if invalid. else a list of choices.
     */
    private List<Choice> buildAndValidateChoiceList(JSONArray jsonChoices){
        Iterator<Integer> it = jsonChoices.iterator();
        List<Choice> ret = new ArrayList<Choice>();
        try {
            while (it.hasNext()) {
                int choiceId = it.next();
                Choice choice = new ChoiceDAOImpl().getChoice(choiceId);
                ret.add(choice);
            }
        }
    }
}