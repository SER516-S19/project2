package controller;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CourseDAOBean;
import model.CourseVO;
import model.QuizDAOBean;
import model.QuizVO;
import model.UserVO;

/**
 * Class CourseDashboardServlet is a controller that routes the User to Course
 * Dashboard Page from Student Home Page.
 * 
 * @author Joshua Drumm
 * @version 2.0
 * @date 02/28/2019
 **/

@WebServlet(name = "StudentCourseHome", urlPatterns = "/StudentCourseHome")
public class StudentCourseDashboardServlet extends HttpServlet {

	private static Logger log = Logger.getLogger(CourseDashboardServlet.class.getName());

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("userVO");
		int courseId = 0;
		if (request.getParameter("CourseId") != null)
			courseId = Integer.parseInt(request.getParameter("CourseId"));
		else
			courseId = (int) session.getAttribute("courseId");

		try {
			if (courseId == 0) {
				response.sendRedirect(request.getContextPath() + "/studentHome.ftl");
				return;
			}

			CourseDAOBean courseBean = new CourseDAOBean();
			CourseVO courseVO = courseBean.getCourseInfoForUser(userVO, courseId);
			QuizDAOBean quizBean = new QuizDAOBean();
			List<QuizVO> quizList = quizBean.getQuizzesForCourse(courseId);
			if (quizList.isEmpty())
				log.info("No Quizzes exist for this course.");
			
			HashMap<Integer, String> quizzes = new HashMap<>();
			for (QuizVO q : quizList)
				quizzes.put(q.getQuizId(), q.getQuizTitle());
			session.setAttribute("QuizHashMap", quizzes);
			session.setAttribute("courseName", courseVO.getCourseName());
			session.setAttribute("courseId", courseId);
			response.sendRedirect(request.getContextPath() + "/studentCourseHome.ftl");
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}
}