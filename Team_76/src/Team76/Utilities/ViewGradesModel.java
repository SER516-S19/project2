package Team76.Utilities;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* SER-516 Software Agility
* Displays the grade of the selected student using ViewGrades.JSP
* @author Manikanta Chintakunta, mchintak@asu.edu
* @version 1.0
* @since 02-15-19
*/

public class ViewGradesModel {
	GradeDetailsQuery obj = new GradeDetailsQuery();
	/* This retrieves the request and response parameters from the UI.
	 */
	public void getParameters(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("request is " + request.toString());
		String quiztitle = (String) request.getParameter("quiztitle");
		String studentName = (String) request.getParameter("studentName");
		System.out.println("This is my title"+ request.getParameter("quiztitle"));
		System.out.println("This is my name"+ request.getParameter("studentName"));
		obj.connection(quiztitle,studentName);
	}
}
