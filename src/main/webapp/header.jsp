<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    

<header>

    <div class="container d-flex justify-content-between align-items-center py-3">
        <!-- Logo -->
        <div class="logo">
            <img src="./images/logo2.png" alt="Website Logo" class="img-fluid" style="max-height: 80px;">
        </div>

        <!-- Hamburger Menu for mobile view -->
        <button class="navbar-toggler d-md-none" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <!-- Navigation Menu -->
        <div class="collapse navbar-collapse d-md-flex" id="navbarNav">
            <div class="menu">
                <a href="Home.jsp" class="nav-link text-nowrap">Home</a>
                <c:if test="${sessionScope.acc != null}">
                    <a href="listCourse" class="nav-link text-nowrap">Khóa học</a>
                    <a href="listSupport" class="nav-link text-nowrap">Support</a>
                    <a href="${pageContext.request.contextPath}/students" class="nav-link text-nowrap">Sinh viên</a>
                    <a href="ketqua" class="nav-link text-nowrap">Kết Quả</a>
                </c:if>
                <c:if test="${sessionScope.acc == null}">
                    <a href="login.jsp" class="nav-link text-nowrap">Khóa học</a>
                    <a href="login.jsp" class="nav-link text-nowrap">Support</a>
                    <a href="login.jsp" class="nav-link text-nowrap">Sinh viên</a>
                    <a href="login.jsp" class="nav-link text-nowrap">Kết Quả</a>
                </c:if>
            </div>
        </div>

        <!-- User Info -->
        <div class="user-info-container d-flex align-items-center">
            <c:if test="${sessionScope.acc != null}">
                <div class="user-info d-flex align-items-center gap-2">
                    <img src="./images/logo2.png" alt="User Avatar" class="img-fluid" style="max-height: 40px; border-radius: 50%;">
                    <a href="logout" class="collapse navbar-collapse d-md-flex">Logout</a>
                </div >
            </c:if>
            <c:if test="${sessionScope.acc == null}">
                <a href="login.jsp" class="collapse navbar-collapse d-md-flex">Login</a>
            </c:if>
        </div>
    </div>
</header>