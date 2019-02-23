package services;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import bean.Answer;
import bean.AnswerMapper;
import bean.Question;
import bean.QuestionAnswer;
import bean.QuestionMapper;
import bean.Quiz;
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

public class QuestionAnswerGenerator {
	public QuestionAnswer generator(int quizId) {
		QuestionDAO questionDao = new QuestionDAO();
		AnswerDAO answerDao = new AnswerDAO();

		QuestionAnswer questionAnswers = new QuestionAnswer();
		List<Question> questionList = questionDao.getQuestionsByQuizId(quizId);
		if(questionList!= null) {
			Quiz quiz = questionList.get(0).getQuiz();
			questionAnswers.setQuizId(quiz.getQuizId());
			questionAnswers.setQuizName(quiz.getQuizName());
			questionAnswers.setQuizInstructions(quiz.getQuizInstructions());
			questionAnswers.setPublished(quiz.isPublished());
			questionAnswers.setShuffled(quiz.isShuffled());
			questionAnswers.setQuizType(quiz.getQuizType());
			questionAnswers.setQuizTimeLimit(quiz.getQuizTimeLimit());
		}
		List<QuestionMapper> questionMapperList = new ArrayList<QuestionMapper>();
		for (Question question : questionList) {
			QuestionMapper mapper = new QuestionMapper();
			mapper.setMultiple(question.isMultiple());
			mapper.setPoints(question.getPoints());
			mapper.setQuestion(question.getQuestion());
			mapper.setQuestionId(question.getQuestionId());
			mapper.setResponseAnswer(new ArrayList<AnswerMapper>());
			List<AnswerMapper> answerMapperList = new ArrayList<AnswerMapper>();
			List<Answer> answersList = answerDao.getAnswersByQuestionId(question.getQuestionId());
			for(Answer ans : answersList) {
				AnswerMapper answerMapper = new AnswerMapper();
				answerMapper.setAnswer(ans.getAnswer());
				answerMapper.setAnswerId(ans.getAnswerId());
				answerMapper.setCorrectAnswer(ans.getCorrectAnswer());
				answerMapperList.add(answerMapper);
			}
			mapper.setAvailableAnswers(answerMapperList);
			questionMapperList.add(mapper);
		}
		questionAnswers.setQuestion(questionMapperList);;
		return questionAnswers;
		

	}

	public String ObjectToJSON(QuestionAnswer quizList) {
		GsonBuilder gsonBuilder = new GsonBuilder();  
		gsonBuilder.serializeNulls();  
		Gson gson = gsonBuilder.create();
		String result = gson.toJson(quizList);
		return result;
	}
}
