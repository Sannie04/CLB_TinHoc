package DAO;

import model.KetQua;
import model.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KetQuaDAO {

    // Get all exam results
    public List<KetQua> getAllKetQua() {
        List<KetQua> ketQuaList = new ArrayList<>();
        String query = "SELECT sv.MaSinhVien, sv.HoTen, sv.LopSinhHoat, dt.Diem, dt.LanThi, "
                + "kq.DiemCuoiKy, lh.TenLopHoc, kh.TenKhoaHoc, kh.MaKhoaHoc "
                + "FROM sinhvien sv "
                + "LEFT JOIN diemthi dt ON sv.MaSinhVien = dt.MaSinhVien "
                + "LEFT JOIN ketqua kq ON sv.MaSinhVien = kq.MaSinhVien "
                + "LEFT JOIN lophoc lh ON lh.MaLopHoc = kq.MaLopHoc "
                + "LEFT JOIN khoahoc kh ON kh.MaKhoaHoc = lh.MaKhoaHoc";

        try (Connection conn = DBConnect.getConnection(); 
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                KetQua ketQua = new KetQua();
                ketQua.setMaSinhVien(rs.getString("MaSinhVien"));
                ketQua.setHoTen(rs.getString("HoTen"));
                ketQua.setLopSinhHoat(rs.getString("LopSinhHoat"));
                ketQua.setDiemThi(rs.getDouble("Diem"));
                ketQua.setLanThi(rs.getInt("LanThi"));
                ketQua.setDiemCuoiKy(rs.getDouble("DiemCuoiKy"));
                ketQua.setTenLopHoc(rs.getString("TenLopHoc"));
                ketQua.setTenKhoaHoc(rs.getString("TenKhoaHoc"));
                ketQua.setMaKhoaHoc(rs.getString("MaKhoaHoc"));
                ketQuaList.add(ketQua);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQuaList;
    }

    // Get all courses
    public List<Course> getAllCourse() {
        List<Course> courses = new ArrayList<>();
        String query = "SELECT * FROM khoahoc";
        try (Connection conn = DBConnect.getConnection(); 
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Loop through result set and create Course objects
            while (rs.next()) {
                Course course = new Course();
                course.setMaKhoaHoc(rs.getInt("MaKhoaHoc"));
                course.setTenKhoaHoc(rs.getString("TenKhoaHoc"));
                course.setMoTa(rs.getString("MoTa"));
                course.setImage(rs.getString("image"));
                
                // Add the course to the list
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    // Add new exam result
    public boolean addDiemThi(String maSinhVien, int maKhoaHoc, double diem, int lanThi) {
        String sql = "INSERT INTO diemthi (MaSinhVien, MaKhoaHoc, Diem, LanThi) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnect.getConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maSinhVien);
            ps.setInt(2, maKhoaHoc);
            ps.setDouble(3, diem);
            ps.setInt(4, lanThi);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Update existing exam result
    public boolean updateDiemThi(String maSinhVien, int maKhoaHoc, double diem, int lanThi) {
        String sql = "UPDATE diemthi SET Diem = ?, LanThi = ? WHERE MaSinhVien = ? AND MaKhoaHoc = ?";
        try (Connection conn = DBConnect.getConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, diem);
            ps.setInt(2, lanThi);
            ps.setString(3, maSinhVien);
            ps.setInt(4, maKhoaHoc);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete exam result
    public boolean deleteDiemThi(String maSinhVien, int maKhoaHoc) {
        String sql = "DELETE FROM diemthi WHERE MaSinhVien = ? AND MaKhoaHoc = ?";
        try (Connection conn = DBConnect.getConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maSinhVien);
            ps.setInt(2, maKhoaHoc);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
