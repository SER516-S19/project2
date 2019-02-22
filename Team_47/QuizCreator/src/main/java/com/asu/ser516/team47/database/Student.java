package com.asu.ser516.team47.database;

/**
 * A business object for a student in the students table.
 * Created by paulhorton on 2/22/19.
 */
public class Student {
    private String username;
    private String firstname;
    private String lastname;
    private String hashedpass;

    /**
     * Constructor for a student
     * @param username unique key for a student's account
     * @param firstname student's first name
     * @param lastname student's last name
     * @param hashedpass student's password (hashed)
     */
    public Student(String username, String firstname, String lastname, String hashedpass) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.hashedpass = hashedpass;
    }

    /**
     * Gets the student's username
     * @return student's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the student's username
     * @param username new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the student's first name
     * @return student's first name
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets the student's first name
     * @param firstname new first name
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Gets the student's last name
     * @return student's last name
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the student's last name
     * @param lastname new last name
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Gets the student's hashed password
     * @return hashed password
     */
    public String getHashedpass() {
        return hashedpass;
    }

    /**
     * Sets the student's hashed password
     * @param hashedpass new password
     */
    public void setHashedpass(String hashedpass) {
        this.hashedpass = hashedpass;
    }
}
