package edu.asupoly.ser516.model;

import java.util.List;

public interface UserDao {

	public List<UserVO> validateAndGet(String userName, String passWord) throws ClassNotFoundException;
	
}
