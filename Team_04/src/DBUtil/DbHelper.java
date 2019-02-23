package DBUtil;

import java.util.Properties;

/**
 * Helper Class to fetch the DB properties
 */
public class DbHelper {

    private static String DB_URL;

    /**
     * @return the DB URL
     */
    public static String getDbUrl() {
        return DB_URL;
    }

    /**
     * This class is going to look for a file named DBDetails.properties in the classpath
     * to get its initial settings
     */
    static {
        try {
            Properties dbProperties = new Properties();
            dbProperties.load(DbHelper.class.getClassLoader().getResourceAsStream("DBDetails.properties"));
            DB_URL = dbProperties.getProperty("jdbcUrl");
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
        }
    }
}
