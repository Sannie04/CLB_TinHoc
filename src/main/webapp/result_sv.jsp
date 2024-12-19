<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Score" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Kết quả thi của Sinh viên</title>

    <link rel="stylesheet" href="css/result_sv.css">
     <link rel="stylesheet" href="css/header.css">
    
</head>
<body class="bg-light">
    <jsp:include page="header.jsp" />
    
    <div class="container py-4">
        <h1 class="text-center mb-4">Kết quả thi của Sinh viên</h1>

        <c:if test="${not empty message}">
            <div class="alert alert-info" role="alert">
                ${message}
            </div>
        </c:if>

        <div class="card shadow-sm">
            <div class="card-body p-0">
                <div class="table-responsive">
                    <table class="table table-hover mb-0">
                        <thead class="table-dark">
                            <tr>
                                <th>Mã Sinh Viên</th>
                                <th>Họ Tên</th>
                                <th>Tên Khóa Học</th>
                                <th>Điểm Thi</th>
                                <th>Lần Thi</th>
                                <th>Hành Động</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="score" items="${scores}">
                                <tr>
                                    <td>${score.maSinhVien}</td>
                                    <td>${score.hoTen}</td>
                                    <td>${score.tenKhoaHoc}</td>
                                    <td>${score.diem}</td>
                                    <td>${score.lanThi}</td>
                                    <td>
                                        <form action="viewScores" method="post" class="d-flex gap-2 align-items-center">
                                            <input type="hidden" name="maSinhVien" value="${score.maSinhVien}">
                                            <input type="hidden" name="maKhoaHoc" value="${score.maKhoaHoc}">
                                            <input type="hidden" name="action" value="edit">
                                            <input type="text" name="diem" value="${score.diem}" 
                                                   class="form-control form-control-sm" style="width: 60px;">
                                            <input type="text" name="lanThi" value="${score.lanThi}" 
                                                   class="form-control form-control-sm" style="width: 60px;">
                                            <button type="submit" class="btn btn-primary btn-sm">Sửa</button>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
