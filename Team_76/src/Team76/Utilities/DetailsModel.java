package Team76.Utilities;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Team76.Entity.DetailsEntity;

public class DetailsModel {

	/**
	 * The method fetches fetches request and response objects from UI and sends
	 * parameters for quering in DB
	 **/

	public void getParameters(HttpServletRequest request, HttpServletResponse response) throws Exception {

		DetailsPageQuery database = new DetailsPageQuery();
		DetailsEntity entity = new DetailsEntity();
		entity.setQuiztitle(request.getParameter("quiztitle"));
		entity.setQinstruct(request.getParameter("qinstruct"));
		entity.setQtype(request.getParameter("qtype"));
		entity.setShuffleAns(request.getParameter("shuffleAns"));
		entity.setClocktype(request.getParameter("clockType"));
		System.out.println("Entity is " + entity.toString());

		database.databaseConnect(entity.getQuiztitle(), entity.getQinstruct(), entity.getQtype(),
				entity.getShuffleAns(), entity.getClocktype());

	}
}
