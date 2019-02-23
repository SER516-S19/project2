package controller;

import java.io.IOException;
import java.sql.Time;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Answer;
import bean.Question;
import bean.Quiz;
import dao.ProfessorDAO;
import dao.QuestionDAO;
import services.ProfessorServices;

/**
 * This is the controller for managing professor side of the quiz.
 *
 * @version 1.0
 * @since 02-16-2019
 * @authors Aneesh, Gangadhar, Janice, Jinal, Viraj
 */
public class ProfessorServlet extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The professor services. */
	private ProfessorServices professorServices = new ProfessorServices();

	/**
	 * This method will handle the get requests. Each request will have a flag that
	 * determines the service
	 * 
	 * @param request  request object from the jsp page
	 * @param response response to be sent to the jsp page
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flag = request.getParameter("flag");
		if ("fetchQuizList".equalsIgnoreCase(flag)) {
			List<Quiz> quizList = professorServices.getAllQuizzes();
			request.setAttribute("quizList", quizList);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/displayQuizDetails.jsp");
			rd.forward(request, response);
		} else if ("publishQuiz".equalsIgnoreCase(flag)) {
			String id = request.getParameter("id");
			int quizID = Integer.parseInt(id);
			professorServices.publishQuiz(quizID);
			List<Quiz> quizList = professorServices.getAllQuizzes();
			request.setAttribute("quizList", quizList);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/displayQuizDetails.jsp");
			rd.forward(request, response);
		} else if ("viewQuiz".equalsIgnoreCase(flag)) {
			String id = request.getParameter("id");
			int quizId = Integer.parseInt(id);
			String quizName = request.getParameter("quizName");
			List<Question> questions = professorServices.getAllQuestionFromQuizID(quizId);
			List queAnsData = professorServices.getAllAnswersFromQueList(questions);
			request.setAttribute("quizName", quizName);
			request.setAttribute("queAnsData", queAnsData);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/displayQuestionstoProfessor.jsp");
			rd.forward(request, response);	
		
		}else if("addQueInQuiz".equalsIgnoreCase(flag)) {
			
			String quizID = request.getParameter("id");
			int quizId = Integer.parseInt(quizID);
			
			ProfessorDAO professorDAO = new ProfessorDAO();
			Quiz quiz = professorDAO.getQuizFromID(quizId);
			
			HttpSession session = request.getSession(true);
			session.setAttribute("quiz", quiz);
			
			response.sendRedirect(request.getContextPath()+"/views/addQuestions.jsp");

		}
	}

	/**
	 * This method will handle the post requests. Each request will have a flag that
	 * determines the service
	 * 
	 * @param request  request object from the jsp page
	 * @param response response to be sent to the jsp page
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flag = request.getParameter("flag");
		if ("InsertProfDetails".equals(flag)) {
			ProfessorServices professorServices = new ProfessorServices();
			professorServices.insertProfDetails(request);
			response.sendRedirect("views/professorLanding.jsp");
		}
		else if("DeleteQuestion".equals(flag)){
	        String quesId = request.getParameter("box1");
			QuestionDAO questionDAO = new QuestionDAO();
			questionDAO.deleteQuestionByQuestionId(quesId);
            response.sendRedirect("views/removeQuestionPage.jsp");
            
        }else if("Add Next Question".equals(flag) || "Save and Exit".equals(flag)) {
			

        	String question = request.getParameter("question").trim();
        	String questionOption1 = request.getParameter("option1").trim();
        	String questionOption2 = request.getParameter("option2").trim();
        	String questionOption3 = request.getParameter("option3").trim();
        	String questionOption4 = request.getParameter("option4").trim();
        	String points = request.getParameter("points");
        	String[] correctanswers = (String[]) request.getParameterValues("options");
     
        	
			HttpSession session = request.getSession(true);
			
    
			professorServices = new ProfessorServices();
			professorServices.storeQuestion((Quiz)session.getAttribute("quiz"), question, questionOption1,
					questionOption2, questionOption3, questionOption4, correctanswers, points);
			
        	String addQuestionPageURL = request.getContextPath() + "/ProfessorController";
        	request.setAttribute("profnavigate", addQuestionPageURL); 
        	if("Add Next Question".equals(flag)) {
        		response.sendRedirect("views/addQuestions.jsp");
        		return;
        	}else if("Save and Exit".equals(flag)) {
        		response.sendRedirect("views/professorLanding.jsp");
            	return;
        	}
        
        	
		}else if("Verify Questions".equals(flag)) {
        	response.sendRedirect("views/displayQuestionAnswer.jsp");
        	return;
        }
    }


		
}