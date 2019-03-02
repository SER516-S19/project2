package services;

import java.util.ArrayList;
import java.util.HashMap;

import bean.Answer;
import bean.CalculatedScores;
import bean.ProfessorStatistics;
import bean.Question;
import bean.Quiz;
import bean.ResponseStatistics;
import dao.AnswerDAO;
import dao.ProfessorDAO;
import dao.QuestionDAO;
import dao.StatisticsDAO;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
		for(int i=0; i<studentCalculatedScores.size();i++)
		{
			studentCalculatedScores.get(i).toString();
		}
		
		// get statistic of each question
		List<ResponseStatistics> resp = statisticsDAO.getResponseOfEachQuestion(quizId);
		HashMap<String,Integer> questionStats = extractQuestionData(resp);
		List<Answer> ans = statisticsDAO.getCorrectResponseOfEachQuestion(quizId);
		HashMap<Integer,Integer> correctAns = extractCOrrectAnsFromTable(ans);
		
		Map<Integer,Integer> result = getCompareResult(questionStats,correctAns);
		System.out.println(result);
		ProfessorStatistics professorStatistics = new ProfessorStatistics(students,studentsGaveQuiz,studentCalculatedScores,result);

		
		return professorStatistics;
		
	}
	
	private Map<Integer, Integer> getCompareResult(HashMap<String, Integer> questionStats,
			HashMap<Integer, Integer> correctAns) {
		Map<Integer, Integer> resultantData = new HashMap<Integer, Integer>();
		for(Entry<String, Integer> ques : questionStats.entrySet()){
			
			String questionId = ques.getKey().split("/")[1];
			int qId = Integer.parseInt(questionId);
			
			int userCount = ques.getValue();
			
			int actualResCount = correctAns.get(qId);
			if(actualResCount == userCount) {
				if (resultantData.containsKey(qId)) {
					resultantData.put(qId, resultantData.get(qId)+1);
		        } else {
		        	resultantData.put(qId, 1);
		        }
				
			}else {
				if (!resultantData.containsKey(qId)) {
					resultantData.put(qId, 0);
		        }
			}
			
		}
		
		return resultantData;
	}

	private HashMap<Integer,Integer> extractCOrrectAnsFromTable(List<Answer> ans) {
		HashMap<Integer,Integer> resultMap =  new HashMap<>();
		
		for(Answer answer : ans) {
			int questionId = answer.getQuestion().getQuestionId();
			if (resultMap.containsKey(questionId)) {
				resultMap.put(questionId, resultMap.get(questionId)+1);
	        } else {
	        	resultMap.put(questionId, 1);
	        }
			
		}
		System.out.println(resultMap);
		return resultMap;
	}

	public HashMap<String,Integer> extractQuestionData(List<ResponseStatistics> resp) {
		HashMap<String,Integer> resultMap =  new HashMap<>();
		for(ResponseStatistics response : resp) {
			
			int userid = response.getUser().getUser_id();
			int queid = response.getQuestion().getQuestionId();
			
			String mapKey = userid + "/"+ queid;
			
			if (resultMap.containsKey(mapKey)) {
				resultMap.put(mapKey, resultMap.get(mapKey)+1);
	        } else {
	        	resultMap.put(mapKey, 1);
	        }
			
		}
		System.out.println(resultMap);
		return resultMap;
	}
	
}