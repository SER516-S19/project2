import java.io.*;
import javax.servlet.*;
import javax.servelt.http.*;
import java.util.*;

public class SubmissionServlet extends HttpServlet {

	@Override
	public doPost(HttpServletRequest req, HttpServletResponse res) throws 
	ServletException, IOException {
		HashMap<int, ArrayList<int>> answers = new HashMap<int, ArrayList<int>>(); 

		String quizIdField = "quiz_id"
		String studentIdField = "studentId"

		Date submissionDate = Java.util.Date();
		int quizId;
		int studentId;
		int timeTaken;
		int attemptNumber;

		Enumeration paramNames = req.getParameterNames();
		while(paramNames.hasMoreElements()){
			String param = paramNames.nextElement();

			if (param.equals("quiz_id")){
				try {
					int quiz_id = Integer.parseInt(req.getHeader("quiz_id"));
				} catch (NumberFormatException nfe){
					System.out.println("[ERROR]: Invalid quiz_id!");
					throw new IOException();
				}
			} else if (param.equals("student_fk")){
				try {

				}
			}
		}
	}

	private double gradeQuestion(){}

	private intChecker



}