package com.asu.ser516.team47.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * An Answer Database Abstraction
 *
 * @author  Paul Horton
 * @version 1.0
 * @since   2/22/19
 */
public class AnswerDAOImpl implements AnswerDAO{
    // Hardcoded (will switch to loading through props in future)
    //    private static Properties __dbProperties;
    private static String __jdbcUrl = "jdbc:sqlite:schema.db";
    private static String __jdbcUser;
    private static String __jdbcPasswd;

    /**
     * Gets all answers in the table
     *
     * @return all answers in the table
     */
    public List<Answer> getAllAnswers() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Answer> rval = new ArrayList<Answer>();

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("select * from answers");
            rs = stmt.executeQuery();
            while (rs.next()) {
                rval.add(new Answer(rs.getInt(1), rs.getInt(2), rs.getInt(3),
                        rs.getInt(4)));
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
     * Gets all answers for a submission
     *
     * @param submission_fk submission_id
     * @return all answers for a submission
     */
    public List<Answer> getSubmissionAnswers(int submission_fk) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Answer> rval = new ArrayList<Answer>();

        try {
            conn = DriverManager.getConnection(__jdbcUrl);
            stmt = conn.prepareStatement("select * from answers where submission_fk = ?");
            stmt.setInt(1, submission_fk);
            rs = stmt.executeQuery();
            while (rs.next()) {
                rval.add(new Answer(rs.getInt(1), rs.getInt(2), rs.getInt(3),
                        rs.getInt(4)));
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
     * Gets all answered responses for a question
     *
     * @param question_fk question_id
     * @return all answers for a question
     */
    public List<Answer> getQuestionAnswers(int question_fk) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Answer> rval = new ArrayList<Answer>();

        try {
            conn = DriverManager.getConnection(__jdbcUrl);
            stmt = conn.prepareStatement("select * from answers where question_fk = ?");
            stmt.setInt(1, question_fk);
            rs = stmt.executeQuery();
            while (rs.next()) {
                rval.add(new Answer(rs.getInt(1), rs.getInt(2), rs.getInt(3),
                        rs.getInt(4)));
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
     * Gets all answered responses for a choice
     *
     * @param choice_fk choice_fk
     * @return all answers for a choice
     */
    public List<Answer> getChoiceAnswers(int choice_fk) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Answer> rval = new ArrayList<Answer>();

        try {
            conn = DriverManager.getConnection(__jdbcUrl);
            stmt = conn.prepareStatement("select * from answers where choice_fk = ?");
            stmt.setInt(1, choice_fk);
            rs = stmt.executeQuery();
            while (rs.next()) {
                rval.add(new Answer(rs.getInt(1), rs.getInt(2), rs.getInt(3),
                        rs.getInt(4)));
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
     * Gets an answer based on it's answer_id
     *
     * @param answer_id the id of the answer_id
     * @return a answer with the answer_id
     */
    public Answer getAnswer(int answer_id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Answer rval = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);
            stmt = conn.prepareStatement("select * from answers where answer_id = ?");
            stmt.setInt(1, answer_id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                rval = new Answer(rs.getInt(1), rs.getInt(2), rs.getInt(3),
                        rs.getInt(4));
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
     * Inserts an answer into the Answer Table
     *
     * @param answer the answer to insert
     * @return a boolean noting success (true) or failure (false)
     */
    public boolean insertAnswer(Answer answer) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("insert into answers (submission_fk, question_fk, choice_fk)" +
                    " VALUES (?,?,?)");
            stmt.setInt(1, answer.getSubmission_fk());
            stmt.setInt(2, answer.getQuestion_fk());
            stmt.setInt(3, answer.getChoice_fk());
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
     * Updates a answer in the database based on the
     * values in a business object
     *
     * @param answer a answer to update in the database
     * @return a boolean noting success (true) or failure (false)
     */
    public boolean updateAnswer(Answer answer) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("update answers set submission_fk=?, question_fk=?, choice_fk=?," +
                    " where answer_id=?");
            stmt.setInt(1, answer.getSubmission_fk());
            stmt.setInt(2, answer.getQuestion_fk());
            stmt.setInt(3, answer.getChoice_fk());
            stmt.setInt(4,answer.getAnswer_id());
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
     * Deletes a answer in the database based on the
     * values in a business object
     *
     * @param answer a answer to delete in the database
     * @return a boolean noting success (true) or failure (false)
     */
    public boolean deleteAnswer(Answer answer) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement("delete from answers where answer_id=?");
            stmt.setInt(1, answer.getAnswer_id());
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