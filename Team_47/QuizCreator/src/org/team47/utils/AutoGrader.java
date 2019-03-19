package org.team47.utils;

import org.team47.database.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author paulhorton
 * @version 1.0
 * @since 2/25/19
 */
public class AutoGrader {
    private Submission submission;
    private float points;

    public AutoGrader(int submission_id){
        submission = new SubmissionDAOImpl().getSubmission(submission_id);
        points = 0;
    }

    public float gradeSubmission() {
        QuestionDAOImpl questionDAO = new QuestionDAOImpl();

        List<Question> questions = questionDAO.getQuizQuestions(submission.getQuiz_fk());

        for (Question question : questions) {
            if (question.getQuesType().toUpperCase().equals("MC")) {
                points += gradeMultipleChoice(question) ? question.getPoints() : 0;
            } else {
                points += gradeMultipleAnswer(question) ? question.getPoints() : 0;
            }
        }
        return points;
    }

    public boolean gradeMultipleChoice(Question question) {
        AnswerDAOImpl answerDAO = new AnswerDAOImpl();
        ChoiceDAOImpl choiceDAO = new ChoiceDAOImpl();

        List<Answer> answers = answerDAO.getSubmissionAnswers(
                submission.getSubmission_id(), question.getQuestion_id());
        if (answers.size() != 1) {
            return false;
        }
        Answer answer = answers.get(0);
        Choice choice = choiceDAO.getChoice(answer.getChoice_fk());
        return choice.isCorrect();
    }

    public boolean gradeMultipleAnswer(Question question) {
        AnswerDAOImpl answerDAO = new AnswerDAOImpl();
        ChoiceDAOImpl choiceDAO = new ChoiceDAOImpl();

        List<Choice> choices = choiceDAO.getQuestionChoices(
                question.getQuestion_id());
        Set<Integer> choiceIDs = new HashSet<>();
        for (Choice choice : choices) {
            if (choice.isCorrect()) {
                choiceIDs.add(choice.getChoice_id());
            }
        }
        List<Answer> answers = answerDAO.getSubmissionAnswers(
                submission.getSubmission_id(), question.getQuestion_id());
        Set<Integer> answerIDs = new HashSet<>();
        for (Answer answer: answers) {
            answerIDs.add(answer.getChoice_fk());
        }

        return choiceIDs.equals(answerIDs);
    }
}
