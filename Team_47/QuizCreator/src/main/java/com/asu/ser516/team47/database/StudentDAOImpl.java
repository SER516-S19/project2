package com.asu.ser516.team47.database;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

/**
 * A Student Table Abstraction
 *
 * @author  Trevor Forrey
 * @version 1.0
 * @since   2/22/19
 */
public class StudentDAOImpl implements StudentDAO {
    private static final String __jdbcUrl = "jdbc:sqlite:schema.db";

    /**
     * Gets all students in the table
     * @return all students in the table
     */
    public List<Student> getAllStudents() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Student> rval = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("select * from students");
            rs = stmt.executeQuery();
            while (rs.next()) {
                rval.add(new Student(rs.getString(1),
                        rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5)));
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
            stmt = conn.prepareStatement("select * from students where username = ?");
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            while (rs.next()) {
                rval = new Student(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getString(5));
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
     * @param student student to insert
     * @return a boolean representing a successful/failed insert
     */
    public boolean insertStudent(Student student) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("insert into students (username, firstname, " +
                    "lastname, hashedpass, sessionid) VALUES (?,?,?,?,?)");
            stmt.setString(1, student.getUsername());
            stmt.setString(2, student.getFirstname());
            stmt.setString(3, student.getLastname());
            stmt.setString(4, student.getHashedpass());
            stmt.setString(5, student.getSession());
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
     * Updates a student in the database based on the
     * values in a business object
     * @param student a student to update in the database
     * @return a boolean representing a successful/failed update
     */
    public boolean updateStudent(Student student) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);

            stmt = conn.prepareStatement("update students set firstname=?, lastname=?, " +
                    "sessionid=? where username=?");
            stmt.setString(1, student.getFirstname());
            stmt.setString(2, student.getLastname());
            stmt.setString(3, student.getSession());
            stmt.setString(4, student.getUsername());
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
     * Deletes a student in the database based on the
     * values in a business object.
     * @param student student to delete
     * @return a boolean representing a successful/failed deletion
     */
    public boolean deleteStudent(Student student) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(__jdbcUrl);
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement("delete from students where id=?");
            stmt.setString(1, student.getUsername());
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
