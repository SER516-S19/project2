package model;

/**
 * CourseVO is a model class for a Course
 *
 * @author NarenkumarKonchada
 * @version 1.1
 * @date 03/14/2019
 */
public class CourseVO {

	private String courseName;
	private String courseNumber;
	private int courseId;

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public CourseVO(String courseName, String courseNumber, int courseId) {
		super();
		this.courseName = courseName;
		this.courseNumber = courseNumber;
		this.courseId = courseId;
	}
}
