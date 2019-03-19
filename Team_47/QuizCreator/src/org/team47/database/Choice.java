package org.team47.database;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * A business object for a choice in the choices table.
 *
 * @author  Paul Horton
 * @version 1.0
 * @since   2019-02-22
 */
public class Choice {
    private int choice_id;
    private int question_fk;
    private boolean correct;
    private String content;

    /**
     * @param choice_id the key of the choice
     * @param question_fk the key of the question the choice is for
     * @param correct if the choice is correct
     * @param content the content of the choice
     */
    public Choice(int choice_id, int question_fk, boolean correct, String content) {
        this.choice_id = choice_id;
        this.question_fk = question_fk;
        this.correct = correct;
        this.content = content;
    }

    public int getChoice_id() {
        return choice_id;
    }

    public void setChoice_id(int choice_id) {
        this.choice_id = choice_id;
    }

    public int getQuestion_fk() {
        return question_fk;
    }

    public void setQuestion_fk(int question_fk) {
        this.question_fk = question_fk;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * toString
     * @return string representation of choice object
     */
    public String toString() {
        String result = "Choice {" + "\n" +
                "  choice_id: " + Integer.toString(choice_id) + "\n" +
                "  question_fk: " + Integer.toString(question_fk) + "\n" +
                "  correct: " + Boolean.toString(correct) + "\n" +
                "  content: " + content + "\n" +
                "}";
        return result;
    }
}
