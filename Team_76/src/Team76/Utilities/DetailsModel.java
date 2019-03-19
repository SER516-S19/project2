package Team76.Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

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

		QuizEntity entity = new QuizEntity();
		int timelimit;
		Date parsed;
		try {
			timelimit = Integer.parseInt(request.getParameter("timelimit"));
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			parsed = format.parse(request.getParameter("duedate"));
		}
		catch(Exception e) {
			timelimit=30;
			parsed=null;
		}
		entity.setQuizTitle(request.getParameter("quiztitle"));
		entity.setQuizInstruct(request.getParameter("qinstruct"));
		entity.setQuizType(request.getParameter("qtype"));
		entity.setClockType(request.getParameter("clockType"));
		entity.setTimeLimit(timelimit);
		entity.setDueDate(parsed);
		

		request.getSession().setAttribute("quiz", entity);
	}
}