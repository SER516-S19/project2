package com.asu.ser516.team47.utils;

import com.asu.ser516.team47.database.Question;
import com.asu.ser516.team47.database.QuizDAOImpl;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import com.asu.ser516.team47.database.*;
import org.json.simple.JSONArray;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Utility to help the submission servlet validate incoming data. Checks for
 * quiz sameness and attempt limits.
 * @author Ruby (Qianru) Zhao
 * @author David Lahtinen
 * @version 1.1
 * @since 2/28/19
 */
public class ServletValidation {

    private static String url = "jdbc:sqlite:schema.db";

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
     * Validates whether the quiz associated with the given choice ID matches
     * the current quiz ID.
     * @param quizID    quiz ID of current submission
     * @param choiceID  choice ID to be validated
     * @return true if choice ID matches, otherwise false.
     */
    public static boolean validSameQuiz(int quizID, int choiceID) {
        Choice choice = new ChoiceDAOImpl().getChoice(choiceID);
        Question ques = new QuestionDAOImpl().getQuestion(choice.getQuestion_fk());
        Quiz quizOfOrigin = new QuizDAOImpl().getQuiz(ques.getQuiz_fk());
        int quizOfOriginID = quizOfOrigin.getQuiz_id();
        return quizID == quizOfOrigin.getQuiz_id();
    }

    /**
     * Check if array of choices is valid.
     * @param jsonChoices A json array of choice Ids
     * @param quizId The ID of the quiz that these choices belong to.
     * @return null if invalid. else a list of choices.
     */
    public static List<Integer> buildAndValidateStudentChoiceList(JSONArray jsonChoices, int quizId){
        Iterator<Long> it = jsonChoices.iterator();
        List<Integer> ret = new ArrayList<>();
        while (it.hasNext()) {
            int choiceId = it.next().intValue();
            if (ServletValidation.validSameQuiz(quizId, choiceId)){
                ret.add(choiceId);
            } else {
                return null;
            }
        }
        return ret;
    }
}