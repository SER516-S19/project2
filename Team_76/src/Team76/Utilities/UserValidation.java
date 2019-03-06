package Team76.Utilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Team76.Database.DatabaseConnection;
import Team76.Entity.UserEntity;

public class UserValidation {
	
	
	public static Boolean validateUser(final UserEntity user) throws Exception {
		Boolean userValidated = Boolean.FALSE;
		Connection con = new DatabaseConnection().establishConnection();
		String query = "SELECT * FROM user WHERE username like '" + user.getUserName()+"'";
		System.out.println(query);
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(query);
		String password = "";
		if(rs.next()) {
			user.setUserId(Integer.parseInt(rs.getString("id")));
			user.setName(rs.getString("name"));
			user.setUserType(rs.getString("usertype"));
			password = rs.getString("password");
		}
		if(password.equals(user.getPassword())) {
			userValidated = Boolean.TRUE;
			user.setPassword("");
		}
		return userValidated;
	}
}
