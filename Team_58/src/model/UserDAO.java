package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * UserDAO is an interface with method to get user information.
 * 
 * @author Aditya Vikram
 * @version 1.4
 * @date 03/14/2019
 **/
public interface UserDAO {

	public List<UserVO> getUserInfo(String userName, String passWord) throws ClassNotFoundException, SQLException, IOException;
	public void updatePassword(String userName, String password) throws ClassNotFoundException, SQLException, IOException;
}
