package services;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
  import java.io.*;
  import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.FileInputStream; 
import java.util.Properties;
// This class can be used to initialize the database connection 
public class DatabaseConnection { 
        private static String __jdbcUrl;
        private static String __jdbcUser=null;
        private static String __jdbcPasswd=null;
        private static String __jdbcDriver=null;
    public static Connection createConnection() 
        throws SQLException, ClassNotFoundException 
    { 
        // Initialize all the information regarding 
        // Database Connection


        System.out.println(__jdbcDriver);
                Connection con = null;
        String dbDriver = __jdbcDriver; 
        String dbURL = __jdbcUrl; 
        String dbUsername = __jdbcUser; 
        String dbPassword = __jdbcPasswd; 
        try 
        {

            Class.forName(dbDriver); //loading MySQL drivers. This differs for database servers 
        } 
        catch (ClassNotFoundException e)
        {   

            e.printStackTrace();
        }
        try 
        {

            con = DriverManager.getConnection(dbURL, dbUsername, dbPassword); //attempting to connect to MySQL database

            System.out.println("Printing connection object "+con);
        } 
        catch (Exception e)
        {   

                    
            e.printStackTrace();
        }

             return con; 
        
    }

        // This class is going to look for a file named rdbm.properties in the classpath
    // to get its initial settings
    static {
        try {
            Properties dbProperties = new Properties();
            dbProperties.load(DatabaseConnection.class.getClassLoader().getResourceAsStream("rdbm.properties"));
            __jdbcUrl    = dbProperties.getProperty("jdbcUrl");
            __jdbcUser   = dbProperties.getProperty("jdbcUser");
            __jdbcPasswd = dbProperties.getProperty("jdbcPasswd");
            __jdbcDriver = dbProperties.getProperty("jdbcDriver");
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
        }
    }



}