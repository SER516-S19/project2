package student.dto;

public class UserData {

    private String userName;
    private String password;
    private String userType;
    private double userId;
    private boolean isActive;



    public UserData(String userName, String password, String userType, double userId, boolean isActive) {
        this.userName = userName;
        this.password = password;
        this.userType = userType;
        this.userId = userId;
        this.isActive = isActive;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public double getUserId() {
        return userId;
    }

    public void setUserId(double userId) {
        this.userId = userId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

}
