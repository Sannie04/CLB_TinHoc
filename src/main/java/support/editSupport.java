package support;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DAO.DAOcn;
import model.SupportClass;

@WebServlet("/editSupport")
@MultipartConfig  // Enable file upload handling
public class editSupport extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public editSupport() {
        super();
    }

    // Handling GET requests to fetch the existing support data
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maSupport = request.getParameter("maSupport");
        if (maSupport == null || maSupport.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing maSupport parameter.");
            return;
        }

        DAOcn dao = new DAOcn();
        SupportClass support = dao.getSupportByMaSupport(maSupport);

        if (support != null) {
            request.setAttribute("support", support);  // Send support data to the JSP
            request.getRequestDispatcher("/editSupportForm.jsp").forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Support entry not found.");
        }
    }

    // Handling POST requests to update the support data
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String maSupport = request.getParameter("maSupport");
        String hoTen = request.getParameter("hoTen");
        String lopSinhHoat = request.getParameter("lopSinhHoat");
        String soDienThoai = request.getParameter("soDienThoai");
        String email = request.getParameter("email");
        String hinhAnh = null; // Đường dẫn lưu ảnh

        String uploadPath = "D:/NAM3/WEB/CLB_TinHoc/src/main/webapp/images";

        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            if (uploadDir.mkdirs()) {
                System.out.println("Thư mục 'images' đã được tạo thành công tại: " + uploadPath);
            } else {
                System.out.println("Không thể tạo thư mục 'images'. Kiểm tra quyền.");
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Không thể tạo thư mục lưu ảnh.");
                return;
            }
        }

     // Xử lý file upload
        Part hinhAnhPart = request.getPart("hinhAnh");
        if (hinhAnhPart != null && hinhAnhPart.getSize() > 0) {
        	// Lấy tên file gốc từ part
        	String originalFileName = hinhAnhPart.getSubmittedFileName();
        	String fileExtension = ""; // Phần mở rộng của file

        	// Kiểm tra và tách phần mở rộng từ tên file gốc
        	if (originalFileName != null && originalFileName.contains(".")) {
        	    fileExtension = originalFileName.substring(originalFileName.lastIndexOf(".")); // Lấy phần mở rộng (bao gồm dấu chấm)
        	} else {
        	    fileExtension = ".jpg"; // Mặc định là .jpg nếu không tìm thấy phần mở rộng
        	}

        	// Chuyển đổi tên họ thành tên file hợp lệ
        	String fileNameBase = hoTen.trim() // Loại bỏ khoảng trắng thừa
        	                           .toLowerCase() // Đổi thành chữ thường
        	                           .replaceAll("[^a-zA-Z0-9]", "_"); // Loại bỏ ký tự đặc biệt, thay bằng '_'

        	// Kiểm tra nếu tên cơ bản rỗng
        	if (fileNameBase.isEmpty()) {
        	    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Tên file không hợp lệ.");
        	    return;
        	}

        	// Gắn phần mở rộng vào tên file
        	String fileName = fileNameBase + fileExtension;

        	// Kiểm tra trùng tên file, nếu trùng thêm UUID
        	File file = new File(uploadDir, fileName);
        	if (file.exists()) {
        	    fileName = fileNameBase + "_" + UUID.randomUUID().toString() + fileExtension;
        	}

        	// Lưu file vào thư mục
        	hinhAnhPart.write(new File(uploadDir, fileName).getAbsolutePath());
        	hinhAnh = fileName; // Lưu tên file để cập nhật vào cơ sở dữ liệu
        	System.out.println("Ảnh được lưu tại: " + new File(uploadDir, fileName).getAbsolutePath());

        } else {
            System.out.println("Không có file ảnh được tải lên.");
        }

        if (maSupport == null || maSupport.isEmpty() || hoTen == null || hoTen.isEmpty() || lopSinhHoat == null || lopSinhHoat.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Thiếu các trường bắt buộc.");
            return;
        }


        DAOcn dao = new DAOcn();
        dao.editSupport(maSupport, hoTen, lopSinhHoat, soDienThoai, email, hinhAnh);

        // Chuyển hướng về danh sách Support
        response.sendRedirect(request.getContextPath() + "/listSupport");
    }

}
