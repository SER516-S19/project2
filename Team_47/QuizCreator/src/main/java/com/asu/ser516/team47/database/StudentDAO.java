package com.asu.ser516.team47.database;

import java.util.List;

/**
 * An interface for a student Data Access Object
 *
 * @author  Paul Horton
 * @author  Trevor Forrey
 * @version 1.0
 * @since   2019-02-22
 */
public interface StudentDAO {
    /**
     * Gets all students in the table
     * @return all student in the table
     */
    List<Student> getAllStudents();

    /**
     * Gets a student based on it's username
     * @param username the id of the student
     * @return a student with the username
     */
    Student getStudent(String username);

    /**
     * Inserts a student in the database based on the
     * values in a business object
     * @param student student to insert
     * @return a boolean representing a successful/failed insert
     */
    boolean insertStudent(Student student);

    /**
     * Updates a student in the database based on the
     * values in a business object
     * @param student a student to update in the database
     * @return a boolean representing a successful/failed update
     */
    boolean updateStudent(Student student);

    /**
     * Deletes a student in the database based on the
     * values in a business object.
     * @param student student to delete
     * @return a boolean representing a successful/failed deletion
     */
    boolean deleteStudent(Student student);
}
