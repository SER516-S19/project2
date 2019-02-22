package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbController {

    //region private members and methods
    private static DbController dbController;

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

    private ResultSet executeGetQuery(String query) {
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = getConnection();
            if (connection != null) {
                Statement statement = connection.createStatement();
                resultSet = statement.executeQuery(query);
            }
            else {
                System.out.println("Connection is NULL");
            }
        }
        catch (Exception e) {
            System.out.println("executeGetQuery Exception");
        }
        finally {
           // closeDbConnection(connection);
        }
        return resultSet;
    }

    private boolean isValidQueryString(String query) {
        return ! (query == null || query.length() == 0);
    }

    private void executeInsertQuery(String query) {
        Connection connection = null;
        try {
            connection = getConnection();
            if (connection != null) {
                Statement statement = connection.createStatement();
                statement.executeUpdate(query);
            }
            else {
                System.out.println("Connection is NULL");
            }
        }
        catch (Exception e) {
            System.out.println("Failed in update db query");
        }
        finally {
            closeDbConnection(connection);
        }

    }
    private void closeDbConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //endregion

    //region public methods
    public static DbController getInstance() {
        if (dbController == null) {
            dbController = new DbController();
        }
        return dbController;
    }

    public ResultSet executeQuery(String query) {
        ResultSet resultSet = null;
        if (isValidQueryString(query)) {
            resultSet = executeGetQuery(query);
        } else {
            System.out.println("INVALID QUERY");
        }
        return resultSet;
    }

    public void executeUpdate(String query) {
        if (isValidQueryString(query)) {
            executeInsertQuery(query);
        } else {
            System.out.println("INVALID QUERY");
        }
    }
    //endregion

}

