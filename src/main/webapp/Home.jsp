<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang chủ</title>
    <style>
        body {
            margin: 5px;
            font-family: Arial, sans-serif;
        }
        nav {
            background-color: #28a745;
            color: white;
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 5px 0;
            margin-top: 50px;
            border-radius: 10px; 
        }
        nav .container {
            display: flex;
            justify-content: space-between;
            align-items: center;
            height: 80px;
            width: 95%;
            margin: 0 auto; 
            padding: 0;
        }
        nav .menu {
            display: flex;
            flex: 1;
            justify-content: space-evenly; 
        }
        nav a {
            color: white;
            text-decoration: none;
            font-size: 30px;
        }
        nav a:hover {
            color: #ffd700; 
        }
        nav img {
            display: block;
            height: 80px;
            margin: 0;
            border-radius: 10px; 
        }
        nav .user-info-container {
            display: flex;
            align-items: center;
            gap: 20px; /* Khoảng cách giữa avatar và logout */
        }
        nav .user-info {
            display: flex;
            align-items: center;
            gap: 10px; /* Khoảng cách giữa ảnh và text */
        }
        nav .user-info img {
            height: 40px;
            width: 40px;
            border-radius: 50%; /* Avatar hình tròn */
        }
        nav .logout-link a {
            color: white;
            font-size: 20px;
            text-decoration: none;
        }
        nav .logout-link a:hover {
            color: #ffd700;
        }
    </style>
</head>
<body>
    <nav>
        <div class="container">
            <div>
                <img src="./images/logo2.png" alt="Logo">
            </div>
            <div class="menu">
                <a href="Home.jsp">Home</a>
                <a href="courses">Khóa học</a>
                <a href="./supPort/menuSupPort.jsp">Support</a>
                <a href="student">Sinh viên</a>
                <a href="classes">Lớp Học</a>
                <a href="results">Kết Quả</a>
            </div>
            <div>
                <ul>
                    <c:if test="${sessionScope.acc != null}">
                        <li class="nav-item user-info-container">
                            <div class="user-info">
                                <img src="./images/logo2.png" 
                                     alt="Avatar">
                                <span>Hello ${sessionScope.acc.studentId}</span>
                            </div>
                            <div class="logout-link">
                                <a href="logout">Logout</a>
                            </div>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.acc == null}">
                        <li >
                            <a href="login.jsp">Login</a>
                        </li>
                    </c:if>
                </ul>
            </div>
        </div>
    </nav>
</body>
</html>
