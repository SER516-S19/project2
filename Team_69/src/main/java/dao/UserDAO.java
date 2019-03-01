package dao;

import bean.HibernateUtil;
import bean.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class UserDAO {

    public User fetchUserDetails(String userEmail){
        Transaction transaction = null;
        User user = null;
        Session session = null;

        try  {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<User> query = builder.createQuery(User.class);
            Root<User> root = query.from(User.class);
            query.select(root).where(builder.equal(root.get("userEmail"),userEmail));
            Query<User> userQuery = session.createQuery(query);
            user = userQuery.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return user;
        }finally {
            session.close();
        }
        return user;
    }
}
