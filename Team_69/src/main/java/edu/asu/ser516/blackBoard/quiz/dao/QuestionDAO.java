package main.java.edu.asu.ser516.blackBoard.quiz.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import main.java.edu.asu.ser516.blackBoard.quiz.bean.HibernateUtil;
import main.java.edu.asu.ser516.blackBoard.quiz.bean.Question;

public class QuestionDAO {
	public void addQuestion(Question ques) {
		 Transaction transaction = null;
	        try  {
	            Session session = HibernateUtil.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the student object
	            session.save(ques);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	}
}
