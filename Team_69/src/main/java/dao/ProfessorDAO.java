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
<<<<<<< HEAD
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
=======
>>>>>>> origin/master
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
<<<<<<< HEAD
=======
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
=======
	            logger.log(Level.SEVERE, "getAllQuestionFromQuizID - exception in connecting to database", sqlException);
>>>>>>> Team_58
>>>>>>> origin/master
=======
>>>>>>> origin/master
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
<<<<<<< HEAD
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
=======
>>>>>>> origin/master
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
	public List<Answer> getAllAnswersFromQuestionID(int questionID) {
		List<Answer> lists = new ArrayList<>();
		 Transaction transaction = null;
	        try  {
	            Session session = HibernateUtil.getSessionFactory().openSession();
<<<<<<< HEAD
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
=======
>>>>>>> origin/master
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
	        }
		return lists;
	}

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
=======
}
>>>>>>> origin/master
