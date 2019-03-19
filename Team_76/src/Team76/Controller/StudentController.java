package Team76.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Team76.Database.StudentInsertQuery;
import Team76.Entity.GradeEntity;
import Team76.Entity.Questions;
import Team76.Entity.QuizEntity;
import Team76.Entity.UserEntity;
import Team76.Utilities.FetchQuestionsQuery;
import Team76.Utilities.GradeModel;
import Team76.Utilities.QuizInstructModel;
import Team76.Utilities.StudentQuizModel;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null || action.isEmpty()) {
			System.out.println("**** no acton");
			response.sendRedirect("login.jsp");
		} else if (action.equalsIgnoreCase("ViewGrade")) {
			UserEntity user = (UserEntity) request.getSession().getAttribute("user");
			List<GradeEntity> grades = new GradeModel().getGrade(user.getUserId());
			request.getSession().setAttribute("grades", grades);
			response.sendRedirect("StudentViewGrade.jsp");
		} else if (action.equalsIgnoreCase("DashBoard")) {
			response.sendRedirect("StudentDash.jsp");
		} else if (action.equalsIgnoreCase("ViewQuiz")) {
			System.out.println("**** attempt quiz");
			List<QuizEntity> quizzes = null;
			StudentQuizModel viewQuiz;
			try {
				viewQuiz = new StudentQuizModel();
				quizzes = viewQuiz.list();
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.getSession().setAttribute("quizzes", quizzes);
			response.sendRedirect("StudentsQuiz.jsp");
		} else if (action.equalsIgnoreCase("StartQuiz")) {
			System.out.println("**** start quiz");
			String quizId = request.getParameter("quizId");
			String timeLimit = request.getParameter("timeLimit");
			request.getSession().setAttribute("quizId", quizId);
			request.getSession().setAttribute("timeLimit", timeLimit);
			System.out.println("**** quiz id: " + quizId);
			QuizEntity quiztaken = null;
			QuizInstructModel quizInstruct = null;
			try {
				quizInstruct = new QuizInstructModel();

				quiztaken = quizInstruct.getQuiz(quizId);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.getSession().setAttribute("quiztaken", quiztaken);
			response.sendRedirect("QuizInstruct.jsp");
		} else if (action.equalsIgnoreCase("AttemptQuiz")) {
			String quizId = (String) request.getSession().getAttribute("quizId");
			try {
				List<Questions> questions = new FetchQuestionsQuery().fetchQuestions(quizId);
				request.getSession().setAttribute("Question", questions);
				request.getSession().setAttribute("quizId", quizId);
				response.sendRedirect("Quiz.jsp");
			} catch (Exception e) {
				response.getWriter().println("<font color=red>An Exception occured.</font>");
				response.sendRedirect("Login.jsp");
			}
		} else if (action.equalsIgnoreCase("SubmitQuiz")) {
			int quizId, studentId, questionId, marks = 0;
			String answer;
			List<Questions> questionArray = (List) request.getSession().getAttribute("questions");

			StudentInsertQuery row = null;
			try {
				row = new StudentInsertQuery();
				String solution[] = null;
				String quizTitle, studentName;
				int grade = 0;
				quizId = Integer.parseInt(request.getSession().getAttribute("quizId").toString());
				studentId = ((UserEntity) request.getSession().getAttribute("user")).getUserId();
				for (Questions que : questionArray) {
					marks = 0;
					questionId = Integer.parseInt(que.getQuestionId());
					answer = request.getParameter(que.getQuestionId());
					answer=answer.trim();
					System.out.println("answer is " + answer);
					System.out.println("Que Id " + questionId);
					solution = row.getSolution(questionId);
					solution[1]=solution[1].trim();
					if (solution[1].equalsIgnoreCase(answer)) {
						System.out.println("sol1 " + solution[1] + "and " + solution[0]);
						marks = Integer.parseInt(solution[0]);
					}
					row.answerEntry(studentId, questionId, quizId, marks, answer);
				}
				quizTitle = row.getQuizName(quizId);
				studentName = row.getStudentName(studentId);
				grade = row.getGrade(quizId, studentId);
				row.gradeEntry(studentId, quizId, quizTitle, studentName, grade);
				row.connectionClose();
			} catch (Exception e) {

				e.printStackTrace();
			}
			response.sendRedirect("StudentDash.jsp");
		} else {
			response.getWriter().println("<font color=red>Somethng went wrong please login again.</font>");
			response.sendRedirect("login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}