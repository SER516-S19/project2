package dao;

import bean.HibernateUtil;
import bean.Quiz;
import bean.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a helper class to perform database operations on the User table
 *
 * @author : Jahnvi Rai
 * @version : 1.0
 * @since : 02/28/2019
 */

public class UserDAO {

	public User fetchUserDetails(String userEmail) {
		Transaction transaction = null;
		User user = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<User> query = builder.createQuery(User.class);
			Root<User> root = query.from(User.class);
			query.select(root).where(builder.equal(root.get("userEmail"), userEmail));
			Query<User> userQuery = session.createQuery(query);
			user = userQuery.getSingleResult();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return user;
		} finally {
			session.close();
		}
		return user;
	}

	public User getUserById(int userId) {
		Transaction transaction = null;
		User user = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<User> query = builder.createQuery(User.class);
			Root<User> root = query.from(User.class);
			query.select(root).where(builder.equal(root.get("user_id"), userId));
			Query<User> userQuery = session.createQuery(query);
			user = userQuery.getSingleResult();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return user;
		} finally {
			session.close();
		}
		return user;
	}

	public List<String> fetchAllUsers(){
		Transaction transaction = null;
		Session session = null;
		List<String> userList = new ArrayList<String>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<String> query = builder.createQuery(String.class);
			Root<User> root = query.from(User.class);
			query.select(root.<String>get("userEmail"));
			Query<String> userListQuery = session.createQuery(query);
			userList = userListQuery.getResultList();
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return userList;
	}
}
