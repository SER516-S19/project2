package edu.asupoly.ser516.model;
/**
 * Class StudentResponseVO is Java Model for Student Response
 * @author akashkadam
 * @version 1.1
 **/
public class GradeQuizVO {
	
	int score;
	String firstName;
	String lastName;
	String quizName;
	
	
	public GradeQuizVO(int score, String firstName, String lastName, String quizName) {
		super();
		this.score = score;
		this.firstName = firstName;
		this.lastName = lastName;
		this.quizName = quizName;
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
	
	
	
	
}
