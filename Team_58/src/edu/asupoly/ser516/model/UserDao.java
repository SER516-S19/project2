package edu.asupoly.ser516.model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {

	public List<UserVO> validateAndGet(String userName, String passWord) throws ClassNotFoundException, SQLException, IOException;
	
}
