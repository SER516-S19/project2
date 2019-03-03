package Team76.Controller;

import java.sql.*;

public class StudentQuizInfoController {
   public static void main(String[] args) {
      try {
         Class.forName("org.apache.derby.jdbc.ClientDriver");
      } catch(ClassNotFoundException e) {
         System.out.println("Class not found "+ e);
      }
      try {
    	  String userid = "root";
    	  String password = "199021";
         Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/ser516p2",userid, password);
         
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM quiz");
         System.out.println("id    status  DueDate    Timelimit");
         
         while (rs.next()) {
        	int quizid = rs.getInt("QuizId"); 
            String status = rs.getString("status");
            String DueDate = rs.getString("DueDate");
            String Timelimit = rs.getString("Timelimit");
            System.out.println(quizid+"    "+status+"   "+DueDate+"    "+Timelimit);
         }
      } catch(SQLException e) {
         System.out.println("SQL exception occured" + e);
      }
   }
}