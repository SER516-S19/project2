package edu.asu.ser516.quiz.dao;

import edu.asu.ser516.quiz.dao.impl.QuizDetailsDaoBean;
import edu.asu.ser516.quiz.model.QuizDetails;

public class QuizDetailsDao{
	
	private static QuizDetailsDaoBean quizDetailsDaoBean = null;
	
	public QuizDetailsDao () {
		quizDetailsDaoBean = new QuizDetailsDaoBean();
	}
	
	public static synchronized void insert(QuizDetails vo) throws Exception {
        QuizDetailsDaoBean.insert(vo);
    }

    public static synchronized QuizDetails findQuizByPrimaryKey(String pPrimaryKey) throws Exception {
    	return quizDetailsDaoBean.findByPrimaryKey(pPrimaryKey);
    }
    
    public Boolean addEntry(String pKey, QuizDetails voEntry) throws Exception {
    	
    	QuizDetails vo = findQuizByPrimaryKey(pKey);
    	
    	if(vo == null) {
    		insert(voEntry);
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    

}
