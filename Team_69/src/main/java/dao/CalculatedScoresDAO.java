package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.NativeQuery;
import bean.CalculatedScores;
import bean.HibernateUtil;


/**
 * This is a helper for implementing DAO pattern
 * for accessing student score data from database.
 * 
 * @author : Alsha Samantaray
 * @version : 1.0
 * @since : 03/01/2019
 */
public class CalculatedScoresDAO {
	public int getStudentScoreByQuizId(int quizId, int userId) {
		Transaction transaction = null;
		Session session = null;
		int score = -1;
		try  {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			 Query query = session.createQuery("from  " + CalculatedScores.class.getName() + 
					 " score where score.quiz.quizId = "+quizId+"AND score.user.user_id = "+userId);
			 score = Integer.parseInt(query.uniqueResult().toString());
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
		return score;
	}

	public void insertCalculatedScore(CalculatedScores calculatedScores){
		Transaction transaction = null;
		Session session = null;
		try  {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(calculatedScores);
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

}
