package content.creator.operations;

import DBUtil.DbHelper;
import content.creator.constants.Constants;
import content.creator.dao.QuizContentDAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import content.creator.dao.QuesResponseDAO;
import content.creator.dao.QuizResultDAO;

import org.sqlite.JDBC;

/** @author Hari Krishnan Puthiya Veetil, Aman Kaushik */
public final class DataOps {


  private DataOps() {}

  private static Connection getConnection() throws SQLException {
    DriverManager.registerDriver(new JDBC());
    String dbUrl = "jdbc:sqlite:/Users/devstation/Github/project2/Team_04/resources/quizDatabase.db";//null;
    /*try {
    Properties dbProperties = new Properties();
    dbProperties.load(DbHelper.class.getClassLoader().getResourceAsStream("DBDetails.properties"));
    dbUrl = dbProperties.getProperty("jdbcUrl");
    } catch (IOException ioExp) {
      System.out.println(ioExp.getMessage());
    }*/
    return DriverManager.getConnection(dbUrl);
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

  public static List<QuizContentDAO> getDataCreateContent(String query) throws RuntimeException, SQLException {
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

  public static List<QuesResponseDAO> getDataQuesResponse(String query) throws RuntimeException, SQLException {
    validateQueryString(query);
    return executeQuesResponseQuery(query);
  }
  public static List<QuizResultDAO> getDataQuizResult(String query) throws RuntimeException, SQLException {
    validateQueryString(query);
    return executeQuizResultQuery(query);
  }
  private static List<QuesResponseDAO> executeQuesResponseQuery(String query) throws SQLException {
    try (Connection connection = getConnection()) {
      try (Statement statement = connection.createStatement()) {
        return processQuesResponseResultSet(statement.executeQuery(query));
      }
    }
  }
  private static List<QuizResultDAO> executeQuizResultQuery(String query) throws SQLException {
    try (Connection connection = getConnection()) {
      try (Statement statement = connection.createStatement()) {
        return processQuizResultSet(statement.executeQuery(query));
      }
    }
  }
    private static List<QuesResponseDAO> processQuesResponseResultSet(ResultSet rs)
      throws SQLException {
      List<String> colNames = Constants.colNames;
      List<QuesResponseDAO> detailsList = new ArrayList<>();
      while (rs.next()) {
        QuesResponseDAO quesResponseDAO = new QuesResponseDAO();
        quesResponseDAO.setStudentId(Integer.parseInt(getColumnValue(rs, colNames.get(0))));
        quesResponseDAO.setAttemptId(Integer.parseInt(getColumnValue(rs, colNames.get(1))));
        quesResponseDAO.setQuizId(Integer.parseInt(getColumnValue(rs, colNames.get(2))));
        quesResponseDAO.setQuesId(Integer.parseInt(getColumnValue(rs, colNames.get(3))));
        quesResponseDAO.setAnsId(Integer.parseInt(getColumnValue(rs, colNames.get(4))));
        quesResponseDAO.setTotalScore(Integer.parseInt(getColumnValue(rs, colNames.get(5))));
        DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
        Date attemptedOnDate = new Date();
        try {
          attemptedOnDate = dateFormat.parse(getColumnValue(rs, colNames.get(6)));
        } catch (ParseException e) {
          e.printStackTrace();
        }
        quesResponseDAO.setAttemptedOn(attemptedOnDate);
        quesResponseDAO.setTimeTaken(Integer.parseInt(getColumnValue(rs, colNames.get(7))));
        quesResponseDAO.setFinal(Boolean.parseBoolean(getColumnValue(rs, colNames.get(8))));
        detailsList.add(quesResponseDAO);
      }
      return detailsList;
    }
    private static List<QuizResultDAO> processQuizResultSet(ResultSet rs)
      throws SQLException {
      List<String> colNames = Constants.colNamesQuizResult;
      List<QuizResultDAO> detailsList = new ArrayList<>();
      while (rs.next()) {
        QuizResultDAO quizResultDAO = new QuizResultDAO();
        quizResultDAO.setQuizId(Integer.parseInt(getColumnValue(rs, colNames.get(0))));
        quizResultDAO.setAttemptId(Integer.parseInt(getColumnValue(rs, colNames.get(1))));
        quizResultDAO.setStudentId(Integer.parseInt(getColumnValue(rs, colNames.get(2))));
        quizResultDAO.setFinalScore((int)Float.parseFloat(getColumnValue(rs, colNames.get(3))));
        detailsList.add(quizResultDAO);
      }
      return detailsList;
    }

    private static Properties getProperties() {
    Properties dbProperties = new Properties();
    try {
      dbProperties.load(DbHelper.class.getClassLoader().getResourceAsStream("DBDetails.properties"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return dbProperties;
  }

  public static String getNamesFromProperty(String property) {
    Properties properties = getProperties();
    return properties.getProperty(property);
  }
}
