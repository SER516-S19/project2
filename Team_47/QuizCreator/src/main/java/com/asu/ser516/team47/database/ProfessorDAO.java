package com.asu.ser516.team47.database;

import java.util.List;

/**
 * An interface for a Professor Data Access Object
 * Created by paulhorton on 2/22/19.
 */
public interface ProfessorDAO {
    /**
     * Gets all professors in the table
     * @return all professor in the table
     */
    public List<Professor> getAllProfessors();

    /**
     * Gets a professor based on it's username
     * @param username the id of the student
     * @return a professor with the username
     */
    public Professor getProfessor(String username);

    /**
     * Updates a professor in the database based on the
     * values in a business object
     * @param professor a professor to update in the database
     */
    public void updateProfessor(Professor professor);

    /**
     * Deletes a professor in the database based on the
     * values in a business object.
     * @param professor
     */
    public void deleteProfessor(Professor professor);
}
