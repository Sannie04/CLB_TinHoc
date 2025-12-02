<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý Sinh viên - CÂU LẠC BỘ TIN HỌC</title>
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/student.css">
</head>
<body>
 <jsp:include page="header.jsp" />

    <div >
    <h2 class="text-center">Quản Lý Sinh Viên</h2>

    <!-- Hiển thị lỗi -->
    <c:if test="${not empty error}">
        <div class="alert alert-danger text-center">${error}</div>
    </c:if>

    <!-- Nút để hiển thị form thêm sinh viên -->
    <div class="text-center">
        <button id="toggleFormButton" class="btn btn-primary">Thêm Sinh Viên</button>
    </div>

    <!-- Form thêm sinh viên (mặc định ẩn) -->
    <div id="studentFormContainer" class="card" style="display: none;">
        <div class="card-header">
            <h4 class="text-center">Thêm Sinh Viên</h4>
        </div>
       <div class="card-body">
	    <form id="studentForm" action="${pageContext.request.contextPath}/students/add" method="post">
	        <table class="table table-borderless">
	            <tbody>
	                <tr>
	                    <td>
	                        <label for="maSinhVien">Mã Sinh Viên</label>
	                        <input type="text" id="maSinhVien" name="maSinhVien" class="form-control" required>
	                    </td>
	                    <td>
	                        <label for="hoTen">Họ Tên</label>
	                        <input type="text" id="hoTen" name="hoTen" class="form-control" required>
	                    </td>
	                </tr>
	                <tr>
	                <td>
	                        <label for="lopSinhHoat">Lớp Sinh Hoạt</label>
	                        <input type="text" id="lopSinhHoat" name="lopSinhHoat" class="form-control" required>
	                    </td>
	                    <td>
	                        <label for="email">Email</label>
	                        <input type="email" id="email" name="email" class="form-control" required>
	                    </td>
	                    
	                </tr>
	                <tr>
	                    <td>
	                        <label for="soDienThoai">Số Điện Thoại</label>
	                        <input type="text" id="soDienThoai" name="soDienThoai" class="form-control" required>
	                    </td>
	                    <td>
	                        <label for="ngayThamGia">Ngày Tham Gia</label>
	                        <input type="date" id="ngayThamGia" name="ngayThamGia" class="form-control" required>
	                    </td>
	                </tr>
	            </tbody>
	        </table>
	        <div class="text-center">
	            <button type="submit" class="btn btn-primary">Thêm</button>
	        </div>
	    </form>
	</div>
</div>

    <!-- Danh sách sinh viên -->
    <div class="card">
    <h4>Danh Sách Sinh Viên</h4>
    <table>
        <thead>
            <tr>
                <th>Mã SV</th>
                <th>Họ Tên</th>
                <th>Lớp Sinh Hoạt</th>
                <th>Email</th>
                <th>Điện Thoại</th>
                <th>Ngày Tham Gia</th>
                <th>Hành Động</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td>${student.maSinhVien}</td>
                    <td>${student.hoTen}</td>
                    <td>${student.lopSinhHoat}</td>
                    <td>${student.email}</td>
                    <td>${student.soDienThoai}</td>
                    <td>${student.ngayThamGia}</td>
                    <td>
                        <button onclick="updateStudent('${student.maSinhVien}')" class="btn-warning">Sửa</button>
                        <button onclick="deleteStudent('${student.maSinhVien}')" class="btn-danger">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<script>
    // JavaScript để ẩn/hiện form thêm sinh viên
    document.getElementById("toggleFormButton").addEventListener("click", function () {
        const formContainer = document.getElementById("studentFormContainer");
        if (formContainer.style.display === "none") {
            formContainer.style.display = "block";
            this.textContent = "Đóng Form";
        } else {
            formContainer.style.display = "none";
            this.textContent = "Thêm Sinh Viên";
        }
    });

    // Xử lý form thêm/cập nhật sinh viên
    document.getElementById('studentForm').addEventListener('submit', function (e) {
        e.preventDefault();

        const formData = new URLSearchParams();
        const form = this;

        formData.append('maSinhVien', form.querySelector('[name="maSinhVien"]').value);
        formData.append('hoTen', form.querySelector('[name="hoTen"]').value);
        formData.append('lopSinhHoat', form.querySelector('[name="lopSinhHoat"]').value);
        formData.append('email', form.querySelector('[name="email"]').value);
        formData.append('soDienThoai', form.querySelector('[name="soDienThoai"]').value);
        formData.append('ngayThamGia', form.querySelector('[name="ngayThamGia"]').value);
        fetch(form.action, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            },
            body: formData.toString()
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(data => {
                if (data.success) {
                    alert(data.message || 'Thao tác thành công!');
                    window.location.reload();
                } else {
                    alert(data.error || 'Có lỗi xảy ra!');
                }
            })
            .catch(error => {
                console.error('Error:', error);
                alert('Có lỗi xảy ra khi lưu thông tin sinh viên: ' + error.message);
            });
    });

    // Xóa sinh viên
    function deleteStudent(maSinhVien) {
        if (confirm('Bạn có chắc chắn muốn xóa sinh viên này?')) {
            const formData = new URLSearchParams();
            formData.append('maSinhVien', maSinhVien);

            fetch('${pageContext.request.contextPath}/students/delete', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded',
                },
                body: formData.toString()
            })
                .then(response => response.json())
                .then(data => {
                    if (data.success) {
                        alert(data.message || 'Xóa sinh viên thành công!');
                        window.location.reload();
                    } else {
                        alert(data.error || 'Có lỗi xảy ra khi xóa sinh viên!');
                    }
                })
                .catch(error => {
                    console.error('Error:', error);
                    alert('Có lỗi xảy ra khi xóa sinh viên: ' + error.message);
                });
        }
    }

    // Cập nhật sinh viên
    function updateStudent(maSinhVien) {
        fetch('${pageContext.request.contextPath}/students/get?id=' + encodeURIComponent(maSinhVien))
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(student => {
                const form = document.getElementById('studentForm');
                form.action = '${pageContext.request.contextPath}/students/update';
                form.querySelector('[name="maSinhVien"]').value = student.maSinhVien;
                form.querySelector('[name="hoTen"]').value = student.hoTen;
                form.querySelector('[name="lopSinhHoat"]').value = student.lopSinhHoat;
                form.querySelector('[name="email"]').value = student.email;
                form.querySelector('[name="soDienThoai"]').value = student.soDienThoai;
                form.querySelector('[name="ngayThamGia"]').value = student.ngayThamGia;
                form.querySelector('button[type="submit"]').textContent = 'Cập nhật';
            })
            .catch(error => {
                console.error('Error:', error);
                alert('Có lỗi xảy ra khi lấy thông tin sinh viên: ' + error.message);
            });
    }
</script>

</body>
</html>