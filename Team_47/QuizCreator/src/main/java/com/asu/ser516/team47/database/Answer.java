package com.asu.ser516.team47.database;

/**
 * A business object for an answer in the answers table
 *
 * @author  Paul Horton
 * @version 1.0
 * @since   2/22/19
 */
public class Answer {
    private int answer_id;
    private int submission_fk;
    private int question_fk;
    private int choice_fk;

    /**
     * @param answer_id a unique key for an answer
     * @param submission_fk foreign key for the submission with this answer
     * @param question_fk foreign key for the question this answers
     * @param choice_fk foreign key for the choice chosen in this answer
     */
    public Answer(int answer_id, int submission_fk, int question_fk, int choice_fk) {
        this.answer_id = answer_id;
        this.submission_fk = submission_fk;
        this.question_fk = question_fk;
        this.choice_fk = choice_fk;
    }

    public int getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(int answer_id) {
        this.answer_id = answer_id;
    }

    public int getSubmission_fk() {
        return submission_fk;
    }

    public void setSubmission_fk(int submission_fk) {
        this.submission_fk = submission_fk;
    }

    public int getQuestion_fk() {
        return question_fk;
    }

    public void setQuestion_fk(int question_fk) {
        this.question_fk = question_fk;
    }

    public int getChoice_fk() {
        return choice_fk;
    }

    public void setChoice_fk(int choice_fk) {
        this.choice_fk = choice_fk;
    }
}
