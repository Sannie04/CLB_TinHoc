package support;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DAO.DAOcn;

@WebServlet("/addSupport")
@MultipartConfig
public class AddSupportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        if (!request.getContentType().startsWith("multipart/form-data")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Form phải có enctype=multipart/form-data.");
            return;
        }

        // Lấy các tham số từ form
        String maSupport = request.getParameter("maSupport");
        String hoTen = request.getParameter("hoTen");
        String lopSinhHoat = request.getParameter("lopSinhHoat");
        String soDienThoai = request.getParameter("soDienThoai");
        String email = request.getParameter("email");
        String hinhAnh = null;

        // Xử lý file ảnh (nếu có)
        Part hinhAnhPart = request.getPart("hinhAnh");
        if (hinhAnhPart != null && hinhAnhPart.getSize() > 0) {
            String fileName = getFileName(hinhAnhPart);
            if (fileName == null || !fileName.toLowerCase().matches(".*\\.(jpg|png|jpeg|gif)$")) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Chỉ cho phép tải lên file ảnh (jpg, png, jpeg, gif).");
                return;
            }

            // Sử dụng thư mục ảnh đã tồn tại
            String uploadPath = getServletContext().getRealPath("/images");
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Thư mục lưu ảnh không tồn tại.");
                return;
            }

            // Tạo tên file ảnh duy nhất
            String fileExtension = fileName.substring(fileName.lastIndexOf("."));
            String fileNameBase = hoTen.trim().toLowerCase().replaceAll("[^a-zA-Z0-9]", "_");
            String uniqueFileName = fileNameBase + "_" + UUID.randomUUID().toString() + fileExtension;

            // Lưu ảnh vào thư mục
            File fileToSave = new File(uploadDir, uniqueFileName);
            hinhAnhPart.write(fileToSave.getAbsolutePath());
            hinhAnh = uniqueFileName;
        }

        // Lưu thông tin vào database
        try {
            DAOcn dao = new DAOcn();
            dao.addSupport(maSupport, hoTen, lopSinhHoat, soDienThoai, email, hinhAnh);
            response.sendRedirect(request.getContextPath() + "/listSupport");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Lỗi khi thêm Support.");
        }
    }

    // Phương thức lấy tên file từ phần Part
    private String getFileName(Part part) {
        String partHeader = part.getHeader("content-disposition");
        for (String content : partHeader.split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
            }
        }
        return null;
    }
}
