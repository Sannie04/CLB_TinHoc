<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="model.Course" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Sửa Khóa Học</title>
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/course.css">
</head>
<body>
    <!-- Include Header -->
    <jsp:include page="header.jsp" />

    <div class="container">
        <h1>Sửa Khóa Học</h1>

        <!-- Form for editing the course -->
        <form action="listCourse" method="post">
            <input type="hidden" name="action" value="edit" />
            <input type="hidden" name="maKhoaHoc" value="${course.maKhoaHoc}" />
            
            <label for="tenKhoaHoc">Tên Khóa Học</label>
            <input type="text" id="tenKhoaHoc" name="tenKhoaHoc" value="${course.tenKhoaHoc}" required />
            
            <label for="moTa">Mô Tả</label>
            <textarea id="moTa" name="moTa" required>${course.moTa}</textarea>
            
            <label for="ngayBatDau">Ngày Bắt Đầu</label>
            <input type="date" id="ngayBatDau" name="ngayBatDau" value="${course.ngayBatDau}" required />
            
            <label for="ngayKetThuc">Ngày Kết Thúc</label>
            <input type="date" id="ngayKetThuc" name="ngayKetThuc" value="${course.ngayKetThuc}" required />
            
            <label for="image">Hình Ảnh</label>
            <input type="text" id="image" name="image" value="${course.image}" />

            <button type="submit" class="btn">Cập Nhật Khóa Học</button>
        </form>
    </div>

    <footer>
        <p>&copy; 2024 CIT Academy</p>
    </footer>
</body>
</html>
