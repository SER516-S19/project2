package com.asu.ser516.team47.database;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A business object for a submission in the submissions table
 *
 * @author paulhorton
 * @version 1.0
 * @since 2/22/19
 */
public class Submission {
    private int submission_id;
    private int quiz_fk;
    private int enrolled_fk;
    private int time_taken;
    private Date date_taken;
    private float score;
    private int attempt;

    /**
     * @param submission_id unique key for the submission
     * @param quiz_fk foreign key for the quiz of the submission
     * @param enrolled_fk foreign key for the enrolled student who submitted
     * @param time_taken time taken on the quiz
     * @param date_taken date quiz was taken
     * @param score score on the quiz
     * @param attempt attempt number for submission
     */
    public Submission(int submission_id, int quiz_fk, int enrolled_fk,
                      int time_taken, Date date_taken, float score, int attempt) {
        this.submission_id = submission_id;
        this.quiz_fk = quiz_fk;
        this.enrolled_fk = enrolled_fk;
        this.time_taken = time_taken;
        this.date_taken = date_taken;
        this.score = score;
        this.attempt = attempt;
    }

    public int getSubmission_id() {
        return submission_id;
    }

    public void setSubmission_id(int submission_id) {
        this.submission_id = submission_id;
    }

    public int getQuiz_fk() {
        return quiz_fk;
    }

    public void setQuiz_fk(int quiz_fk) {
        this.quiz_fk = quiz_fk;
    }

    public int getEnrolled_fk() {
        return enrolled_fk;
    }

    public void setEnrolled_fk(int enrolled_fk) {
        this.enrolled_fk = enrolled_fk;
    }

    public int getTime_taken() {
        return time_taken;
    }

    public void setTime_taken(int time_taken) {
        this.time_taken = time_taken;
    }

    public Date getDate_taken() {
        return date_taken;
    }

    public void setDate_taken(Date date_taken) {
        this.date_taken = date_taken;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }

    /**
     * toString
     * @return string representation of submission object
     */
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String result = "Submission {" + "\n" +
                "  submission_id: " + Integer.toString(submission_id) + "\n" +
                "  quiz_fk: " + Integer.toString(quiz_fk) + "\n" +
                "  enrolled_fk: " + Integer.toString(enrolled_fk) + "\n" +
                "  time_taken: " + Integer.toString(time_taken) + "\n" +
                "  date_taken: " + dateFormat.format(date_taken) + "\n" +
                "  score: " + Float.toString(score) + "\n" +
                "  attempt: " + Integer.toString(attempt) + "\n" +
                "}";
        return result;
    }
}
