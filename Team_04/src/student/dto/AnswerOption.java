package student.dto;

/**
 * Class for Answer option attributes
 */
public class AnswerOption {

    private String ansDesc;
    private long ansId;
    private boolean isCorrect;

    /**
     * Constructor for the class Answeroption
     * @param ansId
     *        Unique ID for Options
     * @param ansDesc
     *        Description for answer
     * @param isCorrect
     *        Boolean to check the option correct or not
     */
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

    public void setAnsId(long ansId) {
        this.ansId = ansId;
    }

    public String getAnsDesc() {
        return ansDesc;
    }

    public void setAnsDesc(String ansDesc) {
        this.ansDesc = ansDesc;
    }
}