<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Course</title>
    <link rel="stylesheet" href="css/addCourse.css">
</head>
<body>
    <h2>Add New Course</h2>
    
    <c:if test="${not empty error}">
        <div class="error-message">
            ${error}
        </div>
    </c:if>
    
    <form action="addCourseServlet" method="post" enctype="multipart/form-data">
        <input type="hidden" name="action" value="add"/>
        
        <label for="courseName">Course Name:</label>
        <input type="text" id="courseName" name="tenKhoaHoc" required>

        <label for="courseDescription">Course Description:</label>
        <textarea id="courseDescription" name="moTa" required></textarea>

        <label for="courseDuration">Course Duration (hours):</label>
        <input type="number" id="courseDuration" name="courseDuration" required>

        <label for="courseInstructor">Instructor:</label>
        <input type="text" id="courseInstructor" name="courseInstructor" required>

        <label for="startDate">Start Date:</label>
        <input type="date" id="startDate" name="ngayBatDau" required>

        <label for="endDate">End Date:</label>
        <input type="date" id="endDate" name="ngayKetThuc" required>

        <label for="image">Course Image:</label>
        <input type="file" id="image" name="image" accept="images/*">

        <button type="submit">Add Course</button>
    </form>

    <br>
    <a href="courseList.jsp" class="back-link">Back to Course List</a>
</body>
</html>
