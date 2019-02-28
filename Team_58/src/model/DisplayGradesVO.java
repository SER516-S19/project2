package model;
/**
 * Class displayGradeVO is Java Model for displaying student grades
 * @author Dhruv Patel
 * @version 1.0
 **/

public class DisplayGradesVO{
	int score;
	String courseName;
	String quizTitle;
	
	
	public DisplayGradesVO(int score, String courseName, String quizTitle) {
		super();
		this.score = score;
		this.courseName = courseName;
		this.quizTitle = quizTitle;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public String getquizTitle() {
		return quizTitle;
	}


	public void setquizTitle(String quizTitle) {
		this.quizTitle = quizTitle;
	}
}