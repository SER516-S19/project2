package com.asu.ser516.team47.database;

/**
 * A business object for a choice in the choices table.
 * Created by paulhorton on 2/21/19.
 */
public class Choice {
    private int choice_id;
    private int question_fk;
    private boolean correct;
    private String content;

    /**
     * A constructor for a choice
     * @param choice_id the key of the choice
     * @param question_fk the key of the question the choice is for
     * @param correct if the choice is correct
     * @param content the content of the choice
     */
    Choice(int choice_id, int question_fk, boolean correct, String content) {
        this.choice_id = choice_id;
        this.question_fk = question_fk;
        this.correct = correct;
        this.content = content;
    }
    /**
     * Gets the choice_id
     * @return the key value for a choice
     */
    public int getChoice_id() {
        return choice_id;
    }

    /**
     * Sets a new key value for a choice
     * @param choice_id
     */
    public void setChoice_id(int choice_id) {
        this.choice_id = choice_id;
    }

    /**
     * Gets the key value of the linked question
     * @return the key value of the linked quesiton
     */
    public int getQuestion_fk() {
        return question_fk;
    }

    /**
     * Sets the key value for a linked quesiton
     * @param question_fk
     */
    public void setQuestion_fk(int question_fk) {
        this.question_fk = question_fk;
    }

    /**
     * Gets if the choice is marked as correct
     * @return if the choice is correct
     */
    public boolean isCorrect() {
        return correct;
    }

    /**
     * sets if the question is correct
     * @param correct
     */
    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    /**
     * gets the content of a choice
     * @return
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }
}
