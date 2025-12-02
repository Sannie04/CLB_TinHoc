package servlet;

import DAO.KetQuaDAO;
import model.KetQua;
import model.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ketqua")
public class KetQuaServlet extends HttpServlet {
    private KetQuaDAO ketQuaDAO = new KetQuaDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<KetQua> ketQuaList = ketQuaDAO.getAllKetQua();
        List<Course> khoaHocList = ketQuaDAO.getAllCourse();  // Fetch list of courses

        // Set attributes for both lists
        request.setAttribute("ketQuaList", ketQuaList);
        request.setAttribute("khoaHocList", khoaHocList);

        // Forward to JSP
        request.getRequestDispatcher("ketqua.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String maSinhVien = request.getParameter("maSinhVien");
        int maKhoaHoc = Integer.parseInt(request.getParameter("maKhoaHoc"));

        String message = null;

        switch (action) {
            case "add":
            case "update":
                double diem = Double.parseDouble(request.getParameter("diem"));
                int lanThi = Integer.parseInt(request.getParameter("lanThi"));

                // ===== Validation điểm thi =====
                if (diem < 0 || diem > 10) {
                    message = "Điểm thi phải nằm trong khoảng 0 đến 10!";
                    break;
                }

                if (action.equals("add")) {
                    if (ketQuaDAO.addDiemThi(maSinhVien, maKhoaHoc, diem, lanThi)) {
                        message = "Điểm thi đã được thêm thành công!";
                    } else {
                        message = "Thêm điểm thi thất bại.";
                    }
                } else { // update
                    if (ketQuaDAO.updateDiemThi(maSinhVien, maKhoaHoc, diem, lanThi)) {
                        message = "Điểm thi đã được cập nhật thành công!";
                    } else {
                        message = "Cập nhật điểm thi thất bại.";
                    }
                }
                break;

            case "delete":
                if (ketQuaDAO.deleteDiemThi(maSinhVien, maKhoaHoc)) {
                    message = "Điểm thi đã được xóa thành công!";
                } else {
                    message = "Xóa điểm thi thất bại.";
                }
                break;

            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action.");
                return;
        }

        // Fetch updated data
        List<KetQua> ketQuaList = ketQuaDAO.getAllKetQua();
        List<Course> khoaHocList = ketQuaDAO.getAllCourse();

        request.setAttribute("message", message);
        request.setAttribute("ketQuaList", ketQuaList);
        request.setAttribute("khoaHocList", khoaHocList);

        request.getRequestDispatcher("ketqua.jsp").forward(request, response);
    }

}