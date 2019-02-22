package bean;
import java.sql.Date;

public class Professor {
	String profId,quizId,status,quizType;
	Date dueDate;
	int timeLimit;
	/**
	 * @return the profId
	 */
	public String getProfId() {
		return profId;
	}
	/**
	 * @param profId the profId to set
	 */
	public void setProfId(String profId) {
		this.profId = profId;
	}
	/**
	 * @return the quizId
	 */
	public String getQuizId() {
		return quizId;
	}
	/**
	 * @param quizId the quizId to set
	 */
	public void setQuizId(String quizId) {
		this.quizId = quizId;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the quizType
	 */
	public String getQuizType() {
		return quizType;
	}
	/**
	 * @param quizType the quizType to set
	 */
	public void setQuizType(String quizType) {
		this.quizType = quizType;
	}
	/**
	 * @return the dueDate
	 */
	public Date getDueDate() {
		return dueDate;
	}
	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	/**
	 * @return the timeLimit
	 */
	public int getTimeLimit() {
		return timeLimit;
	}
	/**
	 * @param timeLimit the timeLimit to set
	 */
	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}	

}
