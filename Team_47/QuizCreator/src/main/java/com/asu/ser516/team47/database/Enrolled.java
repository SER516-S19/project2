package com.asu.ser516.team47.database;

/**
 * A business object for a enrollment in the enrolled table.
 * Created by paulhorton on 2/22/19.
 */
public class Enrolled {
    private int enrolled_id;
    private int course_fk;
    private String student_fk;

    /**
     * @param enrolled_id unique key for enrollment ID
     * @param course_fk foreign key for enrolled course
     * @param student_fk foreign key for enrolled student
     */
    public Enrolled(int enrolled_id, int course_fk, String student_fk) {
        this.enrolled_id = enrolled_id;
        this.course_fk = course_fk;
        this.student_fk = student_fk;
    }

    public int getEnrolled_id() {
        return enrolled_id;
    }

    public void setEnrolled_id(int enrolled_id) {
        this.enrolled_id = enrolled_id;
    }

    public int getCourse_fk() {
        return course_fk;
    }

    public void setCourse_fk(int course_fk) {
        this.course_fk = course_fk;
    }

    public String getStudent_fk() {
        return student_fk;
    }

    public void setStudent_fk(String student_fk) {
        this.student_fk = student_fk;
    }
}
