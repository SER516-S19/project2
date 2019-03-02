package com.asu.ser516.team47.database;

/**
 * A business object for a course in the courses table
 *
 * @author  Paul Horton
 * @version 1.0
 * @since   2019-02-22
 */
public class Course {
    private int course_id;
    private String professor_fk;
    private String prefix;
    private String suffix;

    /**
     * @param course_id unique key for a course
     * @param professor_fk foreign key for a professor's username
     * @param prefix prefix for the course name
     * @param suffix suffix for the course name
     */
    public Course(int course_id, String professor_fk, String prefix, String suffix) {
        this.course_id = course_id;
        this.professor_fk = professor_fk;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getProfessor_fk() {
        return professor_fk;
    }

    public void setProfessor_fk(String professor_fk) {
        this.professor_fk = professor_fk;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    /**
     * toString
     * @return string representation of course object
     */
    public String toString() {
        String result = "Course {" + "\n" +
                "  course_id: " + Integer.toString(course_id) + "\n" +
                "  professor_fk: " + professor_fk + "\n" +
                "  prefix: " + prefix+ "\n" +
                "  suffix: " + suffix + "\n" +
                "}";
        return result;
    }
}
