package student.dto;

public class AnswerOption {
    private String ansDesc;
    private long ansId;
    private boolean isCorrect;
    public AnswerOption(long ansId, String ansDesc, boolean isCorrect) {
        this.ansDesc = ansDesc;
        this.ansId = ansId;
        this.isCorrect = isCorrect;
    }


    public boolean getIsCorrect() {
        return this.isCorrect;
    }

    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public long getAnsId() {
        return ansId;
    }

    public void setAnsId(long ans_id) {
        this.ansId = ansId;
    }

    public String getAnsDesc() {
        return ansDesc;
    }

    public void setAnsDesc(String ansDesc) {
        this.ansDesc = ansDesc;
    }
}

