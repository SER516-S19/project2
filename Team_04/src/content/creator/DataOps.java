package content.creator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;


/** @author Hari Krishnan Puthiya Veetil, Aman Kaushik */
public class DataOps {

  private Connection getConnection() throws SQLException {
    String dbURL = "jdbc:sqlite:../quizDatabase.db";
    return DriverManager.getConnection(dbURL);
  }

  private ResultSet executeGetQuery(String query) throws SQLException {
    try (Connection connection = getConnection()) {
      try (Statement statement = connection.createStatement()) {
        return statement.executeQuery(query);
      }
    }
  }

  private void validateQueryString(String query) throws RuntimeException {
    if (query == null) {
      throw new java.lang.RuntimeException("Query cannot be empty/null");
    }
  }

  private void executeInsertQuery(String query) throws SQLException {
    try (Connection connection = getConnection()) {
      try (Statement statement = connection.createStatement()) {
        statement.executeUpdate(query);
      }
    }
  }

  public ResultSet getData(String query) throws RuntimeException, SQLException {
    validateQueryString(query);
    return executeGetQuery(query);
  }

  public void saveData(String query) throws RuntimeException, SQLException {
    validateQueryString(query);
    executeInsertQuery(query);
  }

  public QuizResultsDAO getQuizResultsDAO() {
    return new QuizResultsDAO();
  }

  public QuizContentDAO getQuizContextDAO() {
    return new QuizContentDAO();
  }

  public List<Integer> getQuizList() {

    List<Integer> list = new ArrayList<Integer>();
    try (ResultSet rs = executeGetQuery("SELECT DISTINCT quiz_id FROM quiz_content")) {
      while (rs.next()) {
        list.add(rs.getInt("quiz_id"));
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return list;
  }

}
