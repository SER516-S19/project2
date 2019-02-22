package com.asu.ser516.team47.database;
import java.util.List;

/**
 * An interface for a Choice Data Access Object
 *
 * @author  Paul Horton
 * @version 1.0
 * @since   2019-02-22
 */
public interface ChoiceDAO {
    /**
     * Gets all choices in the table
     * @return all choices in the table
     */
    List<Choice> getAllChoices();

    /**
     * Gets all choices linked to a question
     * @param question_fk the question key
     * @return all choices linked to the question
     */
    List<Choice> getQuestionChoices(int question_fk);

    /**
     * Gets a choice based on it's id
     * @param choice_id the id of the choice
     * @return a choice with the id
     */
    Choice getChoice(int choice_id);

    /**
     * Updates a choice in the database based on the
     * values in a business object
     * @param choice a choice to update in the database
     */
    void updateChoice(Choice choice);

    /**
     * Deletes a choice in the database basec on the
     * values in a business object.
     * @param choice
     */
    void deleteChoice(Choice choice);
}
