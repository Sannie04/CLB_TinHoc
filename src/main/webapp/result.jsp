<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Score" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Kết quả thi của Sinh viên</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h1>Quản lý Điểm Thi</h1>
<table>
    <thead>
        <tr>
            <th>Mã Sinh Viên</th>
            <th>Họ Tên</th>
            <th>Lớp</th>
            <th>Điểm Thi</th>
            <th>Lần Thi</th>
            <th>Hành Động</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="ketQua" items="${ketQuaList}">
            <tr>
                <td>${ketQua.maSinhVien}</td>
                <td>${ketQua.hoTen}</td>
                <td>${ketQua.lopSinhHoat}</td>
                <td>${ketQua.diemThi}</td>
                <td>${ketQua.lanThi}</td>
                <td>
                    <!-- Form Cập Nhật -->
                    <form action="diemthi" method="post" style="display: inline;">
                        <input type="hidden" name="action" value="update">
                        <input type="hidden" name="maSinhVien" value="${ketQua.maSinhVien}">
                        <input type="hidden" name="maKhoaHoc" value="1"> <!-- Mã khóa học mẫu -->
                        <input type="text" name="diem" value="${ketQua.diemThi}" placeholder="Điểm mới">
                        <input type="number" name="lanThi" value="${ketQua.lanThi}" placeholder="Lần thi mới">
                        <button type="submit">Cập Nhật</button>
                    </form>

                    <!-- Form Xóa -->
                    <form action="diemthi" method="post" style="display: inline;">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="maSinhVien" value="${ketQua.maSinhVien}">
                        <input type="hidden" name="maKhoaHoc" value="1"> <!-- Mã khóa học mẫu -->
                        <button type="submit">Xóa</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<!-- Form Thêm Mới -->
<h2>Thêm Điểm Thi</h2>
<form action="diemthi" method="post">
    <input type="hidden" name="action" value="add">
    <input type="text" name="maSinhVien" placeholder="Mã Sinh Viên" required>
    <input type="number" name="maKhoaHoc" placeholder="Mã Khóa Học" required>
    <input type="text" name="diem" placeholder="Điểm Thi" required>
    <input type="number" name="lanThi" placeholder="Lần Thi" required>
    <button type="submit">Thêm</button>
</form>


</body>
</html>
