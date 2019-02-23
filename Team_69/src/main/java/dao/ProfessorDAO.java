package dao;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import bean.Answer;
import bean.HibernateUtil;
import bean.Question;
import bean.Quiz;

// TODO: Auto-generated Javadoc
/**
 * This is the DAO class for performing CRUD operations.
 *
 * @version 1.0
 * @since 02-16-2019
 * @authors  Aneesh, Gangadhar, Janice, Jinal, Viraj
 */
public class ProfessorDAO {
	
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
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
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
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
		return lists;
	}
	
	/**
	 * The method set the publish flag in the database
	 *
	 * @param quiz_id the quiz id
	 */
	public void publishQuiz(int quiz_id) {
		 Transaction transaction = null;
		 Session session = null;
	        try {
	        	session = HibernateUtil.getSessionFactory().openSession();
	            transaction = session.beginTransaction();
	            Quiz quizObj = (Quiz) session.get(Quiz.class, quiz_id);
	            quizObj.setIsPublished(true);
	            transaction.commit();
	        } catch(Exception sqlException) {
	            if(null != transaction) {
	                transaction.rollback();
	            }
	            sqlException.printStackTrace();
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
        } catch (Exception e) {
            if (transaction != null) 
                transaction.rollback();
            e.printStackTrace();
        }
    }
	
	public Quiz getQuizFromID(int quizID) {

		 Quiz quizObj = null;
		 Transaction transaction = null;
	        try  {
	            Session session = HibernateUtil.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            
	            quizObj = (Quiz) session.get(Quiz.class, quizID);
	            
	           
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
		return quizObj;
	
		
	}
	

	/**
	 * Gets all answers for each question.
	 *
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
	        } catch (Exception e) {
	            if (transaction != null)
	                transaction.rollback();
	            e.printStackTrace();
	        }
		return lists;
	}
}
