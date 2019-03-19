package model;

/**
 * Class StudentResponseVO is Java Model for Student Response
 * 
 * @author akashkadam
 * @version 1.2
 * @date 03/14/2019
 **/
public class GradeQuizVO {

	int score;
	String firstName;
	String lastName;
	String quizName;
	String courseName;

	public GradeQuizVO(int score, String firstName, String lastName, String quizName) {
		this.score = score;
		this.firstName = firstName;
		this.lastName = lastName;
		this.quizName = quizName;
	}

	public GradeQuizVO(int score, String quizName, String courseName) {
		this.score = score;
		this.quizName = quizName;
		this.courseName = courseName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getQuizName() {
		return quizName;
	}

	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
}
