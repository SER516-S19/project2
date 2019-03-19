package org.team47.database;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

/**
 * An Quiz Database Abstraction
 *
 * @author  Trevor Forrey
 * @version 1.0
 * @since   2/22/19
 */
public class QuizDAOImpl implements QuizDAO {
    private static final String __jdbcUrl = "jdbc:sqlite:schema.db";

    /**
     * Gets all quizzes in the table
     * @return all quizzes in the table
     */
    public List<Quiz> getAllQuizzes() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Quiz> rval = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("select * from quizzes");
            rs = stmt.executeQuery();
            while (rs.next()) {
                rval.add(new Quiz(rs.getInt(1), rs.getInt(2), rs.getString(3),
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
            DbUtils.closeConnections(rs, stmt, conn);
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
        List<Quiz> rval = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(__jdbcUrl);
            stmt = conn.prepareStatement("select * from quizzes where course_fk = ?");
            stmt.setInt(1, course_fk);
            rs = stmt.executeQuery();
            while (rs.next()) {
                rval.add(new Quiz(rs.getInt(1), rs.getInt(2), rs.getString(3),
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
            DbUtils.closeConnections(rs, stmt, conn);
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

            stmt = conn.prepareStatement("select * from quizzes where quiz_id = ?");
            stmt.setInt(1, quiz_id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                rval = new Quiz(rs.getInt(1), rs.getInt(2), rs.getString(3),
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
            DbUtils.closeConnections(rs, stmt, conn);
        }

        return rval;
    }

    /**
     * Inserts a quiz in the database based on the
     * values in a business object
     * @param quiz quiz to insert
     * @return a boolean representing a successful/failed insert
     */
    public boolean insertQuiz(Quiz quiz) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("insert into quizzes (course_fk, title, instructions, shuffle," +
                    " time_limit, date_open, date_close, quiz_type, attempts," +
                    " quiz_group, total_points) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1, quiz.getCourse_fk());
            stmt.setString(2, quiz.getTitle());
            stmt.setString(3, quiz.getInstructions());
            stmt.setBoolean(4, quiz.isShuffle());
            stmt.setInt(5, quiz.getTime_limit());
            stmt.setDate(6, new java.sql.Date(quiz.getDate_open().getTime()));
            stmt.setDate(7, new java.sql.Date(quiz.getDate_close().getTime()));
            stmt.setString(8, quiz.getQuiz_type());
            stmt.setInt(9, quiz.getAttempts());
            stmt.setString(10, quiz.getQuiz_group());
            stmt.setDouble(11, quiz.getTotal_points());
            int updatedRows = stmt.executeUpdate();
            if (updatedRows <= 0) {
                return false;
            }

            // Update quiz id to SQLite generated id
            stmt = conn.prepareStatement("SELECT last_insert_rowid()");
            rs = stmt.executeQuery();
            while (rs.next()) {
                quiz.setQuiz_id(rs.getInt(1));
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
     * Updates a quiz in the database based on the
     * values in a business object
     * @param quiz a quiz to update in the database
     * @return a boolean representing a successful/failed update
     */
    public boolean updateQuiz(Quiz quiz) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("update quizzes set course_fk=?, title=?, instructions=?," +
                    "shuffle=?, time_limit=?, date_open=?, date_close=?, quiz_type=?, attempts=?," +
                    " quiz_group=?, total_points=? where quiz_id=?");
            stmt.setInt(1, quiz.getCourse_fk());
            stmt.setString(2, quiz.getTitle());
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
     * Deletes a quiz in the database based on the
     * values in a business object
     * @param quiz a quiz to delete in the database
     * @return a boolean representing a successful/failed deletion
     */
    public boolean deleteQuiz(Quiz quiz) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement("delete from quizzes where quiz_id=?");
            stmt.setInt(1, quiz.getQuiz_id());
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
