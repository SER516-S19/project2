package com.asu.ser516.team47.database;
import java.util.List;

/**
 * An interface for a Choice Data Access Object
 * Created by paulhorton on 2/22/19.
 */
public interface ChoiceDAO {
    /**
     * Gets all choices in the table
     * @return all choices in the table
     */
    public List<Choice> getAllChoices();

    /**
     * Gets all choices linked to a question
     * @param question_fk the question key
     * @return all choices linked to the question
     */
    public List<Choice> getQuestionChoices(int question_fk);

    /**
     * Gets a choice based on it's id
     * @param choice_id the id of the choice
     * @return a choice with the id
     */
    public Choice getChoice(int choice_id);

    /**
     * Updates a choice in the database based on the
     * values in a business object
     * @param choice a choice to update in the database
     */
    public void updateChoice(Choice choice);

    /**
     * Deletes a choice in the database basec on the
     * values in a business object.
     * @param choice
     */
    public void deleteChoice(Choice choice);
}
