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
 * @version 1.0
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
		log.info("" + courseId);

		try {
			if (courseId == 0) {
				response.sendRedirect(request.getContextPath() + "/studentHome.ftl");
				return;
			}

			log.info("Here 0");
			CourseDAOBean courseBean = new CourseDAOBean();
			log.info("Here 0.1");
			CourseVO courseVO = courseBean.getCourseInfoForUser(userVO, courseId);
			log.info("Here 0.2");
			QuizDAOBean quizBean = new QuizDAOBean();
			log.info("Here 0.3");
			List<QuizVO> quizList = quizBean.getQuizzesForCourse(courseId);
			log.info("Here 0.4");
			if (quizList.isEmpty())
				log.info("No Quizzes exist for this course.");
			
			log.info("Here");
			HashMap<Integer, String> quizzes = new HashMap<>();
			for (QuizVO q : quizList)
				quizzes.put(q.getQuizId(), q.getQuizTitle());
			session.setAttribute("QuizHashMap", quizzes);
			session.setAttribute("courseName", courseVO.getCourseName());
			log.info("Here2");
			response.sendRedirect(request.getContextPath() + "/studentCourseHome.ftl");
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}
}