package edu.asupoly.ser516.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.asupoly.ser516.model.QuestionsVO;
import edu.asupoly.ser516.model.QuizVO;
import edu.asupoly.ser516.model.ViewQuizDAOBean;

/**
 * Servlet code takes quizId from courseDashboard.ftl  and renders a page displaying
 * information about the quiz and it's questions.
 * Database connections and retrievals are all conducted via the DAO interface.
 * @author Aditya Samant / @author akashkadam
 * @version 1.2
 * @see resources/courseDashboard.ftl
 * @see edu.asupoly.ser516.model/ViewQuizDAOBean.java
 * @see resources/viewQuiz.ftl
 */
public class ViewQuizServlet extends HttpServlet {
	// This servlet will not make any Get requests.
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) {

	}

	/**
	 * Grabs quizId from courseDashboard and renders viewQuiz page
	 *
	 * The viewQuiz page displays what the selected quiz name is, its scheduled date
	 * whether it is graded or not graded and displays the question, the correct
	 * answer, the total points each question is worth and
	 * 
	 * @param req Request made to server
	 * @param res Responses from server
	 *
	 *@throws IOException
	 *@throws ServletException
	 * */
	public void doPost(HttpServletRequest req, HttpServletResponse res)  throws ServletException, IOException{
		   
	       HttpSession session = req.getSession();
	       List<QuestionsVO> quizQuestions = new ArrayList<QuestionsVO>();
	       int quizId = Integer.parseInt(req.getParameter("Quiz"));
	       
	       
	       //Get today's date for comparison
	       Calendar cal = Calendar.getInstance();
	       cal.set(Calendar.HOUR_OF_DAY, 0);
	       cal.set(Calendar.MINUTE, 0);
	       cal.set(Calendar.SECOND,0);
	       cal.set(Calendar.MILLISECOND,0);
	       
	       Date today = new Date(cal.getTime().getTime());
	       boolean isAfter = false;
	       
	       //counter to addup and get total points for the quiz
	       int total = 0;
	       
	       try {

	    	   	   ViewQuizDAOBean bean = new ViewQuizDAOBean();
	    	   	   QuizVO quiz = bean.getQuizInfo(quizId);
	    	   	   quizQuestions = bean.getQuestionsInfo(quizId);
	    	   	   
	    	   	   for (int i = 0; i < quizQuestions.size(); i++) {
	    	   		 int points = quizQuestions.get(i).getTotalPoints();
	    	   		 total += points;
	    	   	   }
	    	   	   
	    	   	   Date scheduledDate = quiz.getQuizScheduledDate();
	    	   	   if (scheduledDate.before(today)) {
		   			   isAfter = true;
	    	   	   }
	    	   	   
	    	   	  // QuizVO quizInfo = new QuizVO(quizId, quizName);
		   		   
		   		   //Add Quiz info to Session attributes
		   		   session.setAttribute("quizId", quizId);
		   		   session.setAttribute("Grade",quiz.isGraded());
		   		   session.setAttribute("Schedule", quiz.getQuizScheduledDate());
		   		   session.setAttribute("Directions", quiz.getQuizInstruction());
		   		   session.setAttribute("isAfter", isAfter);
		   		   session.setAttribute("QuizQuestions",quizQuestions);
		   		   session.setAttribute("quizName", quiz.getQuizTitle());
		   		   session.setAttribute("Total", total);
	       
		   		   res.sendRedirect(req.getContextPath()+"/viewQuiz.ftl");
		   		   
			   		if (req.getParameter("logoutProfile") != null) {  
					    session.invalidate();
					    res.sendRedirect("login.jsp");
					    return; 
					}
	       }catch(Exception e) {
	    	   	   e.printStackTrace();
	       }
	}
}