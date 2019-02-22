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
 * A Student Table Abstraction
 *
 * @author  Trevor Forrey
 * @version 1.0
 * @since   2/22/19
 */
public class StudentDAOImpl implements StudentDAO {
    // Hardcoded (will switch to loading through props in future)
    //    private static Properties __dbProperties;
    private static String __jdbcUrl = "jdbc:sqlite:src/main/java/com/asu/ser516/team47/main/schema.db";
    private static String __jdbcUser;
    private static String __jdbcPasswd;

    /**
     * Gets all students in the table
     * @return all students in the table
     */
    public List<Student> getAllStudents() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Student> rval = new ArrayList<Student>();

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("select * from students");
            rs = stmt.executeQuery();
            while (rs.next()) {
                rval.add(new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
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
     * Gets a student based on it's username
     * @param username the id of the student
     * @return a student with the username
     */
    public Student getStudent(String username) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Student rval = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);
            stmt = conn.prepareStatement("select * where username = ?");
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            while (rs.next()) {
                rval = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
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
     * Inserts a student in the database based on the
     * values in a business object
     * @param student
     * @return a boolean representing a successful/failed insert
     */
    public boolean insertStudent(Student student) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("insert into students (username, firstname, lastname, hashedpass) VALUES (?,?,?,?)");
            stmt.setString(1, student.getUsername());
            stmt.setString(2, student.getFirstname());
            stmt.setString(3, student.getLastname());
            stmt.setString(4, student.getHashedpass());
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
     * Updates a student in the database based on the
     * values in a business object
     * @param student a student to update in the database
     * @return a boolean representing a successful/failed update
     */
    public boolean updateStudent(Student student) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("update students set firstname=? lastname=? where username=?");
            stmt.setString(1, student.getFirstname());
            stmt.setString(2, student.getLastname());
            stmt.setString(3, student.getUsername());
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
     * Deletes a student in the database based on the
     * values in a business object.
     * @param student
     * @return a boolean representing a successful/failed deletion
     */
    public boolean deleteStudent(Student student) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement("delete from students where id=?");
            stmt.setString(1, student.getUsername());
            stmt.executeUpdate();
            // TODO (DELETE BEFORE SUBMISSION) May need to manually delete foreign keys in enrolled
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
