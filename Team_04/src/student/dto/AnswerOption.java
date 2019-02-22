package student.dto;

public class AnswerOption {
    private String ans_desc;
    private long ans_id;
    public AnswerOption(long ans_id, String ans_desc) {
        this.ans_desc = ans_desc;
        this.ans_id = ans_id;
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

