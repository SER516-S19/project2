package student.dto;

public class AnswerOption {
    private String ans_desc;
    private long ans_id;
    private boolean is_correct;
    public AnswerOption(long ans_id, String ans_desc, boolean is_correct) {
        this.ans_desc = ans_desc;
        this.ans_id = ans_id;
        this.is_correct = is_correct;
    }


    public boolean getIsCorrect() {
        return this.is_correct;
    }
    public void setIs_correct(boolean is_correct) {
        this.is_correct = is_correct;
    }

    public long getAns_id() {
        return ans_id;
    }

    public void setAns_id(long ans_id) {
        this.ans_id = ans_id;
    }

    public String getAns_desc() {
        return ans_desc;
    }

    public void setAns_desc(String ans_desc) {
        this.ans_desc = ans_desc;
    }
}

