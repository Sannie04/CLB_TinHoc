<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thêm Khóa Học</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <h2>Thêm Khóa Học Mới</h2>
    <form action="listCourse" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
        <input type="hidden" name="action" value="add">
        
        <label for="tenKhoaHoc">Tên Khóa Học:</label>
        <input type="text" id="tenKhoaHoc" name="tenKhoaHoc" required><br>

        <label for="moTa">Mô Tả:</label>
        <textarea id="moTa" name="moTa" rows="4" required></textarea><br>

        <label for="ngayBatDau">Ngày Bắt Đầu:</label>
        <input type="date" id="ngayBatDau" name="ngayBatDau" required><br>

        <label for="ngayKetThuc">Ngày Kết Thúc:</label>
        <input type="date" id="ngayKetThuc" name="ngayKetThuc" required><br>

        <label for="image">Ảnh Khóa Học:</label>
        <input type="file" id="image" name="image"><br><br>

        <button type="submit">Thêm Khóa Học</button>
    </form>
</body>
</html>
