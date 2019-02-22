package edu.asupoly.ser516.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 * Class CourseDAOBean is a class the 
 * Home after login.
 * 
 * @author shivamverma
 * @version 1.0
 * @date 02/21/2019
 **/

public class CourseDAOBean implements CourseDAO{
	
	private static Properties dbProperties = new Properties();
	
	public CourseDAOBean() throws IOException {
		dbProperties.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("database.properties"));
	}
	
	@Override
	public List<CourseVO> getCourseAssignedToProfessor(UserVO userVO) throws SQLException, ClassNotFoundException {
		
		Connection connection = null;
		PreparedStatement query = null;
		ResultSet resultData = null;
		
		connection = ConnectionFactory.getConnection();
		
		query = connection.prepareStatement(dbProperties.getProperty("getCourseAssignedToProfessorQuery"));
		query.setInt(1, userVO.getUserId());

		resultData = query.executeQuery();

		List<CourseVO> list = new ArrayList<>();

		while (resultData.next()) {
			int courseId = resultData.getInt("courseId");
			String courseName = resultData.getString("courseName");
			String courseNumber = resultData.getString("courseNumber");
			CourseVO course = new CourseVO(courseName, courseNumber, courseId);
			list.add(course);
		}
		
		return list;
	}   
}
