package com.asu.ser516.team47.servlet;

import java.io.IOException;
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

@WebServlet(name = "SubmissionServlet")
public class SubmissionServlet extends HttpServlet {

    private int submissionID = 0;

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
        int htmlCode = 204;
        String htmlMessage;
        //Mandatory fields to create a submission entry
        int quizId;
        String enrollIdField;
        String timetaken;
        String attempt;

        Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()){
            String paramName = (String)paramNames.nextElement();
            if (paramName.equals("quiz_id")){
                try {
                    quizId = Integer.parseInt(
                            request.getParameter("quiz_id"));
                } catch () {}
            }
                quizIdField = request.getParameter("quiz_id");

            } else if (paramName.equals("enroll_id")){
                try {
                    enrollIdField = request.getParameter();
                } catch () {}
            } else if (paramName.equals("attempt")){

            } else if (paramName.equals("timeTaken")){

            } else if (paramName.length() >= "choice_fk".length()){}
        }

        response.setStatus

    /**
     * Creates a Submission object based on the data from the parameters and
     * sends it to the database as a new submission table.
     * @param quizID    quiz ID
     * @param enrollID  enrollment ID
     * @param time      time the quiz was taken
     * @param date      date the quiz was taken
     * @param score     graded quiz score
     * @param attempt   number of attempts
     * @return true if the insertion into database succeeds, otherwise false.
     */
    private boolean sendSubmission(int quizID, int enrollID, int time, Date date,
                                  float score, int attempt) {
        boolean hasSucceeded;

        Submission studentSubmission = new Submission(0, quizID, enrollID,
                time, date, score, attempt);
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

    private void invalidQuiz() {

    }
}