package com.asu.ser516.team47.database;

import java.util.List;

/**
 * An interface for a Submission Data Access Object
 *
 * @author  Paul Horton
 * @author  Trevor Forrey
 * @version 1.0
 * @since   2/22/19
 */
public interface SubmissionDAO {
    /**
     * Gets all submissions in the table
     * @return all submissions in the table
     */
    List<Submission> getAllSubmissions();

    /**
     * Gets all submissions for a quiz
     * @param quiz_fk quiz_id
     * @return all submissions for a quiz
     */
    List<Submission> getQuizSubmissions(int quiz_fk);

    /**
     * Gets all submissions for an enrollment
     * @param enrolled_fk enrolled_id
     * @return all submissions for an enrollment
     */
    List<Submission> getEnrolledSubmissions(int enrolled_fk);

    /**
     * Gets a submission based on it's submission_id
     * @param submission_id the id of the submission_id
     * @return a submission with the submission_id
     */
    Submission getSubmission(int submission_id);

    /**
     * Inserts a submission in the database based on the
     * values in a business object
     * @param submission
     * @return an int representing the generated id of the db row
     */
    int insertSubmission(Submission submission);

    /**
     * Updates a submission in the database based on the
     * values in a business object
     * @param submission a submission to update in the database
     * @return a boolean representing a successful/failed update
     */
    boolean updateSubmission(Submission submission);

    /**
     * Deletes a submission in the database based on the
     * values in a business object
     * @param submission a submission to delete in the database
     * @return a boolean representing a successful/failed deletion
     */
    boolean deleteSubmission(Submission submission);
}
