package com.Quizzer.code.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Quizzer.code.dao.QuizRepo;
import com.Quizzer.code.dao.SubmitQuizRepo;
import com.Quizzer.code.model.db.Quiz;
import com.Quizzer.code.model.db.SubmitQuiz;
import com.Quizzer.code.model.response.StatisticsResponseVO;

/**
 * This is the service for Statistics.
 * 
 * @author kumar
 *
 */
@Service
public class ProfStatisticsService {

	@Autowired
	private SubmitQuizRepo submitQuiz;
	@Autowired
	private QuizRepo quiz;

	/**
	 * This method calculates the statistics for quizzes.
	 * 
	 * @return
	 */
	public StatisticsResponseVO calculateStats() {
		List<Quiz> listQuiz = quiz.findAll();
		List<String> quizNames = new ArrayList<>();
		List<Double> averageMarks = new ArrayList<>();
		List<Integer> medians = new ArrayList<>();

		List<SubmitQuiz> listSubmittedQuizzes = null;
		int i = 0;
		double avg = 0.0;
		int median = 0;
		if (listQuiz.size() > 0) {
			for (Quiz quizzer : listQuiz) {
				listSubmittedQuizzes = submitQuiz.findByQuizId(quizzer.getId());
				if (listSubmittedQuizzes.size() > 0) {
					avg = calculateAverage(listSubmittedQuizzes);
					median = calculateMedian(listSubmittedQuizzes);
					quizNames.add(i, quizzer.getName());
					medians.add(i, median);
					averageMarks.add(i, avg);
					i++;
				}
			}
		}
		return new StatisticsResponseVO(quizNames, averageMarks, medians);
	}

	/**
	 * This is the helper method for average calculation.
	 * 
	 * @param listSubmittedQuizzes
	 * @return
	 */
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

	/**
	 * This is the helper method for median calculation.
	 * 
	 * @param listSubmittedQuizzes
	 * @return
	 */
	private int calculateMedian(List<SubmitQuiz> listSubmittedQuizzes) {
		int length = listSubmittedQuizzes.size();
		if (length > 0) {
			List<Integer> listMarks = new ArrayList<>();
			for (SubmitQuiz submitted : listSubmittedQuizzes) {
				listMarks.add(submitted.getMarksAchieved());
			}
			Collections.sort(listMarks);

			return listMarks.get((length) / 2);
		}
		return 0;
	}
}
