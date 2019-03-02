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
 * author: Hongfei Ju, Xiangwei Zheng
 * version: 1.2
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
			response.sendRedirect("login.jsp");
		} else if (action.equalsIgnoreCase("AttemptQuiz")) {
			List<QuizEntity> quizzes = null;
			StudentQuizModel AttemptQuiz = null;
			try {
				AttemptQuiz = new StudentQuizModel();
				quizzes = AttemptQuiz.list();
			}catch (Exception e) {
				e.printStackTrace();
			}			
			request.getSession().setAttribute("quizzes", quizzes);
			response.sendRedirect("StudentsQuiz.jsp");
		} else if (action.equalsIgnoreCase("StartQuiz")) {
			String quizId = request.getParameter("quizId");
			QuizEntity quiztaken = null;
			QuizInstructModel quizInstruct = null;
			try {
				quizInstruct = new QuizInstructModel();
				quiztaken = quizInstruct.getQuiz(quizId);
			}catch (Exception e) {
				e.printStackTrace();
			}			
			request.getSession().setAttribute("quiztaken", quiztaken);
			response.sendRedirect("QuizInstruct.jsp");	
		} else {
			response.getWriter().println("<font color=red>Something went wrong please login again.</font>");
			response.sendRedirect("login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
