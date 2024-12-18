<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Course</title>
</head>
<body>
    <h2>Edit Course</h2>

    <form action="listCourse?action=edit" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
        <input type="hidden" name="action" value="edit">
        <input type="hidden" name="maKhoaHoc" value="${course.maKhoaHoc}">
        
        <label for="tenKhoaHoc">Course Name:</label>
        <input type="text" name="tenKhoaHoc" value="${course.tenKhoaHoc}" required><br><br>

        <label for="moTa">Description:</label>
        <textarea name="moTa" required>${course.moTa}</textarea><br><br>

        <label for="ngayBatDau">Start Date:</label>
        <input type="date" name="ngayBatDau" value="${course.ngayBatDau}" required><br><br>

        <label for="ngayKetThuc">End Date:</label>
        <input type="date" name="ngayKetThuc" value="${course.ngayKetThuc}" required><br><br>

        <label for="image">Image:</label>
        <input type="file" name="image"><br><br>
        
        <input type="hidden" name="currentImage" value="${course.image}">

        <button type="submit">Update Course</button>
    </form>

    <a href="listCourse">Back to Course List</a>
</body>
</html>
