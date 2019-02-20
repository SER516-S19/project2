package com.model;

public class Answers {

    private int ans_id;
    private String ans_desc;
    private boolean is_correct;
    private float max_score;

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