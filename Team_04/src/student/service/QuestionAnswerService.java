package student.service;

import DBUtil.DataManager;
import student.dto.AnswerOption;
import student.dto.QuizContent;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuestionAnswerService {

    private QuizContent currentQuestion = null;
    private List<QuizContent> questions = new ArrayList<>();
    private int totalScore = 0;
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
}
