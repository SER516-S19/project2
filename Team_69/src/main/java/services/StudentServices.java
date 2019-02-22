package services;

import java.util.List;
import com.google.gson.Gson;
import bean.QuestionAnswer;

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
		return "success";
		
	}
	
	public static QuestionAnswer[] convertStringtoJSON(String studentResponse) {
		Gson gson = new Gson();
		QuestionAnswer[] listOfAnswers = gson.fromJson(studentResponse, QuestionAnswer[].class);
        return listOfAnswers;
	} 
}
