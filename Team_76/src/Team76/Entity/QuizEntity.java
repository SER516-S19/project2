package Team76.Entity;
import java.util.Date;
/**
 * SER516-Project2 
 * @author Janani Anand, janand3@asu.edu
 * @since 02/19/2019
 * version 2.0
 */

public class QuizEntity {
	
	private int quizId = 0;
	private String quizStatus = "";
	private Date dueDate = null;
	private int timeLimit = 0;
	private String quizType = "";
	private String quizTitle = null;
	private String quizInstruct= null;
	private String shuffleAns;
	private String clockType;
	
	private int professorId = 0;
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
	public String getQuizTitle() {
		return quizTitle;
	}
	public void setQuizTitle(String quizTitle) {
		this.quizTitle = quizTitle;
	}
	public String getQuizInstruct() {
		return quizInstruct;
	}
	public void setQuizInstruct(String quizInstruct) {
		this.quizInstruct = quizInstruct;
	}
	public String getShuffleAns() {
		return shuffleAns;
	}
	public void setShuffleAns(String shuffleAns) {
		this.shuffleAns = shuffleAns;
	}
	public String getClockType() {
		return clockType;
	}
	public void setClockType(String clockType) {
		this.clockType = clockType;
	}

}
