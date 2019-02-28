package content.creator.servlet;

import content.creator.dao.QuizContentDAO;
import content.creator.helper.ViewContentDetailsHelper;
import student.dto.QuizContent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@WebServlet(urlPatterns = "/viewContentDetails")
public class ViewContentDetailsServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            Integer quizNumber=Integer.parseInt(request.getParameter("quizId"));
            List<QuizContentDAO> questionsList= ViewContentDetailsHelper.getQuizContent(quizNumber);
            List<String> answers=new ArrayList<>();
//            for (QuizContentDAO question :questionsList) {
//                answers.add(question.getAnsDesc());
//            }
            HashMap<Integer,List<String>> answerMap=new HashMap<Integer, List<String>>();
            for (QuizContentDAO question : questionsList) {
                    Integer key=question.getQuesId();
                if(answerMap.containsKey(key)){
                    List<String> answerList=answerMap.get(key);
                    answerList.add(question.getAnsDesc());
                }
                else{
                    List<String> answerList=new ArrayList<String>();
                    answerList.add(question.getAnsDesc());
                    answerMap.put(key,answerList);
                }
            }
            System.out.println(answerMap);
            request.setAttribute("questions",questionsList);
           request.setAttribute("answers",answerMap);
               // for (QuizContentDAO question : questionsList ) {

                    //Map<QuizContentDAO,List<String>> collect = questionsList.stream().collect(Collectors.groupingBy(QuizContentDAO::getQuesId,QuizContentDAO::getQuesDesc,)
                //}




            //singleLevelGrouping(questionsList);
            request.getRequestDispatcher("viewContentDetails.jsp").forward(request,response);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

   }
    public void singleLevelGrouping(List<QuizContentDAO> quizContentDAOList) {

        Map<Integer, List<QuizContentDAO>> groupQuizQuestions = quizContentDAOList.stream().collect(Collectors.groupingBy(QuizContentDAO::getQuesId));

        System.out.println(groupQuizQuestions);



        }
}

