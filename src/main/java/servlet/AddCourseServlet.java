package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.StudentDAO;
import DAO.DAOcn;
import model.Student;
import model.SupportClass;

@WebServlet("/addCoursePage")
public class AddCourseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private StudentDAO studentDAO = new StudentDAO();
    private DAOcn supportDAO = new DAOcn();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Lấy danh sách sinh viên từ cơ sở dữ liệu
            List<Student> students = studentDAO.getAllStudents();

            // Lấy danh sách người hỗ trợ từ cơ sở dữ liệu
            List<SupportClass> supports = supportDAO.getAllSupportClass();

            // Gán danh sách vào request attribute
            request.setAttribute("students", students);
            request.setAttribute("supports", supports);

            // Chuyển hướng đến trang addCourse.jsp
            request.getRequestDispatcher("/addCourse.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Lỗi khi lấy dữ liệu: " + e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
