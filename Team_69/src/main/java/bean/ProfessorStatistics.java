package bean;

import java.util.List;
import java.util.Map;

public class ProfessorStatistics {

	int students;
	int studentsGaveQuiz;
	List<CalculatedScores> studentCalculatedScores;
	Map<Integer, Integer> statOfEachQuestion;

	public ProfessorStatistics() {
	}

	public ProfessorStatistics(int students, int studentsGaveQuiz, List<CalculatedScores> studentCalculatedScores,
			Map<Integer, Integer> statOfEachQuestion) {
		super();
		this.students = students;
		this.studentsGaveQuiz = studentsGaveQuiz;
		this.studentCalculatedScores = studentCalculatedScores;
		this.statOfEachQuestion = statOfEachQuestion;
	}

	public Map<Integer, Integer> getStatOfEachQuestion() {
		return statOfEachQuestion;
	}

	public void setStatOfEachQuestion(Map<Integer, Integer> statOfEachQuestion) {
		this.statOfEachQuestion = statOfEachQuestion;
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
