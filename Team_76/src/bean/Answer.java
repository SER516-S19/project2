package bean;
public class Answer {
	private int ansno;
	private Question qs;
	private String ans;
	private boolean correctAns;
	public Answer() {
	}	    
	public Answer(Question qs, String ans, boolean correctAns) {
	        this.qs = qs;
	        this.ans = ans;
	        this.correctAns = correctAns;
	}
	public Answer(Question qs, int ansno, String ans, boolean correctAns) {
	        this.qs = qs;
	        this.ans = ans;
	        this.correctAns = correctAns;
	        this.ansno = ansno;
	}
	/**
	* @return the answer number
	*/	
	public int getAnswerNo() {
	        return ansno;
	}
	public void setAnswerNo(int ansno) {
	        this.ansno = ansno;
	}
	/**
	* @return the question
	*/
	 public Question getQuestion() {
	        return qs;
	 }            
	 public void setQuestion(Question qs) {
	        this.qs = qs;
	 }
	 /**
	 * @return the answer 
	 */
	 public String getAnswer() {
	        return ans;
	 }
	 public void setAnswer(String ans) {
	        this.ans = ans;
	 }
	 /**
	 * @return the correct answer 
	 */
	 public boolean getCorrectAnswer() {
	        return correctAns;
	  }
	  public void setCorrectAnswer(boolean correctAnswer) {
	        this.correctAns = correctAns;
	  }
}
