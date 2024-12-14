package servlet;

import DAO.ScoreDAO;
import model.Score;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/viewScores")
public class ViewScoresServlet extends HttpServlet {

    // Xử lý GET để hiển thị điểm của sinh viên
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maSinhVien = request.getParameter("maSinhVien"); // Lấy mã sinh viên từ tham số URL
        
        if (maSinhVien != null) {
            ScoreDAO scoreDAO = new ScoreDAO();
            try {
                List<Score> scores = scoreDAO.getScoresByStudentId(maSinhVien);
                request.setAttribute("scores", scores); // Lưu danh sách điểm vào request
                request.getRequestDispatcher("/result_sv.jsp").forward(request, response); // Chuyển tiếp đến JSP
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Có lỗi xảy ra khi truy vấn cơ sở dữ liệu");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Mã sinh viên không hợp lệ");
        }
    }

    // Xử lý POST để sửa điểm của sinh viên
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maSinhVien = request.getParameter("maSinhVien");

        // Kiểm tra nếu action là sửa điểm
        String action = request.getParameter("action");
        if (action != null && action.equals("edit")) {
            try {
                int maKhoaHoc = Integer.parseInt(request.getParameter("maKhoaHoc"));
                float diem = Float.parseFloat(request.getParameter("diem"));
                int lanThi = Integer.parseInt(request.getParameter("lanThi"));

                ScoreDAO scoreDAO = new ScoreDAO();
                // Cập nhật điểm của sinh viên
                scoreDAO.updateScore(maSinhVien, maKhoaHoc, diem);
                request.setAttribute("message", "Cập nhật điểm thành công!");

            } catch (SQLException e) {
                e.printStackTrace();
                request.setAttribute("message", "Cập nhật điểm thất bại!");
            }
        }

        // Sau khi thực hiện sửa điểm, chuyển hướng lại trang kết quả
        String redirectURL = "viewScores?maSinhVien=" + maSinhVien;
        response.sendRedirect(redirectURL); // Chuyển hướng lại trang viewScores với mã sinh viên
    }
}
