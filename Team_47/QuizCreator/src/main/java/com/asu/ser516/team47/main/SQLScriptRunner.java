import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SQLScriptRunner {
    String url = "jdbc:sqlite:schema.db";
    File script = null;

    public SQLScriptRunner(String filename) {
        script = new File(filename);
    }

    public void run() throws FileNotFoundException, IOException, SQLException {
        if (script != null) {

            Connection conn = DriverManager.getConnection(url);
            Scanner scriptReader = new Scanner(script).useDelimiter(";");
            while (scriptReader.hasNext()) {
                String sql = scriptReader.next();
                System.out.println(sql);
                Statement stmt = conn.createStatement();
                stmt.addBatch(sql);
                stmt.execute(sql);
            }

            Statement teststmt = conn.createStatement();
            teststmt.execute("SELECT * FROM Quizzes");

        } else throw new FileNotFoundException();
    }


}
