<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Arrays" %>
<%@ page import = "model.SupportClass" %>
<%@ page import = "support.ListSupportServlet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<%
	List<SupportClass> supportList = (List<SupportClass>) request.getAttribute("listP");

	%>
<head>
    <meta charset="UTF-8">
    <title>Danh sách Support</title>
    <style>
        body {
            margin: 10px;
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
        }
        nav {
            background-color: #28a745;
            color: white;
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 10px 20px;
        }
        nav .nav-left {
            display: flex;
            align-items: center;
        }
        nav .nav-left a {
            color: white;
            text-decoration: none;
            font-size: 24px;
            margin-right: 20px;
        }
        nav .nav-left a:hover {
            color: #ffd700;
        }
        nav h1 {
            margin: 0;
            font-size: 30px;
            text-align: center;
            flex-grow: 1;
        }
        .content {
            width: 90%;
            margin: 30px auto;
        }
        .actions {
            display: flex;
            justify-content: flex-end;
            margin-bottom: 20px;
        }
        .btn-add {
            background-color: #28a745;
            color: white;
            padding: 10px 15px;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .btn-add:hover {
            background-color: #218838;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 10px;
            background-color: white;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            overflow: hidden;
        }
        thead th {
            background-color: #28a745;
            color: white;
            text-align: left;
            padding: 10px;
        }
        tbody td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }
        button {
            padding: 8px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 14px;
            margin: 0 5px;
        }
        .btn-edit {
            background-color: #ffc107;
            color: black;
        }
        .btn-delete {
            background-color: #dc3545;
            color: white;
        }
    </style>
    <!-- Bootstrap 5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <nav>
    
        <div class="nav-left">
            <a href="javascript:history.go(-1)">Quay lại</a>
        </div>
        <h1>Danh sách Support</h1>
    </nav>
    <div class="content">
        <!-- Nút thêm mới -->
        <div class="actions">
            <button class="btn-add" data-bs-toggle="modal" data-bs-target="#modalThem">Add New Support</button>
        </div>
        <!-- Bảng danh sách -->
        <table>
            <thead>
                <tr>
                    <th>Mã Support</th>
                    <th>Họ Tên</th>
                    <th>Địa Chỉ</th>
                    <th>Số Điện Thoại</th>
                    <th>Email</th>
                    <th>Hành Động</th>
                </tr>
            </thead>
            
            <tbody>
			    <c:forEach var="objSupport" items="${listP}">
				    <tr>
				        <td>${objSupport.maSupport}</td>
				        <td>${objSupport.hoTen}</td>
				        <td>${objSupport.diaChi}</td>
				        <td>${objSupport.soDienThoai}</td>
				        <td>${objSupport.email}</td>
				        <td>
				            <a href="editSupport?maSupport=${objSupport.maSupport}" class="btn btn-warning btn-sm">Cập nhật</a>
				            <a href="deleteSupport?maSupport=${objSupport.maSupport}" class="btn btn-danger btn-sm">Xóa</a>
				        </td>
				    </tr>
				</c:forEach>

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
                    <form action="AddSupportServlet" method="post">
                        <div class="mb-3">
                            <label for="maSupport" class="form-label">Mã Support</label>
                            <input type="text" class="form-control" id="maSupport" name="maSupport" placeholder="Nhập mã support" required>
                        </div>
                        <div class="mb-3">
                            <label for="hoTen" class="form-label">Họ Tên</label>
                            <input type="text" class="form-control" id="hoTen" name="hoTen" placeholder="Nhập họ tên" required>
                        </div>
                        <div class="mb-3">
                            <label for="diaChi" class="form-label">Địa Chỉ</label>
                            <input type="text" class="form-control" id="diaChi" name="diaChi" placeholder="Nhập địa chỉ">
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
