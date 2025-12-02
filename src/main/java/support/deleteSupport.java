package support;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAOcn;
@WebServlet("/deleteSupport")
public class deleteSupport extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public deleteSupport() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Lấy tham số MaSupport từ request
        String maSupport = request.getParameter("maSupport");

        // Gọi DAO để xóa dữ liệu
        DAOcn dao = new DAOcn();
        dao.delete(maSupport);

        // Chuyển hướng về trang danh sách sau khi xóa
        response.sendRedirect("listSupport");
    }
}
