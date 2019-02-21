package edu.asu.ser516.blackBoard.quiz.dao;

import edu.asu.ser516.blackBoard.quiz.bean.Answer;
import edu.asu.ser516.blackBoard.quiz.bean.HibernateUtil;
import edu.asu.ser516.blackBoard.quiz.bean.ResponseStatistics;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StatisticsDAO {

    public void insertAnswer(Answer answer){
        Transaction transaction = null;
        try  {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(answer);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }


    }

    public void insertStudentResponse(ResponseStatistics responseStatistics){

        Transaction transaction = null;
        try  {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(responseStatistics);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }


}
