package controller;
 
import java.io.IOException;
import java.util.logging.Logger;
 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.QuizVO;
import model.QuizDAOBean;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
 
/**
 * Display Quiz Instruction Servlet is a controller that displays Quiz
 * instructions before student starts the quiz.
 *
 * @author Prashansa
 * @version 2.0
 * @date 02/28/2019
 **/
 
@WebServlet(name = "DisplayQuizInstructionServlet", urlPatterns = "/DisplayInst")
public class DisplayQuizInstructionServlet extends HttpServlet {
 
    private static Logger log = Logger.getLogger(DisplayQuizInstructionServlet.class.getName());
 
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
 
            int quizId = Integer.parseInt(req.getParameter("QuizId"));
            HttpSession session = req.getSession();
            QuizDAOBean quizBean = new QuizDAOBean();
            QuizVO quiz = quizBean.getQuiz(quizId);
            session.setAttribute("QuizVO", quiz);
            res.sendRedirect(req.getContextPath() + "/displayQuizInstruction.ftl");
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }
}