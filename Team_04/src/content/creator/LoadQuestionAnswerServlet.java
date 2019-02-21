package content.creator;

import com.dao.QuestionAnswerDAO;

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/servlet")
public class LoadQuestionAnswerServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
			Connection conn = null;
			try {
				// db parameters
				String url = "jdbc:sqlite:/Users/aj/Developer/SER-516/project2/Team_04/resources/quizDatabase.db";

				// create a connection to the database
				conn = DriverManager.getConnection(url);

				System.out.println("Connection to SQLite has been established.");

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
					if (conn != null) {
						try {
							Statement s =conn.createStatement();
							ResultSet rs = s.executeQuery("SELECT * FROM quiz_content");

							while (rs.next()) {
								System.out.println(rs.getString("ques_desc"));
							}

						} catch (SQLException e) {
							e.printStackTrace();
						}
					}

			}
	}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		response.setContentType("text/html");
		response.setStatus(response.SC_OK);

		QuestionAnswerDAO qaObj = new QuestionAnswerDAO();

		request.setAttribute("data", qaObj.getResult());

		RequestDispatcher rd =
				request.getRequestDispatcher("questionsanswers.jsp");

		rd.forward(request, response);



	}

}
