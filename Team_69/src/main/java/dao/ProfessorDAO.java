package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import bean.Answer;
import bean.HibernateUtil;
import bean.Question;
import bean.Quiz;

/**
 * This is the DAO class for performing CRUD operations.
 *
 * @version 1.0
 * @since 02-16-2019
 * @authors  Aneesh, Gangadhar, Janice, Jinal, Viraj
 */
public class ProfessorDAO {
	
	Logger logger = Logger.getAnonymousLogger();
	
	/**
	 * Gets the list of quizzes from the database.
	 */
	public List<Quiz> getAllQuizzes(){
		List<Quiz> lists = new ArrayList<>();
		Transaction transaction = null;
		try  {
		    Session session = HibernateUtil.getSessionFactory().openSession();
		    transaction = session.beginTransaction();
		    lists = session.createQuery("from Quiz").list();
		    transaction.commit();
		} 
		catch (Exception sqlException) {
		    if (transaction != null) {
		        transaction.rollback();
		    }
		    logger.log(Level.SEVERE, "getAllQuizzes - exception in connecting to database", sqlException);
		}
		return lists;
	}

	/**
	 * The method is used to retrieve all question from quiz ID.
	 */
	public List<Question> getAllQuestionFromQuizID(int quizID){
		List<Question> lists = new ArrayList<>();
		 Transaction transaction = null;
	        try  {
	            Session session = HibernateUtil.getSessionFactory().openSession();
	            transaction = session.beginTransaction();
	            Query query = session.createQuery("from  " + Question.class.getName() + " que where que.quiz.quizId = "+quizID);
	            lists = query.list();
	            transaction.commit();
	        } catch (Exception sqlException) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            logger.log(Level.SEVERE, "getAllQuestionFromQuizID - exception in connecting to database", sqlException);
	        }
		return lists;
	}
	
	/**
	 * The method set the publish flag in the database
	 *
	 * @param quizId the quiz id
	 */
	public void publishQuiz(int quizId) {
		 Transaction transaction = null;
		 Session session = null;
	        try {
	        	session = HibernateUtil.getSessionFactory().openSession();
	            transaction = session.beginTransaction();
	            Quiz quizObj = session.get(Quiz.class, quizId);
	            quizObj.setIsPublished(true);
	            transaction.commit();
	        } catch(Exception sqlException) {
	            if(null != transaction) {
	                transaction.rollback();
	            }
	            logger.log(Level.SEVERE, "publishQuiz - exception in connecting to database", sqlException);
	        } finally {
	            if(session != null) {
	                session.close();
	            }
	        }
	    }
	
	/**
	 * The method is used to add the quiz details into the database
	 *
	 * @param quiz the quiz
	 */
	public void insertProfDetails(Quiz quiz) {
        Transaction transaction = null;
        try  {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(quiz);
            transaction.commit();
        } catch (Exception sqlException) {
            if (transaction != null) 
                transaction.rollback();
            logger.log(Level.SEVERE, "insertProfDetails - exception in connecting to database", sqlException);
        }
    }
	
	public Quiz getQuizFromID(int quizID) {
		 Quiz quizObj = null;
		 Transaction transaction = null;
	        try  {
	            Session session = HibernateUtil.getSessionFactory().openSession();
	            transaction = session.beginTransaction();
	            quizObj = session.get(Quiz.class, quizID);
	            transaction.commit();
	        } catch (Exception sqlException) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            logger.log(Level.SEVERE, "getQuizFromID - exception in connecting to database", sqlException);
	        }
		return quizObj;
	}
	
	/**
	 * Gets all answers for each question.
	 */
	public List<Answer> getAllAnswersFromQuestionID(int questionID) {
		List<Answer> lists = new ArrayList<>();
		 Transaction transaction = null;
	        try  {
	            Session session = HibernateUtil.getSessionFactory().openSession();
	            transaction = session.beginTransaction();	            
	            Query query = session.createQuery("from  " + Answer.class.getName() + " ans where ans.question.questionId = "+questionID);	            
	            lists = query.list();
	            transaction.commit();
	        } catch (Exception sqlException) {
	            if (transaction != null)
	                transaction.rollback();
	            logger.log(Level.SEVERE, "getAllAnswersFromQuestionID - exception in connecting to database", sqlException);
	        }
		return lists;
	}
}