package edu.asupoly.ser516.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.asupoly.ser516.model.GradeQuizVO;
import edu.asupoly.ser516.model.GradeQuizVODAOBean;
import edu.asupoly.ser516.model.QuizVO;
import edu.asupoly.ser516.model.StudentResponseDAO;
import edu.asupoly.ser516.model.StudentResponseDAOBean;

/**
 * Class GradeQuizServlet is a controller 
 * that routes the Professor to Grade Dashboard Page from Professor Home Page.
 * 
 * @author akashkadam
 * @version 1.3
 **/
public class GradeQuizServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(ProfessorHomeServlet.class.getName());

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		int quizId = Integer.parseInt(session.getAttribute("quizId").toString());
		String quizName = session.getAttribute("quizName").toString();

		try {
			StudentResponseDAOBean studentResponseDAOBean = new StudentResponseDAOBean();
		
			studentResponseDAOBean.updateStudentResponse(quizId);
			
			GradeQuizVODAOBean quizVODAOBean = new GradeQuizVODAOBean();
			
			List<GradeQuizVO> gradedQuizList = quizVODAOBean.getgradeQuiz(quizId, quizName);
			
			session.setAttribute("gradeQuiz", gradedQuizList);
			session.setAttribute("quizName", quizName);

			response.sendRedirect(request.getContextPath()+"/gradeQuiz.ftl");  
		}
		catch(Exception exception) {
			log.info(exception.getMessage());
		}

	}

}
