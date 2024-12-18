<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Support</title>
</head>
<body>
    <h2>Add Support</h2>
   <form action="${pageContext.request.contextPath}/addSupport" method="post" enctype="multipart/form-data">
    <label for="maSupport">Mã Support:</label>
    <input type="text" name="maSupport" required />

    <label for="hoTen">Họ Tên:</label>
    <input type="text" name="hoTen" required />

    <label for="lopSinhHoat">Lớp Sinh Hoạt:</label>
    <input type="text" name="lopSinhHoat" required />

    <label for="soDienThoai">Số Điện Thoại:</label>
    <input type="text" name="soDienThoai" />

    <label for="email">Email:</label>
    <input type="email" name="email" />

    <label for="hinhAnh">Hình Ảnh:</label>
    <input type="file" name="hinhAnh" />

    <input type="submit" value="Submit" />
</form>


</body>
</html>
