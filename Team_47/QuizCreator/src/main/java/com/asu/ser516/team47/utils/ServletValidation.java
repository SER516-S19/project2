package com.asu.ser516.team47.utils;

import com.asu.ser516.team47.database.QuizDAOImpl;
import org.json.simple.JSONArray;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Utility to help the submission servlet validate incoming data. Checks for
 * quiz sameness and attempt limits.
 * @author Ruby (Qianru) Zhao
 * @version 1.0
 * @since 2/23/19
 */
public class ServletValidation {

    private static String url = "jdbc:sqlite:schema.db";

    /**
     * Validates whether the quiz associated with the given choice ID matches
     * the current quiz ID.
     * @param quizID    quiz ID of current submission
     * @param choiceID  choice ID to be validated
     * @return true if choice ID matches, otherwise false.
     */
    public static boolean  validSameQuiz(int quizID, int choiceID) {
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
    public static boolean validAttempt(int quizID, int attempt) {
        QuizDAOImpl quizDAO = new QuizDAOImpl();
        return attempt <= quizDAO.getQuiz(quizID).getAttempts();
    }

    /**
     * Check if array of choices is valid.
     * @param jsonChoices A json array of choice Ids
     * @param quizId The ID of the quiz that these choices belong to.
     * @return null if invalid. else a list of choices.
     */
    public static List<Integer> buildAndValidateChoiceList(JSONArray jsonChoices, int quizId){
        Iterator<Integer> it = jsonChoices.iterator();
        List<Integer> ret = new ArrayList<Integer>();
        while (it.hasNext()) {
            int choiceId = it.next();
            if (ServletValidation.validSameQuiz(choiceId, quizId)){
                ret.add(choiceId);
            } else {
                return null;
            }
        }
        return ret;
    }
}