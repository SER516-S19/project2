package model;

import java.util.List;

/*This class is created to display Questions to a student. It's a plain old java object file.
 * @author Jainish Soni
 * @date Created - 03/02/2019
 */

public class displayQuestionsVO {
	private int quizId;
	private int questionId;
	private String question;
	private List<String> correctAnswers;
	private List<String> incorrectAnswers;
	private int totalPoints;
	private boolean isMCQ;
	
	public int getQuizId() {
		return quizId;
	}
	
	public int getqId() {
		return questionId;
	}
	
	public String getQuestion() {
		return question;
	}


	public displayQuestionsVO(int quizId, String question, List<String> correctAnswers, List<String> incorrectAnswers, int totalPoints, boolean isMCQ) {
		super();
		this.quizId = quizId;
		this.question = question;
		this.correctAnswers = correctAnswers;
		this.incorrectAnswers = incorrectAnswers;
		this.totalPoints = totalPoints;
		this.isMCQ = isMCQ;
	}

	public displayQuestionsVO(int qId, int totalPoints, List<String> correctAnswers, List<String> incorrectAnswers, String question) {
		this.questionId = qId;
		this.question = question;
		this.correctAnswers = correctAnswers;
		this.incorrectAnswers = incorrectAnswers;
		this.totalPoints = totalPoints;
	}
	
	public int getTotalPoints() {
		return totalPoints;
	}
	
	public List<String> getCorrectAnswers() {
		return correctAnswers;
	}

	public List<String> getIncorrectAnswers() {
		return incorrectAnswers;
	}
	
	public boolean isMCQ() {
		return isMCQ;
	}

}