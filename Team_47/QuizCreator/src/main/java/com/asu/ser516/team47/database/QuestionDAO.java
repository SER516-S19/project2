package com.asu.ser516.team47.database;

import java.util.List;

/**
 * An interface for a Question Data Access Object
 *
 * @author  Paul Horton
 * @version 1.0
 * @since   2/22/19
 */
public interface QuestionDAO {
    /**
     * Gets all questions in the table
     * @return all questions in the table
     */
    List<Question> getAllQuestions();

    /**
     * Gets all questions for a quiz
     * @param quiz_fk quiz_id
     * @return all questions for a quiz
     */
    List<Question> getQuizQuestions(int quiz_fk);

    /**
     * Gets a question based on it's question_id
     * @param question_id the id of the question_id
     * @return a question with the question_id
     */
    Question getQuestion(int question_id);

    /**
     * Updates a question in the database based on the
     * values in a business object
     * @param question a question to update in the database
     */
    void updateQuestion(Question question);

    /**
     * Deletes a question in the database based on the
     * values in a business object
     * @param question a question to delete in the database
     */
    void deleteQuestion(Question question);
}
