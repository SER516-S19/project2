package com.asu.ser516.team47.database;

import java.util.List;

/**
 * An interface for a Enrolled Data Access Object
 *
 * @author  Paul Horton
 * @version 1.0
 * @since   2019-02-22
 */
public interface EnrolledDAO {
    /**
     * Gets all the enrollments in the database
     * @return all enrollments
     */
    List<Enrolled> getAllEnrollment();

    /**
     * Gets all enrollments for a course
     * @param course_fk the course's id
     * @return all enrollments in a course
     */
    List<Enrolled> getCourseEnrollment(int course_fk);

    /**
     * Gets all enrollments for a student
     * @param student_fk the student's username
     * @return all enrollments in a student
     */
    List<Enrolled> getStudentEnrollment(String student_fk);

    /**
     * Gets a enrollment based on id
     * @param Enrolled_id a Enrolled id
     * @return the Enrolled business object
     */
    Enrolled getEnrolled(int Enrolled_id);

    /**
     * Updates a Enrolled in the database based on the
     * values in a business object
     * @param enrolled
     */
    void updateEnrolled(Enrolled enrolled);

    /**
     * Deletes a Enrolled in the database based on the
     * values in a business object.
     * @param enrolled
     */
    void deleteEnrolled(Enrolled enrolled);
}
