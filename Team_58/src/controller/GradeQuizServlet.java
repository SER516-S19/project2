package controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.GradeQuizVO;
import model.GradeQuizVODAOBean;
import model.QuestionsDAOBean;
import model.QuestionsVO;
import model.StudentResponseDAOBean;
import model.StudentResponseVO;

/**
 * Class GradeQuizServlet is a controller that routes the Professor to Grade
 * Dashboard Page from Professor Home Page.
 * 
 * @author akashkadam
 * @version 1.3
 **/
public class GradeQuizServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(ProfessorHomeServlet.class.getName());

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		int quizId = Integer.parseInt(session.getAttribute("quizId").toString());
		String quizName = session.getAttribute("quizName").toString();

		try {
			QuestionsDAOBean questionsDAOBean = new QuestionsDAOBean();

			List<QuestionsVO> questionVOList = questionsDAOBean.getQuestionsInfo(quizId);

			for (QuestionsVO question : questionVOList) {
				StudentResponseDAOBean studentResponseDAOBean = new StudentResponseDAOBean();
				List<StudentResponseVO> studentResponseVOList = studentResponseDAOBean
						.getStudentListFromQuizIdQuestionId(quizId, question.getqId());
				for (StudentResponseVO student : studentResponseVOList) {
					int score = calculateScore(student, question);
					System.out.println("score" + score);
					studentResponseDAOBean.updateStudentResponse(quizId, question.getqId(), student.getUserId(), score);
				}
			}

			GradeQuizVODAOBean quizVODAOBean = new GradeQuizVODAOBean();

			List<GradeQuizVO> gradedQuizList = quizVODAOBean.getgradeQuiz(quizId, quizName);

			session.setAttribute("gradeQuiz", gradedQuizList);
			session.setAttribute("quizName", quizName);

			response.sendRedirect(request.getContextPath() + "/gradeQuiz.ftl");
		} catch (Exception exception) {
			log.info(exception.getMessage());
		}

	}

	private int calculateScore(StudentResponseVO student, QuestionsVO question) {

		int score = 0;
		JSONParser parser = new JSONParser();
		try {
			JSONObject correctAnswersJson = (JSONObject) parser.parse(question.getCorrectAnswer());
			JSONObject studentSelectedAnswersJson = (JSONObject) parser.parse(student.getAnswerSelected());
			int countOfWrongAnswers = 0;
			int countOfCorrectAnswered = 0;
			int countOfCorrectAnswers = correctAnswersJson.size();

			for (Object correctAnswerOption : correctAnswersJson.values()) {
				for (Object selectedAnswerOption : studentSelectedAnswersJson.values()) {
					String selectedAnswerOptionString = (String) selectedAnswerOption;
					String correctAnswerOptionString = (String) correctAnswerOption;
					System.out.println(selectedAnswerOptionString + " " + correctAnswerOptionString);
					if (selectedAnswerOptionString.equals(correctAnswerOptionString)) {
						countOfCorrectAnswered++;
					}
				}
			}
			countOfWrongAnswers = studentSelectedAnswersJson.size() - countOfCorrectAnswered;
			countOfCorrectAnswered = countOfCorrectAnswered - countOfWrongAnswers;
			score = countOfCorrectAnswered <= 0 ? 0
					: (question.getTotalPoints() / countOfCorrectAnswers) * countOfCorrectAnswered;
		} catch (ParseException exception) {

		}

		return score;

	}

}
