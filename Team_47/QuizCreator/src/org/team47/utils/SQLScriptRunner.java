package org.team47.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Runs an sql script on schema.db given a path.
 *
 * @author David Lahtinen
 * @version 1.0
 */
public class SQLScriptRunner {
    private static final String url = "jdbc:sqlite:schema.db";

    public static void run(String filename) throws IOException, SQLException {
        File script = new File(filename);
        Connection conn = DriverManager.getConnection(url);
        Scanner scriptReader = new Scanner(script).useDelimiter(";");
        while (scriptReader.hasNext()) {
            String sql = scriptReader.next();
            Statement stmt = conn.createStatement();
            stmt.addBatch(sql);
            stmt.execute(sql);
        }
    }
}