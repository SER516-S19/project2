package org.team47.database;

/**
 * A business object for a question in the questions table.
 *
 * @author  Paul Horton
 * @version 1.0
 * @since   2/22/19
 */
public class Question {
    private int question_id;
    private int quiz_fk;
    private String quesType;
    private float points;
    private String content;

    /**
     * @param question_id unique key for a question
     * @param quiz_fk foreign key for the quiz the question belongs to
     * @param quesType question type (MC/MA for multiple choice/answer)
     * @param points number of points
     * @param content content of question
     */
    public Question(int question_id, int quiz_fk, String quesType, float points, String content) {
        this.question_id = question_id;
        this.quiz_fk = quiz_fk;
        this.quesType = quesType;
        this.points = points;
        this.content = content;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getQuiz_fk() {
        return quiz_fk;
    }

    public void setQuiz_fk(int quiz_fk) {
        this.quiz_fk = quiz_fk;
    }

    public String getQuesType() {
        return quesType;
    }

    public void setQuesType(String quesType) {
        this.quesType = quesType;
    }

    public float getPoints() {
        return points;
    }

    public void setPoints(float points) {
        this.points = points;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * toString
     * @return string representation of question object
     */
    public String toString() {
        String result = "Question {" + "\n" +
                "  question_id: " + Integer.toString(question_id) + "\n" +
                "  quiz_fk: " + Integer.toString(quiz_fk) + "\n" +
                "  quesType: " + quesType + "\n" +
                "  points: " + Float.toString(points) + "\n" +
                "  content: " + content + "\n" +
                "}";
        return result;
    }
}
