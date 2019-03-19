package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.*;
import bean.Question;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import bean.HibernateUtil;
import bean.Quiz;

/**
 * This is a helper for implementing DAO pattern for accessing question data 
 * from database.
 * 
 * @author : Gangadhar Matti
 * @version : 1.0
 * @since 02-16-2019
 */
public class QuestionDAO {

	/**
	 * Method is used to add question in the Question table
	 */
	public void addQuestion(Question question) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(question);
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

	/**
	 * Method is used to update question information 
	 * in the question table
	 */
	public void updateQuestion(Question question) {
		Transaction transaction = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(question);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<Question> getQuestionsByQuizId(int quizId) {
		Transaction transaction = null;
		List<Question> quesList = new ArrayList<Question>();
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Question> query = builder.createQuery(Question.class);
			Root<Question> root = query.from(Question.class);
			Join<Question, Quiz> join = root.join("quiz");
			query.select(root).where(builder.equal(join.get("quizId"), quizId));
			Query<Question> questionByIdQuery = session.createQuery(query);
			quesList = questionByIdQuery.getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return quesList;
		} finally {
			session.close();
		}
		return quesList;
	}

	/**
	 * This method will delete questions from the quiz.
	 */
	public void deleteQuestionByQuestionId(String quesId) {
		Transaction transaction = null;
		Question quesList = null;
		Session session = null;
		try {
			int qId = Integer.parseInt(quesId);
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			quesList = (Question) session.get(Question.class, qId);
			session.delete(quesList);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return;
		} finally {
			session.close();
		}
		return;
	}
}