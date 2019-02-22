package DBUtil;

public class DbHelper {
    private static final String DB_URL =
            "jdbc:sqlite:C:/Users/14807/Documents/Project516/project2/Team_04/src/quizDatabase.db";
    public static String getDbUrl() {
        return DB_URL;
    }
}
