package controller;
 
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.QuizVO;
import model.StudentResponseDAOBean;
import model.StudentResponseVO;
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
        	HttpSession session = req.getSession();
        	
        	int courseId = Integer.parseInt(session.getAttribute("courseId").toString());	
            int quizId = Integer.parseInt(req.getParameter("QuizId"));          	
			int userId = Integer.parseInt(session.getAttribute("userId").toString());
			String quizAlreadyTakenMsg = "";
            
            
            log.info("courseId in doget quiz inst"+courseId);
            log.info("quizId in doget quiz inst"+quizId);
            log.info("userId in doget quiz inst"+userId);
            
            StudentResponseDAOBean studentResponse = new StudentResponseDAOBean();
			
			List<StudentResponseVO> studentResponseVOList = studentResponse.getStudentListFromCourseIdQuizIdUserId(courseId,quizId,userId);
			
			
			log.info("studentResponseVOList size is "+studentResponseVOList.size());
			
			if(studentResponseVOList.size()  > 0)
			{

				log.info("You have already taken this quiz");
				quizAlreadyTakenMsg = "You have already taken this quiz";
			
			}
		
			
			
	
            
            QuizDAOBean quizBean = new QuizDAOBean();
            QuizVO quiz = quizBean.getQuiz(quizId);
            session.setAttribute("QuizVO", quiz);
            session.setAttribute("quizAlreadyTakenMsg", quizAlreadyTakenMsg);
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