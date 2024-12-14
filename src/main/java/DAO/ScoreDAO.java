package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Score;

public class ScoreDAO {

    // Lấy điểm của sinh viên
    public List<Score> getScoresByStudentId(String maSinhVien) throws SQLException {
        List<Score> scores = new ArrayList<>();
        String query = "SELECT s.MaSinhVien, s.HoTen, k.TenKhoaHoc, d.Diem, d.LanThi " +
                       "FROM diemthi d " +
                       "JOIN khoahoc k ON d.MaKhoaHoc = k.MaKhoaHoc " +
                       "JOIN sinhvien s ON d.MaSinhVien = s.MaSinhVien " +
                       "WHERE d.MaSinhVien = ?";

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, maSinhVien); // Cài giá trị cho tham số
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Score score = new Score();
                score.setMaSinhVien(rs.getString("MaSinhVien"));
                score.setHoTen(rs.getString("HoTen"));
                score.setTenKhoaHoc(rs.getString("TenKhoaHoc"));
                score.setDiem(rs.getFloat("Diem"));
                score.setLanThi(rs.getInt("LanThi"));
                scores.add(score);
            }
        }
        return scores;
    }

    // Cập nhật điểm của sinh viên
    public void updateScore(String maSinhVien, int maKhoaHoc, float diem) throws SQLException {
        String sql = "UPDATE diemthi SET Diem = ? WHERE MaSinhVien = ? AND MaKhoaHoc = ?";

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setFloat(1, diem);
            ps.setString(2, maSinhVien);
            ps.setInt(3, maKhoaHoc);
            ps.executeUpdate();
        }
    }

    // Xóa điểm của sinh viên
   
    }

