package model;

import java.util.Date;

/**
 *QuizVO is a model class for a Quiz
 *
 * @author NarenkumarKonchada
 * @author Aditya Samant
 * @version 1.0
 * @date 02/22/2019
 */
public class QuizVO {
	

	private int courseId;
	private int quizId;
	private boolean isGraded;
	private int assignedTime;
	private String quizInstruction;
	private Date quizScheduledDate;
	private boolean isShuffled;
	private String quizTitle;

	public int getQuizId() {
		return quizId;
	}
	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}
	public int getAssignedTime() {
		return assignedTime;
	}
	public void setAssignedTime(int assignedTime) {
		this.assignedTime = assignedTime;
	}
	public String getQuizInstruction() {
		return quizInstruction;
	}
	public void setQuizInstruction(String quizInstruction) {
		this.quizInstruction = quizInstruction;
	}
	public String getQuizTitle() {
		return quizTitle;
	}
	public void setQuizTitle(String quizTitle) {
		this.quizTitle = quizTitle;
	}
	public boolean isGraded() {
		return isGraded;
	}
	public void setGraded(boolean isGraded) {
		this.isGraded = isGraded;
	}
	public boolean isShuffled() {
		return isShuffled;
	}
	public void setShuffled(boolean isShuffled) {
		this.isShuffled = isShuffled;
	}
	public Date getQuizScheduledDate() {
		return quizScheduledDate;
	}
	public void setQuizScheduledDate(Date quizScheduledDate) {
		this.quizScheduledDate = quizScheduledDate;
	}
	public QuizVO(int courseId, int quizId, boolean isGraded, int assignedTime, String quizInstruction,
			Date quizScheduledDate, boolean isShuffled, String quizTitle) {
		
		super();
		this.courseId = courseId;
		this.quizId = quizId;
		this.isGraded = isGraded;
		this.assignedTime = assignedTime;
		this.quizInstruction = quizInstruction;
		this.quizScheduledDate = quizScheduledDate;
		this.isShuffled = isShuffled;
		this.quizTitle = quizTitle;
	}
	
	/**
	 * The following constructor is created to use quiz information in viewQuiz page
	 * 
	 * @param name quiz name
	 * @param instructions 
	 * @param date 
	 * @param graded 
	 * */
	public QuizVO(String name, String instructions, Date date, boolean graded) {
		
		quizTitle = name;
		quizInstruction = instructions;
		quizScheduledDate = date;
		isGraded = graded;
	}
	public QuizVO(int quizId2, String quizTitle2) {
		
		// TODO Auto-generated constructor stub
		quizTitle = quizTitle2;
		quizId = quizId2;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
}
