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

public class ProfessorDAO {
	
	public List<Quiz> getAllQuizzes(){
		List<Quiz> lists = new ArrayList<>();
		 Transaction transaction = null;
	        try  {
	            Session session = HibernateUtil.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the student object
	            lists = session.createQuery("from Quiz").list();
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
		return lists;
	}

	public List<Question> getAllQuestionFromQuizID(int quizID){
		List<Question> lists = new ArrayList<>();
		 Transaction transaction = null;
	        try  {
	            Session session = HibernateUtil.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            
	            Query query = session.createQuery("from  " + Question.class.getName() + " que where que.quiz.quizId = "+quizID);
	            
	            lists = query.list();
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
		return lists;
	}
	
	public void publishQuiz(int quiz_id) {
		 Transaction transaction = null;
		 Session session = null;
	        try {
	        	session = HibernateUtil.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	 
	            // Creating Transaction Entity
	            Quiz quizObj = (Quiz) session.get(Quiz.class, quiz_id);
	            quizObj.setIsPublished(true);
	            
	            // Committing The Transactions To The Database
	            transaction.commit();
	
	            System.out.println("Quiz published successfully");
	        } catch(Exception sqlException) {
	            if(null != transaction) {
	                System.out.println("\n.......Transaction Is Being Rolled Back.......\n");
	                transaction.rollback();
	            }
	            sqlException.printStackTrace();
	        } finally {
	            if(session != null) {
	                session.close();
	            }
	        }
	    }

	
	public void insertProfDetails(Quiz quiz) {
        Transaction transaction = null;
        try  {
            Session session = HibernateUtil.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(quiz);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

	public List<Answer> getAllAnswersFromQuestionID(int questionID) {
		List<Answer> lists = new ArrayList<>();
		 Transaction transaction = null;
	        try  {
	            Session session = HibernateUtil.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            
	            Query query = session.createQuery("from  " + Answer.class.getName() + " ans where ans.question.questionId = "+questionID);
	            
	            lists = query.list();
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
		return lists;
	}


	
}
