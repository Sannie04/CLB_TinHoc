<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Score" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Kết quả thi của Sinh viên</title>
    <link rel="stylesheet" href="css/result_sv.css">
    <link rel="stylesheet" href="css/header.css">
</head>
<body>
  <jsp:include page="header.jsp" />
    <h1>Kết quả thi của Sinh viên</h1>

    <c:if test="${not empty message}">
        <p>${message}</p>
    </c:if>

    <!-- Hiển thị bảng điểm thi -->
    <table border="1">
        <thead>
            <tr>
                <th>Mã Sinh Viên</th>
                <th>Họ Tên</th>
                <th>Tên Khóa Học</th>
                <th>Điểm Thi</th>
                <th>Lần Thi</th>
                <th>Hành Động</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="score" items="${scores}">
                <tr>
                    <td>${score.maSinhVien}</td>
                    <td>${score.hoTen}</td>
                    <td>${score.tenKhoaHoc}</td>
                    <td>${score.diem}</td>
                    <td>${score.lanThi}</td>
                    <td class="action-buttons">
                  
<form action="viewScores" method="post" style="display:inline;">
    <input type="hidden" name="maSinhVien" value="${score.maSinhVien}">
    <input type="hidden" name="maKhoaHoc" value="${score.maKhoaHoc}">
    <input type="hidden" name="action" value="edit"> <!-- Chỉ hành động sửa -->
    <input type="text" name="diem" value="${score.diem}">
    <input type="text" name="lanThi" value="${score.lanThi}">
    <button type="submit">Sửa</button>
</form>


                       
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
