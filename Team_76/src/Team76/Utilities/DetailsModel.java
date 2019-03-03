package Team76.Utilities;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Team76.Entity.QuizEntity;

public class DetailsModel {

	/**
	 * @author Janani Anand
	 * The method fetches request and response objects from UI and sends
	 * parameters for quering in DB
	 **/

	public void getParameters(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//DetailsPageQuery database = new DetailsPageQuery();
		QuizEntity entity = new QuizEntity();
		entity.setQuizTitle(request.getParameter("quiztitle"));
		entity.setQuizInstruct(request.getParameter("qinstruct"));
		entity.setQuizType(request.getParameter("qtype"));
		entity.setShuffleAns(request.getParameter("shuffleAns"));
		entity.setClockType(request.getParameter("clockType"));
		System.out.println("Entity is " + entity.toString());

		//database.databaseConnect(entity.getQuizTitle(), entity.getQuizInstruct(), entity.getQuizType(),
				//entity.getShuffleAns(), entity.getClockType());

		request.getSession().setAttribute("quiz", entity);
	}
}
