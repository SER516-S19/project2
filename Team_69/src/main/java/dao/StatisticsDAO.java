package dao;

import bean.*;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

/**
 * This is a helper class to perform database operations on the Response
 * Statistics table
 *
 * @author : Jahnvi Rai
 * @version : 1.0
 * @since : 02/18/2019
 */

public class StatisticsDAO {

    public void insertStudentResponse(ResponseStatistics responseStatistics){
        Transaction transaction = null;
        Session session = null;
        try  {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(responseStatistics);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            session.close();
        }

    }

    public long checkQuizStatus(int quizId){
        Transaction transaction = null;
        Session session = null;
        Long count= 0L;
        try  {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Long> query = builder.createQuery(Long.class);
            Root<ResponseStatistics> root = query.from(ResponseStatistics.class);
            Join<ResponseStatistics, Quiz> join = root.join("quiz");
            query.select((builder.count(root))).where(builder.equal(join.get("quizId"),quizId));
            Query<Long> userStatusQuery = session.createQuery(query);
            count = userStatusQuery.getSingleResult();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return count;
    }

	public int retrieveStudentsCount() {
        int studentCount = 0;
		Transaction transaction = null;
        Session session = null;
        try  {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
            Root<User> user = criteriaQuery.from(User.class);
            criteriaQuery.select(builder.count(user));
            criteriaQuery.where(builder.equal(user.get("user_type"), "student"));
            Query<Long> query = session.createQuery(criteriaQuery);
            studentCount = (int)(long)query.getSingleResult();
            
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            session.close();
        }
		return studentCount;
	}

	public int retrieveStudentsQuizCount(int quizId) {
        int studentQuizCount = 0;
		Transaction transaction = null;
        Session session = null;
        try  {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            
            Query query = session.createSQLQuery(
            		"select count(distinct user_id) as count FROM `response_stats` WHERE Quiz_id = :quizId")
            		.setParameter("quizId", quizId);
    		List result = query.list();
    		studentQuizCount = Integer.parseInt(result.get(0).toString());
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            session.close();
        }
		return studentQuizCount;
	}

	
	public List<CalculatedScores> retrieveStudentsGrades(int quizId) {
        List<CalculatedScores> studentCalculatedScores = new ArrayList<CalculatedScores>();
		Transaction transaction = null;
        Session session = null;
        try  {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("from  " + CalculatedScores.class.getName() + " calculatedscores where Quiz_id = "+quizId);	            
            studentCalculatedScores = query.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            session.close();
        }
		return studentCalculatedScores;
	}
}