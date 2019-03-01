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
    private String sessionid;

    /**
     * @param username unique key for a student's account
     * @param firstname student's first name
     * @param lastname student's last name
     * @param hashedpass student's password (hashed)
     * @param session student's session information
     */
    public Student(String username, String firstname, String lastname, String hashedpass, String session) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.hashedpass = hashedpass;
        this.sessionid = session;
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

    public String getSession() {
        return sessionid;
    }

    public void setSession(String session) {
        this.sessionid = session;
    }

    /**
     * toString
     * @return string representation of student object
     */
    public String toString() {
        String result = "Student {" + "\n" +
                "  username: " + username + "\n" +
                "  firstname: " + firstname + "\n" +
                "  lastname: " + lastname + "\n" +
                "  hashedpass: " + hashedpass + "\n" +
                "  sessionid: " + sessionid + "\n" +
                "}";
        return result;
    }
}
