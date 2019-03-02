/*
 * package Team76.Utilities; import java.sql.Connection; import
 * java.sql.DriverManager; import java.sql.SQLException; import
 * java.sql.PreparedStatement; import java.sql.ResultSet; import
 * java.util.ArrayList; import java.util.List; import
 * java.text.SimpleDateFormat; import java.util.Date;
 * 
 * import Team76.Database.DatabaseConnection; import Team76.Entity.QuizEntity;
 * import Team76.Entity.ResponseStats;
 * 
 * public class StudentAnswerModel{ private DatabaseConnection connect = null;
 * private Connection conn = null; private Statement stmt = null; private String
 * dbname = "ser516p2";
 * 
 * public StudentAnswerModel(){ try { connect = new DatabaseConnection(); conn =
 * connect.establishConnection(); dbname = "ser516p2"; } catch (Throwable t) {
 * t.printStackTrace(); } } public String storeResponses(String studentResponse)
 * { QuizDetails Response =
 * StudentAnswerModel.convertStringtoJSON(studentResponse); int quizId =
 * Response.getQuizId(); ResponseStats statR = new ResponseStats();
 * ResponseStatistics stats; List<QuestionDetails> questions =
 * jsonResponse.getQuestion(); Quiz quiz = new Quiz(quizId,
 * jsonResponse.getQuizTitle(), jsonResponse.getQuizInstruct(),
 * jsonResponse.getQuizType(), jsonResponse.getTimeLimit()); for
 * (QuestionDetails questionMapper : questions) { int questionId =
 * questionMapper.getQuestionId(); Question question = new Question(quiz,
 * questionId, questionMapper.getQuestion(), questionMapper.getMarks());
 * List<AnswerDetails> answers = questionMapper.getResponseAnswer(); if (answers
 * != null) { for (AnswerDetails ansMapper : answers) { Answer answer = new
 * Answer(question, ansMapper.getAnswerId(), ansMapper.getAnswer(),
 * ansMapper.getCorrectAnswer()); stats = new ResponseStatistics(user, quiz,
 * question, answer); statR.insertStudentResponse(stats); } } }
 * 
 * return "succesfullystoredanswers";
 * 
 * } public static QuizDetails convertStringtoJSON(String studentResponse) {
 * Gson gson = new Gson(); QuizDetails quizList = gson.fromJson(studentResponse,
 * QuizEnity.class); return quizList; } public List<String> fetchAllQuizNames(){
 * QuizEntity quizEntity = new QuizEntity(); return
 * quizEntity.fetchAllQuizNames(); }
 * 
 * public int fetchQuizId(String quizName){ QuizEntity quizEntity = new
 * QuizEntity(); return quizEntity.fetchQuizId(quizName); }
 * 
 * public List<String> fetchQuizStatus(List<String> quizNames){ List<String>
 * status = new ArrayList<>(); ResponseStats statR = new ResponseStats();
 * for(String quizName : quizNames) { int quizID = fetchQuizId(quizName); long
 * count = statR.checkQuizStatus(quizID); if(count>=1){ status.add("Answered");
 * } else { status.add("Unanswered"); } }
 * 
 * return status; }
 * 
 * public List<Integer> fetchAllQuizIds(List<String> quizNames){ List<Integer>
 * quizIds = new ArrayList<>(); for(String quizName : quizNames){ int quizId =
 * fetchQuizId(quizName); quizIds.add(quizId); } return quizIds; }
 * 
 * public String getCurrentDateTime() { String pattern = "MMM dd HH:mm";
 * SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern); String
 * dateTime = simpleDateFormat.format(new Date()); return dateTime; }
 * 
 * }
 */