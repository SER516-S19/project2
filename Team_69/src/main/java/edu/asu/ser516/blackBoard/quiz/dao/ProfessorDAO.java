package edu.asu.ser516.blackBoard.quiz.dao;


import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import edu.asu.ser516.blackBoard.quiz.bean.HibernateUtil;
import edu.asu.ser516.blackBoard.quiz.bean.Quiz;

public class ProfessorDAO {
	
	public List getAllQuizzes(){
		List lists = new ArrayList<>();
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
	
	 public static void publishQuiz(int quiz_id) {   
		 Transaction transaction = null;
		 Session session = null;
	        try {
	        	session = HibernateUtil.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	 
	            // Creating Transaction Entity
	            Quiz quizObj = (Quiz) session.get(Quiz.class, quiz_id);
	            quizObj.setPublished(true);
	            
	            // Committing The Transactions To The Database
	            session.getTransaction().commit();
	 
	            
	            System.out.println("Quiz published successfully");
	        } catch(Exception sqlException) {
	            if(null != session.getTransaction()) {
	                System.out.println("\n.......Transaction Is Being Rolled Back.......\n");
	                session.getTransaction().rollback();
	            }
	            sqlException.printStackTrace();
	        } finally {
	            if(session != null) {
	                session.close();
	            }
	        }
	    }

	
}
