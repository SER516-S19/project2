package bean;

public class Grade {

	String studentId,quizId,grade;
	int totalAttempts,totalMarks;

	/**
	 * @return the studentId
	 */
	public String getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
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
	 * @return the totalAttempts
	 */
	public int getTotalAttempts() {
		return totalAttempts;
	}
	/**
	 * @param TotalAttempts the TotalAttempts to set
	 */
	public void setTotalAttempts(int totalAttempts) {
		this.totalAttempts = totalAttempts;
	}
	/**
	 * @return the TotalMarks
	 */
	public int getTotalMarks() {
		return totalMarks;
	}
	/**
	 * @param TotalMarks the TotalMarks to set
	 */
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}			

}
