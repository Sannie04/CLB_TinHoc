package servlet;

import DAO.ScoreDAO;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
@WebServlet("/editScores")
public class EditScoresServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy tham số từ form
        String maSinhVien = request.getParameter("maSinhVien");
        String diem = request.getParameter("diem");
        String maDiem = request.getParameter("maDiem");

        // Kiểm tra tham số
        if (maSinhVien == null || diem == null || maDiem == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Thông tin không hợp lệ.");
            return;
        }

        // Cập nhật điểm
        ScoreDAO scoreDAO = new ScoreDAO();
        try {
            // Cập nhật điểm trong cơ sở dữ liệu
            scoreDAO.updateScore(Integer.parseInt(maDiem), Float.parseFloat(diem));

            // Sau khi sửa điểm, chuyển hướng về trang kết quả thi
            response.sendRedirect("viewScores?maSinhVien=" + maSinhVien);

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Lỗi khi cập nhật dữ liệu điểm.");
        }
    }
}
