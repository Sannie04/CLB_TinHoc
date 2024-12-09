	package support;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.DAOcn;
import model.SupportClass;


/**
 * Servlet implementation class ListSupportServlet
 */
@WebServlet("/listSupport")
public class ListSupportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Khởi tạo DAO và lấy danh sách SupportClass
        DAOcn supportDAO = new DAOcn();
        List<SupportClass> listP = supportDAO.getAllSupportClass(); // Lấy tất cả các đối tượng

        // Kiểm tra xem list có dữ liệu không
        if (listP != null && !listP.isEmpty()) {
            System.out.println("Dữ liệu đã được lấy thành công từ DAO.");
        } else {
            System.out.println("Danh sách Support không có dữ liệu.");
        }

        // Gửi dữ liệu đến JSP
        request.setAttribute("listP", listP);

        // Chuyển tiếp đến JSP để hiển thị
        System.out.println("Đang chuyển tiếp đến JSP: ./supPort/menuSupPort.jsp");
        request.getRequestDispatcher("./supPort/menuSupPort.jsp").forward(request, response);
        //response.sendRedirect("./supPort/menuSupPort.jsp");
    }
}
