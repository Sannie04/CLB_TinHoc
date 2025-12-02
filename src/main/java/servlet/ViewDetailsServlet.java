package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ClassnameDAO;
import model.ClassDetails;
import model.Student;
import model.SupportClass;
import DAO.StudentDAO;
import DAO.DAOcn;
@WebServlet("/viewDetails")
public class ViewDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(ViewDetailsServlet.class.getName());
    private StudentDAO studentDAO = new StudentDAO();
    private DAOcn supportDAO = new DAOcn();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy tham số mã lớp học từ request (kiểm tra lại tên tham số trong URL)
        String maLopHocParam = request.getParameter("maLopHoc");
        if (maLopHocParam == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Thiếu tham số mã lớp học.");
            return;
        }

        int maLopHoc = 0;
        try {
            maLopHoc = Integer.parseInt(maLopHocParam);
        } catch (NumberFormatException e) {
            logger.log(Level.WARNING, "Tham số mã lớp học không hợp lệ: " + maLopHocParam, e);
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Tham số mã lớp học không hợp lệ.");
            return;
        }

        ClassnameDAO dao = new ClassnameDAO();
        try {
            // Lấy thông tin chi tiết của lớp học
            ClassDetails details = dao.getClassDetailsByLop(maLopHoc);

            if (details == null) {
                request.setAttribute("error", "Không tìm thấy lớp học với mã " + maLopHoc);
                RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
                dispatcher.forward(request, response);
                return;
            }

            // Lấy danh sách sinh viên và hỗ trợ từ DTO
            List<Student> studentsdetails = details.getStudents();
            List<SupportClass> supportsdetails = details.getSupports();

            // Đưa thông tin lớp học vào request để truyền sang JSP
            request.setAttribute("lop", details); // Corrected this line

            // Đưa danh sách sinh viên và hỗ trợ vào request
            request.setAttribute("studentsdetails", studentsdetails);
            request.setAttribute("supportsdetails", supportsdetails);
            
            List<Student> students = studentDAO.getAllStudents();

            // Lấy danh sách người hỗ trợ từ cơ sở dữ liệu
            List<SupportClass> supports = supportDAO.getAllSupportClass();

            // Gán danh sách vào request attribute
            request.setAttribute("students", students);
            request.setAttribute("supports", supports);
            // Chuyển hướng tới JSP
            RequestDispatcher dispatcher = request.getRequestDispatcher("viewDetails.jsp");
            dispatcher.forward(request, response);

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Lỗi cơ sở dữ liệu khi lấy thông tin lớp học ID: " + maLopHoc, e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Lỗi truy vấn dữ liệu.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Chuyển hướng POST về GET
        doGet(request, response);
    }

    @Override
    public void destroy() {
        // Đóng tài nguyên nếu cần thiết
        logger.info("Servlet ViewDetailsServlet đã được hủy.");
    }
}