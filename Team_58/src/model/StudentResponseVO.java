package model;


/**
* StudentResponseVO is a model class for a Questions
*
* @author Sami
* @version 1.1
* @date 03/17/2019
* */

public class StudentResponseVO {
	
	int courseId;
	int quizId;
	int userId;
	int quiestionId;
	String answerSelected;
	int score;
	
	public StudentResponseVO(int userId, String answerSelected) {
		super();
		this.userId = userId;
		this.answerSelected = answerSelected;
	}
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getQuizId() {
		return quizId;
	}
	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getQuiestionId() {
		return quiestionId;
	}
	public void setQuiestionId(int quiestionId) {
		this.quiestionId = quiestionId;
	}
	public String getAnswerSelected() {
		return answerSelected;
	}
	public void setAnswerSelected(String answerSelected) {
		this.answerSelected = answerSelected;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}
