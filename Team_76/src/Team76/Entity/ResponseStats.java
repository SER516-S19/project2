/*
 * package Team76.Entity;
 * 
 * import controller.*; import org.hibernate.Session; import
 * org.hibernate.Transaction; import org.hibernate.query.Query; import
 * javax.persistence.criteria.CriteriaBuilder; import
 * javax.persistence.criteria.CriteriaQuery; import
 * javax.persistence.criteria.Join; import javax.persistence.criteria.Root;
 * 
 * public class ResponseStats {
 * 
 * public void insertStudentResponse(ResponseStatistics stats){ Transaction
 * transaction = null; Session session = null; try { session =
 * HibernateUtil.getSessionFactory().openSession(); transaction =
 * session.beginTransaction(); session.save(stats); transaction.commit(); }
 * catch (Exception e) { if (transaction != null) { transaction.rollback(); }
 * e.printStackTrace(); } finally { session.close(); }
 * 
 * }
 * 
 * public long checkQuizStatus(int quizId){ Transaction transaction = null;
 * Session session = null; Long count= 0L; try { session =
 * HibernateUtil.getSessionFactory().openSession(); transaction =
 * session.beginTransaction(); CriteriaBuilder builder =
 * session.getCriteriaBuilder(); CriteriaQuery<Long> query =
 * builder.createQuery(Long.class); Root<ResponseStatistics> root =
 * query.from(QuestionEntity.class); Join<ResponseStatistics, Quiz> join =
 * root.join("quiz");
 * query.select((builder.count(root))).where(builder.equal(join.get("quizId"),
 * quizId)); Query<Long> userStatusQuery = session.createQuery(query); count =
 * userStatusQuery.getSingleResult(); transaction.commit(); session.close(); }
 * catch (Exception e) { if (transaction != null) { transaction.rollback(); }
 * e.printStackTrace(); } finally { session.close(); } return count; }
 * 
 * }
 */