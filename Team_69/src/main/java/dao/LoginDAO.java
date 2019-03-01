package dao;

import bean.HibernateUtil;
import bean.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class LoginDAO {

    public String checkUserType(String userEmail){
        Transaction transaction = null;
        String userType = null;
        Session session = null;

        try  {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<String> query = builder.createQuery(String.class);
            Root<User> root = query.from(User.class);
            query.select(root.get("user_type")).where(builder.equal(root.get("user_email"),userEmail));
            Query<String> userQuery = session.createQuery(query);
            userType = userQuery.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return userType;
        }finally {
            session.close();
        }
        return userType;
    }

    public int fetchUserId(String userEmail){
        Transaction transaction = null;
        int userId = 0;
        Session session = null;

        try  {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Integer> query = builder.createQuery(Integer.class);
            Root<User> root = query.from(User.class);
            query.select(root.get("user_id")).where(builder.equal(root.get("user_email"),userEmail));
            Query<Integer> userQuery = session.createQuery(query);
            userId = userQuery.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return userId;
        }finally {
            session.close();
        }
        return userId;

    }
}
