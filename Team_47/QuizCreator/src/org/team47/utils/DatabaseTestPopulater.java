package org.team47.utils;

import org.team47.database.*;
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
    /**
     * populates the database with test entries
     */
    public static void populateDB() {
        try {
            //Create student, professor, and course
            String stu_pass = PasswordStorage.createHash("password");
            Student stu = new Student("studently", "Stu", "Jacobson",
                    stu_pass, "");
            if (!new StudentDAOImpl().insertStudent(stu)) return; //TODO: throws exception if student already exists
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
            Submission sub = new Submission(-1, quiz.getQuiz_id(), enrollment.getEnrolled_id(), new Date(),
                    new Date(), 45, 1);
            new SubmissionDAOImpl().insertSubmission(sub);
            Answer answerToQues1 = new Answer(-1, sub.getSubmission_id(), multiChoice.getQuestion_id(),
                    trueChoice.getChoice_id());
            Answer choseAOnQues2 = new Answer(-1, sub.getSubmission_id(), multiAnswer.getQuestion_id(),
                    choiceA.getChoice_id());
            Answer choseBOnQues2 = new Answer(-1, sub.getSubmission_id(), multiAnswer.getQuestion_id(),
                    choiceB.getChoice_id());
            AnswerDAOImpl aDAO = new AnswerDAOImpl();
            aDAO.insertAnswer(answerToQues1);
            aDAO.insertAnswer(choseAOnQues2);
            aDAO.insertAnswer(choseBOnQues2);

        }  catch (PasswordStorage.CannotPerformOperationException cpoe){
            System.out.println("[ERROR] problem hashing password");
        }
    }

    /**
     * Updates legacy test entries to have valid hashed passwords
     */
    public static void updateExampleUsersToValidPasswords(){
        try {
            // PLEASE DONT REMOVE. THIS IS FOR FRONTEND TEAM TO TEST RIGHT NOW - Trevor
            StudentDAOImpl studentDAO = new StudentDAOImpl();
            Student harryPotter = studentDAO.getStudent("boywholived");
            String newPassword = PasswordStorage.createHash("butter");
            if(harryPotter != null) {
                harryPotter.setHashedpass(newPassword);
                studentDAO.updateStudent(harryPotter);
            } else {
                harryPotter = new Student("boywholived", "Harry", "Potter", null, newPassword);
                studentDAO.insertStudent(harryPotter);
            }
            System.out.println(harryPotter.toString());

            ProfessorDAOImpl professorDAO = new ProfessorDAOImpl();
            Professor professor = professorDAO.getProfessor("xXKitten_OwnerXx");
            String newProfPassword = PasswordStorage.createHash("cats");
            if(professor != null) {
                professor.setHashedpass(newProfPassword);
                professorDAO.updateProfessor(professor);
            } else {
                professor = new Professor("xXKitten_OwnerXx", "Dolores", "Umbridge", null, newPassword);
                professorDAO.insertProfessor(professor);
            }
            System.out.println(professor.toString());
        } catch (PasswordStorage.CannotPerformOperationException cpoe){
            System.out.println("Error hashing password!");
        }
    }

    /**
     * prints everything in the db.
     */
    public static void printEverything(){
        List<Professor> profs = new ProfessorDAOImpl().getAllProfessors();
        for (Professor prof : profs){
            System.out.println(profs.toString());
        }
        List<Course> courses = new CourseDAOImpl().getAllCourses();
        for (Course course : courses){
            System.out.println(course.toString());
        }
        List<Student> studs = new StudentDAOImpl().getAllStudents();
        for (Student stud : studs){
            System.out.println(stud.toString());
        }
        List<Enrolled> enrolls = new EnrolledDAOImpl().getAllEnrollment();
        for (Enrolled enr : enrolls){
            System.out.println(enr.toString());
        }
        List<Quiz> quizzes = new QuizDAOImpl().getAllQuizzes();
        for (Quiz qz : quizzes){
            System.out.println(qz.toString());
        }
        List<Question> quests = new QuestionDAOImpl().getAllQuestions();
        for (Question q : quests){
            System.out.println(q.toString());
        }
        List<Choice> choices = new ChoiceDAOImpl().getAllChoices();
        for (Choice c : choices){
            System.out.println(c.toString());
        }
        List<Submission> subs = new SubmissionDAOImpl().getAllSubmissions();
        for (Submission sub : subs){
            System.out.println(sub.toString());
        }
        List<Answer> as = new AnswerDAOImpl().getAllAnswers();
        for (Answer a : as){
            System.out.println(a.toString());
        }
    }


}
