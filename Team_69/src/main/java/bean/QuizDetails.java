package bean;

import java.util.List;

/**
 * 
 * This class represents a Quiz and its associated questions.
 * 
 * @author: leharbhatt
 * @version: 1.0
 * @since: 02/20/2019
 */

public class QuizDetails {
	private int quizId;
	private String quizName;
	private String quizInstructions;
	private String quizType;
	private String quizTimeLimit;
	private boolean isShuffled;
	private boolean isPublished;

	private List<QuestionDetails> question;

	public String getQuizName() {
		return quizName;
	}

	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}

	public String getQuizInstructions() {
		return quizInstructions;
	}

	public void setQuizInstructions(String quizInstructions) {
		this.quizInstructions = quizInstructions;
	}

	public String getQuizType() {
		return quizType;
	}

	public void setQuizType(String quizType) {
		this.quizType = quizType;
	}

	public String getQuizTimeLimit() {
		return quizTimeLimit;
	}

	public void setQuizTimeLimit(String quizTimeLimit) {
		this.quizTimeLimit = quizTimeLimit;
	}

	public boolean isShuffled() {
		return isShuffled;
	}

	public void setShuffled(boolean isShuffled) {
		this.isShuffled = isShuffled;
	}

	public boolean isPublished() {
		return isPublished;
	}

	public void setPublished(boolean isPublished) {
		this.isPublished = isPublished;
	}

	public List<QuestionDetails> getQuestion() {
		return question;
	}

	public void setQuestion(List<QuestionDetails> question) {
		this.question = question;
	}

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

}
