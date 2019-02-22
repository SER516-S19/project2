package DBUtil;

public class DbHelper {
    private static final String DB_URL =
            "jdbc:sqlite:/Users/aj/Developer/SER-516/project2/Team_04/resources/quizDatabase.db";
    public static String getDbUrl() {
        return DB_URL;
    }
}
