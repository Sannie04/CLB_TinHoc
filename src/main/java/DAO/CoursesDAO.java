package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Course;
import model.ClassDetails;

public class CoursesDAO {

    // Method to get all courses
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        String courseQuery = "SELECT * FROM khoahoc";
        String classQuery = "SELECT * FROM lophoc WHERE MaKhoaHoc = ?";

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement courseStmt = conn.prepareStatement(courseQuery)) {
            ResultSet courseRs = courseStmt.executeQuery();

            while (courseRs.next()) {
                Course course = new Course();
                course.setMaKhoaHoc(courseRs.getInt("MaKhoaHoc"));
                course.setTenKhoaHoc(courseRs.getString("TenKhoaHoc"));
                course.setMoTa(courseRs.getString("MoTa"));
                course.setImage(courseRs.getString("image"));

                // Lấy danh sách lớp học
                List<ClassDetails> classes = new ArrayList<>();
                try (PreparedStatement classStmt = conn.prepareStatement(classQuery)) {
                    classStmt.setInt(1, course.getMaKhoaHoc());
                    ResultSet classRs = classStmt.executeQuery();

                    while (classRs.next()) {
                        ClassDetails lop = new ClassDetails();
                        lop.setMaLopHoc(classRs.getInt("MaLopHoc"));
                        lop.setTenLopHoc(classRs.getString("TenLopHoc"));
                        classes.add(lop);
                    }
                }
                course.setDanhSachLop(classes);

                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();  // For production, use logging instead of printing stack trace.
        }
        return courses;
    }

    // Method to get classes by course ID (return ClassDetails instead of Class)
    public List<ClassDetails> getClassesByCourseId(int maKhoaHoc) {
        List<ClassDetails> classes = new ArrayList<>();
        String query = "SELECT MaLopHoc, TenLopHoc FROM lophoc WHERE MaKhoaHoc = ?";

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maKhoaHoc);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ClassDetails lop = new ClassDetails(); // Use ClassDetails instead of Class
                lop.setMaLopHoc(rs.getInt("MaLopHoc"));
                lop.setTenLopHoc(rs.getString("TenLopHoc"));
                classes.add(lop);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classes;
    }
    public Course getCourseById(int maKhoaHoc) {
        Course course = null;
        String query = "SELECT * FROM khoahoc WHERE MaKhoaHoc = ?";
        
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maKhoaHoc);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                course = new Course();
                course.setMaKhoaHoc(rs.getInt("MaKhoaHoc"));
                course.setTenKhoaHoc(rs.getString("TenKhoaHoc"));
                course.setMoTa(rs.getString("MoTa"));
                course.setImage(rs.getString("image"));
                course.setNgayBatDau(rs.getDate("NgayBatDau"));
                course.setNgayKetThuc(rs.getDate("NgayKetThuc"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }


    // Method to add a new course
    public void addCourse(int maKhoaHoc, String tenKhoaHoc, String moTa, java.sql.Date ngayBatDau, java.sql.Date ngayKetThuc, String image) {
        if (image == null || image.trim().isEmpty()) {
            image = "default_image.jpg";  // Default image if no image provided
        }

        String sql = "INSERT INTO khoahoc (maKhoaHoc, tenKhoaHoc, moTa, ngayBatDau, ngayKetThuc, image) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setInt(1, maKhoaHoc);
            stm.setString(2, tenKhoaHoc);
            stm.setString(3, moTa);
            stm.setDate(4, ngayBatDau);
            stm.setDate(5, ngayKetThuc);
            stm.setString(6, image);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();  // For production, use logging instead of printing stack trace.
        }
    }

    // Method to edit a course
    public void editCourse(int maKhoaHoc, String tenKhoaHoc, String moTa, java.sql.Date ngayBatDau, java.sql.Date ngayKetThuc, String image) {
        if (image == null || image.trim().isEmpty()) {
            image = "default_image.jpg";  // Default image if no image provided
        }

        String sql = "UPDATE khoahoc SET tenKhoaHoc = ?, moTa = ?, ngayBatDau = ?, ngayKetThuc = ?, image = ? WHERE maKhoaHoc = ?";

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, tenKhoaHoc);
            stm.setString(2, moTa);
            stm.setDate(3, ngayBatDau);
            stm.setDate(4, ngayKetThuc);
            stm.setString(5, image);
            stm.setInt(6, maKhoaHoc);  // Set maKhoaHoc
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();  // For production, use logging instead of printing stack trace.
        }
    }

  
    
}
