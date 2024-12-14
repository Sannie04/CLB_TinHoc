<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Course" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh sách Khóa Học</title>
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/course.css">
</head>
<body>
    <!-- Include Header -->
    <jsp:include page="header.jsp" />

    <div class="container">
        <h1>Danh sách Khóa Học</h1>

        <!-- Button to Add New Course -->
        <a href="addCourse.jsp" class="btn">Thêm Khóa Học</a>

        <div class="course-cards">
            <!-- Loop through the courses list -->
            <c:choose>
                <c:when test="${not empty listC}">
                    <c:forEach var="course" items="${listC}">
                        <div class="course-card">
                            <!-- Fallback image if image is empty or null -->
                            <img src="${empty course.image ? 'default_image.jpg' : course.image}" alt="Course Image" />
                            <h3>${course.tenKhoaHoc}</h3>
                            <p>${course.moTa}</p>

                            <!-- Edit button for the course -->
                            <a href="listCourse?action=edit&maKhoaHoc=${course.maKhoaHoc}" class="btn">Sửa</a>

                            <!-- Displaying class list (assuming course has a class list) -->
                            <ul>
                                <c:forEach var="lop" items="${course.danhSachLop}">
                                    <li>
                                        <a href="viewDetails?maLopHoc=${lop.maLopHoc}" class="btn">${lop.tenLopHoc}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <p style="text-align: center; width: 100%; color: #666;">Không có dữ liệu</p>
                </c:otherwise>
            </c:choose>
        </div>
    </div>

    <footer>
        <p>&copy; 2024 CIT Academy</p>
    </footer>
</body>
</html>
