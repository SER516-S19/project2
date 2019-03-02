package content.creator.servlet;


import content.creator.helper.ViewStudentListHelper;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/studentList")
public class ViewStudentListServlet extends HttpServlet {

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            try {
                List<Integer> studentId = ViewStudentListHelper.getStudentList();
                request.setAttribute("studentIds", studentId);
                request.getRequestDispatcher("viewStudentList.jsp").forward(request,response);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
