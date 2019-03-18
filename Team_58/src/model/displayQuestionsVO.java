package model;

import java.util.List;
import java.util.Random;
import java.lang.Math;
import java.util.logging.Logger;
import java.util.ArrayList;

import controller.DisplayQuizServlet;


/*This class is created to display Questions to a student. It's a plain old java object file.
 * @author Jainish Soni
 * @author Subhradeep Biswas
 * @date Created - 03/02/2019
 */
public class displayQuestionsVO {
	
	private static Logger log = Logger.getLogger(DisplayQuizServlet.class.getName());
	
	private int quizId;
	private int questionId;
	private String question;
	private List<String> answers = new ArrayList<String>();;
	private int totalPoints;
	private boolean isMCQ;
	
	public int getQuizId() {
		return quizId;
	}
	public int getqId() {
		return questionId;
	}
	public String getQuestion() {
		return question;
	}
	
	public displayQuestionsVO(int quizId, String question, List<String> correctAnswers, List<String> incorrectAnswers, int totalPoints, boolean isMCQ) {
		
		super();
		this.quizId = quizId;
		this.question = question;
		this.totalPoints = totalPoints;
		this.isMCQ = isMCQ;
		
		int cLen = correctAnswers.size();
		int icLen = incorrectAnswers.size();
		int iter = Math.min(icLen, cLen);
		
		log.info("iter is"+iter);
		//int idx;
		int chs;
		for (int i=0; i<iter; i++) {
			chs = getRandomNumberInRange(0, 10);
			log.info("Chs is"+chs);
			log.info("i is"+i);
			if (chs%2 == 0)
				this.answers.add(correctAnswers.get(i));
			if (chs%2 == 1)
				this.answers.add(incorrectAnswers.get(i));
			
		}
		
		if ((incorrectAnswers.size() - iter)>0){
			for (int j=iter; j<incorrectAnswers.size(); j++) {
				this.answers.add(incorrectAnswers.get(j));
			}
		}
		if ((correctAnswers.size() - iter)>0){
			for (int j=iter; j<correctAnswers.size(); j++) {
				this.answers.add(correctAnswers.get(j));
			}
		}
	}

	public displayQuestionsVO(int qId, int totalPoints, List<String> correctAnswers, List<String> incorrectAnswers, String question) {
		
		this.questionId = qId;
		this.question = question;
		this.totalPoints = totalPoints;
		
		int cLen = correctAnswers.size();
		int icLen = incorrectAnswers.size();
		int iter = Math.min(icLen, cLen);
		
		log.info("cLen is"+cLen);
		log.info("icLen is"+icLen);
		log.info("Incorrect 0 is  "+incorrectAnswers.get(0));
		
		
		log.info("iter is"+iter);
		
		//int idx;
		int chs;
		for (int i=0; i<iter; i++) {
			chs = getRandomNumberInRange(0, 10);
			log.info("Chs is"+chs);
			log.info("i is"+i);
			
			if (chs%2 == 0)
				log.info("Incorrect 0 is  "+incorrectAnswers.get(i));
				log.info("i is"+i);
				this.answers.add(correctAnswers.get(i));
			if (chs%2 == 1)
				log.info("Incorrect 0 is  "+incorrectAnswers.get(i));
				log.info("i is"+i);
				this.answers.add(incorrectAnswers.get(i));
			
		}
		
		if ((incorrectAnswers.size() - iter)>0){
			for (int j=iter; j<incorrectAnswers.size(); j++) {
				this.answers.add(incorrectAnswers.get(j));
			}
		}
		if ((correctAnswers.size() - iter)>0){
			for (int j=iter; j<correctAnswers.size(); j++) {
				this.answers.add(correctAnswers.get(j));
			}
		}
	}
	
	public int getTotalPoints() {
		return totalPoints;
	}
	public List<String> getAnswers() {
		return answers;
	}

	public boolean isMCQ() {
		return isMCQ;
	}
	
	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
}
