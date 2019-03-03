package Team76.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Team76.Database.ProfInsertQuerry;
import Team76.Entity.DetailsEntity;
import Team76.Entity.QuestionEntity;
import Team76.Entity.QuizEntity;
import Team76.Utilities.DetailsModel;
import Team76.Utilities.QuestionModel;
import Team76.Utilities.ViewGradesModel;

/**
 * Servlet implementation class ProfessorController
 */
@WebServlet("/ProfessorController")
public class ProfessorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	QuestionModel quiz = new QuestionModel();
	QuestionEntity entity = new QuestionEntity();
	DetailsEntity ent1 = new DetailsEntity();
	DetailsModel q = new DetailsModel(); // object of quiz class used for calling fetch method
	ViewGradesModel vc = new ViewGradesModel();
	
	public ProfessorController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
		String action = request.getParameter("action");

		if (action.equals("ProfessorDash")) {
			response.sendRedirect("ProfessorDash.jsp");
		}
		if (action.equals("ViewGrades")) {
			try {
				vc.getParameters(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect("ViewGrades.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null || action.isEmpty()) {
			response.sendRedirect("Login.jsp");
		}
		if (action.equals("CreateQuiz")) {
			response.sendRedirect("CreateQuiz.jsp");
		}
		if (action.equals("ViewGrades")) {
			response.sendRedirect("ViewGrades.jsp");
		}
		if (action.equals("Options")) {
			response.sendRedirect("Options.jsp");
		}
		if (action.equals("Statistics")) {
			response.sendRedirect("Statistics.jsp");
		}
		if (action.equals("Continue")) {
			try {
				quiz.getParameters(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect("Options.jsp");
		}
		if (action.equals("AddQuestion")) {
			response.sendRedirect("Questions.jsp");
		}
		
		if (action.equals("Submit")) {
			 
			response.sendRedirect("ReviewProfQuiz.jsp");
		}
		
		
		if (action.equals("Continue1")) {
			if (request.getParameter("qtype").equals("NonGraded")
					|| request.getParameter("qtype").equals("Practice")) {
				request.setAttribute("visibilty", "invisible");
			}
			try {
				q.getParameters(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}

			RequestDispatcher rd = request.getRequestDispatcher("Questions.jsp");
			rd.forward(request, response);
		}

		if (action.equals("Cancel")) {
			response.sendRedirect("ProfessorDash.jsp");
		}

		if (action.equals("Logout")) {
			response.sendRedirect("ProfessorDash.jsp");
		}
		if (action.equals("ReviewSubmit")) {
			QuizEntity entity=(QuizEntity)request.getSession().getAttribute("quiz");
			try {
				ProfInsertQuerry prof= new ProfInsertQuerry();
				prof.QuestionDetailPage(entity);
				prof.QuestionPage(entity);
				prof.connectionClose();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			response.sendRedirect("ProfessorDash.jsp");
		}
		//	ReviewSubmit

	}

}