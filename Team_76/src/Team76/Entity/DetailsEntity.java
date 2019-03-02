package Team76.Entity;
/**
*  SER516-Project2
*  @author Janani Anand,
*  @since 02/19/2019
*/
public class DetailsEntity {

	String quiztitle;
	String qinstruct;
	String qtype;
	String shuffleAns;
	String clockType;

	public DetailsEntity() {
	}
	
	public String getQuiztitle() {
		return quiztitle;
	}

	public void setQuiztitle(String quiztitle) {
		this.quiztitle = quiztitle;
	}

	public String getQinstruct() {
		return qinstruct;
	}

	public void setQinstruct(String qinstruct) {
		this.qinstruct = qinstruct;
	}

	public String getQtype() {
		return qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}
	
	public String getShuffleAns() {
		return shuffleAns;
	}

	public void setShuffleAns(String shuffleAns) {
		this.shuffleAns = shuffleAns;
	}

	public String getClocktype() {
		return clockType;
	}

	public void setClocktype(String clockType) {
		this.clockType = clockType;
	}
	
	public String toString() {
		return "DetailsEntity [quiztitle=" + quiztitle + ", qinstruct=" + qinstruct + ", qtype=" + qtype + ", shuffleAns=" + shuffleAns + ",clockType=" + clockType + "]";
	}

}
