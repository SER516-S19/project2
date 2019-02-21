package edu.asu.ser516.blackBoard.quiz.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import edu.asu.ser516.blackBoard.quiz.bean.HibernateUtil;
import edu.asu.ser516.blackBoard.quiz.bean.Question;
import edu.asu.ser516.blackBoard.quiz.bean.Quiz;

public class QuestionDAO {
	public void addQuestion(Question ques) {
		Transaction transaction = null;
		try  {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(ques);
			// commit transaction
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
		List<Question> quesList = null;
		try  {
			Session session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			quesList = (List<Question>) session.get(Question.class,quizId);
			session.save(quesList);
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

	public int getPointsByQuestion(String ques) {
		Transaction transaction = null;
		int points = -1;
		try  {
			Session session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Question question  = (Question)session.get(Question.class,ques);
			points = question.getPoints();
			session.save(ques);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return points;
		}
		return points;
	}
	
	
	public void deleteQuestionByQuestionId(String quesId){
		Transaction transaction = null;
		Question quesList = null;
		try  {
			int qId = Integer.parseInt(quesId);
			Session session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			quesList = (Question) session.get(Question.class, qId);
//			System.out.println(quesList.toString());
			session.delete(quesList);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return ;
		}
		return ;
	}
	
}
