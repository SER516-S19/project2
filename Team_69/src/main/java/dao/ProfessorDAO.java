package dao;
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> Team_58
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
<<<<<<< HEAD

=======

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
=======
>>>>>>> Team_58
import bean.Answer;
import bean.HibernateUtil;
import bean.Question;
import bean.Quiz;

<<<<<<< HEAD
<<<<<<< HEAD
=======
/**
 * This class implements various database operations for Professor database.
 *
 * @version 1.0
 * @since 02-16-2019
 * @authors  Aneesh, Gangadhar, Janice, Jinal, Viraj
 */
>>>>>>> Team_58
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

<<<<<<< HEAD
=======
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
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
=======
	/**
	 * This method is used to retrieve all questions with provided quiz ID from Question Table.
	 */
>>>>>>> Team_58
	public List<Question> getAllQuestionFromQuizID(int quizID){
		List<Question> lists = new ArrayList<>();
		 Transaction transaction = null;
	        try  {
	            Session session = HibernateUtil.getSessionFactory().openSession();
<<<<<<< HEAD
<<<<<<< HEAD
	            // start a transaction
=======
>>>>>>> Team_58
	            transaction = session.beginTransaction();
<<<<<<< HEAD
=======
	            Query query = session.createQuery("from  " + Question.class.getName() + " que where que.quiz.quizId = "+quizID);
	            lists = query.list();
	            transaction.commit();
	        } catch (Exception sqlException) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
<<<<<<< HEAD
	            e.printStackTrace();
=======
	            transaction = session.beginTransaction();
>>>>>>> origin/master
	            Query query = session.createQuery("from  " + Question.class.getName() +
	            		" que where que.quiz.quizId = "+quizID);
	            lists = query.list();
	            transaction.commit();
	        } catch (Exception sqlException) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            logger.log(Level.SEVERE, "getAllQuestionFromQuizID - exception in connecting to database", 
	            		sqlException);
<<<<<<< HEAD
=======
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
=======
	            logger.log(Level.SEVERE, "getAllQuestionFromQuizID - exception in connecting to database", sqlException);
>>>>>>> Team_58
>>>>>>> origin/master
	        }
		return lists;
	}
	
<<<<<<< HEAD
<<<<<<< HEAD
	public void publishQuiz(int quiz_id) {
=======
=======
>>>>>>> Team_58
	/**
	 * This method set the publish flag to true in the Quiz Table
	 */
	public void publishQuiz(int quizId) {
<<<<<<< HEAD
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
=======
>>>>>>> Team_58
		 Transaction transaction = null;
		 Session session = null;
	        try {
	        	session = HibernateUtil.getSessionFactory().openSession();
<<<<<<< HEAD
<<<<<<< HEAD
	            // start a transaction
=======
>>>>>>> Team_58
	            transaction = session.beginTransaction();
	            Quiz quizObj = session.get(Quiz.class, quizId);
	            quizObj.setIsPublished(true);
	            transaction.commit();
	        } catch(Exception sqlException) {
	            if(null != transaction) {
	                transaction.rollback();
	            }
<<<<<<< HEAD
	            sqlException.printStackTrace();
=======
	            transaction = session.beginTransaction();
	            Quiz quizObj = session.get(Quiz.class, quizId);
	            quizObj.setIsPublished(true);
	            transaction.commit();
	        } catch(Exception sqlException) {
	            if(null != transaction) {
	                transaction.rollback();
	            }
	            logger.log(Level.SEVERE, "publishQuiz - exception in connecting to database", sqlException);
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
=======
	            logger.log(Level.SEVERE, "publishQuiz - exception in connecting to database", sqlException);
>>>>>>> Team_58
	        } finally {
	            if(session != null) {
	                session.close();
	            }
	        }
	    }
<<<<<<< HEAD
<<<<<<< HEAD

	
	public void insertProfDetails(Quiz quiz) {
=======
	
=======
	
>>>>>>> Team_58
	/**
	 * This method is used to add the quiz details into the Quiz Table
	 */
	public void insertQuizDetails(Quiz quiz) {
<<<<<<< HEAD
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
=======
>>>>>>> Team_58
        Transaction transaction = null;
        try  {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(quiz);
            transaction.commit();
<<<<<<< HEAD
<<<<<<< HEAD
        } catch (Exception e) {
            if (transaction != null) {
=======
        } catch (Exception sqlException) {
            if (transaction != null) 
>>>>>>> Team_58
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
<<<<<<< HEAD
=======
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
	
<<<<<<< HEAD

=======
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
>>>>>>> origin/master
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
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
=======
	/**
	 * This method is used to retrieve all answers with provided question ID from Answer Table.
	 */
>>>>>>> Team_58
	public List<Answer> getAllAnswersFromQuestionID(int questionID) {
		List<Answer> lists = new ArrayList<>();
		 Transaction transaction = null;
	        try  {
	            Session session = HibernateUtil.getSessionFactory().openSession();
<<<<<<< HEAD
<<<<<<< HEAD
	            // start a transaction
	            transaction = session.beginTransaction();
	            
	            Query query = session.createQuery("from  " + Answer.class.getName() + " ans where ans.question.questionId = "+questionID);
	            
=======
	            transaction = session.beginTransaction();	            
<<<<<<< HEAD
=======
	            Query query = session.createQuery("from  " + Answer.class.getName() + " ans where ans.question.questionId = "+questionID);	            
>>>>>>> Team_58
	            lists = query.list();
	            transaction.commit();
	        } catch (Exception sqlException) {
	            if (transaction != null)
	                transaction.rollback();
<<<<<<< HEAD
	            }
	            e.printStackTrace();
=======
	            transaction = session.beginTransaction();	            
>>>>>>> origin/master
	            Query query = session.createQuery("from  " + Answer.class.getName() + 
	            		" ans where ans.question.questionId = "+questionID);	            
	            lists = query.list();
	            transaction.commit();
	        } catch (Exception sqlException) {
	            if (transaction != null)
	                transaction.rollback();
	            logger.log(Level.SEVERE, "getAllAnswersFromQuestionID - exception in connecting to database", 
	            		sqlException);
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
	        }
		return lists;
	}

<<<<<<< HEAD

	
}
=======
	/**
	 * This method is used to retrieve Question data with provided question ID from Question Table.
	 */
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
<<<<<<< HEAD
}
=======
}
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
=======
	            logger.log(Level.SEVERE, "getAllAnswersFromQuestionID - exception in connecting to database", sqlException);
	        }
		return lists;
	}
}
>>>>>>> Team_58
>>>>>>> origin/master
