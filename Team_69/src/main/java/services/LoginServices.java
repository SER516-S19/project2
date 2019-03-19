package services;

import dao.UserDAO;

/**
 * This is a class to manipulate data for requests from login servlet
 *
 * @author : Jahnvi Rai
 * @version : 1.0
 * @since : 02/25/2019
 */

public class LoginServices {

	public String checkUserType(String userEmail) {
		UserDAO userDAO = new UserDAO();
		String userType = userDAO.fetchUserDetails(userEmail).getUser_type();
		return userType;
	}

	public int fetchUserId(String userEmail) {
		UserDAO userDAO = new UserDAO();
		int userId = userDAO.fetchUserDetails(userEmail).getUser_id();
		return userId;
	}

	public boolean validateUserPassword(String userEmail, String userPassword) {
		UserDAO userDAO = new UserDAO();
		String storedPassword = userDAO.fetchUserDetails(userEmail).getPassword();
		return storedPassword.equals(userPassword);
	}

	public String fetchUserName(String userEmail) {
		UserDAO userDAO = new UserDAO();
		String userName = userDAO.fetchUserDetails(userEmail).getUser_name();
		return userName;
	}
}
