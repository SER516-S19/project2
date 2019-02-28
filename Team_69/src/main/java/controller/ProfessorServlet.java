package controller;

import java.io.IOException;
import java.util.List;
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
 * @authors  Gangadhar, Janice, Jinal
 */
public class ProfessorServlet extends HttpServlet {

	ProfessorServices professorServices = new ProfessorServices();
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
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/displayQuizDetails.jsp");
			request.setAttribute("quizList", quizList);
			rd.forward(request, response);
		} 
		else if ("publishQuiz".equalsIgnoreCase(flag)) {
			String id = request.getParameter("id");
			int quizID = Integer.parseInt(id);
			professorServices.publishQuiz(quizID);
			List<Quiz> quizList = professorServices.getAllQuizzes();
			request.setAttribute("quizList", quizList);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/displayQuizDetails.jsp");
			rd.forward(request, response);
		} 
		else if ("viewQuiz".equalsIgnoreCase(flag)) {
			String id = request.getParameter("id");
			String quizName = request.getParameter("quizName");
			int quizId = Integer.parseInt(id);
			List<Question> questions = professorServices.getAllQuestionFromQuizID(quizId);
			List queAnsData = professorServices.getAllAnswersFromQueList(questions);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/displayQuestionstoProfessor.jsp");
			request.setAttribute("quizName", quizName);
			request.setAttribute("queAnsData", queAnsData);
			rd.forward(request, response);	
		}
		else if("addQueInQuiz".equalsIgnoreCase(flag)) {
			String quizID = request.getParameter("id");
			int quizId = Integer.parseInt(quizID);
			ProfessorDAO professorDAO = new ProfessorDAO();
			Quiz quiz = professorDAO.getQuizFromID(quizId);
			HttpSession session = request.getSession(true);
			session.setAttribute("quiz", quiz);
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
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flag = request.getParameter("flag");
		if ("InsertQuizDetails".equals(flag)) {
			professorServices.insertQuizDetails(request);
			List<Quiz> quizList = professorServices.getAllQuizzes();
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/displayQuizDetails.jsp");
			request.setAttribute("quizList", quizList);
			rd.forward(request, response);
		} 
		else if ("deleteQuestion".equals(flag)) {
			String quesID = request.getParameter("quesId");
			String flag1 = request.getParameter("flagOld");
			String id = request.getParameter("quizId");
			String quizName = request.getParameter("quizName");
			QuestionDAO questionDAO = new QuestionDAO();
			questionDAO.deleteQuestionByQuestionId(quesID);
			response.sendRedirect("ProfessorController?" + "flag="+ flag1 + "&id="+id + "&quizName=" + quizName);
		}  
		else if ("EditQuestion".equals(flag)) {
			String quesId = request.getParameter("quesId");
			String quizId = request.getParameter("quizId");
			String quizName = request.getParameter("quizName");
			int quizid = Integer.parseInt(quizId);
			List<Question> questions = professorServices.getAllQuestionFromQuizID(quizid);
			List queAnsData = professorServices.getAllAnswersFromQueList(questions);
			request.setAttribute("quesId", quesId);
			request.setAttribute("queAnsData", queAnsData);
			request.getRequestDispatcher("views/canEditQuestion.jsp").forward(request, response);
		}
		else if ("Add Next Question".equals(flag) || "Save and Exit".equals(flag) || "Verify Questions".equals(flag)) {
			
			//professorServices.storeQuestion((Quiz)session.getAttribute("quiz"), question, questionOption1,
			//		questionOption2, questionOption3, questionOption4, correctanswers, points);
			
			professorServices.storeQuestion(request);

        	String addQuestionPageURL = request.getContextPath() + "/ProfessorController";
        	request.setAttribute("profnavigate", addQuestionPageURL); 
        	if("Add Next Question".equals(flag)) {
        		response.sendRedirect("views/addQuestions.jsp");
        	}else if("Save and Exit".equals(flag)) {
        		response.sendRedirect("views/professorLanding.jsp");
        	}
		}else if("Verify Questions".equals(flag)) {
        	response.sendRedirect("views/displayQuestionAnswer.jsp");
        }
    }
}