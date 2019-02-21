package edu.asu.ser516.blackBoard.quiz.controller;

import java.io.IOException;
import java.sql.Time;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.asu.ser516.blackBoard.quiz.bean.Question;
import edu.asu.ser516.blackBoard.quiz.bean.Quiz;
import edu.asu.ser516.blackBoard.quiz.dao.ProfessorDAO;
import edu.asu.ser516.blackBoard.quiz.dao.QuestionDAO;

public class ProfessorControllerServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		if("fetchQuizList".equalsIgnoreCase(flag)){
			System.out.println("Hi!....");
			ProfessorDAO proffessorDAO = new ProfessorDAO();
			List quizList = proffessorDAO.getAllQuizzes();
			request.setAttribute("quizList", quizList);
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/displayQuizDetails.jsp");
			rd.forward(request, response);
			
		}else if("publishQuiz".equalsIgnoreCase(flag)) {
			String id = request.getParameter("id");
			int quizID = Integer.parseInt(id);
			ProfessorDAO professorDAO = new ProfessorDAO();
			professorDAO.publishQuiz(quizID);
			
		}
	}

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

    	System.out.println("hi fetching question");

        String flag = request.getParameter("flag");
		if("InsertProfDetails".equals(flag)){
			System.out.println("Hi!....");
			String name = request.getParameter("name");
	        String instructions = request.getParameter("instructions");
	        String quiz_type = request.getParameter("quiz_type");
	        String assignment_group = request.getParameter("assignment_group");
	        String shuffle = request.getParameter("shuffle");
	        String time_limit = request.getParameter("time_limit");
	        String attempts = request.getParameter("attempts");

			ProfessorDAO proffessorDAO = new ProfessorDAO();
			//System.out.println("Quiz : "+proffessorDAO.InsertProfDetails());
		
            response.sendRedirect("views/professorDetails.jsp");
		}
		else if("DeleteQuestion".equals(flag)){
			System.out.println("hi fetching question inside");
	        String quesId = request.getParameter("box1");
	        
	        System.out.println(quesId);
	        
			QuestionDAO questionDAO = new QuestionDAO();
			//System.out.println("Quiz : "+proffessorDAO.InsertProfDetails());
			
			questionDAO.deleteQuestionByQuestionId(quesId);
            response.sendRedirect("views/removeQuestionPage.jsp");
            
        }else if("addQuestion".equals(flag)) {
        	String question = request.getParameter("question");
        	String option1 = request.getParameter("option1");
        	String option2 = request.getParameter("option2");
        	String option3 = request.getParameter("option3");
        	String option4 = request.getParameter("option4");
        	
        	Time t = new Time(343443);
        	Quiz quiz = new Quiz("Quiz1","Hello", "Graded",t, false, false );
        	Question q = new Question(quiz, question, 2, false, 25 );
        	QuestionDAO questionDAO = new QuestionDAO();
        	questionDAO.addQuestion(q);
        	System.out.println("Here I AM");
        	
        	String contextURL = request.getContextPath();
        	String addQuestionPageURL = "./ProfessorController";
        	request.setAttribute("profnavigate", addQuestionPageURL); 
        	request.getRequestDispatcher("views/AddQuestions.jsp").forward(request, response);
        	return;
        }
		
		


    }

}
