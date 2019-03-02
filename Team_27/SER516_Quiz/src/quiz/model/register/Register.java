package quiz.model.register;

/**
 * A Java class used for modelling New Users in MySQL
 * Database into JDBC
 * 
 * @author (Palak Chugh),(Yuti Desai)
 * @version (1.0)
 * @createDate (25 Feb 2019)
 */

public class Register {
	private String fullName;
	private String email;
	private String userName;
	private String user_type;
	private String password;
	public Register() {}

	/* A constructor that sets all the member variables */
	public Register(String fullName, String email, String userName,String user_type,String password) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.userName = userName;
		this.user_type = user_type;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserType() {
		return user_type;
	}
	public void setUserType(String user_type) {
		this.user_type = user_type;
	}	 
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
}
