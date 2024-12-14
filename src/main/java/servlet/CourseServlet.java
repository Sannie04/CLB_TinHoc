package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.CoursesDAO;
import model.Course;
import java.sql.Date;

@WebServlet("/listCourse")
public class CourseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // Initialize CoursesDAO to interact with database
    private CoursesDAO coursesDAO = new CoursesDAO();

    // Handling GET requests
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");
        
        if (action == null || action.isEmpty()) {
            // Fetch all courses and forward to course list page
            request.setAttribute("listC", coursesDAO.getAllCourses());
            request.getRequestDispatcher("./courseList.jsp").forward(request, response);
        } else if (action.equals("edit")) {
            // Edit course
            int maKhoaHoc = Integer.parseInt(request.getParameter("maKhoaHoc"));
            Course course = coursesDAO.getCourseById(maKhoaHoc);  // Get course details for editing
            request.setAttribute("course", course);
            request.getRequestDispatcher("./editCourse.jsp").forward(request, response);
        }
    }

    // Handling POST requests
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");

        if ("add".equals(action)) {
            // Add new course
            int maKhoaHoc = Integer.parseInt(request.getParameter("maKhoaHoc"));
            String tenKhoaHoc = request.getParameter("tenKhoaHoc");
            String moTa = request.getParameter("moTa");
            Date ngayBatDau = Date.valueOf(request.getParameter("ngayBatDau"));
            Date ngayKetThuc = Date.valueOf(request.getParameter("ngayKetThuc"));
            String image = request.getParameter("image");

            coursesDAO.addCourse(maKhoaHoc, tenKhoaHoc, moTa, ngayBatDau, ngayKetThuc, image);
            response.sendRedirect(request.getContextPath() + "/course");  // Redirect to list page
        } else if ("edit".equals(action)) {
            // Edit existing course
            int maKhoaHoc = Integer.parseInt(request.getParameter("maKhoaHoc"));
            String tenKhoaHoc = request.getParameter("tenKhoaHoc");
            String moTa = request.getParameter("moTa");
            Date ngayBatDau = Date.valueOf(request.getParameter("ngayBatDau"));
            Date ngayKetThuc = Date.valueOf(request.getParameter("ngayKetThuc"));
            String image = request.getParameter("image");

            coursesDAO.editCourse(maKhoaHoc, tenKhoaHoc, moTa, ngayBatDau, ngayKetThuc, image);
            response.sendRedirect(request.getContextPath() + "/course");  // Redirect to list page
        }
    }
}
