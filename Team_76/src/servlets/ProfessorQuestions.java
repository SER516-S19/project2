package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProfessorQuestions
 */
@WebServlet("/ProfessorQuestions")
public class ProfessorQuestions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfessorQuestions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Question = request.getParameter("Question");
		String Option1 = request.getParameter("Option1");
		String Option2 = request.getParameter("Option2");
		String Option3 = request.getParameter("Option3");
		String Option4 = request.getParameter("Option4");
		//send it to db
		request.setAttribute("Questions", "Next Question");
		RequestDispatcher rd = request.getRequestDispatcher("Questions.jsp");
		rd.forward(request, response);
		System.out.println("Questions are " + Question);
		doGet(request, response);
	}

}
