package DAO;

import model.Course;
import DAO.DBConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CoursesDAO {

    /**
     * Lấy danh sách tất cả các khóa học từ cơ sở dữ liệu.
     * 
     * @return List<Course> - Danh sách các khóa học
     */
    public List<Course> getAllCourses() {
        List<Course> courseList = new ArrayList<>();
        String query = "SELECT * FROM KhoaHoc";

        try (Connection connection = DBConnect.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Course course = new Course(
                    resultSet.getInt("MaKhoaHoc"),         // Mã khóa học
                    resultSet.getString("TenKhoaHoc"),    // Tên khóa học
                    resultSet.getString("MoTa"),          // Mô tả khóa học
                    resultSet.getDate("NgayBatDau"),      // Ngày bắt đầu
                    resultSet.getDate("NgayKetThuc"),     // Ngày kết thúc
                    resultSet.getString("image")          // Đường dẫn hình ảnh
                );
                courseList.add(course);
            }
        } catch (SQLException e) {
            System.err.println("Error while retrieving courses: " + e.getMessage());
            e.printStackTrace();
        }

        return courseList;
    }
}
