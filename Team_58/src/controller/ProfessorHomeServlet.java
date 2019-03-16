package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CourseDAOBean;
import model.CourseVO;
import model.UserVO;

/**
 * Class ProfessorHome Servlet is a controller that routes the user to Professor
 * Home after login.
 * 
 * @author shivamverma
 * @version 1.3
 * @date 03/14/2019
 */

public class ProfessorHomeServlet extends HttpServlet{
	
	private static Logger log = Logger.getLogger(ProfessorHomeServlet.class.getName());

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		
	}

	/**
	 * This method is to find the courses assigned to Professor 
	 * and display them in his homepage. 
	 *@param request  Request made to server
	 *@param response  Responses from server
	 *
	 * @throws IOException
	 */	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		Boolean isCoursesAssigned = false;
		UserVO userVO = (UserVO) req.getAttribute("UserVO");
		
		HttpSession session = req.getSession();
		session.setAttribute("userVO", userVO);
		
		try {
			CourseDAOBean courseBean = new CourseDAOBean();
			if(courseBean.equals(null)) {
			}
			List<CourseVO> courseVO = courseBean.getCourseAssignedToProfessor(userVO);
      
			if(courseVO.isEmpty()) {
				session.setAttribute("displayMessage", "No Courses have been assigned to the professor");
				log.info("No Courses have been assigned to the professor.");
			}
			else {
				isCoursesAssigned = true;
				HashMap<Integer, String> course = new HashMap<>();
				for (int i = 0; i < courseVO.size(); i++)
					course.put(courseVO.get(i).getCourseId(), courseVO.get(i).getCourseName());
				session.setAttribute("CourseHashMap", course);
			}
			session.setAttribute("isCoursesAssigned", isCoursesAssigned);
			res.sendRedirect(req.getContextPath() + "/professorHome.ftl");
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}
}
