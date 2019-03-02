package com.asu.ser516.team47.database;

/**
 * A business object for a student in the students table.
 *
 * @author  Paul Horton
 * @version 1.0
 * @since   2019-02-22
 */
public class Student {
    private String username;
    private String firstname;
    private String lastname;
    private String hashedpass;
<<<<<<< HEAD
=======
    private String session;
>>>>>>> f3ae326

    /**
     * @param username unique key for a student's account
     * @param firstname student's first name
     * @param lastname student's last name
     * @param hashedpass student's password (hashed)
<<<<<<< HEAD
     */
    public Student(String username, String firstname, String lastname, String hashedpass) {
=======
     * @param session student's session information
     */
    public Student(String username, String firstname, String lastname, String hashedpass, String session) {
>>>>>>> f3ae326
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.hashedpass = hashedpass;
<<<<<<< HEAD
=======
        this.session = session;
>>>>>>> f3ae326
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getHashedpass() {
        return hashedpass;
    }

    public void setHashedpass(String hashedpass) {
        this.hashedpass = hashedpass;
    }
<<<<<<< HEAD
=======

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
>>>>>>> f3ae326
}
