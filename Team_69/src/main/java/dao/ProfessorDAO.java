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
 * This class implements various database operations for Professor database.
 *
 * @version 1.0
 * @since 02-16-2019
 * @authors  Aneesh, Gangadhar, Janice, Jinal, Viraj
 */
public class ProfessorDAO {
	
	Logger logger = Logger.getAnonymousLogger();
	
	/**
	 * Gets the list of all available quizzes from the Quiz Table.
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
	 * This method is used to retrieve all questions with provided quiz ID from Question Table.
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
	 * This method set the publish flag to true in the Quiz Table
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
	 * This method is used to add the quiz details into the Quiz Table
	 */
	public void insertQuizDetails(Quiz quiz) {
        Transaction transaction = null;
        try  {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(quiz);
            transaction.commit();
        } catch (Exception sqlException) {
            if (transaction != null) 
                transaction.rollback();
            logger.log(Level.SEVERE, "insertQuizDetails - exception in connecting to database", sqlException);
        }
    }
	
	/**
	 * This method is used to retrieve Quiz data with provided quiz ID from Quiz Table.
	 */
	public Quiz getQuizFromID(int quizID) {
		 Quiz quizObj = null;
		 Transaction transaction = null;
		 Session session = null;
	        try  {
	            session = HibernateUtil.getSessionFactory().openSession();
	            transaction = session.beginTransaction();
	            quizObj = session.get(Quiz.class, quizID);
	            transaction.commit();
	        } catch (Exception sqlException) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            logger.log(Level.SEVERE, "getQuizFromID - exception in connecting to database", sqlException);
	        }
	        finally {
	        	if(session!=null)
	        		session.close();
			}
		return quizObj;
	}
	
	/**
	 * This method is used to retrieve all answers with provided question ID from Answer Table.
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

	public Question getQuestionFromID(Integer questionId) {
		Question questionObj = null;
		 Transaction transaction = null;
		 Session session = null;
	        try  {
	            session = HibernateUtil.getSessionFactory().openSession();
	            transaction = session.beginTransaction();
	            questionObj = session.get(Question.class, questionId);
	            transaction.commit();
	        } catch (Exception sqlException) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            logger.log(Level.SEVERE, "getQuestionFromID - exception in connecting to database", sqlException);
	        }
	        finally {
	        	if(session!=null)
	        		session.close();
			}
		return questionObj;
	}
}