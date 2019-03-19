package services;

import java.util.HashMap;
import bean.Answer;
import bean.CalculatedScores;
import bean.ProfessorStatistics;
import bean.ResponseStatistics;
import dao.StatisticsDAO;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * This is the service class for manipulating data models.
 *
 * @version 1.0
 * @since 03-01-2019
 * @authors Gangadhar, Viraj
 */
public class StatisticServices {

	StatisticsDAO statisticsDAO = new StatisticsDAO();

	/**
	 * This method verifies question form data and add question details in Question
	 * table
	 */
	public ProfessorStatistics getQuizStatistics(int quizId) {
		int students = statisticsDAO.retrieveStudentsCount();
		int studentsGaveQuiz = statisticsDAO.retrieveStudentsQuizCount(quizId);
		List<CalculatedScores> studentCalculatedScores = statisticsDAO.retrieveStudentsGrades(quizId);
		for (int i = 0; i < studentCalculatedScores.size(); i++)
			studentCalculatedScores.get(i).toString();

		List<ResponseStatistics> resp = statisticsDAO.getResponseOfEachQuestion(quizId);
		HashMap<String, Integer> questionStats = extractQuestionData(resp);
		List<Answer> ans = statisticsDAO.getCorrectResponseOfEachQuestion(quizId);
		HashMap<Integer, Integer> correctAns = calculateQuestionToAnswerCount(ans);

		Map<Integer, Integer> result = getCompareResult(questionStats, correctAns);
		ProfessorStatistics professorStatistics = new ProfessorStatistics(students, studentsGaveQuiz,
				studentCalculatedScores, result);
		return professorStatistics;
	}

	/**
	 * This method compares the students correct response count to the correct
	 * answer count. If they match the count is incremented, otherwise defaults to 0
	 */
	private Map<Integer, Integer> getCompareResult(HashMap<String, Integer> questionStats,
			HashMap<Integer, Integer> correctAns) {
		Map<Integer, Integer> resultantData = new HashMap<Integer, Integer>();
		for (Entry<String, Integer> ques : questionStats.entrySet()) {
			String questionId = ques.getKey().split("/")[1];
			int qId = Integer.parseInt(questionId);
			int userCount = ques.getValue();
			int actualResCount = correctAns.get(qId);

			if (actualResCount == userCount) {
				if (resultantData.containsKey(qId))
					resultantData.put(qId, resultantData.get(qId) + 1);
				else
					resultantData.put(qId, 1);
			} else {
				if (!resultantData.containsKey(qId))
					resultantData.put(qId, 0);
			}
		}
		return resultantData;
	}

	/**
	 * A question can have multiple answers, so based on the answer list for the
	 * questions the function calculates and returns a map of question id : answer
	 * count
	 */
	private HashMap<Integer, Integer> calculateQuestionToAnswerCount(List<Answer> answerList) {
		HashMap<Integer, Integer> resultMap = new HashMap<>();

		for (Answer answer : answerList) {
			int questionId = answer.getQuestion().getQuestionId();
			if (resultMap.containsKey(questionId)) {
				resultMap.put(questionId, resultMap.get(questionId) + 1);
			} else {
				resultMap.put(questionId, 1);
			}
		}
		return resultMap;
	}

	/**
	 * Based on the user responses the function returns a dictionary mapping the
	 * userid-question to the count of correct answer
	 */
	public HashMap<String, Integer> extractQuestionData(List<ResponseStatistics> statisticList) {
		HashMap<String, Integer> resultMap = new HashMap<>();
		for (ResponseStatistics response : statisticList) {
			int userId = response.getUser().getUser_id();
			int questionId = response.getQuestion().getQuestionId();
			String mapKey = userId + "/" + questionId;
			if (resultMap.containsKey(mapKey))
				resultMap.put(mapKey, resultMap.get(mapKey) + 1);
			else
				resultMap.put(mapKey, 1);
		}
		return resultMap;
	}
}