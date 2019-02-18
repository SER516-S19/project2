package edu.asu.ser516.blackBoard.quiz.dao;
import edu.asu.ser516.blackBoard.quiz.bean.HibernateUtil;
import edu.asu.ser516.blackBoard.quiz.bean.Quiz;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class QuizDAO {

   public void fetchAllQuizName(){
       Transaction transaction = null;
       try  {
           Session session = HibernateUtil.getSessionFactory().openSession();
           transaction = session.beginTransaction();
           CriteriaBuilder builder = session.getCriteriaBuilder();
           CriteriaQuery<String> query = builder.createQuery(String.class);
           Root<Quiz> root = query.from(Quiz.class);
           query.select(root.<String>get("quizName"));
           Query<String> q=session.createQuery(query);
           List<String> list=q.getResultList();
           for (String name : list) {
               System.out.println(name);
           }
           transaction.commit();
       } catch (HibernateException e) {
           e.printStackTrace();
           if (transaction != null) {
               transaction.rollback();
           }
       }
   }
}
