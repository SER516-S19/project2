package com.Quizzer.code.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.Quizzer.code.dao.QuizRepo;
import com.Quizzer.code.dao.SubmitQuizRepo;
import com.Quizzer.code.model.db.Quiz;
import com.Quizzer.code.model.db.SubmitQuiz;
import com.Quizzer.code.model.response.StatisticsResponseVO;

public class ProfStatisticsService {

	@Autowired
	private SubmitQuizRepo submitQuiz;
	@Autowired
	private QuizRepo quiz;

	public StatisticsResponseVO calculateStats() {
		List<Quiz> listQuiz = quiz.findAll();
		List<String> quizNames = new ArrayList<>();
		List<Double> averageMarks = new ArrayList<>();

		List<SubmitQuiz> listSubmittedQuizzes = null;
		int i = 0;
		double avg = 0.0;
		for (Quiz quizzer : listQuiz) {
			listSubmittedQuizzes = submitQuiz.findByQuizId(quizzer.getId());
			avg = calculateAverage(listSubmittedQuizzes);
			quizNames.set(i, quizzer.getName());
			averageMarks.set(i, avg);
			i++;

		}

		return new StatisticsResponseVO(quizNames, averageMarks);
	}

	private double calculateAverage(List<SubmitQuiz> listSubmittedQuizzes) {

		int length = listSubmittedQuizzes.size();
		if (length > 0) {
			double sum = 0.0;
			for (SubmitQuiz submitted : listSubmittedQuizzes) {
				sum = sum + submitted.getMarksAchieved();
			}
			return sum / length;
		}
		return 0;
	}
}
