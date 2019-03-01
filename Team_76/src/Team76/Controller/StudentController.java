package Team76.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Team76.Entity.QuizEntity;
import Team76.Utilities.QuizInstructModel;
import Team76.Utilities.StudentQuizModel;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public StudentController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null || action.isEmpty()) {
			System.out.println("**** no acton");
			response.sendRedirect("login.jsp");
		} /*else if (action.equalsIgnoreCase("AttemptQuiz")) {
			System.out.println("**** attempt quiz");
			List<QuizEntity> quizzes = null;
			StudentQuizModel AttemptQuiz;
			try {
				AttemptQuiz = new StudentQuizModel();
				quizzes = AttemptQuiz.list();
			}catch (Exception e) {
				e.printStackTrace();
			}			
			request.getSession().setAttribute("quizzes", quizzes);
			response.sendRedirect("StudentsQuiz.jsp");
		            } */else if (action.equalsIgnoreCase("AttemptQuiz")) {			
			      //} else if (action.equalsIgnoreCase("StartQuiz")) {//TEST
			//Xiangwei
			System.out.println("**** start quiz");
			String quizId = request.getParameter("quizId");
			System.out.println("**** quiz id: " + quizId);
			QuizEntity quiztaken = null;
			QuizInstructModel QuizInstruct;
			try {
				QuizInstruct = new QuizInstructModel();
				quiztaken = QuizInstruct.getquiz("1");
			}catch (Exception e) {
				e.printStackTrace();
			}			
			request.getSession().setAttribute("quiztaken", quiztaken);
			response.sendRedirect("QuizInstruct.jsp");	
			//Xiangwei
			/*System.out.println("**** start quiz");
			String quizId = request.getParameter("quizId");
			System.out.println("**** quiz id: " + quizId);
			QuizEntity quiztaken = null;
			QuizInstructModel QuizInstruct;
			try {
				QuizInstruct = new QuizInstructModel();
				quiztaken = QuizInstruct.getquiz(quizId);
			}catch (Exception e) {
				e.printStackTrace();
			}			
			request.getSession().setAttribute("quiztaken", quiztaken);
			response.sendRedirect("QuizInstruct.jsp");	*/
		} else {
			response.getWriter().println("<font color=red>Something went wrong please login again.</font>");
			response.sendRedirect("login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
