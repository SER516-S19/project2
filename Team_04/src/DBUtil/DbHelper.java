package DBUtil;

import java.util.Properties;

public class DbHelper {
    private static String DB_URL ;
    public static String getDbUrl() {
        System.out.println("DB_URL"+DB_URL);
        return DB_URL;
    }

    static {
        try {
            Properties dbProperties = new Properties();
            dbProperties.load(DbHelper.class.getClassLoader().getResourceAsStream("DBDetails.properties"));
            DB_URL    = dbProperties.getProperty("jdbcUrl");
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
