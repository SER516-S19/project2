package Team76.Utilities;

/**
* SER516-Project2
*  @author Janani Anand, 
*  @since 02/19/2019
*/
import java.sql.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Team76.Entity.DetailsEntity;
import Team76.Entity.QuizEntity;

public class DetailsModel {

	/** The method fetches fetches request and response objects from UI and sends parameters for quering in DB**/
	
	public void getParameters(HttpServletRequest request, HttpServletResponse response) throws Exception {

		DetailsPageQuery database = new DetailsPageQuery();
		QuizEntity entity = new QuizEntity();
		entity.setQuizTitle(request.getParameter("quiztitle"));
		entity.setQuizInstruct(request.getParameter("qinstruct"));
		entity.setQuizType(request.getParameter("qtype"));
		//entity.setShuffleAns(request.getParameter("shuffleAns"));
		//entity.setClocktype(request.getParameter("clockType"));
		System.out.println("Entity is " + entity.toString());

		request.getSession().setAttribute("quiz", entity);
		//database.databaseConnect(entity.getQuiztitle(), entity.getQinstruct(), entity.getQtype(), entity.getShuffleAns(), entity.getClocktype());
		//database.databaseConnect(entity.getQuizTitle(), entity.getQuizInstruct(), entity.getQuizType());


	}
}
