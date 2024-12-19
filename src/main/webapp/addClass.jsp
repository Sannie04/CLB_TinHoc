<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thêm Lớp</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
   <form action="listCourse" method="post">
    <input type="hidden" name="action" value="addClass" />
    <label for="tenLopHoc">Tên lớp học:</label>
    <input type="text" id="tenLopHoc" name="tenLopHoc" required />

    <label for="maKhoaHoc">Mã khóa học:</label>
    <input type="number" id="maKhoaHoc" name="maKhoaHoc" required />

    <label for="selectedStudents">Chọn sinh viên:</label>
    <select id="selectedStudents" name="selectedStudents" multiple>
        <c:forEach var="student" items="${students}">
            <option value="${student.maSinhVien}">${student.hoTen}</option>
        </c:forEach>
    </select>

    <button type="submit">Thêm lớp</button>
</form>

</body>
</html>
