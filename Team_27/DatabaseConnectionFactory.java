import java.sql.*;

import com.mysql.jdbc.Statement;

public class DatabaseConnectionFactory {

	private static String dbURL="jdbc:mysql://localhost:3306/project2_team27?useSSL=false";
	private static String dbUser="root";
	private static String dbPassword="Ser516";

	public static void main(String [] args)
	{
		 
		try{
			Connection con= DriverManager.getConnection(dbURL,dbUser,dbPassword);
			try {
				   Class.forName("com.mysql.jdbc.Driver");
				   Statement st= (Statement) con.createStatement();
				   ResultSet rs= st.executeQuery("SELECT * FROM quiz;");
				   while(rs.next())
				   {
					   System.out.println(rs.getString(1));
					   System.out.println(rs.getString(2));
					   System.out.println(rs.getString(3));
					   System.out.println("-----------------------------------");
					   
				   }
				   
				}
				catch(ClassNotFoundException ex) {
				   System.out.println("Error: unable to load driver class!");
				   System.exit(1);
				}			
		     
		   }
		  catch(SQLException sqe){ System.out.println("Error: While Creating connection to database");sqe.printStackTrace();}
	}

}