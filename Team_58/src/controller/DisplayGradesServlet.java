package controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.GradeQuizVO;
import model.GradeQuizVODAO;
import model.GradeQuizVODAOBean;
import model.UserVO;

import java.sql.PreparedStatement;
import javax.servlet.annotation.WebServlet;

import java.util.List;
import java.util.logging.Logger;
/**
 * Display grades of the quiz
 * @author Dhruv Patel
 * @version 1.1
 * @date 03/1/2019
 **/

@WebServlet(name = "DisplayGradesServlet", urlPatterns = "/displayGrades")
public class DisplayGradesServlet extends HttpServlet {
	
	/**
	 * This method is to get Grades
	 *@param request  req made to server
	 *@param response  res from server
	 *
	 * @throws IOException
	 */
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        try {
        	HttpSession session = req.getSession();
    		UserVO userVO = (UserVO) session.getAttribute("userVO");
			
    		GradeQuizVODAOBean gradeQuizVODAOBean = new GradeQuizVODAOBean();
			List<GradeQuizVO> grades = gradeQuizVODAOBean.getQuizGradesForStudent(userVO.getUserId());
    		session.setAttribute("Grades", grades);
			
			res.sendRedirect(req.getContextPath() + "/displayGrades.ftl");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) {

	}
}
