package edu.asu.ser516.blackBoard.quiz.dao;
import edu.asu.ser516.blackBoard.quiz.bean.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class QuizDAO {

   public void fetchQuizName(){
       Transaction transaction = null;
       try  {
           Session session = HibernateUtil.getSessionFactory().openSession();

       } catch (HibernateException e) {
           e.printStackTrace();
       }

   }
}
