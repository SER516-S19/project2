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
	public List<Question> getQuestionsByQuizId(Quiz qz){
		Transaction transaction = null;
		List<Question> quesList = null;
		try  {
			Session session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			quesList = (List<Question>) session.get(Question.class,qz.getQuizId());
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

	public int getPointsByQuestion(Question ques) {
		Transaction transaction = null;
		int points = -1;
		try  {
			Session session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Question question  = (Question)session.get(Question.class,ques.getQuestion());
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
}
