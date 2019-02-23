package controller;

import java.io.IOException;
import java.sql.Time;
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
			
			HttpSession sess = request.getSession(true);
			sess.setAttribute("quiz", quiz);
		
			professorDAO.insertProfDetails(quiz);
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
            
        }else if("Save".equals(flag)) {
        	String question = request.getParameter("question");
        	String option1 = request.getParameter("option1");
        	String option2 = request.getParameter("option2");
        	String option3 = request.getParameter("option3");
        	String option4 = request.getParameter("option4");
        	String[] correctanswers = (String[]) request.getParameterValues("options"); //correct answers
        	
        	HttpSession sess = request.getSession(true);
			Quiz quiz = (Quiz) sess.getAttribute("quiz");
        	
        	Question q = new Question(quiz, question, 2, false, 25 );
        	
        	QuestionDAO questionDAO = new QuestionDAO();
        	questionDAO.addQuestion(q);
        	
        	for(String s: correctanswers)
        		System.out.println("CorrectAnswe ID is   - " + s);
        	
        	String contextURL = request.getContextPath();
        	String addQuestionPageURL = "./ProfessorController";
        	request.setAttribute("profnavigate", addQuestionPageURL); 
        	request.getRequestDispatcher("views/AddQuestions.jsp").forward(request, response);
        	return;
        }
    }

}
