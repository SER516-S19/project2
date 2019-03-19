package quiz.controller.professor;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quiz.dao.professor.QuizDetailsDao;
import quiz.model.professor.QuizModel;

/**
 * A servlet which creates a new quiz and edits old quiz for professor.
 * 
 * @author (Shefali Anand)
 * @version (1.0)
 * @createDate (19 Feb 2019)
 */

@SuppressWarnings("serial")
public class QuizDetailsController extends HttpServlet {

	private static QuizDetailsDao quizDetailsDao = null;

	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		quizDetailsDao = new QuizDetailsDao();
	}

	/* This method create the quiz details and directs to Adding Question page
	 * It also edits the quiz details and directs to Editing Questions for this quiz*/
	@SuppressWarnings("static-access")
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// set Content-Type and other response headers
		res.setHeader("Cache-Control", "no-cache");
		res.setContentType("text/html");

		// process request headers

		// process request parameters
		String action = req.getParameter("Action");
		String title = req.getParameter("title");
		String instructions = req.getParameter("instructions");
		String assignmentGroup = req.getParameter("assignmentGroup");
		String shuffled = req.getParameter("shuffled");
		String graded = req.getParameter("graded");
		String time = req.getParameter("timeLimit");
		String multipleAttempt = req.getParameter("multipleAttempt");

		Boolean isShuffled = false;
		Boolean isGraded = false;
		Integer timeLimit = 0;
		Boolean isMultipleAttempt = false;

		// perform processing and aggregate response payload
		try {
			if (action.equals("Add Questions")) {
					if (title != null && Pattern.matches("[0-9][0-9]*", time)) {


					if (shuffled != null && shuffled.equals("true"))
						isShuffled = true;
					if (graded != null && graded.equals("true"))
						isGraded = true;
					if (time != null)
						timeLimit = Integer.valueOf(time);
					if (multipleAttempt != null && multipleAttempt.equals("true"))
						isMultipleAttempt = true;

					QuizModel quizModel = quizDetailsDao.findByPrimaryKey(title);

					if (quizModel != null)
						res.sendError(HttpServletResponse.SC_BAD_REQUEST, "This Quiz already Exists!");
					else {
						quizModel = new QuizModel(title, instructions, assignmentGroup, isShuffled, isGraded, timeLimit,
								isMultipleAttempt);
						quizDetailsDao.insert(quizModel);
						req.getSession().setAttribute("rowValues", quizDetailsDao.getAll());

						String quizId = quizDetailsDao.getQuizId(title);
						req.getSession().setAttribute("quizId", quizId);
						req.getSession().setAttribute("quizTitle", title);
						req.getRequestDispatcher("/updateQuestions").forward(req, res);
					}

				} else {
					res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Wrong Parameters Sent!");
				}
			} else if (action.equals("Update Questions")) {
				if (title != null && Pattern.matches("[0-9][0-9]*", time)) {

					if (shuffled != null && shuffled.equals("true"))
						isShuffled = true;
					if (graded != null && graded.equals("true"))
						isGraded = true;
					if (time != null)
						timeLimit = Integer.valueOf(time);
					if (multipleAttempt != null && multipleAttempt.equals("true"))
						isMultipleAttempt = true;

					QuizModel quizModel = quizDetailsDao.findByPrimaryKey(title);
					String quizId = quizDetailsDao.getQuizId(title);
					req.getSession().setAttribute("quizId", quizId);

					if (quizModel == null)
						res.sendError(HttpServletResponse.SC_BAD_REQUEST, "This Quiz doesn't Exist!");
					else {
						quizModel = new QuizModel(title, instructions, assignmentGroup, isShuffled, isGraded, timeLimit,
								isMultipleAttempt);
						quizDetailsDao.update(quizModel);
						req.getRequestDispatcher("/updateQuestions").forward(req, res);
					}

				} else {
					res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Wrong Parameters Sent!");
				}
			}
			else if (action.equals("View Questions")) {
				String quizId = quizDetailsDao.getQuizId(title);
				req.getSession().setAttribute("quizId", quizId);
				req.getRequestDispatcher("/viewQuestions").forward(req, res);
			}
			else {
				req.getRequestDispatcher("showQuizes.jsp").forward(req, res);
			}
		} catch (Exception exc) {
			res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Java Exception at Server");
			exc.printStackTrace();
		}

	}

	/* This method will return an error as this servlet should be accessed in POST method */
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setHeader("Cache-Control", "no-cache");
		res.setContentType("text/html");
		res.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED, "GET not supported by this servlet");
	}
}
