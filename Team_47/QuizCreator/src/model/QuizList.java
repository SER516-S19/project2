package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuizList {

    private String quizName;
    private String quizInstructions;

    QuizList() { }

    public QuizList(String quizName, String quizInstructions) {
        this.quizName = quizName;
        this.quizInstructions = quizInstructions;
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
    
    public static String createQuizSelectTable() {
    	// This should ultimately come from DB.
    	String[] quizNo = {"1", "2", "3", "4", "5"};
		String[] instructions = {"This is pretty easy!", "A little bit hard.",
				"Extremely Hard", "SUPER HOT!", "BYE BYE"};
		
		List<Map<String,String>> maps = new ArrayList<Map<String,String>>();
		
		for(int i = 0; i<quizNo.length ; i++) {
			HashMap<String, String> temp = new HashMap<String, String>();
		    temp.put("quizNo", quizNo[i]);
		    temp.put("instruction", instructions[i]);
			maps.add(temp);
		}
		// ------------------------------------------------------

		StringBuilder buf = new StringBuilder();
		
		for (Map<String, String> map: maps) {
			String myNo = map.get("quizNo");
			String myIns = map.get("instruction");
			buf.append(String.format(
					"<tr>" +
                    "<td>%s</td>" +
                    "<td>%s</td>" +
                "</tr>", myNo, myIns));
		}
		String html = buf.toString();
		return html;
    }
}
