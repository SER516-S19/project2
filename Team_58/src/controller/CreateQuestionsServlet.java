package controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.QuestionsDAOBean;
import model.QuestionsVO;

/**
 * Class CreateQuestionServlet Servlet is a controller that routes the user to
 * Create Questions after Create Quiz.
 * 
 * @author trupti khatavkar
 * @version 1.4
 * @date 03/14/2019
 */
public class CreateQuestionsServlet extends HttpServlet {
	private static Logger log = Logger.getLogger(CreateQuestionsServlet.class.getName());

	// This servlet will not make any Get requests.
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) {

	}

	/**
	 * This method is to create UI for create questions page
	 * 
	 * @param req Request made to server
	 * @param res Responses from server
	 * @throws IOException
	 */
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

		try {
			String question = req.getParameter("question");
			String correctAnswer = req.getParameter("correctAnswer");
			String incorrectAnswer1 = req.getParameter("incorrectAnswer1");
			String incorrectAnswer2 = req.getParameter("incorrectAnswer2");
			String incorrectAnswer3 = req.getParameter("incorrectAnswer3");
			int totalPoints = Integer.parseInt(req.getParameter("totalPoints"));
			Boolean isMCQ = Boolean.valueOf(req.getParameter("isMCQ"));

			HttpSession session = req.getSession();
			int quizId = (int) session.getAttribute("quizId");

			QuestionsVO questionsVO = new QuestionsVO(quizId, question, correctAnswer, incorrectAnswer1,
					incorrectAnswer2, incorrectAnswer3, totalPoints, isMCQ);
			QuestionsDAOBean qdb = new QuestionsDAOBean();
			qdb.insertingQuestions(questionsVO);

			res.sendRedirect(req.getContextPath() + "/createQuestions.ftl");

			
			if (req.getParameter("logoutProfile") != null) {  
			    session.invalidate();
			    res.sendRedirect("login.jsp");
			    return; 
			}
			
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}
}
