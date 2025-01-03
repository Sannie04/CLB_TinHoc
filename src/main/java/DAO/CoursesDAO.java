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
    public static Course getCourseById(int maKhoaHoc) {
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
    public void addCourse(String tenKhoaHoc, String moTa, java.sql.Date ngayBatDau, java.sql.Date ngayKetThuc, String image) {
        if (image == null || image.trim().isEmpty()) {
            image = "images/default_image.jpg"; // Đường dẫn mặc định đến ảnh
        }

        String sql = "INSERT INTO khoahoc (tenKhoaHoc, moTa, ngayBatDau, ngayKetThuc, image) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, tenKhoaHoc);
            stm.setString(2, moTa);
            stm.setDate(3, ngayBatDau);
            stm.setDate(4, ngayKetThuc);
            stm.setString(5, image);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Sử dụng logging thay vì in stack trace trong sản xuất
        }
    }


    // Method to edit a course
    public void editCourse(int maKhoaHoc, String tenKhoaHoc, String moTa, java.sql.Date ngayBatDau, java.sql.Date ngayKetThuc, String image) {
        
          String  sql = "UPDATE khoahoc SET tenKhoaHoc = ?, moTa = ?, ngayBatDau = ?, ngayKetThuc = ?, image = ? WHERE maKhoaHoc = ?";
       

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, tenKhoaHoc);
            stm.setString(2, moTa);
            stm.setDate(3, ngayBatDau);
            stm.setDate(4, ngayKetThuc);

            if (image == null || image.trim().isEmpty()) {
                stm.setInt(5, maKhoaHoc);
            } else {
                stm.setString(5, image);
                stm.setInt(6, maKhoaHoc);
            }
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }  
    public int getLatestCourseId() {
        int id = -1;
        String sql = "SELECT MAX(MaKhoaHoc) AS LatestID FROM khoahoc";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt("LatestID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public int addClass(String tenLopHoc, int maKhoaHoc) {
        String sql = "INSERT INTO lophoc (tenLopHoc, maKhoaHoc) VALUES (?, ?)";
        int maLopHoc = -1; // Default value if no error occurs
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, tenLopHoc);
            stmt.setInt(2, maKhoaHoc);

            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        maLopHoc = generatedKeys.getInt(1); // Get new class ID
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maLopHoc;
    }

    public void addStudentToCourse(int maLopHoc, String maSinhVien) {
        String query = "INSERT INTO student_lophoc (MaSinhVien, MaLopHoc)\r\n"
        				+ "VALUES (?, ?)";

        try (Connection conn = DBConnect.getConnection(); // Giả định bạn có phương thức Database.getConnection()
             PreparedStatement ps = conn.prepareStatement(query)) {

            // Thiết lập tham số
            ps.setString(1, maSinhVien); // Giá trị mã sinh viên
            ps.setInt(2, maLopHoc);     // Giá trị mã lớp học

            // Thực thi câu lệnh
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Successfully added student to course.");
            } else {
                System.out.println("Failed to add student to course. Either student or course does not exist.");
            }
        } catch (SQLException e) {
            System.err.println("Error adding student to course: " + e.getMessage());
        }
    }

    public void addSupportToCourse(int maLopHoc, String maSupport) {
        String query = "INSERT INTO support_lophoc (MaSupport, MaLopHoc)\r\n"
						+ "VALUES (?, ?)";
        try (Connection conn = DBConnect.getConnection(); // Kết nối đến cơ sở dữ liệu
             PreparedStatement ps = conn.prepareStatement(query)) {

            // Thiết lập tham số
            ps.setString(1, maSupport); // Giá trị mã người hỗ trợ
            ps.setInt(2, maLopHoc);     // Giá trị mã lớp học

            // Thực thi câu lệnh
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Successfully added support person to course.");
            } else {
                System.out.println("Failed to add support person to course. Either support or course does not exist.");
            }
        } catch (SQLException e) {
            System.err.println("Error adding support person to course: " + e.getMessage());
        }
    }

}

