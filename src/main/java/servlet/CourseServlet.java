package servlet;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DAO.CoursesDAO;
import model.Course;

@WebServlet("/listCourse")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
    maxFileSize = 1024 * 1024 * 10, // 10MB
    maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class CourseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CoursesDAO coursesDAO = new CoursesDAO();

    // Handle POST requests (adding/editing courses)
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        String uploadPath = getServletContext().getRealPath("") + File.separator + "images";
        File uploadDir = new File(uploadPath);
        
        // Ensure the upload directory exists
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
     
        System.out.println("Action: " + action); // In ra giá trị của action để kiểm tra

        // Handle course adding
        if ("add".equals(action)) {
            String tenKhoaHoc = request.getParameter("tenKhoaHoc");
            String moTa = request.getParameter("moTa");
            Date ngayBatDau = Date.valueOf(request.getParameter("ngayBatDau"));
            Date ngayKetThuc = Date.valueOf(request.getParameter("ngayKetThuc"));

            String fileName = "";
            Part filePart = request.getPart("image"); // Get the file part
            if (filePart != null && filePart.getSize() > 0) {
                // Extract the file name and save the image
                fileName = new File(filePart.getSubmittedFileName()).getName();
                filePart.write(uploadPath + File.separator + fileName);
            }

            // Store the file path for the database
            String imagePath = fileName.isEmpty() ? "" : fileName;
            coursesDAO.addCourse(tenKhoaHoc, moTa, ngayBatDau, ngayKetThuc, imagePath);

            // Redirect to the course list page after adding
            response.sendRedirect("listCourse");

        }  else if ("edit".equals(action)) {
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
