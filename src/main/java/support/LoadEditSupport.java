package support;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DAOcn;
import model.SupportClass;

/**
 * Servlet implementation class LoadEditSupport
 */
@WebServlet("/LoadEditSupport")
public class LoadEditSupport extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
		String maSupport = request.getParameter("maSupport");
		DAOcn dao = new DAOcn();
        SupportClass support = dao.getSupportByMaSupport(maSupport);
        request.setAttribute("support", support);
        request.getRequestDispatcher("./supPort/editSupport.jsp").forward(request, response);  // Đảm bảo đường dẫn chính xác
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
