package student.servlet;

import DBUtil.DataManager;

import student.dto.AnswerOption;
import student.dto.QuizContent;
import com.validation.InputValidation;
import sun.security.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * The {@code QuestionAnswerServlet} class represents a web servlet.
 * It includes methods to load questions from the database,insert answers,
 * submit answers to the database.
 *
 * @author Ankita Shivanand Bhandari
 */
@WebServlet("/servlet")
public class QuestionAnswerServlet extends HttpServlet {

    private QuizContent currentQuestion = null;
    private String view = "";
    private List<QuizContent> questions = new ArrayList<>();
    private int currentQuestionIndex = 0;
    private int totalScore = 0;
    private int questionNumber = 0;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MMM-dd-yyyy");
    private String dates = dateFormat.format(new Date());
    private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    private String time = timeFormat.format(new Date());
    private int attemptId = (int) (System.currentTimeMillis() & 0xfffffff);
    private int studentId = (int) (System.currentTimeMillis() & 0xfffffff);

    /**
     * Inserts the question response to the database
     */
    private void executeInsertQuery() {

        for (String selectedOption : currentQuestion.getSelectedAnswers()) {
            String updateQuery = "INSERT INTO ques_response(quesId," +
                    "quizId,ansId,attemptId,studentId,totalScore, attemptedOn," +
                    " timeTaken, isFinal) VALUES(?,?,?,?,?,?,?,?,?)";
            int numOfRowsAffected = DataManager.getInstance().
                    executeUpdateQuery(updateQuery,
                            currentQuestion.getQuesId(),
                            currentQuestion.getQuizId(),
                            selectedOption, attemptId, studentId,
                            currentQuestion.getScore(), dates, time, true);
        }

    }

    /**
     * Function to load the quiz details from DB
     */
    private void loadQuestionsAnswers() {

        List<QuizContent> questions = DataManager.getInstance().executeGetQuery(QuizContent.class,
                "SELECT * FROM quiz_content where quizId='1' group by quesId");

        for (QuizContent question : questions) {
            List<QuizContent> options = DataManager.getInstance().executeGetQuery(QuizContent.class,
                    "SELECT * FROM quiz_content where quizId='1' and quesId=" +
                            question.getQuesId());
            for (QuizContent answerOption : options) {
                question.getAnswerOptions().add(new AnswerOption(answerOption.getAnsId(),
                        answerOption.getAnsDesc(), answerOption.getIsCorrect()));
            }
        }
        this.questions = questions;
    }

    /**
     * Function to submit the quiz results to DB
     */
    private void executeSubmitEntry() {

        String submitQuizQuery = "insert into quiz_result(quizId, attemptId," +
                " studentId, finalScore) values (?,?,?,?)";
        DataManager.getInstance().executeUpdateQuery(submitQuizQuery,
                currentQuestion.getQuizId(), attemptId, studentId, totalScore);
    }

    /**
     * Method to post the quiz results
     *
     * @param request  the request from Client
     * @param response the response from Server
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        InputValidation validObj = new InputValidation();
        if(!request.getParameter("username").isEmpty() || !request.getParameter("password").isEmpty())
        {
            InputValidation input = new InputValidation();
            String name = request.getParameter("username");
            String password = request.getParameter("password");
            input.loginValidation(name,password);
        }
        if (request.getParameterMap().containsKey("selectedOptionId") && currentQuestionIndex <= questions.size()) {
            switch (currentQuestion.getQuesType()) {
                case "SA":
                    String[] radioSelection = {request.getParameter("selectedOptionId")};
                    currentQuestion.setSelectedAnswers(Arrays.asList(radioSelection));
                    totalScore += computeScore(currentQuestionIndex - 1,
                            currentQuestion.getSelectedAnswers());
                    break;
                case "MA":
                    String[] checkBoxSelection = request.getParameterValues("selectedOptionId");
                    currentQuestion.setSelectedAnswers(Arrays.asList(checkBoxSelection));
                    totalScore += computeScore(currentQuestionIndex - 1,
                            currentQuestion.getSelectedAnswers());
                    break;
                case "TA":
                    break;
            }
        }
        if (action.equalsIgnoreCase("SignUp")) {
            String userName = request.getParameter("username");
            String passWord = request.getParameter("password");
            String userType = request.getParameter("userTypeBtn");
            if(validObj.signupValidation(userName, passWord, userType).equals("returningUser"))
            {
                request.setAttribute("userStatus", "returningUser");
            }
            else{
                request.setAttribute("userStatus", "newUser");
            }
            request.setAttribute("userEntName", userName);
            view = "loginPage.jsp";
        }
        else
        {
            executeInsertQuery();
            if (currentQuestionIndex == questions.size()) {
                executeSubmitEntry();
            }
        }
        doGet(request, response);
    }

    /**
     * Method to calculate the score
     *
     * @param currentQuestionIndex index of the current question
     * @param selectedOptions      list of selected options
     * @return
     */
    private int computeScore(int currentQuestionIndex, List<String> selectedOptions) {
        int actualCorrectAnsCount = 0, totalCorrectAnsCount = 0;
        int result;
        QuizContent currentQuestion = questions.get(currentQuestionIndex);
        for (AnswerOption answerOption : currentQuestion.getAnswerOptions()) {
            boolean isCorrectAns = answerOption.getIsCorrect();
            boolean isSelected = selectedOptions.contains(Long.toString(answerOption.getAnsId()));
            if (isCorrectAns) {
                totalCorrectAnsCount += 1;
                actualCorrectAnsCount = isSelected ? actualCorrectAnsCount + 1 : actualCorrectAnsCount - 1;
            } else if (isSelected) {
                actualCorrectAnsCount -= 1;
            }
        }
        if (totalCorrectAnsCount != 0 && actualCorrectAnsCount > 0) {
            result = (int) ((actualCorrectAnsCount / totalCorrectAnsCount) *
                    currentQuestion.getMaxScore());
        } else {
            result = 0;
        }
        currentQuestion.setScore(result);
        return result;
        }

        /**
         * Method to get the quiz results
         *
         * @param request  the request from Client
         * @param response the response from Server
         * @throws ServletException
         * @throws IOException
         */
        protected void doGet (HttpServletRequest request,
                HttpServletResponse response) throws ServletException, IOException {
            String action = request.getParameter("action");
            if (this.questions.size() == 0 && !action.equalsIgnoreCase("SignUp")) {
                loadQuestionsAnswers();
            }

            HttpSession session = request.getSession(true);
            questionNumber++;
            session.setAttribute("count", questionNumber);

            if (action.isEmpty()) {
                currentQuestionIndex = 0;
                view = "errorHandler.jsp";
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                request.setAttribute("errorResponse", response.getStatus());
            } else if ((action.equalsIgnoreCase("Start Quiz") || action.equalsIgnoreCase("NEXT"))
                    && currentQuestionIndex < questions.size()) {
                currentQuestion = questions.get(currentQuestionIndex);
                request.setAttribute("data", currentQuestion);
                currentQuestionIndex += 1;
                request.setAttribute("enableSubmitButton", currentQuestionIndex == questions.size());
                view = "questionsAnswers.jsp";
                response.setStatus(response.SC_OK);

            } else if (action.equalsIgnoreCase("submit")) {
                currentQuestionIndex = 0;
                request.setAttribute("totalScore", totalScore);
                view = "quizResult.jsp";
                response.setStatus(response.SC_OK);
            }
            else if (action.equalsIgnoreCase("SignUp"))
            {
                request.setAttribute("signup", "success");
                response.setStatus(response.SC_OK);
            }
            else {
                currentQuestionIndex = 0;
                view = "errorHandler.jsp";
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                request.setAttribute("errorResponse", response.getStatus());
            }
            response.setContentType("text/html");
            request.getRequestDispatcher(view).forward(request, response);
        }
    }