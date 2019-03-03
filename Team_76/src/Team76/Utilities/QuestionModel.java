package Team76.Utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Team76.Entity.QuestionEntity;
import Team76.Entity.QuizEntity;

/**
 * SER516-Project2 File content- Captures the Quiz Questions Information from UI
 * 
 * @author Nikhila Saini,nsaini3@asu.edu
 * @since 02/19/2019
 *
 **/

public class QuestionModel {
	List<QuestionEntity> questionsList;

	/*
	 * This method fetches request and response objects from UserInterface Passes
	 * the result to query the database
	 */

	public void getParameters(HttpServletRequest request, HttpServletResponse response) throws Exception {
		questionsList = new ArrayList();
		QuestionPageQuery database = new QuestionPageQuery();
		QuestionEntity entity = new QuestionEntity();

		entity.setQuestion(request.getParameter("question"));
		entity.setOption1(request.getParameter("option1"));
		entity.setOption2(request.getParameter("option2"));
		entity.setOption3(request.getParameter("option3"));
		entity.setOption4(request.getParameter("option4"));
		String concatoptions = entity.getOption1()+"$$@"+entity.getOption2()+"$$@"+entity.getOption3()+"$$@"+entity.getOption4();
		
		System.out.println(" concat string is "+concatoptions);

		entity.setAnswer(request.getParameter("correctanswer"));
		entity.setMarks(request.getParameter("marks"));

		
		QuizEntity quizDetails = (QuizEntity) request.getSession().getAttribute("quiz");
		quizDetails.setQuestionsList(entity);
		request.getSession().setAttribute("quiz", quizDetails);
		System.out.println("List is " + request.getSession().getAttribute("quiz").toString());
	
		
		//database.databaseConnect(entity.getQuestion(), concatoptions, entity.getAnswer());

	}

}
