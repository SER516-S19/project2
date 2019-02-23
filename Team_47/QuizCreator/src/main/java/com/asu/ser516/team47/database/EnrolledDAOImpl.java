package com.asu.ser516.team47.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * An Enrolled Database Abstraction
 *
 * @author paulhorton
 * @version 1.0
 * @since 2/22/19
 */
public class EnrolledDAOImpl implements EnrolledDAO{
    private static final String __jdbcUrl = "jdbc:sqlite:schema.db";

    /**
     * Gets all the enrollments in the database
     *
     * @return all enrollments
     */
    public List<Enrolled> getAllEnrollment() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Enrolled> rval = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("select * from enrolled");
            rs = stmt.executeQuery();
            while (rs.next()) {
                rval.add(new Enrolled(rs.getInt(1), rs.getInt(2), rs.getString(3)));
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
     * Gets all enrollments for a course
     *
     * @param course_fk the course's id
     * @return all enrollments in a course
     */
    public List<Enrolled> getCourseEnrollment(int course_fk) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Enrolled> rval = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("select * from enrolled where course_fk = ?");
            stmt.setInt(1,course_fk);
            rs = stmt.executeQuery();
            while (rs.next()) {
                rval.add(new Enrolled(rs.getInt(1), rs.getInt(2), rs.getString(3)));
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
     * Gets all enrollments for a student
     *
     * @param student_fk the student's username
     * @return all enrollments in a student
     */
    public List<Enrolled> getStudentEnrollment(String student_fk) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Enrolled> rval = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("select * from enrolled where student_fk = ?");
            stmt.setString(1,student_fk);
            rs = stmt.executeQuery();
            while (rs.next()) {
                rval.add(new Enrolled(rs.getInt(1), rs.getInt(2), rs.getString(3)));
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
     * Gets a enrollment based on id
     *
     * @param enrolled_id a Enrolled id
     * @return the Enrolled business object
     */
    public Enrolled getEnrolled(int enrolled_id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Enrolled rval = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("select * from enrolled where enrolled_id = ?");
            stmt.setInt(1,enrolled_id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                rval = new Enrolled(rs.getInt(1), rs.getInt(2), rs.getString(3));
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
         * Inserts a Enrolled in the database based on the
         * values in a business object
         *
         * @param enrolled enrollment to insert
         * @return a boolean representing a successful/failed insert
         */
    public boolean insertEnrolled(Enrolled enrolled) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("insert into enrolled (course_fk, student_fk) VALUES (?,?)");
            stmt.setInt(1, enrolled.getCourse_fk());
            stmt.setString(2, enrolled.getStudent_fk());
            int updatedRows = stmt.executeUpdate();
            if (updatedRows <= 0) {
                return false;
            }

            // Return SQLite generated id of inserted value
            stmt = conn.prepareStatement("SELECT last_insert_rowid()");
            rs = stmt.executeQuery();
            while (rs.next()) {
                enrolled.setEnrolled_id(rs.getInt(1));
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
     * Updates a Enrolled in the database based on the
     * values in a business object
     *
     * @param enrolled enrollment to update
     * @return a boolean representing a successful/failed update
     */
    public boolean updateEnrolled(Enrolled enrolled) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("update enrolled set course_fk=?, student_fk=? where enrolled_id = ?");
            stmt.setInt(1, enrolled.getCourse_fk());
            stmt.setString(2, enrolled.getStudent_fk());
            stmt.setInt(3, enrolled.getEnrolled_id());
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
     * Deletes a Enrolled in the database based on the
     * values in a business object.
     *
     * @param enrolled enrollment to delete
     * @return a boolean representing a successful/failed deletion
     */
    public boolean deleteEnrolled(Enrolled enrolled) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement("delete from enrolled where enrolled_id=?");
            stmt.setInt(1, enrolled.getEnrolled_id());
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
