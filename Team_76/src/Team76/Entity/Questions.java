package Team76.Entity;

/**
 * @author Naga Sai Krishna
 *
 */
public class Questions {

	String quizId, questionId, questions, options, correctAnswer;

	

	
	public Questions(String quizId, String questionId, String questions, String options, String correctAnswer) {
		this.quizId = quizId;
		this.questionId = questionId;
		this.questions = questions;
		this.options = options;
		this.correctAnswer = correctAnswer;
	}


	public String getQuizId() {
		return quizId;
	}

	public void setQuizId(String quizId) {
		this.quizId = quizId;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	
}