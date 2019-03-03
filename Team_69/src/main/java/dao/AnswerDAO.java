package dao;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import bean.Question;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import bean.Answer;
import bean.HibernateUtil;

<<<<<<< HEAD

=======
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
/**
 * This is a helper for implementing DAO pattern
 * for accessing answer data from database.
 * 
 * @author : Alsha Samantaray
 * @version : 1.0
 * @since : 02/20/2019
 */

public class AnswerDAO {
	
	public void addAnswer(Answer answer) {
		Transaction transaction = null;
<<<<<<< HEAD
<<<<<<< HEAD
		try  {
			Session session = HibernateUtil.getSessionFactory().openSession();
=======
		Session session = null;
		try  {
			session = HibernateUtil.getSessionFactory().openSession();
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
=======
		Session session = null;
		try  {
			session = HibernateUtil.getSessionFactory().openSession();
>>>>>>> Team_58
			transaction = session.beginTransaction();
			session.save(answer);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
<<<<<<< HEAD
<<<<<<< HEAD
=======
		}finally {
			session.close();
		}
	}
	

	public void updateQuestion(Answer answer) {
		Transaction transaction = null;
		Session session = null;
		try  {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(answer);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
=======
		}finally {
			session.close();
>>>>>>> Team_58
		}
	}
	
	public List<Answer> getAnswersByQuestionId(int questionId){
		Transaction transaction = null;
		List<Answer> answerDetails = null;
<<<<<<< HEAD
<<<<<<< HEAD
		try  {
			Session session = HibernateUtil.getSessionFactory().openSession();
=======
		Session session = null;
		try  {
			session = HibernateUtil.getSessionFactory().openSession();
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
=======
		Session session = null;
		try  {
			session = HibernateUtil.getSessionFactory().openSession();
>>>>>>> Team_58
			transaction = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Answer> query = builder.createQuery(Answer.class);
			Root<Answer> root = query.from(Answer.class);
			Join<Answer, Question> join = root.join("question");
			query.select(root).where(builder.equal(join.get("questionId"),questionId));
<<<<<<< HEAD
			Query<Answer> answerQuery = session.createQuery(query);
			answerDetails = answerQuery.getResultList();
=======
<<<<<<< HEAD
			Query<Answer> q = session.createQuery(query);
			answerDetails = q.getResultList();
=======
			Query<Answer> answerQuery = session.createQuery(query);
			answerDetails = answerQuery.getResultList();
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
>>>>>>> origin/master
			transaction.commit();
			session.close();
			for(Answer ans: answerDetails)
				System.out.println(ans.toString());
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return answerDetails;
<<<<<<< HEAD
<<<<<<< HEAD
		}
		return answerDetails;
	}
=======
=======
>>>>>>> Team_58
		}finally {
			session.close();
		}
		return answerDetails;
	}

	public void deleteAnswer(Integer questionId) {
		Transaction transaction = null;
		Session session = null;
		try  {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();		
			String hql = "delete from Answer where question_id= :questionId";
			session.createQuery(hql).setInteger("questionId", questionId).executeUpdate();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
<<<<<<< HEAD
=======
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
>>>>>>> origin/master
}
