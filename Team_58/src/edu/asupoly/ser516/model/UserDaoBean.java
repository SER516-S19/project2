package edu.asupoly.ser516.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoBean implements UserDao {

	@Override
	public List<UserVO> validateAndGet(String userName, String passWord) throws ClassNotFoundException {
		List<UserVO> list = new ArrayList<UserVO>();
		// Connect to database
		
	    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        String hostName = "showtimefinder.database.windows.net"; // update me
        String dbName = "ser516_db"; // update me
        String user = "scrum_mates@showtimefinder"; // update me
        String password = "Azure@Cloud"; // update me
        String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
            + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        Connection connection = null;
		
		try{ 
			connection = DriverManager.getConnection(url);
            String schema = connection.getSchema();
            System.out.println("Successful connection - Schema: " + schema);
            
			PreparedStatement query=connection.prepareStatement("select * from [dbo].[UserDetails] where username=? and password=?");  
			query.setString(1,userName);  
			query.setString(2,passWord);  
			      
			ResultSet resultData = query.executeQuery();
		
			while(resultData.next()) {
				String firstname = resultData.getString("firstname");
				String lastname = resultData.getString("lastname"); 
				int phonenumber = resultData.getInt("phonenumber");
				boolean isStudent = resultData.getBoolean("isStudent");
				String email = resultData.getString("email");
				String username = resultData.getString("username");
				int userId = resultData.getInt("userId");
				UserVO obj = new UserVO(firstname, lastname, phonenumber, isStudent, email, username, userId);
				list.add(obj);
			}
		}catch(Exception e){
			System.out.println(e);
		}
		return list;
	}
}
