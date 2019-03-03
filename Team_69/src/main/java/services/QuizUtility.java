package services;

import java.util.ArrayList;
import java.util.List;

import bean.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dao.AnswerDAO;
import dao.QuestionDAO;

/**
 * A class to combine the questions with its answers
 * 
 * @author: leharbhatt
 * @version: 1.0
 * @since : 02/20/2019
 *
 */

public class QuizUtility {

	public QuizDetails generator(int quizId) {
		QuestionDAO questionDao = new QuestionDAO();
		AnswerDAO answerDao = new AnswerDAO();
<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
=======
>>>>>>> Team_58
		QuizDetails questionAnswers = new QuizDetails();
		List<Question> questionList = questionDao.getQuestionsByQuizId(quizId);
		if(questionList.size()!= 0) {
			Quiz quiz = questionList.get(0).getQuiz();
			questionAnswers.setQuizId(quiz.getQuizId());
			questionAnswers.setQuizName(quiz.getQuizName());
			questionAnswers.setQuizInstructions(quiz.getQuizInstructions());
			questionAnswers.setPublished(quiz.getIsPublished());
			questionAnswers.setShuffled(quiz.isShuffled());
			questionAnswers.setQuizType(quiz.getQuizType());
			questionAnswers.setQuizTimeLimit(quiz.getQuizTimeLimit());
		}
		List<QuestionDetails> questionMapperList = new ArrayList<QuestionDetails>();
		for (Question question : questionList) {
			QuestionDetails mapper = new QuestionDetails();
			mapper.setMultiple(question.isMultiple());
			mapper.setPoints(question.getPoints());
			mapper.setQuestion(question.getQuestion());
			mapper.setQuestionId(question.getQuestionId());
			mapper.setResponseAnswer(new ArrayList<AnswerDetails>());
			List<AnswerDetails> answerDetailsList = new ArrayList<AnswerDetails>();
			List<Answer> answersList = answerDao.getAnswersByQuestionId(question.getQuestionId());
			for(Answer ans : answersList) {
				AnswerDetails answerDetails = new AnswerDetails();
				answerDetails.setAnswer(ans.getAnswer());
				answerDetails.setAnswerId(ans.getAnswerId());
				answerDetails.setCorrectAnswer(ans.getCorrectAnswer());
				answerDetailsList.add(answerDetails);
			}
			mapper.setAvailableAnswers(answerDetailsList);
			questionMapperList.add(mapper);
		}
		questionAnswers.setQuestion(questionMapperList);;
		return questionAnswers;
	}

	public String ObjectToJSON(QuizDetails quizList) {
		GsonBuilder gsonBuilder = new GsonBuilder();  
		gsonBuilder.serializeNulls();  
		Gson gson = gsonBuilder.create();
		String result = gson.toJson(quizList);
		return result;
	}
}
