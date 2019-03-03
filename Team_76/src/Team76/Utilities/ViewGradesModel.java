package Team76.Utilities;

import javax.servlet.http.HttpServletRequest;
import Team76.Entity.ViewGradesEntity;
import javax.servlet.http.HttpServletResponse;

/**
* SER-516 Software Agility
* Displays the grade of the selected student using ViewGrades.JSP
* @author Manikanta Chintakunta, mchintak@asu.edu
* @version 1.0
* @since 02-15-19
*/

public class ViewGradesModel {
	/* This retrieves the request and response parameters from the UI.
	 */
	public void getParameters(HttpServletRequest request, HttpServletResponse response) throws Exception {
		GradeDetailsQuery database = new GradeDetailsQuery();
		ViewGradesEntity entity = new ViewGradesEntity();
		entity.setQuizTitle(request.getParameter("quizTitle"));
		System.out.println("Title is " + entity.getQuizTitle());
		entity.setStudentName(request.getParameter("studentName"));
		entity.setQuizDrop(request.getParameter("quizDrop"));
		
		System.out.println("Entity is " + entity.toString());

		database.databaseConnect(entity.getQuizTitle(), entity.getStudentName(), entity.getQuizDrop());
	}
}
