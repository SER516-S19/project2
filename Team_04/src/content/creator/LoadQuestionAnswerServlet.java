package content.creator;

import DBUtil.DataManager;
import student.dto.AnswerOption;
import student.dto.QuizContent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



/**
 * Servlet to load the questions and answers
 */
@WebServlet("/servlet")
public class LoadQuestionAnswerServlet extends HttpServlet {

	String view = "";
	private int score = 0;
	private List<QuizContent> questions = new ArrayList<>();
	private int currentQuestionIndex = 0;

	/**
	 * Function to load the quiz details
	 */
	private void loadQuestionsAnswers() {

		List<QuizContent> questions = DataManager.getInstance().executeGetQuery(QuizContent.class,
				"SELECT * FROM quiz_content group by ques_id");

		for (QuizContent question : questions) {
			List<QuizContent> options = DataManager.getInstance().executeGetQuery(QuizContent.class,
					"SELECT * FROM quiz_content where ques_id=" + question.getQues_id());
			for (QuizContent answerOption : options) {
				question.getAnswerOptions().add(new AnswerOption(answerOption.getAns_id(),
						answerOption.getAns_desc(), answerOption.isIs_correct()));
			}
		}
		this.questions = questions;
	}

	/**
	 * Method to post the quiz results
	 *
	 * @param request  the request from Client
	 * @param response the response from Server
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long userSelectedAns = 0;
		String selectedOptId = request.getParameter("selectedOptionId");
		String ansDesc = (String) request.getAttribute("ansDesc");

		if (selectedOptId == null || selectedOptId.isEmpty()) {
			userSelectedAns = -1;
		} else {

			userSelectedAns = new Long(selectedOptId);
		}

		QuizContent quiz = this.questions.get(currentQuestionIndex - 1);
		for (AnswerOption ans : quiz.getAnswerOptions()) {
			if (ans.getIsCorrect() && userSelectedAns != -1 && userSelectedAns == ans.getAns_id()) {
				score++;
			}
		}

		doGet(request, response);
	}

	/**
	 * Method to get the quiz details from database
	 *
	 * @param request the request from Client
	 * @param response the request from Server
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (this.questions.size() == 0) {
			loadQuestionsAnswers();
		}

		HttpSession session = request.getSession(true);
		String action = request.getParameter("action");

		if (action.isEmpty()) {
			view = "error.jsp";
		} else if (action.equalsIgnoreCase("NEXT") && currentQuestionIndex < questions.size()) {

			request.setAttribute("data", questions.get(currentQuestionIndex));
			currentQuestionIndex += 1;
			view = "questionsanswers.jsp";
			response.setContentType("text/html");
			response.setStatus(response.SC_OK);
			request.getRequestDispatcher(view).forward(request, response);
		} else {
			System.out.println(currentQuestionIndex);
		}
	}
}