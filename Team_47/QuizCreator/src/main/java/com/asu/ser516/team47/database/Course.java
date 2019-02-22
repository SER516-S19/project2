package com.asu.ser516.team47.database;

/**
 * A business object for a course in the courses table
 * Created by paulhorton on 2/22/19.
 */
public class Course {
    private int course_id;
    private String professor_fk;
    private String prefix;
    private String suffix;

    /**
     * A constructor for a course
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

    /**
     * Gets the course_id
     * @return course_id
     */
    public int getCourse_id() {
        return course_id;
    }

    /**
     * Sets the course_id
     * @param course_id new course_id
     */
    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    /**
     * Gets the professor's username
     * @return professor's username
     */
    public String getProfessor_fk() {
        return professor_fk;
    }

    /**
     * Sets the professor's username
     * @param professor_fk new professor's username
     */
    public void setProfessor_fk(String professor_fk) {
        this.professor_fk = professor_fk;
    }

    /**
     * Gets the prefix for the class
     * @return class prefix
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * Sets the prefix for the class
     * @param prefix new prefix
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * Gets the suffix for the class
     * @return class suffix
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * Sets the suffix for the class
     * @param suffix new suffix
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
