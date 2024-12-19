<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thêm Sinh Viên</title>
    <link rel="stylesheet" href="css/form.css">
</head>
<body>
    <jsp:include page="header.jsp" />

    <div class="container">
        <h1>Thêm Sinh Viên</h1>
        <!-- Form thêm sinh viên -->
        <form action="addStudent" method="post">
            <!-- Gửi maLopHoc ẩn -->
            <input type="hidden" name="maLopHoc" value="${param.maLopHoc}">

            <label for="hoTen">Họ Tên Sinh Viên:</label>
            <input type="text" id="hoTen" name="hoTen" required>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>

            <label for="ngaySinh">Ngày Sinh:</label>
            <input type="date" id="ngaySinh" name="ngaySinh">

            <button type="submit" class="btn">Lưu</button>
            <a href="courseList.jsp" class="btn">Hủy</a>
        </form>
    </div>

    <footer>
        <p>&copy; 2024 CIT Academy</p>
    </footer>
</body>
</html>
