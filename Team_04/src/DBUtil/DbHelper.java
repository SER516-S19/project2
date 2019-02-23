package DBUtil;

import java.util.Properties;

/**
 * {@code DbHelper} class to fetch the database properties
 */
public class DbHelper {

    //region private members
    private static String DB_URL;
    //endregion

    //region static block
    /**
     * Reads the file with name {@literal DBDetails.properties} and loads
     * the url string for {@code JDBC} connection
     */
    static {
        try {
            Properties dbProperties = new Properties();
            dbProperties.load(DbHelper.class.getClassLoader().getResourceAsStream("DBDetails.properties"));
            DB_URL = dbProperties.getProperty("jdbcUrl");
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    //endregion

    //region Description
    /**
     * @return the local database url string
     */
    public static String getDbUrl() {
        return DB_URL;
    }
    //endregion
}
