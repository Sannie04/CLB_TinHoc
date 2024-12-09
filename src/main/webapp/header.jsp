<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<header>
    <div class="container">
        <!-- Logo -->
        <div class="logo">
            <img src="./images/logo2.png" alt="Website Logo">
        </div>

        <!-- Navigation Menu -->
        <div class="menu">
            <a href="Home.jsp">Home</a>
            <a href="courses">Khóa học</a>
            <a href="listSupport">Support</a>
            <a href="student">Sinh viên</a>
            <a href="classes">Lớp Học</a>
            <a href="results">Kết Quả</a>
        </div>

        <!-- User Info -->
        <div class="user-info-container">
            <c:if test="${sessionScope.acc != null}">
                <div class="user-info">
                    <img src="./images/logo2.png" alt="User Avatar">
                    <span>Hello, ${sessionScope.acc.studentId}</span>
                </div>
                <div class="logout-link">
                    <a href="logout">Logout</a>
                </div>
            </c:if>
            <c:if test="${sessionScope.acc == null}">
                <a href="login.jsp">Login</a>
            </c:if>
        </div>
    </div>
</header>
