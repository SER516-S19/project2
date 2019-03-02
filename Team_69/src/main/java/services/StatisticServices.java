package services;

import java.util.ArrayList;
import bean.Answer;
import bean.CalculatedScores;
import bean.ProfessorStatistics;
import bean.Question;
import bean.Quiz;
import dao.AnswerDAO;
import dao.ProfessorDAO;
import dao.QuestionDAO;
import dao.StatisticsDAO;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * This is the service class for manipulating data models.
 *
 * @version 1.0
 * @since 03-01-2019
 * @authors Gangadhar,  Viraj
 */
public class StatisticServices {
	
	/**
	 * This method verifies question form data and add question details in Question table
	 * @return 
	 */
	public ProfessorStatistics getQuizStatistics(int quizId) {
		
		StatisticsDAO statisticsDAO = new StatisticsDAO();
		int students = statisticsDAO.retrieveStudentsCount();
		int studentsGaveQuiz = statisticsDAO.retrieveStudentsQuizCount(quizId);
		List<CalculatedScores> studentCalculatedScores = statisticsDAO.retrieveStudentsGrades(quizId);
		
		ProfessorStatistics professorStatistics = new ProfessorStatistics(students,studentsGaveQuiz,studentCalculatedScores);
		return professorStatistics;
		
	}
}