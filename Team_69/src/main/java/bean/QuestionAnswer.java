package bean;

import java.sql.Time;
import java.util.List;

/**
 * 
 * This class represents a Questions and its answers.
 * 
 * @author: leharbhatt
 * @version: 1.0
 * @since: 02/20/2019
 */

public class QuestionAnswer {
	private int quizId;
	private String quizName;
    private String quizInstructions;
    private String quizType;
	private Time quizTimeLimit;
    private boolean isShuffled;
    private boolean isPublished;
    
    private List<QuestionMapper> question;
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

	public Time getQuizTimeLimit() {
		return quizTimeLimit;
	}

	public void setQuizTimeLimit(Time quizTimeLimit) {
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

	public List<QuestionMapper> getQuestion() {
		return question;
	}

	public void setQuestion(List<QuestionMapper> question) {
		this.question = question;
	}

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

}
