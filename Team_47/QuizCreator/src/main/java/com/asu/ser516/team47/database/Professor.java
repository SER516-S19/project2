package com.asu.ser516.team47.database;

/**
 * A business object for a professor in the professors table.
 *
 * @author  Paul Horton
 * @version 1.0
 * @since   2019-02-22
 */
public class Professor {
    private String username;
    private String firstname;
    private String lastname;
    private String sessionid;
    private String hashedpass;

    /**
     * @param username unique key for a professor's account
     * @param firstname professor's first name
     * @param lastname professor's last name
     * @param sessionid professor's session information
     * @param hashedpass professor's password (hashed)
     */
    public Professor(String username, String firstname, String lastname, String sessionid, String hashedpass) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.sessionid = sessionid;
        this.hashedpass = hashedpass;
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
     * @return string representation of professor object
     */
    public String toString() {
        String result = "Professor {" + "\n" +
                "  username: " + username + "\n" +
                "  firstname: " + firstname + "\n" +
                "  lastname: " + lastname + "\n" +
                "  hashedpass: " + hashedpass + "\n" +
                "  sessionid: " + sessionid + "\n" +
                "}";
        return result;
    }
}
