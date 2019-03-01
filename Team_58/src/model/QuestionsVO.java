package model;

import java.util.List;

/**
 * QuestionVO is the plain old java file for CreateQuestions and ViewQiz pages
 * 
 * @version 1.1
 * @author trupti khatavkar / @author aditya samant
 * @date 02/22/2019
 */

public class QuestionsVO {

	private int quizId;
	private int questionId;
	private String question;
	private List<String> correctAnswers;
	private List<String> incorrectAnswers;
	private int totalPoints;
	private boolean isMCQ;

	/**
	 * Constructor for setting values while creating questions
	 * 
	 * @date 02/22/2019
	 */
	public QuestionsVO(int quizId, String question, List<String> correctAnswers, List<String> incorrectAnswers, int totalPoints, boolean isMCQ) {
		super();
		this.quizId = quizId;
		this.question = question;
		this.correctAnswers = correctAnswers;
		this.incorrectAnswers = incorrectAnswers;
		this.totalPoints = totalPoints;
		this.isMCQ = isMCQ;
	}

	/**
	 * Constructor for retrieving values while displaying questions
	 * 
	 * @date 02/22/2019
	 */
	public QuestionsVO(int qId, int totalPoints, List<String> correctAnswers, List<String> incorrectAnswers, String question) {
		this.questionId = qId;
		this.question = question;
		this.correctAnswers = correctAnswers;
		this.incorrectAnswers = incorrectAnswers;
		this.totalPoints = totalPoints;
	}

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public int getqId() {
		return questionId;
	}

	public void setqId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<String> getCorrectAnswers() {
		return correctAnswers;
	}

	public void setCorrectAnswers(List<String> correctAnswers) {
		this.correctAnswers = correctAnswers;
	}

	public List<String> getIncorrectAnswers() {
		return incorrectAnswers;
	}

	public void setIncorrectAnswers(List<String> incorrectAnswers) {
		this.incorrectAnswers = incorrectAnswers;
	}

	public int getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}

	public boolean isMCQ() {
		return isMCQ;
	}

	public void setMCQ(boolean isMCQ) {
		this.isMCQ = isMCQ;
	}
}
