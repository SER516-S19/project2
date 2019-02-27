package com.asu.ser516.team47.utils;

import com.asu.ser516.team47.database.QuizDAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Utility to help the submission servlet validate incoming data. Checks for
 * quiz sameness and attempt limits.
 * @author Ruby (Qianru) Zhao
 * @version 1.0
 * @since 2/23/19
 */
public class ServletValidation {

    private String url = "jdbc:sqlite:schema.db";

    /**
     * Validates whether the quiz associated with the given choice ID matches
     * the current quiz ID.
     * @param quizID    quiz ID of current submission
     * @param choiceID  choice ID to be validated
     * @return true if choice ID matches, otherwise false.
     */
    public boolean validSameQuiz(int quizID, int choiceID) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int result;

        try {
            conn = DriverManager.getConnection(url);
            stmt = conn.prepareStatement("select quiz_id from submissions" +
                    "inner join answers on answers.submission_fk =" +
                    "submissions.submission_id where = ?");
            stmt.setInt(1, choiceID);
            rs = stmt.executeQuery();
            result = rs.getInt("quiz_id");
        }
        catch (Exception se) {
            se.printStackTrace();
            return false;
        }
        finally {
            try {
                if (rs != null) { rs.close();}
                if (stmt != null) { stmt.close();}
                if (conn != null) { conn.close();}
            } catch (Exception e) { e.printStackTrace(); }
        }

        return quizID == result;
    }

    /**
     * Validates whether the attempt number of the student's current submission is within
     * the limits of the attempt limit set for the quiz.
     * @param quizID    quiz ID of current submission
     * @param attempt   student attempt number
     * @return true if attempt is within limits, otherwise false.
     */
    public boolean validAttempt(int quizID, int attempt) {
        QuizDAOImpl quizDAO = new QuizDAOImpl();
        return attempt <= quizDAO.getQuiz(quizID).getAttempts();
    }
}