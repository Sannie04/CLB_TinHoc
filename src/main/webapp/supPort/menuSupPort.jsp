<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Arrays" %>
<%@ page import = "model.SupportClass" %>
<%@ page import = "support.ListSupportServlet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
   <link rel="stylesheet" href="./css/header.css">
    <link rel="stylesheet" href="./css/support.css">

    <meta charset="UTF-8">
    <title>Danh sách Support</title>
    
<body>
 <jsp:include page="../header.jsp" />
 
    <div class="content">
        <h1>Danh sách Support</h1>
        <!-- Nút thêm mới -->
        <div class="actions">
            <button class="btn-add" data-bs-toggle="modal" data-bs-target="#modalThem">Thêm </button>
        </div>
        <!-- Bảng danh sách -->
        <table>
            <thead>
                <tr>
                    <th>Mã Support</th>
                    <th>Họ Tên</th>
                    <th>Lớp Học Phần</th>
                    <th>Số Điện Thoại</th>
                    <th>Email</th>
                    <th>Hành Động</th>
                </tr>
            </thead>
            
            <tbody>
			    <%
				if (request.getAttribute("listP") != null) {
				    List<SupportClass> supportList = (List<SupportClass>) request.getAttribute("listP");
				    if (supportList.size() > 0) {
				        for (SupportClass objSupport : supportList) {
				%>
				<tr>
				    <td><%= objSupport.getMaSupport() %></td>
				    <td><%= objSupport.getHoTen() %></td>
	
				    <td><%= objSupport.getLopSinhHoat() %></td>
				    <td><%= objSupport.getSoDienThoai() %></td>
				    <td><%= objSupport.getEmail() %></td>
				    <td>
					    <a href="LoadEditSupport?maSupport=<%= objSupport.getMaSupport() %>" class="btn-green">Cập nhật</a>
						<a href="deleteSupport?maSupport=<%= objSupport.getMaSupport() %>" class="btn-green">Xóa</a>

					</td>

				</tr>
				<%
				        }
				    } else {
				%>
				<tr>
				    <td colspan="6" style="text-align: center;">Không có dữ liệu</td>
				</tr>
				<%
				    }
				} else {
				%>
				<tr>
				    <td colspan="6" style="text-align: center;">Dữ liệu không được tải</td>
				</tr>
				<%
				}
				%>

			</tbody>
        </table>
    </div>
    <!-- Modal Thêm Support -->
    <div class="modal fade" id="modalThem" tabindex="-1" aria-labelledby="modalThemLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="modalThemLabel">Thêm Support</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form action="AddSupportServlet" method="post" accept-charset="UTF-8">
                        <div class="mb-3">
                            <label for="maSupport" class="form-label">Mã Support</label>
                            <input type="text" class="form-control" id="maSupport" name="maSupport" placeholder="Nhập mã support" required>
                        </div>
                        <div class="mb-3">
                            <label for="hoTen" class="form-label">Họ Tên</label>
                            <input type="text" class="form-control" id="hoTen" name="hoTen" placeholder="Nhập họ tên" required>
                        </div>
                        <div class="mb-3">
                            <label for="LopSinhHoat" class="form-label">Chuyên Môn</label>
                            <input type="text" class="form-control" id="LopSinhHoat" name="LopSinhHoat" placeholder="Nhập Lớp">
                        </div>
                        <div class="mb-3">
                            <label for="soDienThoai" class="form-label">Số Điện Thoại</label>
                            <input type="text" class="form-control" id="soDienThoai" name="soDienThoai" placeholder="Nhập số điện thoại">
                        </div>
                        <div class="mb-3">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" class="form-control" id="email" name="email" placeholder="Nhập email" required>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
                            <button type="submit" class="btn btn-primary">Thêm</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
