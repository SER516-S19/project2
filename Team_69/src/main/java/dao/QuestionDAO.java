package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.*;
import bean.Question;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import bean.Answer;
import bean.HibernateUtil;
import bean.Quiz;

public class QuestionDAO {

	public void addQuestion(Question question) {
		Transaction transaction = null;
<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
		try  {
			Session session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(question);
=======
>>>>>>> origin/master
=======
>>>>>>> origin/master
		Session session = null;
		try  {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(question);
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
>>>>>>> origin/master
=======
>>>>>>> origin/master
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
		}
	}

	public List<Question> getQuestionsByQuizId(int quizId){

		Transaction transaction = null;
		List<Question> quesList = new ArrayList<Question>();

		try  {
			Session session = HibernateUtil.getSessionFactory().openSession();
=======
>>>>>>> origin/master
=======
>>>>>>> origin/master
		}finally {
			session.close();
		}
	}

	public void updateQuestion(Question question) {

		Transaction transaction = null;
		try  {
			Session session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			/*Question question =  session.get(Question.class,questionNew.getQuestionId());
			
			System.out.println(question);
			System.out.println(questionNew.getQuestionId());
			System.out.println(questionNew.getQuestion());
			question.setQuestion(questionNew.getQuestion());*/
			session.saveOrUpdate(question);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public List<Question> getQuestionsByQuizId(int quizId){

		Transaction transaction = null;
		List<Question> quesList = new ArrayList<Question>();
		Session session = null;
		
		try  {
			session = HibernateUtil.getSessionFactory().openSession();
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
>>>>>>> origin/master
=======
>>>>>>> origin/master
			transaction = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Question> query = builder.createQuery(Question.class);
			Root<Question> root = query.from(Question.class);
			Join<Question,Quiz> join = root.join("quiz");
			query.select(root).where(builder.equal(join.get("quizId"),quizId));
<<<<<<< HEAD
<<<<<<< HEAD
			Query<Question> questionByIdQuery = session.createQuery(query);
			quesList = questionByIdQuery.getResultList();
=======
<<<<<<< HEAD
			Query<Question> q = session.createQuery(query);
			quesList = q.getResultList();
=======
			Query<Question> questionByIdQuery = session.createQuery(query);
			quesList = questionByIdQuery.getResultList();
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
>>>>>>> origin/master
=======
			Query<Question> questionByIdQuery = session.createQuery(query);
			quesList = questionByIdQuery.getResultList();
>>>>>>> origin/master
			for(Question qu: quesList)
				System.out.println(qu.toString());
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return quesList;
<<<<<<< HEAD
<<<<<<< HEAD
		}finally {
			session.close();
=======
<<<<<<< HEAD
>>>>>>> origin/master
		}
		return quesList;
	}
	
	/**
	 * This method will delete questions from the quiz.
	 */
	public void deleteQuestionByQuestionId(String quesId){
		Transaction transaction = null;
		Question quesList = null;
<<<<<<< HEAD
=======
		try  {
			int qId = Integer.parseInt(quesId);
			Session session = HibernateUtil.getSessionFactory().openSession();
=======
=======
>>>>>>> origin/master
		}finally {
			session.close();
		}
		return quesList;
	}
	
	/**
	 * This method will delete questions from the quiz.
	 */
	public void deleteQuestionByQuestionId(String quesId){
		Transaction transaction = null;
		Question quesList = null;
>>>>>>> origin/master
		Session session = null;
		try  {
			int qId = Integer.parseInt(quesId);
			session = HibernateUtil.getSessionFactory().openSession();
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
>>>>>>> origin/master
=======
>>>>>>> origin/master
			transaction = session.beginTransaction();
			quesList = (Question) session.get(Question.class, qId);
			session.delete(quesList);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return ;
<<<<<<< HEAD
<<<<<<< HEAD
		}finally {
			session.close();
=======
<<<<<<< HEAD
>>>>>>> origin/master
		}
		return ;
	}
		
	/**
	 * Joins the question and answer table in Database.
	 */
	public List<Answer> getQuestionsAndAnswers(int quizId) {
		Transaction transaction = null;
	       List<Answer> quesList = new ArrayList<Answer>();
<<<<<<< HEAD
	       Session session = null;
	       try  {
	           session = HibernateUtil.getSessionFactory().openSession();
=======
	       try  {
	           Session session = HibernateUtil.getSessionFactory().openSession();
=======
=======
>>>>>>> origin/master
		}finally {
			session.close();
		}
		return ;
	}
		
	/**
	 * Joins the question and answer table in Database.
	 */
	public List<Answer> getQuestionsAndAnswers(int quizId) {
		Transaction transaction = null;
	       List<Answer> quesList = new ArrayList<Answer>();
	       Session session = null;
	       try  {
	           session = HibernateUtil.getSessionFactory().openSession();
<<<<<<< HEAD
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
>>>>>>> origin/master
=======
>>>>>>> origin/master
	           transaction = session.beginTransaction();
	           CriteriaBuilder builder = session.getCriteriaBuilder();
	           CriteriaQuery<Answer> query = builder.createQuery(Answer.class);
	           Root<Answer> root = query.from(Answer.class);
	           Join<Answer, Question> join = root.join("question");
	           query.select(root).where(root.get("quiz").in(quizId));
	           Query<Answer> q=session.createQuery(query);
	           quesList= q.getResultList();
	           transaction.commit();
	       } catch (HibernateException e) {
	           e.printStackTrace();
	           if (transaction != null) {
	               transaction.rollback();
	           }
<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
	       }
	       return quesList;
	}
	
}
=======
>>>>>>> origin/master
=======
>>>>>>> origin/master
	       }finally {
				session.close();
			}
       return quesList;
	}

	public List<Answer> getDataByQuestionId(String quesId) {
		Transaction transaction = null;
		Question quesList = null;
		Session session = null;
		List<Answer> lists = new ArrayList<>();
		try  {
			int qId = Integer.parseInt(quesId);
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from  " + Answer.class.getName() + 
					" ans where ans.question.questionId = "+qId);	            
            lists = query.list();
            transaction.commit();
		} catch (Exception sqlException) {
            if (transaction != null)
                transaction.rollback();
        }finally {
			session.close();
		}
	return lists;
}

	public void editQuestionByQuestionId(String quesId) {
		Transaction transaction = null;
		Question quesList = null;
		Session session = null;
		try  {
			int qId = Integer.parseInt(quesId);
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			quesList = (Question) session.get(Question.class, qId);
			session.save(quesList);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return ;
		}finally {
			session.close();
		}
		return ;	
	}	
<<<<<<< HEAD
<<<<<<< HEAD
}
=======
}
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
>>>>>>> origin/master
=======
}
>>>>>>> origin/master
