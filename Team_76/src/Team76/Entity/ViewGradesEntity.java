package Team76.Entity;

public class ViewGradesEntity {

	
	private String quizTitle;
	private String studentName;
	private String quizDrop;
	
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
	public String getQuizDrop() {
		return quizDrop;
	}
	public void setQuizDrop(String quizDrop) {
		this.quizDrop = quizDrop;
	}

  public String toString() {
	  return "ViewGradesEntity [quizTitle=" +quizTitle +",studentName= " +studentName+ ", quizDrop= "+quizDrop+"]";
  }
}
