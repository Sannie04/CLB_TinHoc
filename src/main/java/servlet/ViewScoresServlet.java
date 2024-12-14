package servlet;

import DAO.ScoreDAO;
import model.Score;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/viewScores")
public class ViewScoresServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy mã sinh viên từ tham số URL
        String maSinhVien = request.getParameter("maSinhVien");

        if (maSinhVien != null) {
            ScoreDAO scoreDAO = new ScoreDAO();
            try {
                // Lấy điểm của sinh viên từ DAO
                List<Score> scores = scoreDAO.getScoresByStudentId(maSinhVien);
                // Truyền kết quả điểm đến JSP
                request.setAttribute("scores", scores);
                request.setAttribute("maSinhVien", maSinhVien); // Truyền mã sinh viên
                // Chuyển tiếp đến trang JSP hiển thị kết quả
                RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
                dispatcher.forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Lỗi khi truy vấn dữ liệu điểm.");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Mã sinh viên không hợp lệ.");
        }
    }
}
