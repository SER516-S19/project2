package org.team47.database;

import java.util.List;

/**
 * An interface for a Quiz Data Access Object
 *
 * @author  Paul Horton
 * @author  Trevor Forrey
 * @version 1.0
 * @since   2/22/19
 */
public interface QuizDAO {
    /**
     * Gets all quizzes in the table
     * @return all quizzes in the table
     */
    List<Quiz> getAllQuizzes();

    /**
     * Gets all quizzes for a course
     * @param course_fk course_id
     * @return all quizzes for a course
     */
    List<Quiz> getCourseQuizzes(int course_fk);

    /**
     * Gets a quiz based on it's quiz_id
     * @param quiz_id the id of the quiz
     * @return a quiz with the quiz_id
     */
    Quiz getQuiz(int quiz_id);

    /**
     * Inserts a quiz in the database based on the
     * values in a business object
     * @param quiz quiz to insert
     * @return a boolean representing a successful/failed insert
     */
    boolean insertQuiz(Quiz quiz);

    /**
     * Updates a quiz in the database based on the
     * values in a business object
     * @param quiz a quiz to update in the database
     * @return a boolean representing a successful/failed update
     */
    boolean updateQuiz(Quiz quiz);

    /**
     * Deletes a quiz in the database based on the
     * values in a business object
     * @param quiz a quiz to delete in the database
     * @return a boolean representing a successful/failed deletion
     */
    boolean deleteQuiz(Quiz quiz);
}
