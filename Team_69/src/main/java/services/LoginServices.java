package services;


import dao.UserDAO;

public class LoginServices {

    public String checkUserType(String userEmail){
        UserDAO userDAO = new UserDAO();
        String userType = userDAO.fetchUserDetails(userEmail).getUser_type();
        return userType;
    }

    public int fetchUserId(String userEmail){
        UserDAO userDAO = new UserDAO();
        int userId = userDAO.fetchUserDetails(userEmail).getUser_id();
        return userId;
    }

    public boolean validateUserPassword(String userEmail,String userPassword){
        UserDAO userDAO = new UserDAO();
        String storedPassword = userDAO.fetchUserDetails(userEmail).getPassword();
        if(storedPassword.equals(userPassword))
            return true;
        else return false;

    }

}
