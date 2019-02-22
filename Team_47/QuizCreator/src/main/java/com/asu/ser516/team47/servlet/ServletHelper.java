package com.asu.ser516.team47.servlet;

import java.util.Date;
import com.asu.ser516.team47.database.*;

/**
 * A helper class that is used by the submission servlet to process incoming data
 * and store it to the database. Handles creating quiz submission objects and
 * assembling student answer data.
 *
 * @author Ruby Zhao (qrzhao)
 * @version 1.0
 * @since 2/22/19
 */

public class ServletHelper {

    /**
     * Creates a Submission object based on the data from the parameters and
     * sends it to the database as a new submission table.
     * @param quizID    quiz ID
     * @param enrollID  enrollment ID
     * @param time      time the quiz was taken
     * @param date      date the quiz was taken
     * @param score     graded quiz score
     * @param attempt   number of attempts
     * @return true if the submission succeeded, false if it failed.
     */
    public boolean sendSubmission(int quizID, int enrollID, int time, Date date,
                                  float score, int attempt) {

        Submission studentSubmission = new Submission(submissionID, quizID, enrollID,
                time, date, score, attempt);
        SubmissionDAOImpl submitter = new SubmissionDAOImpl();

        return submitter.insertSubmission(studentSubmission);

    }

    //TODO: add sendAnswers() {}

}
