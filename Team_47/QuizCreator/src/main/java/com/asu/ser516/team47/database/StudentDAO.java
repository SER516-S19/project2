package com.asu.ser516.team47.database;

import java.util.List;

/**
 * An interface for a student Data Access Object
 * Created by paulhorton on 2/22/19.
 */
public interface StudentDAO {
    /**
     * Gets all students in the table
     * @return all student in the table
     */
    public List<Student> getAllStudents();

    /**
     * Gets a student based on it's username
     * @param username the id of the student
     * @return a student with the username
     */
    public Student getStudent(String username);

    /**
     * Updates a student in the database based on the
     * values in a business object
     * @param student a student to update in the database
     */
    public void updateStudent(Student student);

    /**
     * Deletes a student in the database based on the
     * values in a business object.
     * @param student
     */
    public void deleteStudent(Student student);
}
