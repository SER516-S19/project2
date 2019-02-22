package com.asu.ser516.team47.database;

import java.util.List;

/**
 * An interface for an Answer Data Access Object
 *
 * @author  Paul Horton
 * @author  Trevor Forrey
 * @version 1.0
 * @since   2/22/19
 */
public interface AnswerDAO {
    /**
     * Gets all answers in the table
     * @return all answers in the table
     */
    List<Answer> getAllAnswers();

    /**
     * Gets all answers for a submission
     * @param submission_fk submission_id
     * @return all answers for a submission
     */
    List<Answer> getSubmissionAnswers(int submission_fk);

    /**
     * Gets all answered responses for a question
     * @param question_fk question_id
     * @return all answers for a question
     */
    List<Answer> getQuestionAnswers(int question_fk);

    /**
     * Gets all answered responses for a choice
     * @param choice_fk choice_fk
     * @return all answers for a choice
     */
    List<Answer> getChoiceAnswers(int choice_fk);

    /**
     * Gets an answer based on it's answer_id
     * @param answer_id the id of the answer_id
     * @return a answer with the answer_id
     */
    Answer getAnswer(int answer_id);

    /**
     * Inserts an answer into the Answer Table
     * @param answer the answer to insert
     * @return a boolean noting success (true) or failure (false)
     */
    boolean insertAnswer(Answer answer);

    /**
     * Updates a answer in the database based on the
     * values in a business object
     * @param answer a answer to update in the database
     * @return a boolean noting success (true) or failure (false)
     */
    boolean updateAnswer(Answer answer);

    /**
     * Deletes a answer in the database based on the
     * values in a business object
     * @param answer a answer to delete in the database
     * @return a boolean noting success (true) or failure (false)
     */
    boolean deleteAnswer(Answer answer);
}
