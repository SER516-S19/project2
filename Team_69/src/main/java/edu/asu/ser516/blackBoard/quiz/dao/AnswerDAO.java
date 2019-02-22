package edu.asu.ser516.blackBoard.quiz.dao;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import edu.asu.ser516.blackBoard.quiz.bean.Answer;
import edu.asu.ser516.blackBoard.quiz.bean.HibernateUtil;
import edu.asu.ser516.blackBoard.quiz.bean.Question;

/**
 * This is a helper for implementing DAO pattern
 * for accessing answer data from database.
 * 
 * @author : Alsha Samantaray
 * @version : 1.0
 * @since : 02/20/2019
 */
public class AnswerDAO {
	
	public List<Answer> getAnswersByQuestionId(int questionId){
		Transaction transaction = null;
		List<Answer> answerDetails = null;
		try  {
			Session session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Answer> query = builder.createQuery(Answer.class);
			Root<Answer> root = query.from(Answer.class);
			Join<Answer,Question> join = root.join("question");
			query.select(root).where(builder.equal(join.get("questionId"),questionId));
			Query<Answer> q = session.createQuery(query);
			answerDetails = q.getResultList();
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
		}
		return answerDetails;
	}
}
