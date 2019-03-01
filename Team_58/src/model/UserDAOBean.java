package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 * This class implements UserDAO interface, establishes database connection 
 * using ConnectionFactory and fetches user information.
 * 
 * @author Aditya Vikram
 * @version 1.1
 * @date 02/22/2019
 */


public class UserDAOBean implements UserDAO {

	public static Properties dbProperties = new Properties();
	
	public UserDAOBean() {
		try {
			dbProperties.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("database.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Makes a connection to the database via ConnectionFactory to gain information about quiz
	 * and returns a custom quiz object to be used by ViewQuizServlet.java
	 * 
	 * @param userName
	 * @param passWord
	 * @throws SQLException in case of database error
	 * @throws ClassNotFoundException in case referencing class does not exist
	 * @throws IOException
	 * @return list UserVO list which returns user data
	 * */
	@Override
	public List<UserVO> getUserInfo(String userName, String passWord) throws ClassNotFoundException, SQLException, IOException {
		
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
		}catch(SQLException sexc){
			sexc.printStackTrace();
		}
		finally {
			resultData = null;
			query = null;
			connection = null;
		}
		return list;
	}

	@Override
	public void updatePassword(String userName, String password)
			throws ClassNotFoundException, SQLException, IOException
	{
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement query = null;
		query=connection.prepareStatement(dbProperties.getProperty("updatePassword"));
		query.setString(2,userName);
		query.setString(1,password);
		query.executeQuery();
	}

}
