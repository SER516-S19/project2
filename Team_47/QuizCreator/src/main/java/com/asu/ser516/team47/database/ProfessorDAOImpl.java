package com.asu.ser516.team47.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * A Professor Database Abstraction
 *
 * @author  Paul Horton
 * @version 1.0
 * @since   2/22/19
 */
public class ProfessorDAOImpl implements ProfessorDAO{
    private static final String __jdbcUrl = "jdbc:sqlite:schema.db";

    /**
     * Gets all professors in the table
     *
     * @return all professor in the table
     */
    public List<Professor> getAllProfessors() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Professor> rval = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("select * from professors");
            rs = stmt.executeQuery();
            while (rs.next()) {
                rval.add(new Professor(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4)));
            }
        }
        catch (Exception se) {
            se.printStackTrace();
            return null;
        }
        finally {
            try {
                if (rs != null) { rs.close();}
                if (stmt != null) { stmt.close();}
                if (conn != null) { conn.close();}
            } catch (Exception e) { e.printStackTrace(); }
        }

        return rval;
    }

    /**
     * Gets a professor based on it's username
     *
     * @param username the id of the professor
     * @return a professor with the username
     */
    public Professor getProfessor(String username) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Professor rval = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("select * from professors");
            rs = stmt.executeQuery();
            while (rs.next()) {
                rval = new Professor(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4));
            }
        }
        catch (Exception se) {
            se.printStackTrace();
            return null;
        }
        finally {
            try {
                if (rs != null) { rs.close();}
                if (stmt != null) { stmt.close();}
                if (conn != null) { conn.close();}
            } catch (Exception e) { e.printStackTrace(); }
        }

        return rval;
    }

    /**
     * Inserts a professor in the database based on the
     * values in a business object
     *
     * @param professor professor to insert
     * @return a boolean representing a successful/failed insert
     */
    public boolean insertProfessor(Professor professor) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("insert into professors (username, firstname, lastname, hashedpass)" +
                    " VALUES (?,?,?,?)");
            stmt.setString(1, professor.getUsername());
            stmt.setString(2, professor.getFirstname());
            stmt.setString(3, professor.getLastname());
            stmt.setString(4, professor.getHashedpass());
            int updatedRows = stmt.executeUpdate();
            return updatedRows > 0;
        }
        catch (Exception se) {
            se.printStackTrace();
            return false;
        }
        finally {
            try {
                if (stmt != null) { stmt.close();}
                if (conn != null) { conn.close();}
            } catch (Exception e) { e.printStackTrace(); }
        }
    }

    /**
     * Updates a professor in the database based on the
     * values in a business object
     *
     * @param professor a professor to update in the database
     * @return a boolean representing a successful/failed update
     */    public boolean updateProfessor(Professor professor) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("update professors set username=?, firstname=?, lastname=?," +
                    " hashedpass=? where username=?");
            stmt.setString(1, professor.getUsername());
            stmt.setString(2, professor.getFirstname());
            stmt.setString(3, professor.getLastname());
            stmt.setString(4, professor.getHashedpass());
            int updatedRows = stmt.executeUpdate();
            return updatedRows > 0;
        }
        catch (Exception se) {
            se.printStackTrace();
            return false;
        }
        finally {
            try {
                if (stmt != null) { stmt.close();}
                if (conn != null) { conn.close();}
            } catch (Exception e) { e.printStackTrace(); }
        }
    }

    /**
     * Deletes a professor in the database based on the
     * values in a business object.
     *
     * @param professor professor to delete
     * @return a boolean representing a successful/failed deletion
     */    public boolean deleteProfessor(Professor professor) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement("delete from professors where username=?");
            stmt.setString(1, professor.getUsername());
            stmt.executeUpdate();
            conn.commit();
            return true;
        }
        catch (Exception se) {
            se.printStackTrace();
            return false;
        }
        finally {
            try {
                if (stmt != null) { stmt.close();}
                if (conn != null) { conn.close();}
            } catch (Exception e) { e.printStackTrace(); }
        }
    }
}
