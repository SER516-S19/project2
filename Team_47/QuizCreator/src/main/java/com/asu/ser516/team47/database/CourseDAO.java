package com.asu.ser516.team47.database;

import java.util.List;

/**
 * An interface for a Choice Data Access Object
 *
 * @author  Paul Horton
 * @version 1.0
 * @since   2019-02-22 */
public interface CourseDAO {
    /**
     * Gets all the courses in the database
     * @return all courses
     */
    List<Course> getAllCourses();

    /**
     * Gets all courses a professor teaches
     * @param professor_fk the professor's username
     * @return all courses a professor teaches
     */
    List<Course> getProfessorsCourses(String professor_fk);

    /**
     * Gets a course based on it's id
     * @param course_id a course id
     * @return the course business object
     */
    Course getCourse(int course_id);

    /**
     * Updates a course in the database based on the
     * values in a business object
     * @param course
     */
    void updateCourse(Course course);

    /**
     * Deletes a course in the database based on the
     * values in a business object.
     * @param course
     */
    void deleteCourse(Course course);
}
