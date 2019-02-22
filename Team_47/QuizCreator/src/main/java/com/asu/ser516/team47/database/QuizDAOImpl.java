package com.asu.ser516.team47.database;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.ArrayList;

import java.util.List;
import java.util.Properties;

/**
 * An Submission Database Abstraction
 *
 * @author  Trevor Forrey
 * @version 1.0
 * @since   2/22/19
 */
public class QuizDAOImpl implements QuizDAO {
    // Hardcoded (will switch to loading through props in future)
    //    private static Properties __dbProperties;
    private static String __jdbcUrl = "jdbc:sqlite:src/main/java/com/asu/ser516/team47/main/schema.db";
    private static String __jdbcUser;
    private static String __jdbcPasswd;

    /**
     * Gets all quizzes in the table
     * @return all quizzes in the table
     */
    public List<Quiz> getAllQuizzes() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Quiz> rval = new ArrayList<Quiz>();

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("select * from quizzes");
            rs = stmt.executeQuery();
            while (rs.next()) {
                rval.add(new Quiz(rs.getInt(1), rs.getString(2), rs.getInt(3),
                        rs.getString(4), rs.getBoolean(5), rs.getInt(6),
                        rs.getDate(7), rs.getDate(8), rs.getString(9),
                        rs.getInt(10), rs.getString(11), rs.getDouble(12)));
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
     * Gets all quizzes for a course
     * @param course_fk course_id
     * @return all quizzes for a course
     */
    public List<Quiz> getCourseQuizzes(int course_fk) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Quiz> rval = new ArrayList<Quiz>();

        try {
            conn = DriverManager.getConnection(__jdbcUrl);
            stmt = conn.prepareStatement("select * where course_fk = ?");
            stmt.setInt(1, course_fk);
            rs = stmt.executeQuery();
            while (rs.next()) {
                rval.add(new Quiz(rs.getInt(1), rs.getString(2), rs.getInt(3),
                        rs.getString(4), rs.getBoolean(5), rs.getInt(6),
                        rs.getDate(7), rs.getDate(8), rs.getString(9),
                        rs.getInt(10), rs.getString(11), rs.getDouble(12)));
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
     * Gets a quiz based on it's quiz_id
     * @param quiz_id the id of the quiz
     * @return a quiz with the quiz_id
     */
    public Quiz getQuiz(int quiz_id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Quiz rval = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("select * where id = ?");
            stmt.setInt(1, quiz_id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                rval = new Quiz(rs.getInt(1), rs.getString(2), rs.getInt(3),
                        rs.getString(4), rs.getBoolean(5), rs.getInt(6),
                        rs.getDate(7), rs.getDate(8), rs.getString(9),
                        rs.getInt(10), rs.getString(11), rs.getDouble(12));
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
     * Inserts a quiz in the database based on the
     * values in a business object
     * @param quiz
     * @return a boolean representing a successful/failed insert
     */
    public boolean insertQuiz(Quiz quiz) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("insert into quizzes (id, title, course_fk, instructions, shuffle," +
                    " timeLimit, dateOpen, dateClose, quizType, attempts," +
                    " quizGroup, totalPoints) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1, quiz.getQuiz_id());
            stmt.setString(2, quiz.getTitle());
            stmt.setInt(3, quiz.getCourse_fk());
            stmt.setString(4, quiz.getInstructions());
            stmt.setBoolean(5, quiz.isShuffle());
            stmt.setInt(6, quiz.getTime_limit());
            stmt.setDate(7, new java.sql.Date(quiz.getDate_open().getTime()));
            stmt.setDate(8, new java.sql.Date(quiz.getDate_close().getTime()));
            stmt.setString(9, quiz.getQuiz_type());
            stmt.setInt(10, quiz.getAttempts());
            stmt.setString(11, quiz.getQuiz_group());
            stmt.setDouble(12, quiz.getTotal_points());
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
                if (rs != null) { rs.close();}
                if (stmt != null) { stmt.close();}
                if (conn != null) { conn.close();}
            } catch (Exception e) { e.printStackTrace(); }
        }
    }

    /**
     * Updates a quiz in the database based on the
     * values in a business object
     * @param quiz a quiz to update in the database
     * @return a boolean representing a successful/failed update
     */
    public boolean updateQuiz(Quiz quiz) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("update quizzes set title=?, course_fk=?, instructions=?," +
                    "shuffle=?, timeLimit=?, dateOpen=?, dateClose=?, quizType=?, attempts=?," +
                    " quizGroup=?, totalPoints=? where id=?");
            stmt.setString(1, quiz.getTitle());
            stmt.setInt(2, quiz.getCourse_fk());
            stmt.setString(3, quiz.getInstructions());
            stmt.setBoolean(4, quiz.isShuffle());
            stmt.setInt(5, quiz.getTime_limit());
            stmt.setDate(6, new java.sql.Date(quiz.getDate_open().getTime()));
            stmt.setDate(7, new java.sql.Date(quiz.getDate_close().getTime()));
            stmt.setString(8, quiz.getQuiz_type());
            stmt.setInt(9, quiz.getAttempts());
            stmt.setString(10, quiz.getQuiz_group());
            stmt.setDouble(11, quiz.getTotal_points());
            stmt.setInt(12, quiz.getQuiz_id());
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
                if (rs != null) { rs.close();}
                if (stmt != null) { stmt.close();}
                if (conn != null) { conn.close();}
            } catch (Exception e) { e.printStackTrace(); }
        }
    }

    /**
     * Deletes a quiz in the database based on the
     * values in a business object
     * @param quiz a quiz to delete in the database
     * @return a boolean representing a successful/failed deletion
     */
    public boolean deleteQuiz(Quiz quiz) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement("delete from quizzes where id=?");
            stmt.setInt(1, quiz.getQuiz_id());
            stmt.executeUpdate();
            // TODO (DELETE BEFORE SUBMISSION) May need to manually delete foreign keys in Questions
            conn.commit();
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

    static {
        try {
//            __dbProperties = new Properties();
//            __dbProperties.load(SubmissionDAOImpl.class.getClassLoader().getResourceAsStream("database.properties"));
//            __jdbcUrl    = __dbProperties.getProperty("jdbcUrl");
//            __jdbcUser   = __dbProperties.getProperty("jdbcUser");
//            __jdbcPasswd = __dbProperties.getProperty("jdbcPasswd");
//            __jdbcDriver = __dbProperties.getProperty("jdbcDriver");
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
