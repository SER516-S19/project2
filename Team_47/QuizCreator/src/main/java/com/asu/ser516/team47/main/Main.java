package com.asu.ser516.team47.main;

import java.io.File;
import java.sql.*;

import com.asu.ser516.team47.servlet.SubmissionServlet;

import com.asu.ser516.team47.utils.SQLScriptRunner;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

public class Main {

    public static void main(String[] args) throws Exception {
        String context_Path = "";
        String base_path = new File("WebContent").getAbsolutePath();
        String url = "jdbc:sqlite:schema.db";

        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir(base_path);
        tomcat.setPort(8080);
        tomcat.getHost().setAppBase(base_path);

        Context context = tomcat.addWebapp(context_Path, base_path);

        String servletName = "SubmissionServlet";

        tomcat.addServlet(context_Path, servletName, new SubmissionServlet());
        context.addServletMappingDecoded("/submit", servletName);

        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
            initialize(conn);
            //}
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //populate the db with test data
        try {
            SQLScriptRunner.run("exampleQuiz.sql");
        } catch( SQLException sqle){
            //Database already contains these entries: Do nothing.
        }
        tomcat.start();
        tomcat.getServer().await();
        conn.close();
    }

    /**
     * Initialize the database if there are errors retrieving it.
     * @param conn
     * @return none
     * @exception SQLException
     */
    public static void initialize(Connection conn) throws SQLException{
        // Initialize the database
        String[] sql = {"CREATE TABLE IF NOT EXISTS professors (\n" +
                "username NVARCHAR(50) PRIMARY KEY NOT NULL,\n" +
                "firstname NVARCHAR(50) NOT NULL,\n" +
                "lastname NVARCHAR(50) NOT NULL,\n" +
                "session CHAR(16),\n" +
                "hashedpass NVARCHAR(60) NOT NULL\n" +
                ");",
                "CREATE TABLE IF NOT EXISTS courses (\n" +
                        "course_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
                        "professor_fk NVARCHAR(50) NOT NULL,\n" +
                        "prefix NVARCHAR(3) NOT NULL,\n" +
                        "suffix NVARCHAR(3) NOT NULL,\n" +
                        "FOREIGN KEY (professor_fk) REFERENCES professors(username) ON DELETE CASCADE\n" +
                        ");",
                "CREATE TABLE IF NOT EXISTS quizzes (\n" +
                        "quiz_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
                        "course_fk INTEGER NOT NULL,\n" +
                        "title NVARCHAR(100) NOT NULL,\n" +
                        "instructions NVARCHAR(500),\n" +
                        "shuffle BOOLEAN NOT NULL,\n" +
                        "time_limit INTEGER,\n" +
                        "date_open DATE NOT NULL,\n" +
                        "date_close DATE,\n" +
                        "quiz_type NVARCHAR(50) NOT NULL,\n" +
                        "attempts INTEGER,\n" +
                        "quiz_group NVARCHAR(50),\n" +
                        "total_points REAL NOT NULL,\n" +
                        "FOREIGN KEY (course_fk) REFERENCES courses(course_id) ON DELETE CASCADE\n" +
                        ");",
                "CREATE TABLE IF NOT EXISTS questions (\n" +
                        "question_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
                        "quiz_fk INTEGER NOT NULL,\n" +
                        "quesType CHAR(2) NOT NULL,\n" +
                        "points REAL NOT NULL,\n" +
                        "content NVARCHAR(300),\n" +
                        "FOREIGN KEY (quiz_fk) REFERENCES quizzes(quiz_id) ON DELETE CASCADE\n" +
                        ");",
                "CREATE TABLE IF NOT EXISTS choices (\n" +
                        "choice_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
                        "question_fk INTEGER NOT NULL,\n" +
                        "correct BOOLEAN NOT NULL,\n" +
                        "content NVARCHAR(200) NOT NULL,\n" +
                        "FOREIGN KEY (question_fk) REFERENCES questions(question_id) ON DELETE CASCADE\n" +
                        ");",
                "CREATE TABLE IF NOT EXISTS students (\n" +
                        "username NVARCHAR(50) PRIMARY KEY NOT NULL,\n" +
                        "firstname NVARCHAR(50) NOT NULL,\n" +
                        "lastname NVARCHAR(50) NOT NULL,\n" +
                        "session CHAR(16),\n" +
                        "hashedpass NVARCHAR(60) NOT NULL\n" +
                        ");",
                "CREATE TABLE IF NOT EXISTS enrolled (\n" +
                        "enrolled_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
                        "course_fk INTEGER NOT NULL,\n" +
                        "student_fk NVARCHAR(50) NOT NULL,\n" +
                        "FOREIGN KEY (course_fk) REFERENCES courses(course_id) ON DELETE CASCADE,\n" +
                        "FOREIGN KEY (student_fk) REFERENCES students(username) ON DELETE CASCADE\n" +
                        ");",
                "CREATE TABLE IF NOT EXISTS submissions (\n" +
                        "submission_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
                        "quiz_fk INTEGER NOT NULL,\n" +
                        "enrolled_fk INTEGER NOT NULL,\n" +
                        "time_taken INTEGER,\n" +
                        "date_taken DATE,\n" +
                        "score REAL,\n" +
                        "attempt INTEGER,\n" +
                        "FOREIGN KEY (quiz_fk) REFERENCES quizzes(quiz_id) ON DELETE CASCADE,\n" +
                        "FOREIGN KEY (enrolled_fk) REFERENCES enrolled(enrolled_id) ON DELETE CASCADE\n" +
                        ");",
                "CREATE TABLE IF NOT EXISTS answers (\n" +
                        "answer_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
                        "submission_fk INTEGER NOT NULL,\n" +
                        "question_fk INTEGER NOT NULL,\n" +
                        "choice_fk INTEGER NOT NULL,\n" +
                        "FOREIGN KEY (submission_fk) REFERENCES submissions(submission_id) ON DELETE CASCADE,\n" +
                        "FOREIGN KEY (question_fk) REFERENCES questions(question_id) ON DELETE CASCADE,\n" +
                        "FOREIGN KEY (choice_fk) REFERENCES choices(choice_id) ON DELETE CASCADE\n" +
                        ");"};
        Statement state = conn.createStatement();
        for(int i = 0; i < sql.length; i++){
            state.executeUpdate(sql[i]);
        }
    }
}