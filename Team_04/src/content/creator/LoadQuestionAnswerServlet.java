package content.creator;

import DBUtil.DataManager;

import student.dto.AnswerOption;
import student.dto.QuizContent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Servlet to load the questions and answers
 */
@WebServlet("/servlet")
public class LoadQuestionAnswerServlet extends HttpServlet {

    String view = "";
    private int score = 0;
    private List<QuizContent> questions = new ArrayList<>();
    private int currentQuestionIndex = 0;
    private int totalScore = 0;
    private int questionNumber = 0;

    /**
     * Function to load the quiz details
     */
    private void loadQuestionsAnswers() {

        List<QuizContent> questions = DataManager.getInstance().executeGetQuery(QuizContent.class,
                "SELECT * FROM quiz_content group by quesId");

        for (QuizContent question : questions) {
            List<QuizContent> options = DataManager.getInstance().executeGetQuery(QuizContent.class,
                    "SELECT * FROM quiz_content where quesId=" + question.getQuesId());
            for (QuizContent answerOption : options) {
                question.getAnswerOptions().add(new AnswerOption(answerOption.getAnsId(),
                        answerOption.getAnsDesc(), answerOption.getIsCorrect()));
            }
        }
        this.questions = questions;
    }


    /**
     * Method to post the quiz results
     *
     * @param request  the request from Client
     * @param response the response from Server
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameterMap().containsKey("selectedOptionId") && currentQuestionIndex < questions.size()) {
            switch (questions.get(currentQuestionIndex - 1).getQuesType()) {
                case "SA":
                    String[] radioSelection = {request.getParameter("selectedOptionId")};
                    totalScore += computeScore(currentQuestionIndex - 1, Arrays.asList(radioSelection));
                    break;
                case "MA":
                    String[] checkBoxSelection = request.getParameterValues("selectedOptionId");
                    totalScore += computeScore(currentQuestionIndex - 1, Arrays.asList(checkBoxSelection));
                    break;
                case "TA":
                    break;
            }
        }
        doGet(request, response);
    }

    /**
     * Method to calculate the score
     * @param currentQuestionIndex index of the current question
     * @param selectedOptions      list of selected options
     * @return
     */
    private int computeScore(int currentQuestionIndex, List<String> selectedOptions) {
        int actualCorrectAnsCount = 0, totalCorrectAnsCount = 0;
        int result;
        QuizContent currentQuestion = questions.get(currentQuestionIndex);
        for (AnswerOption answerOption : currentQuestion.getAnswerOptions()) {
            if (answerOption.getIsCorrect()) {
                totalCorrectAnsCount += 1;
                if (selectedOptions.contains(Long.toString(answerOption.getAnsId()))) {
                    actualCorrectAnsCount += 1;
                }
            }
        }
        if (totalCorrectAnsCount != 0) {
            result = (int) ((actualCorrectAnsCount / totalCorrectAnsCount) * currentQuestion.getMaxScore());
        } else {
            result = 0;
        }
        return result;
    }

    /**
     * Method to get the quiz results
     * @param request the request from Client
     * @param response the response from Server
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (this.questions.size() == 0) {
            loadQuestionsAnswers();
        }

        HttpSession session = request.getSession(true);
        questionNumber++;
        session.setAttribute("count", questionNumber);
        String action = request.getParameter("action");

        if (action.isEmpty()) {
            view = "error.jsp";
        } else if ((action.equalsIgnoreCase("Start Quiz") || action.equalsIgnoreCase("NEXT"))
                && currentQuestionIndex < questions.size()) {
            request.setAttribute("data", questions.get(currentQuestionIndex));
            currentQuestionIndex += 1;
            request.setAttribute("enableSubmitButton", currentQuestionIndex == questions.size());
            view = "questionsanswers.jsp";
            response.setContentType("text/html");
            response.setStatus(response.SC_OK);
            request.getRequestDispatcher(view).forward(request, response);
        } else if(action.equalsIgnoreCase("submit")){
            request.setAttribute("totalScore", totalScore);
            view = "ThankYou.jsp";
            response.setContentType("text/html");
            response.setStatus(response.SC_OK);
            request.getRequestDispatcher(view).forward(request, response);
        }
    }
}