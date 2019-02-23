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

public class ProfessorServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private ProfessorServices professorServices = new ProfessorServices();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		if("fetchQuizList".equalsIgnoreCase(flag)){
			List<Quiz> quizList = professorServices.getAllQuizzes();
			request.setAttribute("quizList", quizList);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/displayQuizDetails.jsp");
			rd.forward(request, response);
			
		}else if("publishQuiz".equalsIgnoreCase(flag)) {
			String id = request.getParameter("id");
			int quizID = Integer.parseInt(id);
			professorServices.publishQuiz(quizID);
			List<Quiz> quizList = professorServices.getAllQuizzes();
			// Display updated quiz list after publish
			request.setAttribute("quizList", quizList);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/displayQuizDetails.jsp");
			rd.forward(request, response);			
			
		}else if("viewQuiz".equalsIgnoreCase(flag)) {
			String id = request.getParameter("id");
			int quizId = Integer.parseInt(id);
			QuestionDAO questionDAO = new QuestionDAO();
			List<Answer> questionList = questionDAO.getQuestionsAndAnswers(quizId);
			request.setAttribute("questionList", questionList);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/displayQuestionAnswer.jsp");
			rd.forward(request, response);
		}
	}

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String flag = request.getParameter("flag");
		if("InsertProfDetails".equals(flag)){
			
			ProfessorServices professorServices = new ProfessorServices();
			professorServices.insertProfDetails(request);
			response.sendRedirect("views/professorDetails.jsp");
		}
		else if("DeleteQuestion".equals(flag)){
			System.out.println("hi fetching question inside");
	        String quesId = request.getParameter("box1");
	        
	        System.out.println(quesId);
	        
			QuestionDAO questionDAO = new QuestionDAO();
			
			questionDAO.deleteQuestionByQuestionId(quesId);
            response.sendRedirect("views/removeQuestionPage.jsp");
            
        }else if("Add Next Question".equals(flag)) {
        	String question = request.getParameter("question");
        	String questionOption1 = request.getParameter("option1");
        	String questionOption2 = request.getParameter("option2");
        	String questionOption3 = request.getParameter("option3");
        	String questionOption4 = request.getParameter("option4");
        	String points = request.getParameter("points");
        	String[] correctanswers = (String[]) request.getParameterValues("options");
     
        	HttpSession sess = request.getSession(true);
			Quiz quiz = (Quiz) sess.getAttribute("quiz");
    
			professorServices = new ProfessorServices();
			professorServices.storeQuestion(quiz, question, questionOption1, questionOption2, questionOption3, questionOption4, correctanswers, points);
			
        	String addQuestionPageURL = request.getContextPath() + "/ProfessorController";
        	request.setAttribute("profnavigate", addQuestionPageURL); 
        	request.getRequestDispatcher("views/addQuestions.jsp").forward(request, response);
        	return;
        }
    }

}
