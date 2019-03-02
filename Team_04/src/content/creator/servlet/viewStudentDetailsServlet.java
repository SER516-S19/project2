package content.creator.servlet;

import content.creator.dao.QuizResultsDAO;
import content.creator.helper.ViewStudentDetailsHelper;
import content.creator.helper.ViewStudentListHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/viewStudentDetails")
public class viewStudentDetailsServlet extends HttpServlet {
            protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            try{
                Integer studentNumber=Integer.parseInt(request.getParameter("studentId"));
                List<QuizResultsDAO> questionsList= ViewStudentDetailsHelper.getStudentDetails(studentNumber);

                //maps answers to question ID
                HashMap<Integer,List<String>> answerMap=new HashMap();
                for (QuizResultsDAO question : questionsList) {
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
                request.setAttribute("questions",quesData);
                request.setAttribute("answers",answerMap);
                request.getRequestDispatcher("viewContentDetails.jsp").forward(request,response);
            }

            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
