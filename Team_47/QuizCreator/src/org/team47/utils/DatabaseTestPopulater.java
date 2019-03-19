package org.team47.utils;

import org.team47.database.*;
import org.sqlite.SQLiteException;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import javax.xml.bind.DatatypeConverter;
import java.util.ArrayList;
import java.util.Calendar;
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

    private static int GARBAGE_INT = -1;

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
            CourseDAO courseDAO = new CourseDAOImpl();
            List<Course> courses = courseDAO.getAllCourses();
            boolean courseExists = false;
            for (Course c : courses){
                if (c.getProfessor_fk().equals("xXKitten_OwnerXx")){
                    courseExists = true;
                    break;
                }
            }

            if (!courseExists){
                Course course = new Course(GARBAGE_INT, "xXKitten_OwnerXx", "DDA", "123");
                courseDAO.insertCourse(course);

                EnrolledDAO enrolledDAO = new EnrolledDAOImpl();
                enrolledDAO.insertEnrolled(new Enrolled(GARBAGE_INT, course.getCourse_id(), "boywholived"));
            }

        } catch (PasswordStorage.CannotPerformOperationException cpoe){
            System.out.println("Error hashing password!");
        }
    }

    /**
     * puts example quizzes in the database for Kitten Owner's course
     */
    public static void addKittyQuizzes(){
        QuizDAO quizDAO = new QuizDAOImpl();
        QuestionDAO questionDAO = new QuestionDAOImpl();
        ChoiceDAO choiceDAO = new ChoiceDAOImpl();

        int course_fk = 1;
        String title = "Minute Quiz";
        String instructions = "This is a straightforward quiz. You have 1 minute.";
        boolean shuffle = true;
        int time_limit = 60;
        Date date_open = DatatypeConverter.parseDateTime("2018-12-25").getTime();
        Date date_close = DatatypeConverter.parseDateTime("2019-05-30").getTime();
        String quizType = "quiz";
        int attempts = 3;
        String quizGroup = "Cool Questions";
        double total_points = 340.5;

        //check that the quizzes don't already exist
        boolean hasQuiz = false;
        List<Quiz> quizzes = quizDAO.getAllQuizzes();
        for (Quiz q : quizzes){
            if (q.getTitle().equals("Minute Quiz")){
                hasQuiz = true;
                break;
            }
        }

        if (!hasQuiz) {
            Quiz quiz = new Quiz(GARBAGE_INT, course_fk, title, instructions, shuffle, time_limit, date_open,
                    date_close, quizType, attempts, quizGroup, total_points);
            quizDAO.insertQuiz(quiz);
            int quizId = quiz.getQuiz_id();
            System.out.println("QUIZ ID:::::::: " + quizId);

            float q1Points = new Float(20.5);
            float q2Points = 280;
            float q3Points = 20;
            float q4Points = 20;
            List<Question> questions = new ArrayList<>();

            Question q1 = new Question(GARBAGE_INT, quizId, "mc", q1Points,
                    "1. What species has the greatest knees?");
            Question q2 = new Question(GARBAGE_INT, quizId, "ma", q2Points,
                    "2. Which of the following are cool places?");
            Question q3 = new Question(GARBAGE_INT, quizId, "mc", q3Points, "I am feeling ok today.");
            Question q4 = new Question(GARBAGE_INT, quizId, "mc", q4Points,
                    "This question exists to test shuffle functionality.");
            questionDAO.insertQuestion(q1);
            questionDAO.insertQuestion(q2);
            questionDAO.insertQuestion(q3);
            questionDAO.insertQuestion(q4);

            Choice q1a1 = new Choice(GARBAGE_INT, q1.getQuestion_id(), false, "Bears");
            Choice q1a2 = new Choice(GARBAGE_INT, q1.getQuestion_id(), true, "Bees");
            Choice q1a3 = new Choice(GARBAGE_INT, q1.getQuestion_id(), false, "Alpacas");
            Choice q1a4 = new Choice(GARBAGE_INT, q1.getQuestion_id(), false, "Spiders");
            choiceDAO.insertChoice(q1a1);
            choiceDAO.insertChoice(q1a2);
            choiceDAO.insertChoice(q1a3);
            choiceDAO.insertChoice(q1a4);

            Choice q2a1 = new Choice(GARBAGE_INT, q2.getQuestion_id(), true, "Antarctica");
            Choice q2a2 = new Choice(GARBAGE_INT, q2.getQuestion_id(), false, "The Sonoran Desert");
            Choice q2a3 = new Choice(GARBAGE_INT, q2.getQuestion_id(), true, "Greenland");
            Choice q2a4 = new Choice(GARBAGE_INT, q2.getQuestion_id(), true, "Finland");
            Choice q2a5 = new Choice(GARBAGE_INT, q2.getQuestion_id(), false, "Venus");
            choiceDAO.insertChoice(q2a1);
            choiceDAO.insertChoice(q2a2);
            choiceDAO.insertChoice(q2a3);
            choiceDAO.insertChoice(q2a4);
            choiceDAO.insertChoice(q2a5);

            Choice q3a1 = new Choice(GARBAGE_INT, q3.getQuestion_id(), false, "True");
            Choice q3a2 = new Choice(GARBAGE_INT, q3.getQuestion_id(), true, "False");
            choiceDAO.insertChoice(q3a1);
            choiceDAO.insertChoice(q3a2);

            Choice q4a1 = new Choice(GARBAGE_INT, q4.getQuestion_id(), true, "True");
            Choice q4a2 = new Choice(GARBAGE_INT, q4.getQuestion_id(), false, "False");
            choiceDAO.insertChoice(q4a1);
            choiceDAO.insertChoice(q4a2);
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
