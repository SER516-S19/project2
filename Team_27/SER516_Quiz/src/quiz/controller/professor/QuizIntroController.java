package quiz.controller.professor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import quiz.dao.ConnectionFactory;
import quiz.dao.professor.QuizDetailsDao;
import quiz.exceptions.DataAccessException;
import quiz.exceptions.NoDataFoundException;

//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * Servlet implementation class QuizIntroController
 */
public class QuizIntroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		QuizDetailsDao quizDetailsDao = new QuizDetailsDao();
		
		ArrayList rowValues = new ArrayList();
		try {
		rowValues = quizDetailsDao.getAll();
		}
		catch(DataAccessException e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("rowValues", rowValues);
		response.sendRedirect("showQuizes.jsp");
		

	}

}
