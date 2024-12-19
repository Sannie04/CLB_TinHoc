<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh sách Khóa Học</title>
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/course.css">
</head>
<body>
    <jsp:include page="header.jsp" />

    <div class="container">
        <h1>Danh sách Khóa Học</h1>
        <a href="addCourse.jsp" class="btn">Thêm Khóa Học</a>

        <div class="course-cards">
            <c:choose>
                <c:when test="${not empty listCourses}">
                    <c:forEach var="course" items="${listCourses}">
                        <div class="course-card">
                            <c:choose>
                                <c:when test="${empty course.image}">
                                    <img src="images/default_image.jpg" alt="Default Course Image" />
                                </c:when>
                                <c:otherwise>
                                    <img src="images/${course.image}" alt="${course.tenKhoaHoc} Image" />
                                </c:otherwise>
                            </c:choose>
                            <h3>${course.tenKhoaHoc}</h3>
                            <p>${empty course.moTa ? 'Mô tả chưa có.' : course.moTa}</p>
                            <a href="loadcourse?maKhoaHoc=${course.maKhoaHoc}" class="btn">Sửa</a>
            
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
                    <p>Không có dữ liệu</p>
                </c:otherwise>
            </c:choose>
        </div>
    </div>

    <footer>
        <p>&copy; 2024 CIT Academy</p>
    </footer>
</body>
</html>
