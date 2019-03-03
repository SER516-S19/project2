package model;

/**
 * CreateQuizVO is the plain old java class for CreateQuiz.
 * 
 * @version 1.1
 * @author Carnic
 * @date 02/21/2019
 */

public class CreateQuizVO {
	private int courseId;
	private String quizTitle;
	private String quizInstructions;
	private String quizScheduledDate;
	private int quizId;
	private boolean isShuffled;
	private int assignedTime;
	private boolean isGraded;

	public CreateQuizVO(int courseId, String quizTitle, String quizInstructions, String quizScheduledDate, int quizId,
			boolean isShuffled, int assignedTime, boolean isGraded) {
		super();
		this.courseId = courseId;
		this.quizTitle = quizTitle;
		this.quizInstructions = quizInstructions;
		this.quizScheduledDate = quizScheduledDate;
		this.quizId = quizId;
		this.isShuffled = isShuffled;
		this.assignedTime = assignedTime;
		this.isGraded = isGraded;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getQuizTitle() {
		return quizTitle;
	}

	public void setQuizTitle(String quizTitle) {
		this.quizTitle = quizTitle;
	}

	public String getQuizInstructions() {
		return quizInstructions;
	}

	public void setQuizInstructions(String quizInstructions) {
		this.quizInstructions = quizInstructions;
	}

	public String getQuizScheduledDate() {
		return quizScheduledDate;
	}

	public void setQuizScheduledDate(String quizScheduledDate) {
		this.quizScheduledDate = quizScheduledDate;
	}

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public boolean getIsShuffled() {
		return isShuffled;
	}

	public void setIsShuffled(boolean isShuffled) {
		this.isShuffled = isShuffled;
	}

	public int getAssignedTime() {
		return assignedTime;
	}

	public void setAssignedTime(int assignedTime) {
		this.assignedTime = assignedTime;
	}

	public boolean getIsGraded() {
		return isGraded;
	}

	public void setIsGraded(boolean isGraded) {
		this.isGraded = isGraded;
	}

}