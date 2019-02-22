import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DBSetup {

    private static final String url = "jdbc:sqlite:quiz.db";

    public static final String[] tableCreationSQL = {
            "CREATE TABLE IF NOT EXISTS Quiz (\n" +
                    " id integer PRIMARY KEY, \n" +
                    " title text NOT NULL,\n" +
                    " instructions text NOT NULL,\n" +
                    " shuffle integer NOT NULL,\n" +
                    " timeLimit integer,\n" +
                    " dateOpen text,\n" +
                    " quizType text NOT NULL,\n" +
                    " attempts integer NOT NULL,\n" +
                    " quizGroup text NOT NULL,\n" +
                    " totalPoints real NOT NULL);",

            "CREATE TABLE IF NOT EXISTS Question (\n" +
                    " id integer PRIMARY KEY, \n" +
                    " quiz_fk int NOT NULL, \n" +
                    " quesType text NOT NULL, \n" +
                    " points real NOT NULL, \n" +
                    " timeLimit integer, \n" +
                    " content text NOT NULL);",

            "CREATE TABLE IF NOT EXISTS Choice (\n" +
                    " id integer PRIMARY KEY, \n" +
                    " quiz_fk int NOT NULL, \n" +
                    " content text NOT NULL, \n" +
                    " isCorrect int NOT NULL); \n",

            "CREATE TABLE IF NOT EXISTS Answers (\n" +
                    " id integer PRIMARY KEY, \n" +
                    " submission_fk int NOT NULL, \n" +
                    " ques_fk NOT NULL, \n" +
                    " choice_fk int NOT NULL);",

            "CREATE TABLE IF NOT EXISTS Submission (\n" +
                    " id integer PRIMARY KEY, \n" +
                    " quiz_id integer NOT NULL, \n" +
                    " student_fk integer NOT NULL,\n" +
                    " timeTaken integer NOT NULL,\n" +
                    " dateTaken text NOT NULL, \n" +
                    " dateOpen text NOT NULL, \n" +
                    " score real NOT NULL,\n" +
                    " attempt integer NOT NULL);",

            "CREATE TABLE IF NOT EXISTS Student (\n" +
                    " id integer PRIMARY KEY, \n" +
                    " name text NOT NULL);"
    };

    public static void setup(){
        connect();
        createTables();
    }

    private static void connect() {
        Connection conn = null;
        try {

            conn = DriverManager.getConnection(url);

            System.out.println("success");
        } catch (SQLException sqlex) {
            System.out.println(sqlex.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException sqle) {
                System.out.println(sqle.getMessage());
            }
        }
    }

    private static void createTables() {

        for (int i = 0; i < tableCreationSQL.length; i++){
            try(Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()){
                stmt.execute(tableCreationSQL[i]);
            } catch (SQLException sqle) {
                System.out.println("Error: problem creating table");
            }
        }
    }
}
