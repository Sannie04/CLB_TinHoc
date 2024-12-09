<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chỉnh sửa Support</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 20px;
        }
        form {
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 400px;
            margin: auto;
        }
        form h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
        }
        input[type="text"], input[type="email"] {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button {
            width: 100%;
            padding: 10px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
        }
        button:hover {
            background-color: #218838;
        }
        nav {
            background-color: #28a745;
            color: white;
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 10px 20px;
        }
        nav h1 {
            margin: 0;
            font-size: 30px;
            text-align: center;
            flex-grow: 1;
        }
        .nav-left a {
            color: white;
            text-decoration: none;
            font-weight: bold;
        }
        .nav-left a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <nav>
        <div class="nav-left">
            <a href="Home.jsp">Home</a>
        </div>
        <h1>update Support</h1>
    </nav>
    
    <form action="editSupport" method="post">
        <h2>Chỉnh sửa thông tin Support</h2>

        <div class="form-group">
            <label for="maSupport">Mã Support</label>
            <input type="text" id="maSupport" name="maSupport" value="${support.maSupport}" readonly>
        </div>

        <div class="form-group">
            <label for="hoTen">Họ Tên</label>
            <input type="text" id="hoTen" name="hoTen" value="${support.hoTen}" required>
        </div>

        <div class="form-group">
            <label for="diaChi">Địa Chỉ</label>
            <input type="text" id="diaChi" name="diaChi" value="${support.diaChi}">
        </div>

        <div class="form-group">
            <label for="lopSinhHoat">Lớp Sinh Hoạt</label>
            <input type="text" id="lopSinhHoat" name="lopSinhHoat" value="${support.lopSinhHoat}">
        </div>

        <div class="form-group">
            <label for="soDienThoai">Số Điện Thoại</label>
            <input type="text" id="soDienThoai" name="soDienThoai" value="${support.soDienThoai}">
        </div>

        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" id="email" name="email" value="${support.email}" required>
        </div>

        <button type="submit">Cập nhật</button>
    </form>
</body>
</html>
