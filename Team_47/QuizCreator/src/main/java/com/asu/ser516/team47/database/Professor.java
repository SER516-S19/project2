package com.asu.ser516.team47.database;

/**
 * A business object for a professor in the professors table.
 * Created by paulhorton on 2/22/19.
 */
public class Professor {
    private String username;
    private String firstname;
    private String lastname;
    private String hashedpass;

    /**
     * Constructor for a professor
     * @param username unique key for a professor's account
     * @param firstname professor's first name
     * @param lastname professor's last name
     * @param hashedpass professor's password (hashed)
     */
    public Professor(String username, String firstname, String lastname, String hashedpass) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.hashedpass = hashedpass;
    }

    /**
     * Gets the professor's username
     * @return professor's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the professor's username
     * @param username new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the professor's first name
     * @return professor's first name
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets the professor's first name
     * @param firstname new first name
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Gets the professor's last name
     * @return professor's last name
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the professor's last name
     * @param lastname new last name
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Gets the professor's hashed password
     * @return hashed password
     */
    public String getHashedpass() {
        return hashedpass;
    }

    /**
     * Sets the professor's hashed password
     * @param hashedpass new password
     */
    public void setHashedpass(String hashedpass) {
        this.hashedpass = hashedpass;
    }
}
