package Model;

import java.util.Date;

/**
 * Quiz object 
 * author: Hongfei Ju 
 * version: 1.0
 */
public class Quiz {
	private int professorId = 0;
	private int quizId = 0;
	private String quizStatus = "";
	private Date dueDate = null;
	private int timeLimit = 0;
	private String quizType = "";
	private String quizTitle = null;

	public String getQuizTitle() {
		return quizTitle;
	}

	public void setQuizTitle(String quizTitle) {
		this.quizTitle = quizTitle;
	}

	public int getProfessorId() {
		return professorId;
	}

	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public String getQuizStatus() {
		return quizStatus;
	}

	public void setQuizStatus(String quizStatus) {
		this.quizStatus = quizStatus;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public int getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}

	public String getQuizType() {
		return quizType;
	}

	public void setQuizType(String quizType) {
		this.quizType = quizType;
	}

}
