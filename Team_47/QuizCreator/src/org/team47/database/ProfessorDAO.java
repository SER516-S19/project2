package org.team47.database;

import java.util.List;

/**
 * An interface for a Professor Data Access Object
 *
 * @author  Paul Horton
 * @author  Trevor Forrey
 * @version 1.0
 * @since   2019-02-22
 */
public interface ProfessorDAO {
    /**
     * Gets all professors in the table
     * @return all professor in the table
     */
    List<Professor> getAllProfessors();

    /**
     * Gets a professor based on it's username
     * @param username the id of the professor
     * @return a professor with the username
     */
    Professor getProfessor(String username);

    /**
     * Inserts a professor in the database based on the
     * values in a business object
     * @param professor professor to insert
     * @return a boolean representing a successful/failed insert
     */
    boolean insertProfessor(Professor professor);

    /**
     * Updates a professor in the database based on the
     * values in a business object
     * @param professor a professor to update in the database
     * @return a boolean representing a successful/failed update
     */
    boolean updateProfessor(Professor professor);

    /**
     * Deletes a professor in the database based on the
     * values in a business object.
     * @param professor professor to delete
     * @return a boolean representing a successful/failed deletion
     */
    boolean deleteProfessor(Professor professor);
}
