package content.creator.servlet;

import content.creator.dao.QuizContentDAO;
import content.creator.helper.ViewContentDetailsHelper;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.*;

/*
* Modified by: Archana Madhavan
* Date: 28/2/19
* Description: Fetches the quiz details and sends response to the view.
*
*  */

@WebServlet(urlPatterns = "/viewContentDetails")
public class ViewContentDetailsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            Integer quizNumber=Integer.parseInt(request.getParameter("quizId"));
            List<QuizContentDAO> questionsList= ViewContentDetailsHelper.getQuizContent(quizNumber);

            //maps answers to question ID
            HashMap<Integer,List<String>> answerMap=new HashMap();
            for (QuizContentDAO question : questionsList) {
                    Integer key=question.getQuesId();
                if(answerMap.containsKey(key)){
                    List<String> answerList=answerMap.get(key);
                    answerList.add(question.getAnsDesc());
                }
                else{
                    List<String> answerList=new ArrayList();
                    answerList.add(question.getAnsDesc());
                    answerMap.put(key,answerList);
                }
            }

            //maps question details to question ID
            Map<Integer, Map<String, String>> quesData = new HashMap<>();
            for (QuizContentDAO question : questionsList) {
                Integer quesId = question.getQuesId();
                if(!quesData.containsKey(quesId)) {
                    Map<String, String> details = new HashMap<>();
                    details.put("desc", question.getQuesDesc());
                    details.put("score", Integer.toString(question.getMaxScore()));
                    quesData.put(quesId, details);
                }
            }
            request.setAttribute("quizId",quizNumber);
            request.setAttribute("questions",quesData);
            request.setAttribute("answers",answerMap);
            request.getRequestDispatcher("viewContentDetails.jsp").forward(request,response);
    }

        catch (Exception e) {
            e.printStackTrace();
        }
   }
}

