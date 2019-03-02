package bean;

import java.util.List;

public class ProfessorStatistics {

	int students;
	int studentsGaveQuiz;
	List<CalculatedScores> studentCalculatedScores;
	
	public ProfessorStatistics(int students, int studentsGaveQuiz, List<CalculatedScores> studentCalculatedScores) {
		super();
		this.students = students;
		this.studentsGaveQuiz = studentsGaveQuiz;
		this.studentCalculatedScores = studentCalculatedScores;
	}
	public int getStudents() {
		return students;
	}
	public void setStudents(int students) {
		this.students = students;
	}
	public int getStudentsGaveQuiz() {
		return studentsGaveQuiz;
	}
	public void setStudentsGaveQuiz(int studentsGaveQuiz) {
		this.studentsGaveQuiz = studentsGaveQuiz;
	}
	public List<CalculatedScores> getStudentCalculatedScores() {
		return studentCalculatedScores;
	}
	public void setStudentCalculatedScores(List<CalculatedScores> studentCalculatedScores) {
		this.studentCalculatedScores = studentCalculatedScores;
	}
	
	
}
