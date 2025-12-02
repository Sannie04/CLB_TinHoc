package servlet;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DAO.CoursesDAO;
import DAO.DAOcn;
import model.Course;
import model.Student;
import model.SupportClass;
import DAO.StudentDAO;
@WebServlet("/listCourse")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
    maxFileSize = 1024 * 1024 * 10, // 10MB
    maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class CourseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CoursesDAO coursesDAO = new CoursesDAO();
    private StudentDAO studentDAO = new StudentDAO();
    private DAOcn supportDAO = new DAOcn();
    // Handle POST requests (adding/editing courses)
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html;charset=UTF-8");
    	List<Student> students = null;
		try {
			students = studentDAO.getAllStudents();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        List<SupportClass> supports = supportDAO.getAllSupportClass();
    
        System.out.println("Students List: " + students);  
        System.out.println("Supports List: " + supports);  
        request.setAttribute("students", students);
        request.setAttribute("supports", supports);

        String action = request.getParameter("action");
        String uploadPath = getServletContext().getRealPath("") + File.separator + "images";
        File uploadDir = new File(uploadPath);
        
        // Ensure the upload directory exists
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
     
        System.out.println("Action: " + action); // In ra giá trị của action để kiểm tra

        if ("add".equals(action)) {
            // Nhận thông tin khóa học
            String tenKhoaHoc = request.getParameter("tenKhoaHoc");
            String moTa = request.getParameter("moTa");
            Date ngayBatDau = Date.valueOf(request.getParameter("ngayBatDau"));
            Date ngayKetThuc = Date.valueOf(request.getParameter("ngayKetThuc"));

            // Xử lý ảnh (nếu có)
            String fileName = "";
            Part filePart = request.getPart("image"); // Get the file part
            if (filePart != null && filePart.getSize() > 0) {
                fileName = new File(filePart.getSubmittedFileName()).getName();
                filePart.write(uploadPath + File.separator + fileName);
            }
            String imagePath = fileName.isEmpty() ? "" : fileName;

            // Thêm khóa học vào database
            coursesDAO.addCourse(tenKhoaHoc, moTa, ngayBatDau, ngayKetThuc, imagePath);

            // Lấy ID khóa học vừa tạo
            int maKhoaHoc = coursesDAO.getLatestCourseId();

            // Thêm lớp học vào database
            String tenLopHoc = request.getParameter("tenLopHoc");
            int maLopHoc = coursesDAO.addClass(tenLopHoc, maKhoaHoc); // Tạo lớp học và lấy maLopHoc

            // Thêm sinh viên vào lớp học (nếu có sinh viên được chọn)
            String[] selectedStudents = request.getParameterValues("selectedStudents");
            if (selectedStudents != null && selectedStudents.length > 0) {
                for (String maSinhVien : selectedStudents) {
                    if (maSinhVien != null && !maSinhVien.trim().isEmpty()) {
                        // Kiểm tra và thêm sinh viên vào lớp học
                        coursesDAO.addStudentToCourse(maLopHoc, maSinhVien);
                    }
                }
            }

            // Thêm người hỗ trợ vào lớp học (nếu có người hỗ trợ được chọn)
            String supportPerson = request.getParameter("supportPerson");
            if (supportPerson != null && !supportPerson.trim().isEmpty()) {
                // Kiểm tra và thêm người hỗ trợ vào lớp học
                supportDAO.addSupports(maLopHoc, supportPerson);
            } else {
                // Nếu không có người hỗ trợ được chọn, có thể log thông báo hoặc xử lý theo cách khác
                System.out.println("Không có người hỗ trợ được chọn.");
            }

            // Chuyển hướng về trang danh sách khóa học
            response.sendRedirect("listCourse");
        }

  else if ("edit".equals(action)) {
            // Handle course editing
            int maKhoaHoc = Integer.parseInt(request.getParameter("maKhoaHoc"));
            String tenKhoaHoc = request.getParameter("tenKhoaHoc");
            String moTa = request.getParameter("moTa");
            Date ngayBatDau = Date.valueOf(request.getParameter("ngayBatDau"));
            Date ngayKetThuc = Date.valueOf(request.getParameter("ngayKetThuc"));

            // Get the current image (if exists)
            String currentImage = request.getParameter("currentImage");
            String fileName = currentImage; // Default to the current image if no new image is uploaded

            // Process new image file upload (if any)
            Part filePart = request.getPart("image");
            if (filePart != null && filePart.getSize() > 0) {
                // If a new image is uploaded, process and save it
                fileName = new File(filePart.getSubmittedFileName()).getName();
                filePart.write(uploadPath + File.separator + fileName);
            }

            // Retain current image if no new image is uploaded
            String imagePath = (fileName == null || fileName.isEmpty()) ? currentImage : fileName;

            // Edit the course in the database
            coursesDAO.editCourse(maKhoaHoc, tenKhoaHoc, moTa, ngayBatDau, ngayKetThuc, imagePath);

            // Redirect to the course list page after editing
            response.sendRedirect("listCourse");
        } else if ("addCoursePage".equals(action)) {
            // Show the page to add a new course
           
            try {
                students = studentDAO.getAllStudents(); // Get all students
            } catch (SQLException e) {
                e.printStackTrace();
                request.setAttribute("error", "Lỗi khi lấy danh sách sinh viên: " + e.getMessage());
            }

            
            try {
                supports= supportDAO.getAllSupportClass(); // Get all support persons
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("error", "Lỗi khi lấy danh sách người hỗ trợ: " + e.getMessage());
            }

            request.setAttribute("students", students);
            request.setAttribute("supports", supports);

            // Forward to the add course page (addCourse.jsp)
            request.getRequestDispatcher("/addCourse.jsp").forward(request, response);
        }
    }

    // Handle GET requests (viewing courses list)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Fetch all courses from the database
        List<Course> listCourses = coursesDAO.getAllCourses();
        request.setAttribute("listCourses", listCourses);
        // Forward the request to the course list page (courseList.jsp)
        request.getRequestDispatcher("/courseList.jsp").forward(request, response);
    }
}
