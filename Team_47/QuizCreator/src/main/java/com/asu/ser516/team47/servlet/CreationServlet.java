package com.asu.ser516.team47.servlet;

import com.asu.ser516.team47.database.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

/**
 * This servlet is called when a professor creates a quiz
 *
 * @author paulhorton
 * @version 1.0
 * @since 2/25/19
 */

@WebServlet(name = "CreationServlet")
public class CreationServlet extends HttpServlet{

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
     *                      First aixs index order must match questions.
     *                      (choice_id and question_fk will be assigned)
     * @return true if everything submitted has been enetered into database.
     */
    private boolean submitQuiz(Quiz quiz, ArrayList<Question> questions,
                               ArrayList<ArrayList<Choice>> choices) {
        if (choices.size() == questions.size()) {
            throw new InputMismatchException("Number of questions " +
                    "does not match number of sets of choices");
        }
        QuizDAOImpl quizDAO = new QuizDAOImpl();
        QuestionDAOImpl questionDAO = new QuestionDAOImpl();
        ChoiceDAOImpl choiceDAO = new ChoiceDAOImpl();
        int quiz_id;
        int question_id;
        boolean hasSucceeded = true;
        if(quizDAO.insertQuiz(quiz)) {
            quiz_id = quiz.getQuiz_id();
            for (int i = 0; i < questions.size(); i++) {
                Question question = questions.get(i);
                question.setQuiz_fk(quiz_id);
                if(questionDAO.insertQuestion(question)) {
                    question_id = question.getQuestion_id();
                    ArrayList<Choice> questionChoices = choices.get(i);
                    for (Choice choice : questionChoices) {
                        choice.setQuestion_fk(question_id);
                        if (!choiceDAO.insertChoice(choice)) {
                            hasSucceeded = false;
                            break;
                        }
                    }
                    if(!hasSucceeded) {
                        break;
                    }
                } else {
                    hasSucceeded = false;
                    break;
                }
            }
        } else {
            hasSucceeded = false;
        }
        return hasSucceeded;
    }
}
