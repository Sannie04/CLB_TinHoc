
package servlet;

import DAO.StudentDAO;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
@WebServlet("/students/*")
public class StudentManagementServlet extends HttpServlet {
    private StudentDAO studentDAO;

    public void init() {
        studentDAO = new StudentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        
        try {
            if (pathInfo != null && pathInfo.equals("/get")) {
                String studentId = request.getParameter("id");
                Student student = studentDAO.getStudent(studentId);
                
                if (student != null) {
                    request.setCharacterEncoding("UTF-8");
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String formattedNgayThamGia = sdf.format(student.getNgayThamGia());
                    
                    String jsonResponse = String.format(
                        "{\"maSinhVien\":\"%s\",\"hoTen\":\"%s\",\"lopSinhHoat\":\"%s\",\"email\":\"%s\",\"soDienThoai\":\"%s\",\"ngayThamGia\":\"%s\"}",
                        student.getMaSinhVien(),
                        student.getHoTen(),
                        student.getLopSinhHoat(),
                        student.getEmail(),
                        student.getSoDienThoai(),
                        formattedNgayThamGia
                    );
                    
                    response.getWriter().write(jsonResponse);
                } else {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    response.getWriter().write("{\"error\":\"Student not found\"}");
                }
            } else {
                List<Student> students = studentDAO.getAllStudents();
                request.setAttribute("students", students);
                request.getRequestDispatcher("/student-management.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null) {
            pathInfo = "/list";
        }
        
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        // Phần xử lý khác...
        
        try {
            switch (pathInfo) {
                case "/add":
                    addStudent(request, response);
                    break;
                case "/update":
                    updateStudent(request, response);
                    break;
                case "/delete":
                    deleteStudent(request, response);
                    break;
                default:
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    response.getWriter().write("{\"error\":\"Invalid action\"}");
                    break;
            }
        } catch (SQLException | ParseException ex) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\":\"" + ex.getMessage() + "\"}");
        }
    }

    private void addStudent(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException, ParseException {
        String maSinhVien = request.getParameter("maSinhVien");
        String hoTen = request.getParameter("hoTen");
        String lopSinhHoat = request.getParameter("lopSinhHoat");
        String email = request.getParameter("email");
        String soDienThoai = request.getParameter("soDienThoai");
        String ngayThamGiaStr = request.getParameter("ngayThamGia");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date ngayThamGia = sdf.parse(ngayThamGiaStr);
        Student newStudent = new Student(maSinhVien, hoTen, lopSinhHoat, email, soDienThoai, ngayThamGia);
        boolean success = studentDAO.addStudent(newStudent);
        if (success) {
            response.getWriter().write("{\"success\":true,\"message\":\"Sinh viên đã được thêm thành công\"}");
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\":\"Không thể thêm sinh viên\"}");
        }
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException, ParseException {
        String maSinhVien = request.getParameter("maSinhVien");
        String hoTen = request.getParameter("hoTen");
        String lopSinhHoat = request.getParameter("lopSinhHoat");
        String email = request.getParameter("email");
        String soDienThoai = request.getParameter("soDienThoai");
        String ngayThamGiaStr = request.getParameter("ngayThamGia");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date ngayThamGia = sdf.parse(ngayThamGiaStr);
        Student student = new Student(maSinhVien, hoTen, lopSinhHoat, email, soDienThoai, ngayThamGia);
        boolean success = studentDAO.updateStudent(student);   
        if (success) {
            response.getWriter().write("{\"success\":true,\"message\":\"Thông tin sinh viên đã được cập nhật\"}");
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\":\"Không thể cập nhật thông tin sinh viên\"}");
        }
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException {
        String studentId = request.getParameter("maSinhVien");
        boolean success = studentDAO.deleteStudent(studentId);
        if (success) {
            response.getWriter().write("{\"success\":true,\"message\":\"Sinh viên đã được xóa\"}");
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\":\"Không thể xóa sinh viên\"}");
        }
    }
}
