package dao;

import bean.Answer;
import bean.HibernateUtil;
import bean.ResponseStatistics;
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
