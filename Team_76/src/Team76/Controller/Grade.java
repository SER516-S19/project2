package Team76.Controller;

public class Grade {
	
	private String studentID;
	private String QuizId;
	private String quiztitle;
	private String studentName;
	private String grade;
	
	public Grade(String studentID, String quizId, String quiztitle, String studentName, String grade) {
		this.studentID = studentID;
		QuizId = quizId;
		this.quiztitle = quiztitle;
		this.studentName = studentName;
		this.grade = grade;
	}

	public Grade(String quizId, String quiztitle, String studentName, String grade) {
		QuizId = quizId;
		this.quiztitle = quiztitle;
		this.studentName = studentName;
		this.grade = grade;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getQuizId() {
		return QuizId;
	}

	public void setQuizId(String quizId) {
		QuizId = quizId;
	}

	public String getQuiztitle() {
		return quiztitle;
	}

	public void setQuiztitle(String quiztitle) {
		this.quiztitle = quiztitle;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Grade [studentID=" + studentID + ", QuizId=" + QuizId
				+ ", quiztitle=" + quiztitle + ", studentName="
				+ studentName + ", grade=" + grade + "]";
	}
}
