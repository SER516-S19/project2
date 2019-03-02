package controller;


import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ConnectionFactory;
import model.QuestionsVO;
import model.QuestionsVO;
import model.UserVO;
import model.StudentResponseDAOBean;
import java.util.logging.Logger;

import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;
import javax.servlet.annotation.WebServlet;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;



/**
 * Submit Quiz  Servlet is a controller that Submits Quiz
 * Submission of answers after the selection of answers 
 *
 * @author Sami
 * @version 1.0
 * @date 03/01/2019
 **/

public class SubmitQuizServlet extends HttpServlet {
	
private static Logger log = Logger.getLogger(DisplayQuizServlet.class.getName());
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		
		try {

			
			HttpSession session = req.getSession();
			
			int quizId = Integer.parseInt(session.getAttribute("mqid").toString());
			int courseId = Integer.parseInt(session.getAttribute("courseIdN").toString());		
			int userId = Integer.parseInt(session.getAttribute("userIdN").toString());
			
	
			List<QuestionsVO> list = new ArrayList<QuestionsVO>();
		
			list = (List<QuestionsVO>) req.getSession().getAttribute("list");

			
			String answerSelected = req.getParameter("jsonData");
			int questionId = Integer.parseInt(req.getParameter("questionId"));
			int score = 0;


			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			StudentResponseDAOBean studentResponse = new StudentResponseDAOBean();
			studentResponse.InsertQuizAnswers(courseId, quizId, userId, questionId, answerSelected, score);

			res.sendRedirect(req.getContextPath() + "/SubmitQuiz.ftl");
			

	} catch (Exception e) {
		e.printStackTrace();
	}
		
		

	}
}


