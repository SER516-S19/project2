package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import bean.HibernateUtil;
import bean.ResponseStatistics;
import bean.User;

public class ResponseStatisticsDAO {

	
	public List<User> getUsersByQuizID(int quizId){
			Transaction transaction = null;
			List<User> quesList = new ArrayList<User>();

			try  {
				Session session = HibernateUtil.getSessionFactory().openSession();
				transaction = session.beginTransaction();
				CriteriaBuilder builder = session.getCriteriaBuilder();
				CriteriaQuery<User> query = builder.createQuery(User.class);
				Root<ResponseStatistics> root = query.from(ResponseStatistics.class);
				Join<ResponseStatistics,User> join = root.join("quiz");
//				query.select(root).where(builder.equal(join.get("quiz"),quizId));
				Query<User> questionByIdQuery = session.createQuery(query);
				quesList = questionByIdQuery.getResultList();
				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
				e.printStackTrace();
				return quesList;
			}
			return quesList;
	}
	

}
