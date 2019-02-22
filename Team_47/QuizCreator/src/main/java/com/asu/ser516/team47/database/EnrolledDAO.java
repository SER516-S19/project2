package com.asu.ser516.team47.database;

import java.util.List;

/**
 * An interface for a Enrolled Data Access Object
 *
 * @author  Paul Horton
 * @author  Trevor Forrey
 * @version 1.0
 * @since   2019-02-22
 */
public interface EnrolledDAO {
    /**
     * Gets all the enrollments in the database
     *
     * @return all enrollments
     */
    List<Enrolled> getAllEnrollment();

    /**
     * Gets all enrollments for a course
     *
     * @param course_fk the course's id
     * @return all enrollments in a course
     */
    List<Enrolled> getCourseEnrollment(int course_fk);

    /**
     * Gets all enrollments for a student
     *
     * @param student_fk the student's username
     * @return all enrollments in a student
     */
    List<Enrolled> getStudentEnrollment(String student_fk);

    /**
     * Gets a enrollment based on id
     *
     * @param enrolled_id a Enrolled id
     * @return the Enrolled business object
     */
    Enrolled getEnrolled(int enrolled_id);

    /**
     * Inserts a Enrolled in the database based on the
     * values in a business object
     *
     * @param enrolled
     * @return a boolean representing a successful/failed insert
     */
    boolean insertEnrolled(Enrolled enrolled);

    /**
     * Updates a Enrolled in the database based on the
     * values in a business object
     *
     * @param enrolled
     * @return a boolean representing a successful/failed update
     */
    boolean updateEnrolled(Enrolled enrolled);

    /**
     * Deletes a Enrolled in the database based on the
     * values in a business object.
     *
     * @param enrolled
     * @return a boolean representing a successful/failed deletion
     */
    boolean deleteEnrolled(Enrolled enrolled);
}
