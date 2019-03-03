package bean;

import javax.persistence.*;

/**
 * This class represents the Quiz table
 *
 * @author : Jahnvi Rai
 * @version : 1.0
 * @since : 02/17/2019
 */

@Entity
@Table(name = "Quiz")
public class Quiz {

<<<<<<< HEAD
<<<<<<< HEAD
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
=======
<<<<<<< HEAD
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
=======
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
>>>>>>> origin/master
=======
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
>>>>>>> origin/master
    @Column(name = "Quiz_Id", nullable = false)
    private int quizId;

    @Column(name = "Name" , nullable = false)
    private String quizName;

    @Column(name="Instructions")
    private String quizInstructions;

    @Column(name ="Type")
    private String quizType;

    @Column(name = "Time_Limit")
    private String quizTimeLimit;

    @Column(name="Is_Shuffled")
    private boolean isShuffled;
    
    @Column(name="Is_Published")
    private boolean isPublished;
    
    Quiz() {}


    public Quiz(String quizName, String quizInstructions, String quizType, String quizTimeLimit, boolean isShuffled,
			boolean isPublished) {
		this.quizName = quizName;
		this.quizInstructions = quizInstructions;
		this.quizType = quizType;
		this.quizTimeLimit = quizTimeLimit;
		this.isShuffled = isShuffled;
		this.isPublished = isPublished;
	}
    
    public Quiz(int quizId, String quizName, String quizInstructions, String quizType, String quizTimeLimit, boolean isShuffled,
			boolean isPublished) {
		this.quizName = quizName;
		this.quizInstructions = quizInstructions;
		this.quizType = quizType;
		this.quizTimeLimit = quizTimeLimit;
		this.isShuffled = isShuffled;
		this.isPublished = isPublished;
		this.quizId = quizId;
	}


	public boolean isShuffled() {
		return isShuffled;
	}

	public void setShuffled(boolean isShuffled) {
		this.isShuffled = isShuffled;
	}

	public boolean getIsPublished() {
		return isPublished;
	}

	public void setIsPublished(boolean isPublished) {
		this.isPublished = isPublished;
	}

	public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public String getQuizInstructions() {
        return quizInstructions;
    }

    public void setQuizInstructions(String quizInstructions) {
        this.quizInstructions = quizInstructions;
    }

    public String getQuizType() {
        return quizType;
    }

    public void setQuizType(String quizType) {
        this.quizType = quizType;
    }

    public String getQuizTimeLimit() {
		return quizTimeLimit;
	}

	public void setQuizTimeLimit(String quizTimeLimit) {
		this.quizTimeLimit = quizTimeLimit;
	}

    @Override
    public String toString() {
        return "Quiz{" +
                "quizId=" + quizId +
                ", quizName='" + quizName + '\'' +
                ", quizInstructions='" + quizInstructions + '\'' +
                ", quizType='" + quizType + '\'' +
                ", quizTimeLimit=" + quizTimeLimit +
                ", isShuffled='" + isShuffled + '\'' +
                ", isPublished='" + isPublished + '\'' +
                '}';
    }
}
