package com.asu.ser516.team47.database;

import java.util.List;

/**
 * An interface for a Submission Data Access Object
 *
 * @author paulhorton
 * @version 1.0
 * @since 2/22/19
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
     * @param submission_id the id of the subission_id
     * @return a submession with the submission_id
     */
    Submission getSubmission(int submission_id);

    /**
     * Updates a submission in the database based on the
     * values in a business object
     * @param submission a submission to update in the database
     */
    void updateSubmission(Submission submission);

    /**
     * Deletes a submission in the database based on the
     * values in a business object
     * @param submission a submission to delete in the database
     */
    void deleteSubmission(Submission submission);
}
