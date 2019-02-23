<<<<<<< HEAD:Team_27/SER516_Quiz/src/quiz/controller/professor/AddQuestionsController.java
package quiz.controller.professor;

import javax.servlet.http.HttpServlet;

public class AddQuestionsController extends HttpServlet {
/*
	// Method to handle GET method request.
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// set Content-Type and other response headers
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/html");

		Enumeration paramNames = request.getParameterNames();

		try {
			while (paramNames.hasMoreElements()) {
				String paramName = (String) paramNames.nextElement();

				if (paramName.substring(0, 8) == "question") {

					String questionNumber = paramName.substring(8);

<<<<<<< HEAD
					String[] questionText = request.getParameterValues("question" + questionNumber);

					String[] optionA = request.getParameterValues("OptionAForQues" + questionNumber);
					String[] optionB = request.getParameterValues("OptionBForQues" + questionNumber);
					String[] optionC = request.getParameterValues("OptionCForQues" + questionNumber);
					String[] optionD = request.getParameterValues("OptionDForQues" + questionNumber);
=======
					String questionText = request.getParameter("question" + questionNumber);

					String optionA = request.getParameter("OptionAForQues" + questionNumber);
					String optionB = request.getParameter("OptionBForQues" + questionNumber);
					String optionC = request.getParameter("OptionCForQues" + questionNumber);
					String optionD = request.getParameter("OptionDForQues" + questionNumber);
>>>>>>> 04c2f7c6cc170f58a858fc0a85aef70f59a93fc2

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

					Question questionModel = new Question(questionText, optionA, optionB, optionC, optionD, isOptionACorrect,
							isOptionBCorrect, isOptionCCorrect, isOptionDCorrect, points, isMultipleAnswer);

					QuestionsDao.insert(questionModel);

				}
			}
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
*/
}
=======
package edu.asu.ser516.quiz.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.asu.ser516.quiz.model.Question;
import edu.asu.ser516.quiz.dao.QuestionsDao;

public class AddQuestionsController extends HttpServlet {

	// Method to handle GET method request.
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// set Content-Type and other response headers
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/html");

		Enumeration paramNames = request.getParameterNames();
		//CREATE USER root@localhost IDENTIFIED WITH mysql_native_password BY Allen@123;
		try {
			while (paramNames.hasMoreElements()) {
				String paramName = (String) paramNames.nextElement();

				if (paramName.substring(0, 8) == "question") {

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

					Question questionModel = new Question(questionText, optionA, optionB, optionC, optionD, isOptionACorrect,
							isOptionBCorrect, isOptionCCorrect, isOptionDCorrect, points, isMultipleAnswer);

					QuestionsDao.insert(questionModel);

				}
			}
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
>>>>>>> 41e31430fbee2c9f6fd2d54c384930b6af990e8d:Team_27/SER516_Quiz/src/edu/asu/ser516/quiz/controller/AddQuestionsController.java
