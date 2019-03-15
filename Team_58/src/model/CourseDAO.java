package model;

import java.sql.SQLException;
import java.util.List;

/**
 * Interface CourseDAO with the following method:
 * a. get courses assigned to Professor
 * 
 * @author shivamverma
 * @version 1.1
 * @date 03/14/2019
 * 
 **/
public interface CourseDAO {

	public List<CourseVO> getCourseAssignedToProfessor(UserVO userVO) throws SQLException, ClassNotFoundException;
	public CourseVO getCourseInfoForUser(UserVO userVO, int courseID) throws SQLException, ClassNotFoundException;
}
