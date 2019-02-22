package com.asu.ser516.team47.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * A Choice Database Abstraction
 *
 * @author paulhorton
 * @version 1.0
 * @since 2/22/19
 */
public class ChoiceDAOImpl implements ChoiceDAO{
    // Hardcoded (will switch to loading through props in future)
    //    private static Properties __dbProperties;
    private static String __jdbcUrl = "jdbc:sqlite:schema.db";
    private static String __jdbcUser;
    private static String __jdbcPasswd;

    /**
     * Gets all choices in the table
     *
     * @return all choices in the table
     */
    public List<Choice> getAllChoices() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Choice> rval = new ArrayList<Choice>();

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("select * from choices");
            rs = stmt.executeQuery();
            while (rs.next()) {
                rval.add(new Choice(rs.getInt(1), rs.getInt(2), rs.getBoolean(3),
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
     * Gets all choices linked to a question
     *
     * @param question_fk the question key
     * @return all choices linked to the question
     */
    public List<Choice> getQuestionChoices(int question_fk) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Choice> rval = new ArrayList<Choice>();

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("select * from choices where question_fk = ?");
            stmt.setInt(1,question_fk);
            rs = stmt.executeQuery();
            while (rs.next()) {
                rval.add(new Choice(rs.getInt(1), rs.getInt(2), rs.getBoolean(3),
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
     * Gets a choice based on it's id
     *
     * @param choice_id the id of the choice
     * @return a choice with the id
     */
    public Choice getChoice(int choice_id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Choice rval = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);
            stmt = conn.prepareStatement("select * from choices where choice_id = ?");
            stmt.setInt(1, choice_id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                rval = new Choice(rs.getInt(1), rs.getInt(2), rs.getBoolean(3),
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
     * Inserts a choice into the database
     *
     * @param choice a choice to insert in the database
     * @return a boolean representing a successful insertion
     */
    public boolean insertChoice(Choice choice) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("insert into choices (quesiton_fk, correct, content)" +
                    " VALUES (?,?,?)");
            stmt.setInt(1, choice.getQuestion_fk());
            stmt.setBoolean(2, choice.isCorrect());
            stmt.setString(3,choice.getContent());
            int updatedRows = stmt.executeUpdate();
            if (updatedRows > 0) {
                return true;
            } else {
                return false;
            }
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
     * Updates a choice in the database based on the
     * values in a business object
     *
     * @param choice a choice to update in the database
     * @return a boolean representing a successful update
     */
    public boolean updateChoice(Choice choice) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("update choices set question_fk=?, correct=?, content=?," +
                    " where choice_id=?");
            stmt.setInt(1, choice.getQuestion_fk());
            stmt.setBoolean(2, choice.isCorrect());
            stmt.setString(3,choice.getContent());
            stmt.setInt(4,choice.getChoice_id());
            int updatedRows = stmt.executeUpdate();
            if (updatedRows > 0) {
                return true;
            } else {
                return false;
            }
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
     * Deletes a choice in the database basec on the
     * values in a business object.
     *
     * @param choice
     * @return a boolean representing a successful deletion
     */
    public boolean deleteChoice(Choice choice) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement("delete from choices where choice_id=?");
            stmt.setInt(1, choice.getChoice_id());
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
