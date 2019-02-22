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
}
