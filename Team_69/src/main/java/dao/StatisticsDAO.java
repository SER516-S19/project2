package dao;

import bean.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

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

    public long checkQuizStatus(int quizId){
        Transaction transaction = null;
        Long count= 0L;
        try  {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Long> query = builder.createQuery(Long.class);
            Root<ResponseStatistics> root = query.from(ResponseStatistics.class);
            Join<ResponseStatistics, Quiz> join = root.join("quiz");
            query.select((builder.count(root))).where(builder.equal(join.get("quizId"),quizId));
            Query<Long> q = session.createQuery(query);
            count = q.getSingleResult();
            transaction.commit();
            session.close();
//            for(Answer ans: answerDetails)
//                System.out.println(ans.toString());
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

        }
        return count;
    }



}
