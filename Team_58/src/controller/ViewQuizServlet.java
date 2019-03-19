package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.QuestionsDAOBean;
import model.QuizDAOBean;
import model.QuestionsVO;
import model.QuizVO;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 * Servlet code takes quizId from courseDashboard.ftl and renders a page
 * displaying information about the quiz and it's questions.
 * 
 * @author Aditya Samant / @author akashkadam
 * @version 1.3
 * @see resources/courseDashboard.ftl
 * @see model/ViewQuizDAOBean.java
 * @see model/QuestionsDAOBean.java
 * @see resources/viewQuiz.ftl
 */
public class ViewQuizServlet extends HttpServlet {
	private static final long serialVersionUID = -1008363826217594704L;


	// This servlet will not make any Get requests.
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) {

	}

	/**
	 * Grabs quizId from courseDashboard and renders viewQuiz page
	 * 
	 * @param req Request made to server
	 * @param res Responses from server
	 *
	 * @throws IOException
	 * @throws ServletException
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession session = req.getSession();
		int quizId = 0;
		List<QuestionsVO> quizQuestions = new ArrayList<QuestionsVO>();
		if (req.getParameterMap().containsKey("Quiz")) {
			quizId = Integer.parseInt(req.getParameter("Quiz"));
		}

		String question = new String();
		String[] ansOne = null; // get param vals
		String answer = new String();
		String one = new String();
		String two = new String();
		String three = new String();
		int pts = 0;
		int questId = 0;
		// get info from viewQuiz page
		if (req.getParameterMap().containsKey("question")) {
			question = req.getParameter("question");
			System.out.println("Question " + question);
		}

		if (req.getParameterMap().containsKey("answer")) {
			ansOne = req.getParameterValues("answer");
			answer = ansOne[0];
			System.out.println("Answer: " + answer);
		}

		if (req.getParameterMap().containsKey("one")) {
			one = req.getParameter("one");
		}

		if (req.getParameterMap().containsKey("two")) {
			two = req.getParameter("two");
		}

		if (req.getParameterMap().containsKey("three")) {
			three = req.getParameter("three");
		}
		if (req.getParameterMap().containsKey("points")) {
			pts = Integer.parseInt(req.getParameter("points"));
		}
		if (req.getParameterMap().containsKey("questId")) {
			questId = Integer.parseInt(req.getParameter("questId"));
		}

		// Get today's date for comparison
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		Date today = new Date(cal.getTime().getTime());
		boolean isAfter = false;

		// counter to addup and get total points for the quiz
		int total = 0;

		try {

			QuizDAOBean bean = new QuizDAOBean();
			QuizVO quiz = bean.getQuizInfo(quizId);

			QuestionsDAOBean bean2 = new QuestionsDAOBean();

			if (question.isEmpty() == false) {
				bean2.updateQuestionsTable(question, answer, one, two, three, pts, questId);
			}

			quizQuestions = bean2.getQuestionsInfo(quizId);

			JSONParser parser = new JSONParser();
			JSONObject jo = new JSONObject();
			for (int i = 0; i < quizQuestions.size(); i++) {
				int points = quizQuestions.get(i).getTotalPoints();
				total += points;

				StringBuilder temp = new StringBuilder();
				String temp2 = "correctAnswer";
				String ans = quizQuestions.get(i).getCorrectAnswer();
				jo = (JSONObject) parser.parse(ans);
				for (int j = 1; j <= jo.size(); j++) {
					temp.append((String) jo.get(temp2 + Integer.toString(j)));
					if (jo.size() != j) {
						temp.append(", ");
					}
				}
				ans = temp.toString();
				quizQuestions.get(i).setCorrectAnswer(ans);
			}

			Date scheduledDate = quiz.getQuizScheduledDate();
			if (scheduledDate.before(today)) {
				isAfter = true;
			}

			// Add Quiz info to Session attributes
			session.setAttribute("quizId", quizId);
			session.setAttribute("Grade", quiz.isGraded());
			session.setAttribute("Schedule", quiz.getQuizScheduledDate());
			session.setAttribute("Directions", quiz.getQuizInstruction());
			session.setAttribute("isAfter", isAfter);
			session.setAttribute("QuizQuestions", quizQuestions);
			session.setAttribute("quizName", quiz.getQuizTitle());
			session.setAttribute("Total", total);

			res.sendRedirect(req.getContextPath() + "/viewQuiz.ftl");

			if (req.getParameter("logoutProfile") != null) {
				session.invalidate();
				res.sendRedirect("login.jsp");
				return;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}