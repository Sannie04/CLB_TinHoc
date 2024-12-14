<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Kết Quả Học Tập</title>
    <link rel="stylesheet" href="css/class.css">
    <link rel="stylesheet" href="css/header.css">
</head>
<body>
 <jsp:include page="header.jsp" />
    <h1>Quản lý Điểm Thi</h1>

    <!-- Display message after action -->
    <c:if test="${not empty message}">
        <div style="color: green; font-weight: bold;">${message}</div>
    </c:if>

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
                        <form action="ketqua" method="post" style="display: inline;">
                            <input type="hidden" name="action" value="update">
                            <input type="hidden" name="maSinhVien" value="${ketQua.maSinhVien}">
                            <input type="hidden" name="maKhoaHoc" value="${ketQua.maKhoaHoc}"> <!-- Dynamic Course ID -->
                            <input type="text" name="diem" value="${ketQua.diemThi}" placeholder="Điểm mới">
                            <input type="number" name="lanThi" value="${ketQua.lanThi}" placeholder="Lần thi mới">
                            <button type="submit">Cập Nhật</button>
                        </form>

                        <!-- Form Xóa -->
                        <form action="ketqua" method="post" style="display: inline;">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="maSinhVien" value="${ketQua.maSinhVien}">
                            <input type="hidden" name="maKhoaHoc" value="${ketQua.maKhoaHoc}"> <!-- Dynamic Course ID -->
                            <button type="submit">Xóa</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <!-- Form Thêm Mới -->
    <h2>Thêm Điểm Thi</h2>
    <form action="ketqua" method="post">
        <input type="hidden" name="action" value="add">
        <input type="text" name="maSinhVien" placeholder="Mã Sinh Viên" required>

        <!-- Dynamic dropdown for Course (maKhoaHoc) -->
        <select name="maKhoaHoc" required>
            <c:forEach var="khoaHoc" items="${khoaHocList}">
                <option value="${khoaHoc.maKhoaHoc}">${khoaHoc.tenKhoaHoc}</option>
            </c:forEach>
        </select>

        <input type="text" name="diem" placeholder="Điểm Thi" required>
        <input type="number" name="lanThi" placeholder="Lần Thi" required>
        <button type="submit">Thêm</button>
    </form>

</body>
</html>
