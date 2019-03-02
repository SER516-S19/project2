package Team76.Utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Team76.Entity.QuestionEntity;

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
		String concatoptions = entity.getOption1();
		concatoptions = concatoptions.concat("$$@").concat(entity.getOption2()).concat("$$@").concat(entity.getOption3())
				.concat("$$@").concat(entity.getOption4());

		entity.setAnswer(request.getParameter("correctanswer"));
		entity.setMarks(request.getParameter("marks"));

		questionsList.add(entity);
		request.getSession().setAttribute("question", questionsList);
		
		database.databaseConnect(entity.getQuestion(), concatoptions, entity.getAnswer());

	}

}
