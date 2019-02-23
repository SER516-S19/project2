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
 * Servlet implementation class Main
 */

public class QuizActionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private static QuizDetailsDao quizDetailsDao = null;

    public void init(ServletConfig config) throws ServletException {
	// if you forget this your getServletContext() will get a NPE! 
    	super.init(config);
		quizDetailsDao = new QuizDetailsDao();
    }
	
	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		String strActionToPerform = request.getParameter("actonToPerform");
		String selectedQuiz = (String)request.getParameter("selectedQuiz");
		
		if(strActionToPerform.equalsIgnoreCase("delete")) {
			QuizModel quizModel = quizDetailsDao.findByPrimaryKey(selectedQuiz);
			if(quizModel != null) {
				if(quizDetailsDao.delete(quizModel)) {
					request.getSession().getAttribute("rowValues");
					response.sendRedirect("showQuizes.jsp");
				}
				else {
					response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR," Couldn't delete");
				}
			}
			else {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST,"This Quiz doesn't Exist!");
			}
		}
        
		else if(strActionToPerform.equalsIgnoreCase("go")) {
			QuizModel quizModel = quizDetailsDao.findByPrimaryKey(selectedQuiz);
			if(quizModel != null) {
				request.setAttribute("model", quizModel);
				request.getRequestDispatcher("ViewQuiz.jsp").forward(request, response);
			}
			else {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST,"Quiz doesn't exist!");
			}
		}
		else if(strActionToPerform.equalsIgnoreCase("update")) {
			QuizModel quizModel = quizDetailsDao.findByPrimaryKey(selectedQuiz);
			
			if(quizModel != null) {
				request.setAttribute("model", quizModel);
				request.getRequestDispatcher("EditQuiz.jsp").forward(request, response);
			}
			else {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST,"Quiz doesn't exist!");
			}
		}
		else if(strActionToPerform.equalsIgnoreCase("add")) {
			request.getRequestDispatcher("CreateQuiz.html").forward(request, response);
		}
		
	} catch (NoDataFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (DataAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	} 

}
