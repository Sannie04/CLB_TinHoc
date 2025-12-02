package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Student;
import model.SupportClass;
import model.ClassDetails;

public class ClassnameDAO {
    // Lấy danh sách sinh viên và support dựa trên mã lớp học
    public ClassDetails getClassDetailsByLop(int maLopHoc) throws SQLException {
        ClassDetails classDetails = new ClassDetails();
        
        // Lấy thông tin lớp học (maLopHoc và tenLopHoc)
        String classQuery = "SELECT MaLopHoc, TenLopHoc FROM lophoc WHERE MaLopHoc = ?";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(classQuery)) {
            ps.setInt(1, maLopHoc);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                classDetails.setMaLopHoc(rs.getInt("MaLopHoc"));
                classDetails.setTenLopHoc(rs.getString("TenLopHoc"));
            }
        }

        // Lấy danh sách sinh viên và support staff
        classDetails.setStudents(getStudentsByLop(maLopHoc));
        classDetails.setSupports(getSupportsByLop(maLopHoc));
        
        return classDetails;
    }

    // Lấy danh sách sinh viên theo mã lớp học
    private List<Student> getStudentsByLop(int maLopHoc) throws SQLException {
        String query = "SELECT s.MaSinhVien, s.HoTen, s.LopSinhHoat, s.Email, s.SoDienThoai, s.NgayThamGia\r\n"
        		+ "FROM sinhvien s \r\n"
        		+ "JOIN student_lophoc sl ON s.MaSinhVien = sl.MaSinhVien\r\n"
        		+ "WHERE sl.MaLopHoc = ?";
        List<Student> students = new ArrayList<>();
        
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, maLopHoc);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Student student = new Student();
                student.setMaSinhVien(rs.getString("MaSinhVien"));
                student.setHoTen(rs.getString("HoTen"));
                student.setLopSinhHoat(rs.getString("LopSinhHoat"));
                student.setEmail(rs.getString("Email"));
                student.setSoDienThoai(rs.getString("SoDienThoai"));
                student.setNgayThamGia(rs.getDate("NgayThamGia")); 
                students.add(student);
            }
        }
        return students;
    }

    // Lấy danh sách support staff theo mã lớp học
    private List<SupportClass> getSupportsByLop(int maLopHoc) throws SQLException {
        String query = "SELECT sp.MaSupport, sp.HoTen, sp.LopSinhHoat, sp.SoDienThoai, sp.Email, sp.HinhAnh "  // Include HinhAnh
                + "FROM support sp "
                + "JOIN support_lophoc sl ON sp.MaSupport = sl.MaSupport "
                + "WHERE sl.MaLopHoc = ?";

        List<SupportClass> supports = new ArrayList<>();
        
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, maLopHoc);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                SupportClass support = new SupportClass();
                support.setMaSupport(rs.getString("MaSupport"));
                support.setHoTen(rs.getString("HoTen"));
                support.setLopSinhHoat(rs.getString("LopSinhHoat"));
                support.setSoDienThoai(rs.getString("SoDienThoai"));
                support.setEmail(rs.getString("Email"));
                support.setHinhAnh(rs.getString("HinhAnh"));  // Set the image field
                supports.add(support);
            }
        }
        return supports;
    }

}