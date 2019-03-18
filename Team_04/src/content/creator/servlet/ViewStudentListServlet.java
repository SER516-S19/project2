package content.creator.servlet;

import content.creator.helper.ViewStudentListHelper;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/*
 *@author Sakshi Gautam
 *@version 1.4
 *@since   2019-02-28
 *Description: Fetches the student list and sends response to the view.
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


