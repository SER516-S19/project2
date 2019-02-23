package bean;
	public class Answer {
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


	    public int getAnswerNo() {
	        return ansno;
	    }


	    public void setAnswerNo(int ansno) {
	        this.ansno = ansno;
	    }


	    public Question getQuestion() {
	        return qs;
	    }


	    public void setQuestion(Question qs) {
	        this.qs = qs;
	    }


	    public String getAnswer() {
	        return ans;
	    }


	    public void setAnswer(String ans) {
	        this.ans = ans;
	    }


	    public boolean getCorrectAnswer() {
	        return correctAns;
	    }


	    public void setCorrectAnswer(boolean correctAnswer) {
	        this.correctAns = correctAns;
	    }


	    @Override
	    public String toString() {
	        return "Answer{" +
	                "ansno=" + ansno +
	                ", question=" + qs +
	                ", answer='" + ans + '\'' +
	                ", correctAnswer='" + correctAns + '\'' +
	                '}';
	    }
	}
