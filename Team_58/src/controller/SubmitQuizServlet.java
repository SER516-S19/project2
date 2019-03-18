package controller;


import java.io.IOException;

import java.sql.Connection;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.displayQuestionsVO;
import model.StudentResponseDAOBean;
import model.StudentResponseVO;

import java.util.logging.Logger;

import java.util.ArrayList;
import java.util.List;


import javax.servlet.annotation.WebServlet;
import org.json.simple.JSONObject;
import model.UserVO;
import java.io.BufferedReader;
import java.io.InputStreamReader;





/**
 * Submit Quiz  Servlet is a controller that Submits Quiz
 * Submission of answers after the selection of answers 
 *
 * @author Sami
 * @version 1.0
 * @date 03/01/2019
 **/


@WebServlet(name = "SubmitQuizServlet", urlPatterns = "/SubmitQuiz")
public class SubmitQuizServlet extends HttpServlet {
	
private static Logger log = Logger.getLogger(DisplayQuizServlet.class.getName());
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		
		try {

			
			log.info("In Submit Quiz Servlet");
			List<Integer> questionsIds = new ArrayList<Integer>();
			
			HttpSession session = req.getSession();
			int displayQuestionsVOLength = Integer.parseInt(session.getAttribute("displayQuestionsVOLength").toString());
			int quizId = Integer.parseInt(session.getAttribute("quizId").toString());
			int courseId = Integer.parseInt(session.getAttribute("courseId").toString());		
			int userId = Integer.parseInt(session.getAttribute("userId").toString());
			questionsIds = (ArrayList<Integer>)session.getAttribute("questionsIds");
			
			log.info("questionsIds"+questionsIds);
			
//			ArrayList<Integer>)session.getAttribute("questionsIds");
			int score = 0;
			int questionId = 0;
			
			
			log.info("displayQuestionsVOLength"+displayQuestionsVOLength);
			log.info("quizId"+quizId);
			log.info("courseId"+courseId);
			log.info("userId"+userId);
			
			StudentResponseDAOBean studentResponse = new StudentResponseDAOBean();
			
			List<StudentResponseVO> studentResponseVOList = studentResponse.getStudentListFromCourseIdQuizIdUserId(courseId,quizId,userId);
			
			log.info("length of studentResponseVOList"+studentResponseVOList.size());
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
//			String[] answerSelectedtest = req.getParameterValues("1");
			
			for(int i=0 ; i< displayQuestionsVOLength ; i++)
			{
				
//				String[] answerSelectedtest = req.getParameterValues("1");
				String[] answerSelected = req.getParameterValues(Integer.toString(questionsIds.get(i)));
				log.info("answer selected"+answerSelected);
				int x = answerSelected.length;
				questionId = questionsIds.get(i);
				
				StringBuilder sb = new StringBuilder();
				sb.append("{");
				sb.append("\"");
				
				for(int j=0; j < answerSelected.length ; j++)
				{
					
					log.info("Values are  "+answerSelected[j]);
					sb.append("correctAnswer"+Integer.toString(x));
					sb.append("\"");
					sb.append(":");
					sb.append("\"");
					sb.append(answerSelected[j]);
					sb.append("\"");
					if (j != answerSelected.length-1) {
						sb.append(",");
						sb.append("\"");
					}
					
					x--;
				}
				
				sb.append("}");
				
				String selectedAnswers = sb.toString();
				
				log.info("String is"+selectedAnswers);
				
			
				
				if(studentResponseVOList.size()  > 0)
				{
				
					studentResponse.updateStudentResponse(courseId,quizId,userId,questionId,selectedAnswers);
				
				}
				else
				{
					
					log.info("Insert New Row in DB");
					studentResponse.InsertQuizAnswers(courseId, quizId, userId, questionId, selectedAnswers, score);
					
				}
				
//				int row = studentResponse.getFromCourseIDQuizIdUserIdQuestionId(courseId, quizId, userId, questionId);
//				log.info("row exists "+row);
//				studentResponse.InsertQuizAnswers(courseId, quizId, userId, questionId, selectedAnswers, score);
			}

			res.sendRedirect(req.getContextPath() + "/submitQuizSuccess.ftl");
			
			

	} catch (Exception e) {
		e.printStackTrace();
	}
		
		

	}
}


