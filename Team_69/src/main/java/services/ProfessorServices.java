package services;
import java.util.List;
import bean.Quiz;
import dao.ProfessorDAO;

public class ProfessorServices {
	ProfessorDAO professorDAO = new ProfessorDAO();
	
	public List<Quiz> getAllQuizzes(){
		
		List<Quiz> lists = professorDAO.getAllQuizzes();
		return lists;
	}
	
	public void publishQuiz(int quiz_id) {
		professorDAO.publishQuiz(quiz_id);
		
	}
	
}
