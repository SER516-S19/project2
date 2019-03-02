package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import bean.CalculatedScores;
import bean.HibernateUtil;

/**
 * This is a helper for implementing DAO pattern for accessing student score
 * data from database.
 * 
 * @author : Alsha Samantaray
 * @version : 1.0
 * @since : 03/01/2019
 */
public class CalculatedScoresDAO {
	public int getStudentScoreByQuizId(int quizId, int userId) {
		Transaction transaction = null;
		Session session = null;
		List<CalculatedScores> studentScores = new ArrayList<CalculatedScores>();
		int score = -1;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from  " + CalculatedScores.class.getName()
					+ " score where score.quiz.quizId = " + quizId + " AND score.user.user_id = " + userId);
			studentScores = query.list();
			score = (int) studentScores.get(0).getScore();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return score;
	}

	public void insertCalculatedScore(CalculatedScores calculatedScores) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(calculatedScores);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
