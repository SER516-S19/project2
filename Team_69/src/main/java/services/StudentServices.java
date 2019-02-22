package services;

import java.util.List;
import com.google.gson.Gson;

import bean.Answer;
import bean.Question;
import bean.QuestionAnswer;
import bean.Quiz;
import bean.ResponseStatistics;
import bean.User;
import dao.QuestionDAO;
import dao.StatisticsDAO;




/**
 * A class to get the JSON string to the student controller
 * 
 * @author amanjotsingh
 * @version 1.0
 * @since 02/21/2019
 * 
 * */

public class StudentServices {
	
	public String getQuestionDetails(int quizId) {
		QuestionAnswerGenerator quizData = new QuestionAnswerGenerator();
		String jsonString = null;
		List<QuestionAnswer> quizList = quizData.generator(quizId);
		jsonString = quizData.ObjectToJSON(quizList);
		return jsonString;
	}
	
	public String feedAnswers(String studentResponse) {
		
		QuestionAnswer[] jsonResponse =  StudentServices.convertStringtoJSON(studentResponse);
		

		StatisticsDAO statisticsDAO = new StatisticsDAO();
		QuestionDAO questionDAO = new QuestionDAO();
		//questionDAO.addQuestion(question);
		//stats = new ResponseStatistics(user,quiz,question,answer);
		//System.out.println(stats);
		//statisticsDAO.insertAnswer();
		//statisticsDAO.insertStudentResponse(stats);
		for(QuestionAnswer entry : jsonResponse) {
			Question question  = new Question(entry.getQuiz(), entry.getQuestion(), entry.getCorrectAnswerId(), entry.isMultiple(), entry.getPoints());
			questionDAO.addQuestion(question);
			Quiz quiz = entry.getQuiz();
			User user = new User("abc","student","abc.com","1234");
			for(Answer ans: entry.getAnswerList()) {
			
			}
			
			
		}
		return "success";
		
	}
	
	public static QuestionAnswer[] convertStringtoJSON(String studentResponse) {
		Gson gson = new Gson();
		QuestionAnswer[] listOfAnswers = gson.fromJson(studentResponse, QuestionAnswer[].class);
        return listOfAnswers;
	} 
}
