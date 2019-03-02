package Team76.Entity;

/**
 * The class GradeEntity is grade object
 * 
 * @author Hsin-Jung Lee 
 * Version 3
 */
public class GradeEntity {

	private int studentId = 0;
	private int quizId = 0;
	private String quizTitle = "";
	private String studentName = "";
	private String grade = "";

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public String getQuizTitle() {
		return quizTitle;
	}

	public void setQuizTitle(String quizTitle) {
		this.quizTitle = quizTitle;
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
		return "Grade [studentId=" + studentId + ", quizId=" + quizId 
				+ ", quizTitle=" + quizTitle + ", studentName="
				+ studentName + ", grade=" + grade + "]";
	}
}
