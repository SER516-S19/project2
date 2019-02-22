package content.creator;

import DBUtil.DataManager;
import com.dao.QuestionAnswerDAO;
import com.model.QuestionAnswers;
import student.dto.AnswerOption;
import student.dto.QuizContent;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/servlet")
public class LoadQuestionAnswerServlet extends HttpServlet {
	String view = "";

	private List<QuizContent> questions = new ArrayList<>();
	private int currentQuestionIndex = 0;

	private void loadQuestions() {
		List<QuizContent> questions = DataManager.getInstance().executeGetQuery(QuizContent.class, "SELECT * FROM quiz_content group by ques_id");
		for (QuizContent question : questions) {
			List<QuizContent> options = DataManager.getInstance().executeGetQuery(QuizContent.class, "SELECT * FROM quiz_content where ques_id="+question.getQues_id());
			for (QuizContent answerOption: options) {
				question.getAnswerOptions().add(new AnswerOption(answerOption.getAns_id(), answerOption.getAns_desc()));
			}
		}
		this.questions = questions;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		if (this.questions.size() == 0) {
			loadQuestions();
		}

		HttpSession session = request.getSession(true);
		String action = request.getParameter("action");
		if (action.isEmpty())
		{
			view="error.jsp";
		}
		else if(action.equalsIgnoreCase("NEXT") && currentQuestionIndex < questions.size())
			{

				request.setAttribute("data", questions.get(currentQuestionIndex));
				currentQuestionIndex += 1;
				view = "questionsanswers.jsp";
				response.setContentType("text/html");
				response.setStatus(response.SC_OK);
				request.getRequestDispatcher(view).forward(request, response);

			}
		else {

		}




	}

}
