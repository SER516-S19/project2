package content.creator.operations;

import content.creator.constants.Constants;
import content.creator.dao.QuizContentDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.sqlite.JDBC;

/** @author Hari Krishnan Puthiya Veetil, Aman Kaushik */
public final class DataOps {
  private DataOps() {}

  private static Connection getConnection() throws SQLException {
    DriverManager.registerDriver(new JDBC());
    String dbURL = "jdbc:sqlite:quizDatabase.db";
    return DriverManager.getConnection(dbURL);
  }

  private static List<QuizContentDAO> executeGetQuery(String query) throws SQLException {
    try (Connection connection = getConnection()) {
      try (Statement statement = connection.createStatement()) {
        return processQuizContentResultSet(statement.executeQuery(query));
      }
    }
  }

  private static void validateQueryString(String query) throws RuntimeException {
    if (query == null) {
      throw new java.lang.RuntimeException("Query cannot be empty/null");
    }
  }

  private static void executeInsertQuery(String query) throws SQLException {
    try (Connection connection = getConnection()) {
      try (Statement statement = connection.createStatement()) {
        statement.executeUpdate(query);
      }
    }
  }

  public static List<QuizContentDAO> getData(String query) throws RuntimeException, SQLException {
    validateQueryString(query);
    return executeGetQuery(query);
  }

  public static void saveData(String query) throws RuntimeException, SQLException {
    validateQueryString(query);
    executeInsertQuery(query);
  }

  private static List<QuizContentDAO> processQuizContentResultSet(ResultSet rs)
      throws SQLException {
    List<String> colNames = Constants.colNames;
    List<QuizContentDAO> detailsList = new ArrayList<>();
    while (rs.next()) {
      QuizContentDAO quizContentDao = new QuizContentDAO();
      quizContentDao.setQuizId(Integer.parseInt(getColumnValue(rs, colNames.get(0))));
      quizContentDao.setQuesId(Integer.parseInt(getColumnValue(rs, colNames.get(1))));
      quizContentDao.setQuesType(getColumnValue(rs, colNames.get(2)));
      quizContentDao.setQuesDesc(getColumnValue(rs, colNames.get(3)));
      quizContentDao.setAnsId(Integer.parseInt(getColumnValue(rs, colNames.get(4))));
      quizContentDao.setAnsDesc(getColumnValue(rs, colNames.get(5)));
      quizContentDao.setCorrect(Boolean.parseBoolean(getColumnValue(rs, colNames.get(6))));
      quizContentDao.setMaxScore(Integer.parseInt(getColumnValue(rs, colNames.get(7))));
      detailsList.add(quizContentDao);
    }
    return detailsList;
    }

    private static String getColumnValue(ResultSet rs, String columnName) {
      String val;
      try{
        val = rs.getString(columnName);
      } catch (Exception sqExp) {
        val = "0"; // Placeholder value for null
      }
      return val;
    }
}