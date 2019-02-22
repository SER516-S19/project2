package DBUtil;

public class DbHelper {
    private static final String DB_URL =
            "jdbc:sqlite:C:\\SER516\\Team_04\\resources\\quizDatabase.db";
    public static String getDbUrl() {
        return DB_URL;
    }
}
