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
    private Date start_time;
    private Date end_time;
    private float score;
    private int attempt;

    /**
     * @param submission_id unique key for the submission
     * @param quiz_fk foreign key for the quiz of the submission
     * @param enrolled_fk foreign key for the enrolled student who submitted
     * @param start_time date quiz began
     * @param end_time date quiz ended
     * @param score score on the quiz
     * @param attempt attempt number for submission
     */
    public Submission(int submission_id, int quiz_fk, int enrolled_fk,
                      Date start_time, Date end_time, float score, int attempt) {
        this.submission_id = submission_id;
        this.quiz_fk = quiz_fk;
        this.enrolled_fk = enrolled_fk;
        this.start_time = start_time;
        this.end_time = end_time;
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

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() { return end_time; }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
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
        String result = "Quiz {" + "\n" +
                "  submission_id: " + Integer.toString(submission_id) + "\n" +
                "  quiz_fk: " + Integer.toString(quiz_fk) + "\n" +
                "  enrolled_fk: " + Integer.toString(enrolled_fk) + "\n" +
                "  start_time: " + dateFormat.format(start_time) + "\n" +
                "  end_time: " + dateFormat.format(end_time) + "\n" +
                "  score: " + Float.toString(score) + "\n" +
                "  attempt: " + Integer.toString(attempt) + "\n" +
                "}";
        return result;
    }
}
