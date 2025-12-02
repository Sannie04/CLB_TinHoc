<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Arrays" %>
<%@ page import = "model.SupportClass" %>
<%@ page import = "support.ListSupportServlet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh sách Support</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/menusupport.css">
    <link rel="stylesheet" href="./css/header.css">
</head>
<body>
    <jsp:include page="../header.jsp" />
    <div class="container">
        <h1 class="text-center my-4">Danh sách Support</h1>

        <!-- Button to trigger the "Add Support" modal -->
        <div class="mb-4 text-center">
            <button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#addSupportModal">Thêm Support</button>
        </div>

       <!-- Modal for adding new Support -->
<div class="modal fade" id="addSupportModal" tabindex="-1" aria-labelledby="addSupportModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addSupportModalLabel">Thêm Support</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="./addSupport" method="POST" enctype="multipart/form-data">
                    <div class="mb-3">
                        <label for="maSupport" class="form-label">Mã Support</label>
                        <input type="text" class="form-control" id="maSupport" name="maSupport" required>
                    </div>
                    <div class="mb-3">
                        <label for="hoTen" class="form-label">Họ Tên</label>
                        <input type="text" class="form-control" id="hoTen" name="hoTen" required>
                    </div>
                    <div class="mb-3">
                        <label for="lopSinhHoat" class="form-label">Lớp</label>
                        <input type="text" class="form-control" id="lopSinhHoat" name="lopSinhHoat" required>
                    </div>
                    <div class="mb-3">
                        <label for="soDienThoai" class="form-label">Số Điện Thoại</label>
                        <input type="text" class="form-control" id="soDienThoai" name="soDienThoai"required>
                    </div>
                    <div class="mb-3">
                        <label for="email" class="form-label">Email</label>
                        <input type="email" class="form-control" id="email" name="email"required>
                    </div>
                    <div class="mb-3">
                        <label for="hinhAnh" class="form-label">Hình ảnh </label>
                        <input type="file" class="form-control" id="hinhAnh" name="hinhAnh"required>
                    </div>
                    <button type="submit" class="btn btn-primary">Thêm Support</button>
                </form>
            </div>
        </div>
    </div>
</div>

        <div class="row mt-5">
            <% if (request.getAttribute("listP") != null) {
                List<SupportClass> supportList = (List<SupportClass>) request.getAttribute("listP");
                if (supportList.size() > 0) {
                    for (SupportClass objSupport : supportList) { %>
                        <div class="col-md-4 mb-4">
                            <div class="support-card text-center">
                                <div class="image-container mb-3">
                                    <img src="<%= request.getContextPath() + "/images/" + (objSupport.getHinhAnh() != null ? objSupport.getHinhAnh() : "default.jpg")  %>" alt="Hình ảnh" width="50" height="50" />
                                </div>
                                <h5><%= objSupport.getHoTen() %></h5>
                                <p>Mã Support: <%= objSupport.getMaSupport() %></p>
                                <p>Lớp: <%= objSupport.getLopSinhHoat() %></p>
                                <p>SĐT: <%= objSupport.getSoDienThoai() %></p>
                                <p>Email: <%= objSupport.getEmail() %></p>
                                <div class="mt-3">
                                    <a href="LoadEditSupport?maSupport=<%= objSupport.getMaSupport() %>" class="btn btn-primary btn-sm">Cập nhật</a>
                                    <a href="deleteSupport?maSupport=<%= objSupport.getMaSupport() %>" class="btn btn-danger btn-sm">Xóa</a>
                                </div>
                            </div>
                        </div>
                    <% }
                } else { %>
                    <div class="col-12 text-center">
                        <p>Không có dữ liệu</p>
                    </div>
                <% }
            } else { %>
                <div class="col-12 text-center">
                    <p>Dữ liệu không được tải</p>
                </div>
            <% } %>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
