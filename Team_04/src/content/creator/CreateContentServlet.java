package content.creator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@WebServlet(name = "create")
public class CreateContentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String score = request.getParameter("score");
        String isCorrect = request.getParameter("choice");
        int quizId = generateRandom(100,999);
        int questionId = generateRandom(1000,9999);
        Map<Integer, ArrayList<String>> collectionOfInputData = new HashMap<Integer, ArrayList<String>>();
        for(int i = 1; i<=4; i++) {
            ArrayList<String> ansList = new ArrayList<String>();
            String ansChoice = request.getParameter(Integer.toString(i));
            ansList.add(ansChoice);
            if(isCorrect.equals(Integer.toString(i)))
                ansList.add("true");
            else
                ansList.add("false");
            int ansId = generateRandom(10000,99999);
            collectionOfInputData.put(ansId,ansList);
        }
       // saveDataToDb(quizId,questionId,collectionOfInputData,score,questionText);
        //response.sendRedirect("viewContentList.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected int generateRandom(int min, int max){
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}
