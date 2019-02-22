package model;

public class Student {
    private String first_name;
    private String last_name;
    private String email_id;
    private int student_id;

    public Student(int student_id, String first_name, String last_name, String email_id)
    {
    	this.student_id = student_id;
    	this.first_name  = first_name;
    	this.last_name  = last_name;
    	this.email_id = email_id;
    }

    public String getfirstname() {
        return first_name;
    }
    public void setfirstname(String first_name) {
        this.first_name = first_name;
    }
    public String getlastname() {
        return last_name;
    }
    public void setlastname(String last_name) {
        this.last_name = last_name;
    }
    public void setphone(String email_id) {
        this.email_id = email_id;
    }
    public String getphone() {
        return email_id;
    }
    
    public void setstudentid(int student_id) {
        this.student_id = student_id;
    }
    public int getstudentid() {
        return student_id;
    }

}