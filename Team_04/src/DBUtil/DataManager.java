package DBUtil;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * The {@code DataManager} class represents a container {@code JPanel} to display a {@code JLabel}
 * @author Pradeep Ambalam Jawaharlal
 */
public class DataManager {

    //region private members
    private static DataManager dataManager = new DataManager();
    //endregion

    private DataManager() {

    }

    //region public methods
    public static DataManager getInstance() {
        return dataManager;
    }

    public <T> List<T> executeGetQuery(Class<T> responseType, String queryString) {
        Connection connection = getConnection();
        QueryRunner queryRunner = new QueryRunner();
        List<T> result = null;
        ResultSetHandler<List<T>> handler = new BeanListHandler<>(responseType);
        try {
            result = queryRunner.query(connection, queryString, handler);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * @param query  UPDATE Person SET height=? WHERE name=?
     * @param params 2.05, "John Doe"
     * @return number of rows affected
     */
    public int executeUpdateQuery(String query, Object... params) {
        Connection connection = getConnection();
        QueryRunner queryRunner = new QueryRunner();
        int noOfRowsAffected = 0;
        try {
            noOfRowsAffected = queryRunner.update(connection, query, params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return noOfRowsAffected;
    }
    //endregion

    //region private methods

    /**
     * @return a new Database connection
     */
    private Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(DbHelper.getDbUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    //endregion

}
