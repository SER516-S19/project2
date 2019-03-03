package com.asu.ser516.team47.utils;

import com.asu.ser516.team47.database.*;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

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
        }  catch (PasswordStorage.CannotPerformOperationException cpoe){
            System.out.println("[ERROR] problem hashing password");
        }
    }
}
