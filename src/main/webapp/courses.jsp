<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách khóa học</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            margin: 20px;
        }
        .course {
            margin: 20px 0;
            padding: 10px;
            border: 1px solid #ccc;
            display: flex;
            align-items: center;
            border-radius: 10px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        .course img {
            width: 100px;
            height: 100px;
            margin-right: 20px;
            border-radius: 10px;
            object-fit: cover;
        }
        .course h3 {
            margin: 0;
            color: #006600;
        }
        .course p {
            margin: 5px 0;
        }
    </style>
</head>
<body>
<h1>Danh sách khóa học</h1>
<%
    List<model.Course> khoaHocList = 
        (List<model.Course>) request.getAttribute("khoaHocList");
    if (khoaHocList != null) {
        for (model.Course course : khoaHocList) {
%>
    <div class="course">
        <img src="<%= request.getContextPath() + "/" + course.getImage() %>" alt="Ảnh khóa học">
        <div>
            <h3><%= course.getTenKhoaHoc() %></h3>
            <p>Mô tả: <%= course.getMoTa() %></p>
            <p>Thời gian: <%= course.getNgayBatDau() %> - <%= course.getNgayKetThuc() %></p>
        </div>
    </div>
<% 
        }
    } else { 
%>
    <p>Không có khóa học nào được tìm thấy.</p>
<% 
    } 
%>
</body>
</html>
