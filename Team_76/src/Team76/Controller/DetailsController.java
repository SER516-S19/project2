package Team76.Controller;

/**
* SER516-Project2
*  @author Janani Anand, 
*  @since 02/19/2019
*/
import java.sql.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DetailsController {

	/** The method fetches fetches request and response objects from UI and sends parameters for quering in DB**/
	
	public void getParameters(HttpServletRequest request, HttpServletResponse response) throws Exception {

		DatabaseConnect database = new DatabaseConnect();
		DetailsEntity entity = new DetailsEntity();
		entity.setQuiztitle(request.getParameter("quiztitle"));
		entity.setQinstruct(request.getParameter("qinstruct"));
		entity.setQtype(request.getParameter("qtype"));
		System.out.println("Entity is " + entity.toString());

		database.databaseConnect(entity.getQuiztitle(), entity.getQinstruct(), entity.getQtype());
		

	}
}
