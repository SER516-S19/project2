package content.creator.servlet;

import content.creator.helper.ViewStudentListHelper;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/*
 * Modified by: Sakshi Gautam
 * Date: 30/2/19
 * Description: Fetches the student list and sends response to the view.
 *
 */

@WebServlet(urlPatterns = "/studentList")
public class ViewStudentListServlet extends HttpServlet {

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            try {
                List<Integer> studentIdList = ViewStudentListHelper.getStudentList();
                request.setAttribute("studentIds", studentIdList);
                request.getRequestDispatcher("viewStudentList.jsp").forward(request,response);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


