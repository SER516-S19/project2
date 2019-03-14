package org.team47.database;

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
    private static final String __jdbcUrl = "jdbc:sqlite:schema.db";

    /**
     * Gets all choices in the table
     *
     * @return all choices in the table
     */
    public List<Choice> getAllChoices() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Choice> rval = new ArrayList<>();

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
            DbUtils.closeConnections(rs, stmt, conn);
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
        List<Choice> rval = new ArrayList<>();

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
            DbUtils.closeConnections(rs, stmt, conn);
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
            DbUtils.closeConnections(rs, stmt, conn);
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
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("insert into choices (question_fk, correct, content)" +
                    " VALUES (?,?,?)");
            stmt.setInt(1, choice.getQuestion_fk());
            stmt.setBoolean(2, choice.isCorrect());
            stmt.setString(3,choice.getContent());
            int updatedRows = stmt.executeUpdate();
            if (updatedRows <= 0) {
                return false;
            }

            // Return SQLite generated id of inserted value
            stmt = conn.prepareStatement("SELECT last_insert_rowid()");
            rs = stmt.executeQuery();
            while (rs.next()) {
                choice.setChoice_id(rs.getInt(1));
            }
            return true;
        }
        catch (Exception se) {
            se.printStackTrace();
            return false;
        }
        finally {
            DbUtils.closeConnections(rs, stmt, conn);
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
            return updatedRows > 0;
        }
        catch (Exception se) {
            se.printStackTrace();
            return false;
        }
        finally {
            DbUtils.closeConnections(null, stmt, conn);
        }
    }

    /**
     * Deletes a choice in the database based on the
     * values in a business object.
     *
     * @param choice choice to delete
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
            DbUtils.closeConnections(null, stmt, conn);
        }
    }
}
