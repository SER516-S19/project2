package edu.asu.ser516.blackBoard.quiz.controller;
import java.io.IOException;
import java.sql.Time;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import edu.asu.ser516.blackBoard.quiz.bean.Professor;
import edu.asu.ser516.blackBoard.quiz.bean.Quiz;
import edu.asu.ser516.blackBoard.quiz.dao.ProfessorDAO;


public class ProfessorControllerServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		if("fetchQuizList".equals(flag)){
			System.out.println("Hi!....");
			ProfessorDAO proffessorDAO = new ProfessorDAO();
			List quizList = proffessorDAO.getAllQuizzes();
			request.setAttribute("quizList", quizList);
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/displayQuizDetails.jsp");
			rd.forward(request, response);
			
		}
	}

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        

        String flag = request.getParameter("flag");
		if("InsertProfDetails".equals(flag)){
			String quizName = request.getParameter("name");
	        String quizInstructions = request.getParameter("instructions");
	        String quizType = request.getParameter("quiz_type");
	        String isTimeLimitSet = request.getParameter("time_limit");
	        Time quizTimeLimit = new Time(0);
	        boolean isShuffled = false;
	        boolean isPublished = false;
	        String assignmentGroup = request.getParameter("assignment_group");
	        
	        if(isTimeLimitSet!="null")
	        {
	        	quizTimeLimit = new Time(10);
	        }
	        
	        if(request.getParameter("shuffle")!="null")
	        {
	        	isShuffled = true;
	        }
	        	        
	        
			ProfessorDAO professorDAO = new ProfessorDAO();
			Quiz quiz = new Quiz(quizName, quizInstructions, quizType, quizTimeLimit, isShuffled, isPublished);
			
			professorDAO.insertProfDetails(quiz);
            response.sendRedirect("views/professorDetails.jsp");
        }  

    }

}
