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
                double diemAdd = Double.parseDouble(request.getParameter("diem"));
                int lanThiAdd = Integer.parseInt(request.getParameter("lanThi"));
                if (ketQuaDAO.addDiemThi(maSinhVien, maKhoaHoc, diemAdd, lanThiAdd)) {
                    message = "Điểm thi đã được thêm thành công!";
                } else {
                    message = "Thêm điểm thi thất bại.";
                }
                break;

            case "update":
                double diemUpdate = Double.parseDouble(request.getParameter("diem"));
                int lanThiUpdate = Integer.parseInt(request.getParameter("lanThi"));
                if (ketQuaDAO.updateDiemThi(maSinhVien, maKhoaHoc, diemUpdate, lanThiUpdate)) {
                    message = "Điểm thi đã được cập nhật thành công!";
                } else {
                    message = "Cập nhật điểm thi thất bại.";
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

        // Fetch the updated data to display again
        List<KetQua> ketQuaList = ketQuaDAO.getAllKetQua();
        List<Course> khoaHocList = ketQuaDAO.getAllCourse();

        // Set attributes for the JSP
        request.setAttribute("message", message);
        request.setAttribute("ketQuaList", ketQuaList);
        request.setAttribute("khoaHocList", khoaHocList);

        // Forward to JSP
        request.getRequestDispatcher("ketqua.jsp").forward(request, response);
    }
}