package com.asu.ser516.team47.utils;

import com.asu.ser516.team47.database.*;
import org.sqlite.SQLiteException;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Uses DAOs to populate the db. Meant to eventually replace SQLScriptRunner and exampleQuiz.sql
 *
 * @author David Lahtinen
 * @version 1.1
 * @since 03/02/2019
 */
public class DatabaseTestPopulater {
    public static void populateDB() {
        try {
            //Create student, professor, and course
            String stu_pass = PasswordStorage.createHash("password");
            Student stu = new Student("studently", "Stu", "Jacobson",
                    stu_pass, "");
            if (!new StudentDAOImpl().insertStudent(stu)) return;
            String prof_pass = PasswordStorage.createHash("password");
            Professor prof = new Professor("professorly", "Priscilla",
                    "Proffton", prof_pass, "");
            if (!new ProfessorDAOImpl().insertProfessor(prof)) return;

            Course course = new Course(-1, prof.getUsername(), "FML", "101");
            new CourseDAOImpl().insertCourse(course);
            Enrolled enrollment = new Enrolled(-1, course.getCourse_id(), stu.getUsername());
            new EnrolledDAOImpl().insertEnrolled(enrollment);

            //Create example quiz
            Quiz quiz = new Quiz(-1, course.getCourse_id(), "How to take a quiz.", "Just answer the questions.",
                    true, 9000, new Date(), new Date(1999999999), "quiz", 900, "History",
                    100);

            Question multiChoice = new Question(-1, quiz.getQuiz_id(), "MC", 45, "The answer is True.");
            new QuestionDAOImpl().insertQuestion(multiChoice);

            Choice trueChoice = new Choice(-1, multiChoice.getQuestion_id(), true, "True");
            Choice falseChoice = new Choice(-1, multiChoice.getQuestion_id(), false, "False");
            new ChoiceDAOImpl().insertChoice(trueChoice);
            new ChoiceDAOImpl().insertChoice(falseChoice);

            Question multiAnswer = new Question(-1, quiz.getQuiz_id(), "MA", 55,
                    "The answers are Cherry and Detroit.");
            new QuestionDAOImpl().insertQuestion(multiAnswer);

            Choice choiceA = new Choice(-1, multiAnswer.getQuestion_id(), false, "Amber");
            Choice choiceB = new Choice(-1, multiAnswer.getQuestion_id(), false, "Boulevard");
            Choice choiceC = new Choice(-1, multiAnswer.getQuestion_id(), true, "Cherry");
            Choice choiceD = new Choice(-1, multiAnswer.getQuestion_id(), true, "Detroit");
            new ChoiceDAOImpl().insertChoice(choiceA);
            new ChoiceDAOImpl().insertChoice(choiceB);
            new ChoiceDAOImpl().insertChoice(choiceC);
            new ChoiceDAOImpl().insertChoice(choiceD);

            //Creating example submission and answers
            Submission sub = new Submission(-1, quiz.getQuiz_id(), enrollment.getEnrolled_id(), 30,
                    new Date(), 45, 1);
            new SubmissionDAOImpl().insertSubmission(sub);
            Answer answerToQues1 = new Answer(-1, sub.getSubmission_id(), multiChoice.getQuestion_id(),
                    trueChoice.getChoice_id());
            Answer choseAOnQues2 = new Answer(-1, sub.getSubmission_id(), multiAnswer.getQuestion_id(),
                    choiceA.getChoice_id());
            Answer choseBOnQues2 = new Answer(-1, sub.getSubmission_id(), multiAnswer.getQuestion_id(),
                    choiceB.getChoice_id());

        }  catch (PasswordStorage.CannotPerformOperationException cpoe){
            System.out.println("[ERROR] problem hashing password");
        }
    }

    public static void updateExampleUsersToValidPasswords(){
        try {
            // PLEASE DONT REMOVE. THIS IS FOR FRONTEND TEAM TO TEST RIGHT NOW - Trevor
            StudentDAOImpl studentDAO = new StudentDAOImpl();
            Student harryPotter = studentDAO.getStudent("boywholived");
            String newPassword = PasswordStorage.createHash("butter");
            harryPotter.setHashedpass(newPassword);
            studentDAO.updateStudent(harryPotter);
            System.out.println(harryPotter.toString());

            ProfessorDAOImpl professorDAO = new ProfessorDAOImpl();
            Professor professor = professorDAO.getProfessor("xXKitten_OwnerXx");
            String newProfPassword = PasswordStorage.createHash("cats");
            professor.setHashedpass(newProfPassword);
            professorDAO.updateProfessor(professor);
            System.out.println(professor.toString());
        } catch (PasswordStorage.CannotPerformOperationException cpoe){
            System.out.println("Error hashing password!");
        }
    }


}
