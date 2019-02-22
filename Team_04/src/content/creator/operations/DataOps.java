package content.creator.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
<<<<<<< HEAD:Team_04/src/content/creator/DataOps.java
import java.util.List;
import java.util.ArrayList;
=======
import org.sqlite.JDBC;
>>>>>>> b73c6173b4486e6b6888daa728055ca1ebe1f350:Team_04/src/content/creator/operations/DataOps.java

/** @author Hari Krishnan Puthiya Veetil, Aman Kaushik */
public final class DataOps {
  private DataOps() {}

  private static Connection getConnection() throws SQLException {
    DriverManager.registerDriver(new JDBC());
    String dbURL = "jdbc:sqlite:../../quizDatabase.db";
    return DriverManager.getConnection(dbURL);
  }

  private static ResultSet executeGetQuery(String query) throws SQLException {
    try (Connection connection = getConnection()) {
      try (Statement statement = connection.createStatement()) {
        return statement.executeQuery(query);
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

  public static ResultSet getData(String query) throws RuntimeException, SQLException {
    validateQueryString(query);
    return executeGetQuery(query);
  }

  public static void saveData(String query) throws RuntimeException, SQLException {
    validateQueryString(query);
    executeInsertQuery(query);
  }
<<<<<<< HEAD:Team_04/src/content/creator/DataOps.java

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

=======
>>>>>>> b73c6173b4486e6b6888daa728055ca1ebe1f350:Team_04/src/content/creator/operations/DataOps.java
}
