package org.team47.servlet;

import org.team47.database.*;
import org.team47.utils.JSONRequestParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Endpoint for professor to create a quiz.
 *
 * @author David Lahtinen
 * @author Paul Horton
 * @version 1.0
 * @since 02/28/19
 */
@WebServlet(name = "QuizCreationServlet")
public class QuizCreationServlet extends HttpServlet {
    //Garbage value is used where needed for constructors where the value doesn't matter.
    final private int GARBAGE_VALUE = -1;
    private String title = null;
    private Integer course_id = null;
    private String instructions = null;
    private Boolean shuffle = null;
    private Integer time_limit = null;
    private Date date_open = null;
    private Date date_close = null;
    private String quiz_type = null;
    private Integer attempts = null;
    private String quiz_group = null;
    private Double total_points = null;
    private JSONArray jsonQuestions = null;
    private List<Question> questionList = new ArrayList<>();
    private List<List<Choice>> choiceTable = new ArrayList<>();

    /**
     * Take newly submitted quiz from professor and insert into database.
     *
     * @param req HttpRequest containing json form of quiz data
     * @param res HttpResponse
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        JSONObject jsonQuiz = null;

        //Validate all required fields are present
        try {
            jsonQuiz = JSONRequestParser.getJsonFromRequest(req);
        } catch (ParseException pe) {
            res.sendError(400, "Could not parse form");
            return;
        }
        if (!validateQuizFields(jsonQuiz)){
            res.sendError(400, "Invalid fields.");
            return;
        }
        //as close date is optional, verify separately
        try {
            String dateStr = (String) jsonQuiz.get("date_open");
            Calendar cal = javax.xml.bind.DatatypeConverter.parseDateTime(dateStr);
            date_open = cal.getTime();
            dateStr = (String) jsonQuiz.get("date_close");
            cal = javax.xml.bind.DatatypeConverter.parseDateTime(dateStr);
            date_close = cal.getTime();
            if (date_open.after(date_close)) {
                res.sendError(400, "Nice try, you monster.");
                return;
            }
        } catch (ClassCastException ex) {
            res.sendError(400, "Invalid format for dates.");
            return;
        } catch (NullPointerException npe) {
            //Date not included: open immediately and use no close date.
        }
        if (date_open == null) date_open = new Date();
        Quiz qz = new Quiz(GARBAGE_VALUE, course_id, title, instructions, shuffle, time_limit, date_open, date_close,
                quiz_type, attempts, quiz_group, total_points);
        if (submitQuiz(qz, questionList, choiceTable)) {
            res.setStatus(204);
        } else {
            res.sendError(500, "problem entering quiz into db.");
        }
    }

    /**
     * Checks validity and presence of quiz fields
     *
     * @param jsonQuiz
     * @return whether all required fields are present and valid
     */
    private boolean validateQuizFields(JSONObject jsonQuiz){
        try{
            title = (String)jsonQuiz.get("title");
            course_id = ((Number)jsonQuiz.get("course_id")).intValue();
            instructions = (String)jsonQuiz.get("instructions");
            shuffle = (Boolean)jsonQuiz.get("shuffle");
            time_limit = ((Number)jsonQuiz.get("time_limit")).intValue();
            quiz_type = (String)jsonQuiz.get("quiz_type");
            if (!(quiz_type.equals("quiz") || quiz_type.equals("survey"))) {
                return false;
            }
            attempts = ((Number)jsonQuiz.get("attempts")).intValue();
            quiz_group = (String)jsonQuiz.get("quiz_group");
            total_points = ((Number)jsonQuiz.get("total_points")).doubleValue();
            jsonQuestions = (JSONArray)jsonQuiz.get("questions");
        } catch (ClassCastException ex) {
            System.out.println(ex);
            return false;
        }
        if (title == null || course_id == null || instructions == null || shuffle == null ||
                quiz_group == null || total_points == null || jsonQuestions == null){
            return false;
        }
        try {
            return validateAndBuildQuestionList(jsonQuestions);
        } catch (IOException ioe) {
            return false;
        }
    }

    /**
     * Submits a choice into the database
     *
     * @param question_id id of question choice belongs to
     * @param choice Choice object containing choice info
     * @return true if entered successfully, false otherwise.
     */
    private boolean submitChoice(int question_id, Choice choice){
        boolean hasSucceeded = true;
        ChoiceDAOImpl choiceDAO = new ChoiceDAOImpl();
        choice.setQuestion_fk(question_id);
        if (!choiceDAO.insertChoice(choice)) {
            hasSucceeded = false;
        }
        return hasSucceeded;
    }

    /**
     * Submits a question to the database
     *
     * @param quizId Id of quiz these questions are attached to
     * @param question A question to be inserted
     * @param choices A list of choices belonging to that question
     * @return true if entered properly into the database. false otherwise.
     */
    private boolean submitQuestion(int quiz_id, Question question, List<Choice> choices){
        boolean hasSucceeded = true;
        QuestionDAOImpl questionDAO = new QuestionDAOImpl();
        question.setQuiz_fk(quiz_id);
        if(questionDAO.insertQuestion(question)) {
            int question_id = question.getQuestion_id();
            for (Choice choice : choices) {
                hasSucceeded = submitChoice(question_id, choice);
                if(!hasSucceeded) {
                    break;
                }
            }
        } else {
            hasSucceeded = false;
        }
        return hasSucceeded;
    }

    /**
     * Submits a quiz to the database with foreign key linked questions
     * and foreign key linked choices to the questions.
     *
     * @param quiz          Quiz business object
     *                      (quiz_id will be assigned)
     * @param questions     List of question business objects.
     *                      Index order must match choices.
     *                      (question_id and quiz_fk will be assigned)
     * @param choices       List of lists of choice business objects.
     *                      First axis index order must match questions.
     *                      (choice_id and question_fk will be assigned)
     * @return true if everything submitted has been enetered into database.
     */
    private boolean submitQuiz(Quiz quiz, List<Question> questions,
                               List<List<Choice>> choices) {
        if (choices.size() != questions.size()) {
            throw new InputMismatchException("Number of questions " +
                    "does not match number of sets of choices");
        }
        QuizDAOImpl quizDAO = new QuizDAOImpl();
        int quiz_id;
        boolean hasSucceeded = true;
        if(quizDAO.insertQuiz(quiz)) {
            quiz_id = quiz.getQuiz_id();
            for (int i = 0; i < questions.size(); i++) {
                Question question = questions.get(i);
                List<Choice> question_choices = choices.get(i);
                hasSucceeded = submitQuestion(quiz_id, question, question_choices);
                if (!hasSucceeded){
                    break;
                }
            }
        } else {
            hasSucceeded = false;
        }
        return hasSucceeded;
    }

    /**
     * validates that JSONArray of choices have all necessary info for choice creation
     *
     * @param jsonChoices json array containing info needed to build a list of choices for a question.
     * @return returns null if failed to build choice list for a question.
     */
    public List<Choice> validateAndBuildChoiceList(JSONArray jsonChoices) throws IOException,
            java.text.ParseException {
        Iterator<JSONObject> it = jsonChoices.iterator();
        Boolean correct = null;
        String content = null;
        List<Choice> choices = new ArrayList<>();
        try {
            while (it.hasNext()){
                JSONObject choice = it.next();
                correct = (Boolean) choice.get("correct");
                content = (String) choice.get("content");
                if (correct == null || content == null) return null;
                Choice ch = new Choice(GARBAGE_VALUE, GARBAGE_VALUE, correct, content);
                choices.add(ch);
            }
        } catch (ClassCastException ex) {
            return null;
        }
        return choices;
    }

    /**
     * validates that JSONArray of questions have all necessary info for question creation
     *
     * @param jsonQuestions json array containing info needed to build quizzes
     * @return returns false if questionListFailed to build
     */
    private boolean validateAndBuildQuestionList(JSONArray jsonQuestions) throws IOException {
        Iterator<JSONObject> it = jsonQuestions.iterator();
        String quesType = null;
        Float points = null;
        String content = null;
        try {
            while (it.hasNext()) {
                JSONObject jsonQuestion = it.next();
                quesType = (String) jsonQuestion.get("quesType");
                if (!(quesType.equals("MC") || quesType.equals("MA"))) {
                    return false;
                }
                points = ((Number) jsonQuestion.get("points")).floatValue();
                content = (String) jsonQuestion.get("content");
                JSONArray choicesJson = (JSONArray) jsonQuestion.get("choices");
                if (choicesJson == null || choicesJson.isEmpty()){
                    return false;
                }
                List<Choice> choices = validateAndBuildChoiceList(choicesJson);
                if (choices == null) {
                    return false;
                }
                choiceTable.add(choices);
                Question q = new Question(GARBAGE_VALUE, GARBAGE_VALUE, quesType, points, content);
                questionList.add(q);
            }
        } catch (java.text.ParseException | IOException | ClassCastException ex){
            return false;
        }

        if (quesType == null || points == null || content == null){
            return false;
        }
        return true;
    }
}


