package com.asu.ser516.team47.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * A Course Database Abstraction
 *
 * @author  Paul Horton
 * @version 1.0
 * @since   2/22/19
 */
public class CourseDAOImpl implements CourseDAO {
    // Hardcoded (will switch to loading through props in future)
    //    private static Properties __dbProperties;
    private static String __jdbcUrl = "jdbc:sqlite:schema.db";
    private static String __jdbcUser;
    private static String __jdbcPasswd;

    /**
     * Gets all the courses in the database
     *
     * @return all courses
     */
    public List<Course> getAllCourses() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Course> rval = new ArrayList<Course>();

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("select * from courses");
            rs = stmt.executeQuery();
            while (rs.next()) {
                rval.add(new Course(rs.getInt(1), rs.getString(2), rs.getString(3),
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
     * Gets all courses a professor teaches
     *
     * @param professor_fk the professor's username
     * @return all courses a professor teaches
     */
    public List<Course> getProfessorsCourses(String professor_fk) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Course> rval = new ArrayList<Course>();

        try {
            conn = DriverManager.getConnection(__jdbcUrl);
            stmt = conn.prepareStatement("select * from courses where professor_fk = ?");
            stmt.setString(1, professor_fk);
            rs = stmt.executeQuery();
            while (rs.next()) {
                rval.add(new Course(rs.getInt(1), rs.getString(2), rs.getString(3),
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
     * Gets a course based on it's id
     *
     * @param course_id a course id
     * @return the course business object
     */
    public Course getCourse(int course_id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Course rval = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("select * from courses where course_id = ?");
            stmt.setInt(1, course_id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                rval = new Course(rs.getInt(1), rs.getString(2), rs.getString(3),
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
     * Inserts a course in the database based on the
     * values in a business object
     *
     * @param course
     * @return a boolean representing a successful/failed insert
     */
    public boolean insertCourse(Course course) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("insert into courses (professor_fk, prefix, suffix)" +
                    " VALUES (?,?,?)");
            stmt.setString(1, course.getProfessor_fk());
            stmt.setString(2, course.getPrefix());
            stmt.setString(3, course.getSuffix());
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
     * Updates a course in the database based on the
     * values in a business object
     *
     * @param course
     * @return a boolean representing a successful/failed update
     */
    public boolean updateCourse(Course course) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("update courses set professor_fk=?, prefix=?, suffix=?," +
                    " where course_id=?");
            stmt.setString(1, course.getProfessor_fk());
            stmt.setString(2, course.getPrefix());
            stmt.setString(3, course.getSuffix());
            stmt.setInt(4,course.getCourse_id());
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
     * Deletes a course in the database based on the
     * values in a business object.
     *
     * @param course
     * @return a boolean representing a successful/failed deletion
     */
    public boolean deleteCourse(Course course) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement("delete from courses where course_id=?");
            stmt.setInt(1, course.getCourse_id());
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
