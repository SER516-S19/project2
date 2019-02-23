package edu.asu.ser516.quiz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xpath.internal.operations.Bool;

import edu.asu.ser516.quiz.model.Question;
import edu.asu.ser516.quiz.dao.QuestionsDao;

public class AddQuestionsController extends HttpServlet {

	// Method to handle GET method request.
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// set Content-Type and other response headers
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/html");

		Enumeration paramNames = request.getParameterNames();

		Boolean questionAddedSuccessfully = true;

		try {
			while (paramNames.hasMoreElements()) {
				String paramName = (String) paramNames.nextElement();

				if (paramName.substring(0, 8) == "question") {

					String questionNumber = paramName.substring(8);

					String questionText = request.getParameterValues("question" + questionNumber);

					String optionA = request.getParameterValues("OptionAForQues" + questionNumber);
					String optionB = request.getParameterValues("OptionBForQues" + questionNumber);
					String optionC = request.getParameterValues("OptionCForQues" + questionNumber);
					String optionD = request.getParameterValues("OptionDForQues" + questionNumber);

					String tmp = request.getParameterValues("isOptionACorrectForQues" + questionNumber);
					Boolean isOptionACorrect = (tmp == null) ? false : true;
					tmp = request.getParameterValues("isOptionBCorrectForQues" + questionNumber);
					Boolean isOptionBCorrect = (tmp == null) ? false : true;
					tmp = request.getParameterValues("isOptionCCorrectForQues" + questionNumber);
					Boolean isOptionCCorrect = (tmp == null) ? false : true;
					tmp = request.getParameterValues("isOptionDCorrectForQues" + questionNumber);
					Boolean isOptionDCorrect = (tmp == null) ? false : true;

					Integer points = request.getParameterValues("PointsForQues" + questionNumber);
					tmp = request.getParameterValues("isMultipleAnswerQues" + questionNumber);
					Boolean isMultipleAnswer = (tmp == null) ? false : true;

					Question questionModel = new Question(questionText, optionA, optionB, optionC, optionD, isOptionACorrect,
							isOptionBCorrect, isOptionCCorrect, isOptionDCorrect, points, isMultipleAnswer);

					Boolean isAdded = QuestionsDao.insert(questionModel);

					if (isInserted)
						req.getRequestDispatcher("Success.html").forward(req, res);
					else {
						questionAddedSuccessfully = false;
						break;
					}
				}
			}
		}
		catch (Exception exc) {
			res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Java Exception at Server");
			exc.printStackTrace();
		}

		if (!questionAddedSuccessfully)
			res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Qustion(s) can not be added !");
			
	}

	// Method to handle POST method request.
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
