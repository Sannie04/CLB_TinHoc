<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <link rel="stylesheet" href="./css/addcourse.css">
    <title>Thêm khóa học</title>
</head>
<body>
<jsp:include page="header.jsp" />
    <h1>Thêm khóa học mới</h1>
    <form action="listCourse" method="POST" enctype="multipart/form-data">
        <input type="hidden" name="action" value="add">

        <label for="tenKhoaHoc">Tên khóa học:</label>
        <input type="text" id="tenKhoaHoc" name="tenKhoaHoc" required><br><br>

        <label for="moTa">Mô tả:</label>
        <textarea id="moTa" name="moTa" required></textarea><br><br>

        <label for="ngayBatDau">Ngày bắt đầu:</label>
        <input type="date" id="ngayBatDau" name="ngayBatDau" required><br><br>

        <label for="ngayKetThuc">Ngày kết thúc:</label>
        <input type="date" id="ngayKetThuc" name="ngayKetThuc" required><br><br>

        <label for="image">Ảnh:</label>
        <input type="file" id="image" name="image"><br><br>



        <label for="tenLopHoc">Tên lớp học:</label>
        <input type="text" id="tenLopHoc" name="tenLopHoc" required><br><br>

        <button type="submit">Thêm khóa học</button>
    </form>
</body>
</html>
