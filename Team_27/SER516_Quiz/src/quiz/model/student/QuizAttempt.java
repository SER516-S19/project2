package quiz.model.student;
/**
 * 
 * @author Sumanth
 * @version (1.0)
 */

public class QuizAttempt {
	
	private Integer quizId;
	private Integer studentId;
	private Integer questionId;
	private String response;
	
	public QuizAttempt(Integer quizId, Integer studentId, Integer questionId, String response) {
		super();
		this.quizId = quizId;
		this.studentId = studentId;
		this.questionId = questionId;
		this.response = response;
	}
	
	public Integer getQuizId() {
		return quizId;
	}
	public void setQuizId(Integer quizId) {
		this.quizId = quizId;
	}
	
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
}