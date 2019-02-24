package quiz.controller.professor;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import quiz.dao.professor.QuizDetailsDao;
import quiz.exceptions.DataAccessException;

/**
 * The Servlet which is being called when professor enters in his system.
 * 
 * @author (Yuti Desai)
 * @version (1.0)
 * @createDate 18 Feb 2019
 */

/*
 * Servlet implementation class QuizIntroController
 */
public class QuizIntroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * Controller which fetches the titles of the saved quizes from database and redirects it 
	 * to the JSP page. 
	 */	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		QuizDetailsDao quizDetailsDao = new QuizDetailsDao();

		ArrayList rowValues = new ArrayList();
		try {
			rowValues = quizDetailsDao.getAll();
		}
		catch(DataAccessException e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("rowValues", rowValues);
		response.sendRedirect("showQuizes.jsp");


	}

}
