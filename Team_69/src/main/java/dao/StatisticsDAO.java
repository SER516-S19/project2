package dao;

<<<<<<< HEAD
import bean.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
=======
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import bean.Answer;
import bean.CalculatedScores;
import bean.HibernateUtil;
import bean.ResponseStatistics;
import bean.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
import javax.persistence.criteria.Root;

/**
 * This is a helper class to perform database operations on the Response
 * Statistics table
 *
 * @author : Jahnvi Rai
 * @version : 1.0
 * @since : 02/18/2019
 */

public class StatisticsDAO {

<<<<<<< HEAD
=======
	/**
	 * This method adds the student response to the database
	 */
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
    public void insertStudentResponse(ResponseStatistics responseStatistics){
        Transaction transaction = null;
        Session session = null;
        try  {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(responseStatistics);
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

<<<<<<< HEAD
    public long checkQuizStatus(int quizId){
        Transaction transaction = null;
        Session session = null;
        Long count= 0L;
        try  {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Long> query = builder.createQuery(Long.class);
            Root<ResponseStatistics> root = query.from(ResponseStatistics.class);
            Join<ResponseStatistics, Quiz> join = root.join("quiz");
            query.select((builder.count(root))).where(builder.equal(join.get("quizId"),quizId));
            Query<Long> q = session.createQuery(query);
            count = q.getSingleResult();
            transaction.commit();
            session.close();
=======
    /**
	 * This method checks whether the student has given a particular quiz
	 */
    public int checkQuizStatus(int quizId,int userId){
        Transaction transaction = null;
        Session session = null;
        int userQuizCount= 0;
        try  {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery(
                    "select count(*) as count FROM `response_stats` WHERE Quiz_id = :quizId and user_id = :userId")
                    .setParameter("quizId", quizId)
                    .setParameter("userId",userId);
            List result = query.list();
            userQuizCount = Integer.parseInt(result.get(0).toString());
            transaction.commit();

>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            session.close();
        }
<<<<<<< HEAD
        return count;
    }



}
=======
        return userQuizCount;
    }

    /**
	 * This method returns the list of students in the system
	 */
	public int retrieveStudentsCount() {
        int studentCount = 0;
		Transaction transaction = null;
        Session session = null;
        try  {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
            Root<User> user = criteriaQuery.from(User.class);
            criteriaQuery.select(builder.count(user));
            criteriaQuery.where(builder.equal(user.get("user_type"), "student"));
            Query<Long> query = session.createQuery(criteriaQuery);
            studentCount = (int)(long)query.getSingleResult();
            
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
		return studentCount;
	}

	/**
	 * This method based on the quiz id returns the unique students who have given the quiz
	 */
	public int retrieveStudentsQuizCount(int quizId) {
        int studentQuizCount = 0;
		Transaction transaction = null;
        Session session = null;
        try  {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery(
            		"select count(distinct user_id) as count FROM `response_stats` WHERE Quiz_id = :quizId")
            		.setParameter("quizId", quizId);
    		List result = query.list();
    		studentQuizCount = Integer.parseInt(result.get(0).toString());
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
		return studentQuizCount;
	}

	/**
	 * This method based on the quiz id returns each students grades
	 */
	public List<CalculatedScores> retrieveStudentsGrades(int quizId) {
        List<CalculatedScores> studentCalculatedScores = new ArrayList<CalculatedScores>();
		Transaction transaction = null;
        Session session = null;
        try  {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("from  " + CalculatedScores.class.getName() +
            		" calculatedscores where Quiz_id = "+quizId);	            
            studentCalculatedScores = query.list();
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
		return studentCalculatedScores;
	}
	
	/**
	 * This method based on the quiz id returns the student responses
	 */
	public List<ResponseStatistics> getResponseOfEachQuestion(int quizId) {
		List<ResponseStatistics> lists = new ArrayList<>();
		 Transaction transaction = null;
	        try  {
	            Session session = HibernateUtil.getSessionFactory().openSession();
	            transaction = session.beginTransaction();
	            Query query = session.createQuery("from  " + ResponseStatistics.class.getName() +
	            		" res where res.quiz.quizId = "+quizId+ " and res.answer.correctAnswer=true");
	            lists = query.list();
	            transaction.commit();
	        } catch (Exception sqlException) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	        }
		return lists;
	}

	/**
	 * This method based on the quiz id returns the correct answer list
	 */
	public List<Answer> getCorrectResponseOfEachQuestion(int quizId) {
		List<Answer> lists = new ArrayList<>();
		 Transaction transaction = null;
	        try  {
	            Session session = HibernateUtil.getSessionFactory().openSession();
	            transaction = session.beginTransaction();
	            Query query = session.createQuery("from  " + Answer.class.getName() + 
	            		" ans where ans.question.quiz.quizId = "+quizId + " and ans.correctAnswer = true");
	            lists = query.list();
	            transaction.commit();
	        } catch (Exception sqlException) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	        }
		return lists;
	}
}
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
