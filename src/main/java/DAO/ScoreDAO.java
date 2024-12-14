package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Score;

public class ScoreDAO {

    // Lấy điểm của sinh viên
    public List<Score> getScoresByStudentId(String maSinhVien) throws SQLException {
        List<Score> scores = new ArrayList<>();
        String query = "SELECT k.TenKhoaHoc, d.Diem, d.LanThi \r\n"
        		+ "FROM diemthi d\r\n"
        		+ "JOIN khoahoc k ON d.MaKhoaHoc = k.MaKhoaHoc\r\n"
        		+ "WHERE d.MaSinhVien =?";

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, maSinhVien);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Score score = new Score();
                score.setTenKhoaHoc(rs.getString("TenKhoaHoc"));
                score.setDiem(rs.getFloat("Diem"));
                score.setLanThi(rs.getInt("LanThi"));
                scores.add(score);
            }
        }
        return scores;
    }
    public void addScore(String maSinhVien, int maKhoaHoc, float diem, int lanThi) throws SQLException {
        String sql = "INSERT INTO diemthi (MaSinhVien, MaKhoaHoc, Diem, LanThi) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maSinhVien);
            ps.setInt(2, maKhoaHoc);
            ps.setFloat(3, diem);
            ps.setInt(4, lanThi);
            ps.executeUpdate();
        }
    }
    public void updateScore(int maDiem, float diem) throws SQLException {
        String sql = "UPDATE diemthi SET Diem = ? WHERE MaSinhVien=?AND MaKhoaHoc=?";

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setFloat(1, diem);
            ps.setInt(2, maDiem);
            ps.executeUpdate();
        }
    }

    public void deleteScore(int maDiem) throws SQLException {
        String sql = "DELETE FROM diemthi WHERE MaDiem = ?";

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, maDiem);
            ps.executeUpdate();
        }
    }

}
