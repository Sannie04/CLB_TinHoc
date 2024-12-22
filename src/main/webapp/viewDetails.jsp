<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Student" %>
<%@ page import="model.SupportClass" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Chi tiết lớp học</title>
    <link rel="stylesheet" href="css/class.css">
    <link rel="stylesheet" href="css/header.css">
   
</head>
<body>
    <!-- Đưa vào header -->
    <jsp:include page="header.jsp" />
	
    <div class="class-info">
          
            <c:choose>
                <c:when test="${not empty lop}">
                    <p><strong>Tên lớp:</strong> ${lop.tenLopHoc}</p>
                    <p><strong>Mã lớp:</strong> ${lop.maLopHoc}</p>
                </c:when>
                <c:otherwise>
                    <p>Không có thông tin lớp học nào được tìm thấy.</p>
                </c:otherwise>
            </c:choose>
        </div>
            
		<div class="col-sm-6">
	        <a href="#addstudent"  class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add student</span></a>
	    </div>
        <h2>Danh sách Sinh viên</h2>
        <c:choose>
            <c:when test="${not empty studentsdetails}">
                <table border="1">
                    <tr>
                        <th>Mã Sinh Viên</th>
                        <th>Họ Tên</th>
                        <th>Lớp Sinh Hoạt</th>
                        <th>Email</th>
                        <th>Số Điện Thoại</th>
                        <th>Ngày Tham Gia</th>
                        <th> Kết Quả </th>
                    </tr>
                    <c:forEach var="sv" items="${studentsdetails}">
                        <tr>
                            <td>${sv.maSinhVien}</td>
                            <td>${sv.hoTen}</td>
                            <td>${sv.lopSinhHoat}</td>
                            <td>${sv.email}</td>
                            <td>${sv.soDienThoai}</td>
                            <td>${sv.ngayThamGia}</td>
                            <td>
                        <!-- Thêm liên kết để xem kết quả thi -->
                        <a href="viewScores?maSinhVien=${sv.maSinhVien}" class="btn">Kết Quả</a>
                    </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <p>Không có sinh viên nào trong lớp này.</p>
            </c:otherwise>
        </c:choose>
		<div class="col-sm-6">
	        <a href="#addsupport"  class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add support</span></a>
	    </div>
        <h2>Danh sách Support</h2>
        <c:choose>
            <c:when test="${not empty supportsdetails}">
                <table border="1">
                    <tr>
                        <th>Mã Support</th>
                        <th>Họ Tên</th>
                        <th>Lớp Học Phần</th>
                        <th>Số Điện Thoại</th>
                        <th>Email</th>
                    </tr>
                    <c:forEach var="sp" items="${supportsdetails}">
                        <tr>
                            <td>${sp.maSupport}</td>
                            <td>${sp.hoTen}</td>
                            <td>${sp.lopSinhHoat}</td>
                            <td>${sp.soDienThoai}</td>
                            <td>${sp.email}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <p>Không có hỗ trợ nào cho lớp này.</p>
            </c:otherwise>
        </c:choose>
    </div>
      
	<!-- Edit Modal HTML -->
        <div id="addstudent" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="add" method="post">
                    	<input type="hidden" name="maLopHoc" value="${lop.maLopHoc}" >
                        <div class="modal-header">						
                            <h4 class="modal-title">Add student</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
                            
                            <div class="form-group">
				                <label for="selectedStudents">Chọn sinh viên:</label>
				                <select name="selectedStudents" id="selectedStudents" class="form-control" multiple size="5">
				                    <c:forEach var="student" items="${students}">
				                        <option value="${student.maSinhVien}">${student.hoTen}</option>
				                    </c:forEach>
				                </select>
				            </div>
						
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-success" value="Add">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div id="addsupport" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="add" method="post">
                    	<input type="hidden" name="maLopHoc" value="${lop.maLopHoc}">
                        <div class="modal-header">						
                            <h4 class="modal-title">Add support</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
							<div class="form-group">
				                <label for="supportPerson">Chọn người hỗ trợ:</label>
				                <select name="supportPerson" id="supportPerson" class="form-control">
				                    <c:forEach var="support" items="${supports}">
				                        <option value="${support.maSupport}">${support.hoTen}</option>
				                    </c:forEach>
				                </select>
				            </div>

                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-success" value="Add">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    <!-- Thêm Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
