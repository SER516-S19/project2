package main.java.edu.asu.ser516.blackBoard.quiz.dao;
import org.hibernate.Session;
import org.hibernate.Transaction;

import main.java.edu.asu.ser516.blackBoard.quiz.bean.HibernateUtil;
import main.java.edu.asu.ser516.blackBoard.quiz.bean.User;


public class LoginDAO {

    public void addUser(User student) {
        Transaction transaction = null;
        try  {
            Session session = HibernateUtil.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(student);
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
