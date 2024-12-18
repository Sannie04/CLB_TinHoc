package support;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DAO.DAOcn;
import model.SupportClass;

@WebServlet("/addSupport")
public class AddSupportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // Kiểm tra xem yêu cầu có phải là multipart hay không
        if (!request.getContentType().startsWith("multipart/form-data")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Form must have enctype=multipart/form-data.");
            return;
        }

        // Lấy dữ liệu từ form
        String maSupport = request.getParameter("maSupport");
        String hoTen = request.getParameter("hoTen");
        String lopSinhHoat = request.getParameter("lopSinhHoat");
        String soDienThoai = request.getParameter("soDienThoai");
        String email = request.getParameter("email");
        String hinhAnh = null; // Đường dẫn lưu ảnh

        // Xử lý file upload
        Part hinhAnhPart = request.getPart("hinhAnh");  // Lấy phần ảnh từ form
        if (hinhAnhPart != null && hinhAnhPart.getSize() > 0) {
            String fileName = getFileName(hinhAnhPart);
            String uploadPath = "D:/NAM3/WEB/CLB_TinHoc/src/main/webapp/images";  // Đảm bảo thư mục này tồn tại

            // Kiểm tra thư mục lưu trữ, nếu không tồn tại thì tạo mới
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                if (!uploadDir.mkdirs()) {
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Không thể tạo thư mục lưu ảnh.");
                    return;
                }
            }

            // Tạo tên file mới nếu file đã tồn tại
            String fileNameBase = hoTen.trim().toLowerCase().replaceAll("[^a-zA-Z0-9]", "_");
            if (fileNameBase.isEmpty()) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Tên file không hợp lệ.");
                return;
            }

            String uniqueFileName = fileNameBase;
            File file = new File(uploadDir, fileName);
            if (file.exists()) {
                uniqueFileName = fileNameBase + "_" + UUID.randomUUID().toString() + ".jpg";
            }

            // Lưu file vào thư mục
            hinhAnhPart.write(new File(uploadDir, uniqueFileName).getAbsolutePath());
            hinhAnh = uniqueFileName;  // Cập nhật tên file vào cơ sở dữ liệu
        }

        // Kiểm tra các trường bắt buộc
        if (maSupport == null || maSupport.isEmpty() || hoTen == null || hoTen.isEmpty() || lopSinhHoat == null || lopSinhHoat.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Thiếu các trường bắt buộc.");
            return;
        }

        // Gọi DAO để thêm dữ liệu vào DB
        DAOcn dao = new DAOcn();
        dao.addSupport(new SupportClass(maSupport, hoTen, lopSinhHoat, soDienThoai, email, hinhAnh));

        // Chuyển hướng về danh sách Support
        response.sendRedirect(request.getContextPath() + "/listSupport");
    }

    // Phương thức để lấy tên file từ part
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
