<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<header>
    <div class="container">
        <!-- Logo -->
        <div class="logo">
            <img src="./images/logo2.png" alt="Website Logo">
        </div>

        <!-- Navigation Menu -->
        <div class="menu">
            <a href="Home.jsp">Home</a>     	        
            <c:if test="${sessionScope.acc != null}">
                    <a href="listCourse">Khóa học</a>
		            <a href="listSupport">Support</a>
		            <a href="${pageContext.request.contextPath}/students">Sinh viên</a>
		            <a href="ketqua">Kết Quả</a>
            </c:if>
            <c:if test="${sessionScope.acc == null}">
	            <a href="login.jsp">Khóa học</a>
	            <a href="login.jsp">Support</a>
	            <a href="login.jsp">Sinh viên</a>
	            <a href="login.jsp">Kết Quả</a>
            </c:if>
        </div>

        <!-- User Info -->
        <div class="user-info-container">
		    <c:if test="${sessionScope.acc != null}">
		        <div class="user-info">
		            <img src="./images/logo2.png" alt="User Avatar">
		            
		        </div>
		        <div  class="menu" >
		            <a href="logout">Logout</a>
		        </div>
		    </c:if>
		    <c:if test="${sessionScope.acc == null}">
		        <a href="login.jsp">Login</a>
		    </c:if>
		</div>

    </div>
</header>
