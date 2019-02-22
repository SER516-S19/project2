package com.asu.ser516.team47.database;

import java.util.List;

/**
 * An interface for a Choice Data Access Object
 * Created by paulhorton on 2/22/19.
 */
public interface CourseDAO {
    /**
     * Gets all the courses in the database
     * @return all courses
     */
    public List<Course> getAllCourses();

    /**
     * Gets all courses a professor teaches
     * @param professor_fk the professor's username
     * @return all courses a professor teaches
     */
    public List<Course> getProfessorsCourses(String professor_fk);

    /**
     * Gets a course based on it's id
     * @param course_id a course id
     * @return the course buisness object
     */
    public Course getCourse(int course_id);

    /**
     * Updates a course in the database based on the
     * values in a business object
     * @param course
     */
    public void updateCourse(Course course);

    /**
     * Deletes a course in the database based on the
     * values in a business object.
     * @param course
     */
    public void deleteCourse(Course course);
}
