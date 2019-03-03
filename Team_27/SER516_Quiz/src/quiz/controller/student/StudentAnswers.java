package quiz.controller.student;

import quiz.model.student.QuizAttempt;

/**
 * 
 * @author Manisha Miriyala, Sumanth
 * @version (1.0)
 */
public class StudentAnswers {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* set Content-Type and other response headers
		response.setHeader("Cache-Control", "no-cache"); */
		String resultRow = "";
		try {
			StudentAttemptDao studentAttempts = new StudentAttemptDao(); 
			ArrayList<QuizAttempt> answers = studentAttempts.getAnswers();
			for(QuizAttempt answer : answers) {
				resultRow += answer + " ";
			}
		}
		catch (Exception exc) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Java Exception at Server");
			exc.printStackTrace();
		}	
		response.setContentType("text/plain");
		response.getWriter().write(resultRow);
	}
}
