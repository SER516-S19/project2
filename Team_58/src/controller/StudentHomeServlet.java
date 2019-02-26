package controller;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.QuizDAOBean;
import model.CourseDAOBean;
import model.CourseVO;
import model.QuizVO;
import model.UserVO;
/**
 * StudentHome is a servlet controlling the home page for students
 * 
 * @author Joshua Drumm
 * @version 1.3
 * @date 02/22/2019
 **/

@WebServlet(name = "StudentHome", urlPatterns = "/StudentHome")
public class StudentHomeServlet extends HttpServlet {
	private static Logger log = Logger.getLogger(StudentHomeServlet.class.getName());

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		try {
			res.sendRedirect(req.getContextPath() + "/login.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		try {
			Boolean isCoursesAssigned = false;
			UserVO userVO = (UserVO) req.getAttribute("UserVO");
			HttpSession session = req.getSession();
			session.setAttribute("userVO", userVO);

			try {
				CourseDAOBean courseBean = new CourseDAOBean();
				QuizDAOBean quizBean = new QuizDAOBean();

				if (courseBean.equals(null) || quizBean.equals(null))
					log.info("Database Connection Error");

				List<CourseVO> courseList = courseBean.getCourseAssignedToProfessor(userVO);
				List<QuizVO> quizList = quizBean.getQuizzesForStudent(userVO);
				if (courseList.isEmpty()) {
					session.setAttribute("displayMessage", "No Courses have been assigned to the student");
					log.info("No Courses have been assigned to the student.");
				} else {
					isCoursesAssigned = true;
					HashMap<Integer, String> courses = new HashMap<>();
					for (CourseVO course : courseList)
						courses.put(course.getCourseId(), course.getCourseName());
					session.setAttribute("CourseHashMap", courses);

					HashMap<Integer, String> quizzes = new HashMap<>();
					for (QuizVO quiz : quizList)
						quizzes.put(quiz.getQuizId(), quiz.getQuizTitle());
					session.setAttribute("QuizHashMap", quizzes);
				}
				session.setAttribute("isCourseAssigned", isCoursesAssigned);
				res.sendRedirect(req.getContextPath() + "/studentHome.ftl");
			} catch (Exception e) {
				log.info(e.getMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}