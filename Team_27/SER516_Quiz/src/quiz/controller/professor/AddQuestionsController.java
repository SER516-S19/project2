package quiz.controller.professor;

import java.io.IOException;
import java.util.Enumeration;
import java.util.regex.Pattern;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quiz.dao.professor.QuestionsDao;
import quiz.model.professor.Question;

@SuppressWarnings("serial")
public class AddQuestionsController extends HttpServlet {

	// Method to handle GET method request.
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// set Content-Type and other response headers
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/html");

		Enumeration paramNames = request.getParameterNames();
		
		try {
			String quizId = request.getSession().getAttribute("quizId").toString();
			
			while (paramNames.hasMoreElements()) {
				String paramName = (String) paramNames.nextElement();
				
				if (paramName.substring(0, 8).equals("question")) {
					String questionNumber = paramName.substring(8);
					
					String questionText = request.getParameter("question" + questionNumber);
					
					String optionA = request.getParameter("OptionAForQues" + questionNumber);
					String optionB = request.getParameter("OptionBForQues" + questionNumber);
					String optionC = request.getParameter("OptionCForQues" + questionNumber);
					String optionD = request.getParameter("OptionDForQues" + questionNumber);

					String tmp = request.getParameter("isOptionACorrectForQues" + questionNumber);
					Boolean isOptionACorrect = (tmp == null) ? false : true;
					tmp = request.getParameter("isOptionBCorrectForQues" + questionNumber);
					Boolean isOptionBCorrect = (tmp == null) ? false : true;
					tmp = request.getParameter("isOptionCCorrectForQues" + questionNumber);
					Boolean isOptionCCorrect = (tmp == null) ? false : true;
					tmp = request.getParameter("isOptionDCorrectForQues" + questionNumber);
					Boolean isOptionDCorrect = (tmp == null) ? false : true;

					String points = request.getParameter("PointsForQues" + questionNumber);
					tmp = request.getParameter("isMultipleAnswerQues" + questionNumber);
					Boolean isMultipleAnswer = (tmp == null) ? false : true;
					
					Question questionModel = new Question(quizId, questionText, optionA, optionB, optionC, optionD, isOptionACorrect,
							isOptionBCorrect, isOptionCCorrect, isOptionDCorrect, points, isMultipleAnswer);
					QuestionsDao.insert(questionModel);

				}
			}
			request.getRequestDispatcher("Success.html").forward(request, response);
		}
		catch (Exception exc) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Java Exception at Server");
			exc.printStackTrace();
		}	
	}

	// Method to handle POST method request.
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}