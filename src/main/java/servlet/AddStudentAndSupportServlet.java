package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CoursesDAO;
import DAO.DAOcn;
import DAO.StudentDAO;

/**
 * Servlet implementation class AddStudentAndSupportServlet
 */
@WebServlet("/add")
public class AddStudentAndSupportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDAO studentDAO = new StudentDAO();
    private DAOcn supportDAO = new DAOcn();
    // Giả sử bạn có đối tượng DAO để làm việc với cơ sở dữ liệu
    private CoursesDAO coursesDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        // Khởi tạo DAO (có thể bạn cần thay đổi cách khởi tạo tùy vào cách bạn cấu hình DAO)
        coursesDAO = new CoursesDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ form
    	// Lấy giá trị từ request
    	String maLopHocString = request.getParameter("maLopHoc");

    	// Khởi tạo giá trị mặc định
    	int maLopHoc = Integer.parseInt(maLopHocString);  

        // Thêm sinh viên vào khóa học
        String[] selectedStudents = request.getParameterValues("selectedStudents");
        if (selectedStudents != null) {
            for (String maSinhVien : selectedStudents) {
                if (maSinhVien != null && !maSinhVien.trim().isEmpty()) {
                    // Gọi phương thức DAO để thêm sinh viên vào khóa học
                	coursesDAO.addStudentToCourse(maLopHoc, maSinhVien);
                }
            }
        }

        // Thêm người hỗ trợ vào khóa học
        String supportPerson = request.getParameter("supportPerson");
        if (supportPerson != null && !supportPerson.trim().isEmpty()) {
            // Gọi phương thức DAO để thêm người hỗ trợ vào khóa học
            coursesDAO.addSupportToCourse(maLopHoc, supportPerson);
        }

        // Sau khi xử lý, chuyển hướng về trang danh sách khóa học hoặc trang cần thiết
        request.setAttribute("maLopHoc", maLopHoc);
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewDetails");
        dispatcher.forward(request, response);  
    }

    @Override
    public void destroy() {
        super.destroy();
        // Giải phóng các tài nguyên nếu cần
        coursesDAO = null;
    }
}

