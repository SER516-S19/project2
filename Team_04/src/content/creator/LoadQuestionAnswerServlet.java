package content.creator;

import com.dao.QuestionAnswerDAO;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/servlet")
public class LoadQuestionAnswerServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		response.setContentType("text/html");
		response.setStatus(response.SC_OK);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		response.setContentType("text/html");
		response.setStatus(response.SC_OK);

		QuestionAnswerDAO qaObj = new QuestionAnswerDAO();

		request.setAttribute("data", qaObj.getResult());

		RequestDispatcher rd =
				request.getRequestDispatcher("questionsanswers.jsp");

		rd.forward(request, response);



	}

}
