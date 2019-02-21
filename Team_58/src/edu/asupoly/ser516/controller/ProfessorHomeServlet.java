package edu.asupoly.ser516.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.asupoly.ser516.model.CourseVO;
import edu.asupoly.ser516.model.UserVO;

/**
 * Class ProfessorHome Servlet is a controller that routes the user to Professor
 * Home after login.
 * 
 * @author shivamverma
 * @version 1.1
 * @date 02/20/2019
 **/

public class ProfessorHomeServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) {

	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

		UserVO obj = (UserVO) req.getAttribute("UserVO");
		HttpSession session = req.getSession();
		session.setAttribute("profFirstName", obj.getFirstname());

		System.out.println("profName: " + session.getAttribute("profFirstName"));

		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			String hostName = "showtimefinder.database.windows.net"; // update me
			String dbName = "ser516_db"; // update me
			String user = "scrum_mates@showtimefinder"; // update me
			String password = "Azure@Cloud"; // update me
			String url = String.format(
					"jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
							+ "hostNameInCertificate=*.database.windows.net;loginTimeout=30;",
					hostName, dbName, user, password);
			Connection connection = null;
			connection = DriverManager.getConnection(url);
			String schema;
			schema = connection.getSchema();
			System.out.println("Successful connection - Schema: " + schema);

			PreparedStatement query;
			query = connection.prepareStatement("select * from [dbo].[Course] A" + " join [dbo].[UserCourseMApping] B"
					+ " on A.courseId = B.courseId" + " where B.userId = ?");
			query.setInt(1, obj.getUserId());

			ResultSet resultData = query.executeQuery();

			List<CourseVO> list = new ArrayList<>();

			while (resultData.next()) {
				int courseId = resultData.getInt("courseId");
				String courseName = resultData.getString("courseName");
				String courseNumber = resultData.getString("courseNumber");
				CourseVO course = new CourseVO(courseName, courseNumber, courseId);
				list.add(course);
			}

			HashMap<Integer, String> course = new HashMap<>();
			for (int i = 0; i < list.size(); i++)
				course.put(list.get(i).getCourseId(), list.get(i).getCourseName());

			session.setAttribute("CourseHashMap", course);

			System.out.println(req.getContextPath() + "/professorHome.ftl");

			res.sendRedirect(req.getContextPath() + "/professorHome.ftl");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}