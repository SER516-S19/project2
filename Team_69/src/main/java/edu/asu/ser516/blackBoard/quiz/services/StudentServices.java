package edu.asu.ser516.blackBoard.quiz.services;

import java.util.List;

import edu.asu.ser516.blackBoard.quiz.bean.QuestionAnswer;

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
}
