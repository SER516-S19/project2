package com.model;

public class QuestionAnswers {
	
	private int ques_id;
	private String ques_type;
	private String ques_desc;
	public int getQues_id() {
		return ques_id;
	}


	private int ans_id;
	private String ans_desc;
	private boolean is_correct;
	private float max_score;

	public void setQues_id(int ques_id) {
		this.ques_id = ques_id;
	}

	public String getQuesType() {
		return ques_type;
	}

	public void setQues_type(String ques_type) {
		this.ques_type = ques_type;
	}

	public String getQuesDesc() {
		return ques_desc;
	}

	public void setQues_desc(String ques_desc) {
		this.ques_desc = ques_desc;
	}



	public int getAns_id() {
		return ans_id;
	}

	public void setAns_id(int ans_id) {
		this.ans_id = ans_id;
	}

	public String getAns_desc() {
		return ans_desc;
	}

	public void setAns_desc(String ans_desc) {
		this.ans_desc = ans_desc;
	}

	public boolean isIs_correct() {
		return is_correct;
	}

	public void setIs_correct(boolean is_correct) {
		this.is_correct = is_correct;
	}

	public float getMax_score() {
		return max_score;
	}

	public void setMax_score(float max_score) {
		this.max_score = max_score;
	}
	
	
}
