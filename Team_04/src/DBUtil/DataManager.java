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
 * The {@code DataManager} class represents a singleton controller for database CRUD operations
 * @author Pradeep Ambalam Jawaharlal
 */
public class DataManager {

    //region private members
    private static DataManager dataManager = new DataManager();
    //endregion

    //region public methods

    /**
     * @return a singleton instance of {@code DataManager} class
     */
    public static DataManager getInstance() {
        return dataManager;
    }

    /**
     * Executes the fetch type queries in the database
     * @param queryString SQL query string to perform fetch operations
     * @param <T> Class Type representing the single row in the table
     * @return collection of {@code T}
     */
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
     * @param query
     * Update the values in the database
     * @param params
     * Changes the values of the parameters
     * @return
     * returns the number of rows effected
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
     * private constructor to enforce singleton pattern
     */
    private DataManager() {

    }

    /**
     * Creates a new {@code Connection} instance
     * @return a new {@code Connection} instance
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
