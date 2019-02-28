package quiz.model.login;

/**
 * A Model class to hold the user login information.
 * 
 * @author Lakshmi Kala Pedarla
 * @version (1.0)
 */
public class Login {
	private String username;
	private String password;
	private String usertype;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

}
