package edu.asu.ser516.quiz.dao;

import edu.asu.ser516.quiz.dao.impl.QuestionsDaoBean;
import edu.asu.ser516.quiz.model.Question;

public class QuestionsDao {
	private static QuestionsDaoBean questionsDaoBean = null;
	
	public QuestionsDao () {
		questionsDaoBean = new QuestionsDaoBean();
	}
	
	public static synchronized void insert(QuizDetails vo) throws Exception {
		questionsDaoBean.insert(vo);
    }

    public static synchronized Question findQuizByPrimaryKey(String pPrimaryKey) throws Exception {
    	return questionsDaoBean.findByPrimaryKey(pPrimaryKey);
    }
    
    public Boolean addEntry(String pKey, QuizDetails voEntry) throws Exception {
    	
    	Question vo = findQuizByPrimaryKey(pKey);
    	
    	if(vo == null) {
    		insert(voEntry);
    		return true;
    	}
    	else {
    		return false;
    	}
    }

}
