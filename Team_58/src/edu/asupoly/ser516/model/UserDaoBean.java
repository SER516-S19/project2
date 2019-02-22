package edu.asupoly.ser516.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 * Class ConnectionFactory to get connection object to establish database connection.
 * Home after login.
 * 
 * @author shivamverma
 * @version 1.1
 * @date 02/21/2019
 */


public class UserDaoBean implements UserDao {

	public static Properties dbProperties = new Properties();
	
	public UserDaoBean() {
		try {
			dbProperties.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("database.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<UserVO> validateAndGet(String userName, String passWord) throws ClassNotFoundException, SQLException, IOException {
		
		List<UserVO> list = new ArrayList<UserVO>();
		
        Connection connection = ConnectionFactory.getConnection();
        ResultSet resultData = null;
        PreparedStatement query = null;
        
        System.out.println("validateAndGet"+ connection);
        System.out.println(dbProperties.getProperty("getUserDetailQuery"));
        
		try{             
			query=connection.prepareStatement(dbProperties.getProperty("getUserDetailQuery"));  
			query.setString(1,userName);  
			query.setString(2,passWord);  
			 
			resultData = query.executeQuery();
		
			while(resultData.next()) {
				String firstname = resultData.getString("firstname");
				String lastname = resultData.getString("lastname"); 
				int phonenumber = resultData.getInt("phonenumber");
				boolean isStudent = resultData.getBoolean("isStudent");
				String email = resultData.getString("email");
				String username = resultData.getString("username");
				int userId = resultData.getInt("userId");
				UserVO userVO = new UserVO(firstname, lastname, phonenumber, isStudent, email, username, userId);
				list.add(userVO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			resultData = null;
			query = null;
			connection = null;
		}
		return list;
	}
}
