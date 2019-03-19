package content.creator.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import content.creator.helper.DeleteQuestionHelper;

/*
 * Modified by: Abhishek Gupta
 * Date: 2/28/19
 * Description: Delete an entire quiz.
 *
 * */

@WebServlet(urlPatterns = "/delQues")

public class DeleteQuestionServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			int quizId = Integer.parseInt(request.getParameter("quizid"));
			int quesId = Integer.parseInt(request.getParameter("quesid"));
			DeleteQuestionHelper.removeQues(quizId, quesId);
			response.sendRedirect("./viewContentDetails?quizId=" + quizId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
