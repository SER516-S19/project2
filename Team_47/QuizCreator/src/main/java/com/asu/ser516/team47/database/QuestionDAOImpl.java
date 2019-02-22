package com.asu.ser516.team47.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * A Question Database Abstraction
 *
 * @author  Paul Horton
 * @version 1.0
 * @since  2/22/19
 */
public class QuestionDAOImpl implements QuestionDAO{
    private static String __jdbcUrl = "jdbc:sqlite:schema.db";

    /**
     * Gets all questions in the table
     *
     * @return all questions in the table
     */
    public List<Question> getAllQuestions() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Question> rval = new ArrayList<Question>();

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("select * from questions");
            rs = stmt.executeQuery();
            while (rs.next()) {
                rval.add(new Question(rs.getInt(1), rs.getInt(2), rs.getString(3),
                        rs.getFloat(4), rs.getString(5)));
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
     * Gets all questions for a quiz
     *
     * @param quiz_fk quiz_id
     * @return all questions for a quiz
     */
    public List<Question> getQuizQuestions(int quiz_fk) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Question> rval = new ArrayList<Question>();

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("select * from questions where quiz_fk = ?");
            stmt.setInt(1,quiz_fk);
            rs = stmt.executeQuery();
            while (rs.next()) {
                rval.add(new Question(rs.getInt(1), rs.getInt(2), rs.getString(3),
                        rs.getFloat(4), rs.getString(5)));
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
     * Gets a question based on it's question_id
     *
     * @param question_id the id of the question_id
     * @return a question with the question_id
     */
    public Question getQuestion(int question_id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Question rval = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("select * from questions where question_id = ?");
            stmt.setInt(1, question_id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                rval = new Question(rs.getInt(1), rs.getInt(2), rs.getString(3),
                        rs.getFloat(4), rs.getString(5));
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
     * Inserts a question in the database based on the
     * values in a business object
     *
     * @param question
     * @return a boolean representing a successful/failed insert
     */
    public boolean insertQuestion(Question question) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("insert into questions (quiz_fk, quesType, points, content)" +
                    "VALUES (?,?,?,?)");
            stmt.setInt(1, question.getQuiz_fk());
            stmt.setString(2, question.getQuesType());
            stmt.setFloat(3, question.getPoints());
            stmt.setString(4, question.getContent());
            int updatedRows = stmt.executeUpdate();
            if (updatedRows <= 0) {
                return false;
            }

            // Update question id to SQLite generated id
            stmt = conn.prepareStatement("SELECT last_insert_rowid()");
            rs = stmt.executeQuery();
            while (rs.next()) {
                question.setQuestion_id(rs.getInt(1));
            }
            return true;
        }
        catch (Exception se) {
            se.printStackTrace();
            return false;
        }
        finally {
            try {
                if (rs != null) { rs.close();}
                if (stmt != null) { stmt.close();}
                if (conn != null) { conn.close();}
            } catch (Exception e) { e.printStackTrace(); }
        }
    }

    /**
     * Updates a question in the database based on the
     * values in a business object
     *
     * @param question a question to update in the database
     * @return a boolean representing a successful/failed update
     */
    public boolean updateQuestion(Question question) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("update questions set quiz_fk=?, quesType=?, points=?, content=?" +
                    " where question_id=?");
            stmt.setInt(1, question.getQuiz_fk());
            stmt.setString(2, question.getQuesType());
            stmt.setFloat(3, question.getPoints());
            stmt.setString(4, question.getContent());
            stmt.setInt(5,question.getQuestion_id());
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
     * Deletes a question in the database based on the
     * values in a business object
     *
     * @param question a question to delete in the database
     * @return a boolean representing a successful/failed deletion
     */
    public boolean deleteQuestion(Question question) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement("delete from questions where question_id=?");
            stmt.setInt(1, question.getQuestion_id());
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
