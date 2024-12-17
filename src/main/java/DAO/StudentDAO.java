package DAO;

import model.Student;
import DAO.DBConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
     
    private void logSQLException(String operation, SQLException e) {
        System.err.println("Lỗi SQL trong operation: " + operation);
        System.err.println("SQL State: " + e.getSQLState());
        System.err.println("Error Code: " + e.getErrorCode());
        System.err.println("Message: " + e.getMessage());
        e.printStackTrace();
    }

    public boolean addStudent(Student student) throws SQLException {
        String sql = "INSERT INTO sinhvien (MaSinhVien, HoTen, lopSinhHoat, email, soDienThoai, ngayThamGia) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, student.getMaSinhVien());
            pstmt.setString(2, student.getHoTen());
            pstmt.setString(3, student.getLopSinhHoat());
            pstmt.setString(4, student.getEmail());
            pstmt.setString(5, student.getSoDienThoai());
            pstmt.setDate(6, new java.sql.Date(student.getNgayThamGia().getTime()));
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            logSQLException("addStudent", e);
            throw e;
        }
    }

    public boolean updateStudent(Student student) throws SQLException {
        String sql = "UPDATE sinhvien SET HoTen = ?, lopSinhHoat = ?, email = ?, soDienThoai = ?,  ngayThamGia = ? WHERE MaSinhVien = ?";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, student.getHoTen());
            pstmt.setString(2, student.getLopSinhHoat());
            pstmt.setString(3, student.getEmail());
            pstmt.setString(4, student.getSoDienThoai());
            pstmt.setDate(5, new java.sql.Date(student.getNgayThamGia().getTime()));
            pstmt.setString(6, student.getMaSinhVien());
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            logSQLException("updateStudent", e);
            throw e;
        }
    }

    public boolean deleteStudent(String studentId) throws SQLException {
        String sql = "DELETE FROM sinhvien WHERE MaSinhVien = ?";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, studentId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            logSQLException("deleteStudent", e);
            throw e;
        }
        }

    public Student getStudent(String studentId) throws SQLException {
        String sql = "SELECT * FROM sinhvien WHERE MaSinhVien = ?";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, studentId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Student(
                        rs.getString("MaSinhVien"),
                        rs.getString("HoTen"),
                        rs.getString("lopSinhHoat"),
                        rs.getString("email"),
                        rs.getString("soDienThoai"),
                        rs.getDate("ngayThamGia")
                    );
                }
            }
        } catch (SQLException e) {
            logSQLException("getStudent", e);
            throw e;
        }
        return null;
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM sinhvien";
        try (Connection conn = DBConnect.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                students.add(new Student(
                    rs.getString("MaSinhVien"),
                    rs.getString("HoTen"),
                    rs.getString("lopSinhHoat"),
                    rs.getString("email"),
                    rs.getString("soDienThoai"),
                    rs.getDate("ngayThamGia")
                ));
            }
        } catch (SQLException e) {
            logSQLException("getAllStudents", e);
            throw e;
        }
        return students;
    }

    public boolean authenticate(String maSinhVien, String email) throws SQLException {
        String sql = "SELECT * FROM sinhvien WHERE MaSinhVien = ? AND email = ?";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, maSinhVien);
            pstmt.setString(2, email);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            logSQLException("authenticate", e);
            throw e;
        }
    }
    public List<Student> getStudentsByClass(String maLop) {
        List<Student> students = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet result = null;
        try {
            conn = DBConnect.getConnection();
            String sql = "SELECT * FROM sinhvien WHERE maLop = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, maLop);
            result = stm.executeQuery();

            while (result.next()) {
                students.add(new Student(
                    result.getString("MaSinhVien"),  // Assuming `MaSinhVien` is the student ID
                    result.getString("HoTen"),       // Assuming `HoTen` is the name
                    result.getString("lopSinhHoat"), // Assuming `lopSinhHoat` is the class name
                    result.getString("email"),       // Assuming `email` is the email
                    result.getString("soDienThoai"), // Assuming `soDienThoai` is the phone number
                    result.getDate("ngayThamGia")    // Assuming `ngayThamGia` is the date of joining
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();  // You can log it or handle it accordingly
        } finally {
            try {
                if (result != null) result.close();
                if (stm != null) stm.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return students;
    }

}