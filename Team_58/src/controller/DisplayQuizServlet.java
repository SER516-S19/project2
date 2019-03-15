package controller;

import java.util.List;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.QuestionsDAOBean;
import model.displayQuestionsVO;

/*
 *  @Author: Jainish Soni
 *  @Version: 2.0
 *  @Date: 02/28/2019
 * DisplayQuizServlet class is created to display the question of a quiz to the
 * student.
 */
public class DisplayQuizServlet extends HttpServlet {
	

	
	/*
	 * This method will establish the connection with the database and will fetch
	 * every detail to display the quiz for a student.
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		try {
			HttpSession session = req.getSession();
			
			int quizID = Integer.parseInt(req.getParameter("quizId"));
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			QuestionsDAOBean questionBean = new QuestionsDAOBean();

			List<displayQuestionsVO> questions = questionBean.getQuestionsForQuiz(quizID);

			
			session.setAttribute("displayQuestionsVO", questions);
			
			res.sendRedirect(req.getContextPath() + "/displayQuiz.ftl");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) {

	}
}