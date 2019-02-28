package quiz.controller.professor;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import quiz.dao.professor.QuizDetailsDao;
import quiz.exceptions.DataAccessException;
import quiz.exceptions.NoDataFoundException;
import quiz.model.professor.QuizModel;

/**
 * A servlet which controls add a new quiz,update and go to particular quiz and delete a quiz for the professor.
 * 
 * @author (Palak Chugh)
 * @version (1.0)
 * @createDate (20 Feb 2019)
 */


public class QuizActionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static QuizDetailsDao quizDetailsDao = null;

	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		quizDetailsDao = new QuizDetailsDao();
	}

	/* This method manages the quiz introduction page.It deletes the quiz selected from the drop down.	 
	 * It directs to create Quiz page for adding a new quiz. It allows to update the parameters
	 * of the quiz by redirecting to redirects to update quiz detail page
	 * It also redirects to Quiz detail page showing the details for the selected quiz.*/
	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// perform processing and selects the action based on the button click
		try {
			String strActionToPerform = request.getParameter("actonToPerform");
			String selectedQuiz = (String) request.getParameter("selectedQuiz");

			// Block for deleting the quiz.
			if (strActionToPerform.equalsIgnoreCase("delete")) {
				QuizModel quizModel = quizDetailsDao.findByPrimaryKey(selectedQuiz);
				if (quizModel != null) {
					
					
					if (quizDetailsDao.delete(quizModel)) {
						request.getSession().setAttribute("rowValues", quizDetailsDao.getAll());
						response.sendRedirect("showQuizes.jsp");
					} else {
						response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, " Couldn't delete");
					}
				} else {
					response.sendError(HttpServletResponse.SC_BAD_REQUEST, "This Quiz doesn't Exist!");
				}
			}

			//Block for redirecting to selected quiz detail page.
			else if (strActionToPerform.equalsIgnoreCase("go")) {
				QuizModel quizModel = quizDetailsDao.findByPrimaryKey(selectedQuiz);
				if (quizModel != null) {
					request.setAttribute("model", quizModel);
					request.getRequestDispatcher("ViewQuiz.jsp").forward(request, response);
				} else {
					response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Quiz doesn't exist!");
				}
			} 

			// Block for updating the details of the selected quiz.
			else if (strActionToPerform.equalsIgnoreCase("update")) {
				QuizModel quizModel = quizDetailsDao.findByPrimaryKey(selectedQuiz);
				if (quizModel != null) {
					request.setAttribute("model", quizModel);
					request.getRequestDispatcher("EditQuiz.jsp").forward(request, response);
				} else {
					response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Quiz doesn't exist!");
				}
			} else if (strActionToPerform.equalsIgnoreCase("add")) {
				request.getRequestDispatcher("CreateQuiz.html").forward(request, response);
			}

		} catch (NoDataFoundException e) {
			e.printStackTrace();
		} 
		catch (DataAccessException e) {
			e.printStackTrace();
		}

	}

}
