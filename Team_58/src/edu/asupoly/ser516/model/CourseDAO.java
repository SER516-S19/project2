package edu.asupoly.ser516.model;

import java.sql.SQLException;
import java.util.List;

/**
 * Interface CourseDAO with the following method:
 * 	a. get courses assigned to Professor
 * 
 * @author shivamverma
 * @version 1.0
 * @date 02/21/2019
 * 
 **/

public interface CourseDAO {

	public List<CourseVO> getCourseAssignedToProfessor(UserVO userVO) throws SQLException, ClassNotFoundException;
}
