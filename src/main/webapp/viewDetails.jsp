<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Student" %>
<%@ page import="model.SupportClass" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Chi tiết lớp học</title>
    <link rel="stylesheet" href="css/class.css">
    <link rel="stylesheet" href="css/header.css">
   
</head>
<body>
    <!-- Đưa vào header -->
    <jsp:include page="header.jsp" />

    <div class="class-info">
          
            <c:choose>
                <c:when test="${not empty lop}">
                    <p><strong>Tên lớp:</strong> ${lop.tenLopHoc}</p>
                    <p><strong>Mã lớp:</strong> ${lop.maLopHoc}</p>
                </c:when>
                <c:otherwise>
                    <p>Không có thông tin lớp học nào được tìm thấy.</p>
                </c:otherwise>
            </c:choose>
        </div>
            

        <h2>Danh sách Sinh viên</h2>
        <c:choose>
            <c:when test="${not empty students}">
                <table border="1">
                    <tr>
                        <th>Mã Sinh Viên</th>
                        <th>Họ Tên</th>
                        <th>Lớp Sinh Hoạt</th>
                        <th>Email</th>
                        <th>Số Điện Thoại</th>
                        <th>Ngày Tham Gia</th>
                        <th> Kết Quả </th>
                    </tr>
                    <c:forEach var="sv" items="${students}">
                        <tr>
                            <td>${sv.maSinhVien}</td>
                            <td>${sv.hoTen}</td>
                            <td>${sv.lopSinhHoat}</td>
                            <td>${sv.email}</td>
                            <td>${sv.soDienThoai}</td>
                            <td>${sv.ngayThamGia}</td>
                            <td>
                        <!-- Thêm liên kết để xem kết quả thi -->
                        <a href="viewScores?maSinhVien=${sv.maSinhVien}" class="btn">XKết Quả</a>
                    </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <p>Không có sinh viên nào trong lớp này.</p>
            </c:otherwise>
        </c:choose>

        <h2>Danh sách Support</h2>
        <c:choose>
            <c:when test="${not empty supports}">
                <table border="1">
                    <tr>
                        <th>Mã Support</th>
                        <th>Họ Tên</th>
                        <th>Lớp Học Phần</th>
                        <th>Số Điện Thoại</th>
                        <th>Email</th>
                    </tr>
                    <c:forEach var="sp" items="${supports}">
                        <tr>
                            <td>${sp.maSupport}</td>
                            <td>${sp.hoTen}</td>
                            <td>${sp.lopSinhHoat}</td>
                            <td>${sp.soDienThoai}</td>
                            <td>${sp.email}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <p>Không có hỗ trợ nào cho lớp này.</p>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>
