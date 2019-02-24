package com.asu.ser516.team47.database;

import java.util.Date;

/**
 * A business object for a quiz in the quizzes table.
 *
 * @author  Paul Horton
 * @version 1.0
 * @since   2019-02-22
 */
public class Quiz {
    private int quiz_id;
    private String title;
    private int course_fk;
    private String instructions;
    private boolean shuffle;
    private int time_limit;
    private Date date_open;
    private Date date_close;
    private String quiz_type;
    private int attempts;
    private String quiz_group;
    private double total_points;

    /**
     * @param quiz_id unique id for quiz
     * @param title title for the quiz
     * @param course_fk foreign key for the quiz's course
     * @param instructions instructions for the quiz
     * @param shuffle if questions are shuffled
     * @param time_limit time limit for quiz
     * @param date_open date to open quiz
     * @param date_close date to close quiz
     * @param quiz_type quiz type
     * @param attempts max number of attempts
     * @param quiz_group quiz grouping for professor
     */
    public Quiz(int quiz_id, String title, int course_fk, String instructions,
                boolean shuffle, int time_limit, Date date_open, Date date_close,
                String quiz_type, int attempts, String quiz_group, double total_points) {
        this.quiz_id = quiz_id;
        this.title = title;
        this.course_fk = course_fk;
        this.instructions = instructions;
        this.shuffle = shuffle;
        this.time_limit = time_limit;
        this.date_open = date_open;
        this.date_close = date_close;
        this.quiz_type = quiz_type;
        this.attempts = attempts;
        this.quiz_group = quiz_group;
        this.total_points = total_points;
    }

    public int getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(int quiz_id) {
        this.quiz_id = quiz_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCourse_fk() {
        return course_fk;
    }

    public void setCourse_fk(int course_fk) {
        this.course_fk = course_fk;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public boolean isShuffle() {
        return shuffle;
    }

    public void setShuffle(boolean shuffle) {
        this.shuffle = shuffle;
    }

    public int getTime_limit() {
        return time_limit;
    }

    public void setTime_limit(int time_limit) {
        this.time_limit = time_limit;
    }

    public Date getDate_open() {
        return date_open;
    }

    public void setDate_open(Date date_open) {
        this.date_open = date_open;
    }

    public Date getDate_close() {
        return date_close;
    }

    public void setDate_close(Date date_close) {
        this.date_close = date_close;
    }

    public String getQuiz_type() {
        return quiz_type;
    }

    public void setQuiz_type(String quiz_type) {
        this.quiz_type = quiz_type;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public String getQuiz_group() {
        return quiz_group;
    }

    public void setQuiz_group(String quiz_group) {
        this.quiz_group = quiz_group;
    }

    public double getTotal_points() { return total_points; }

    public void setTotal_points(double newTotal) { this.total_points = newTotal; }
}
