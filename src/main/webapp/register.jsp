<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>CÂU LẠC BỘ TIN HỌC - Đăng ký</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f0f0f0;
        }
        .container {
            display: flex;
            max-width: 800px;
            width: 100%;
            background-color: white;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .logo-section, .form-section {
            flex: 1;
            padding: 20px;
        }
        .logo-section {
            display: flex;
            justify-content: center;
            align-items: center;
          
            color: white;
            position: relative;
        }
        .logo-section h1 {
            position: absolute;
            top: 70px; /* Adjust the top position as needed */
            left: 36%;
            transform: translateX(-50%);
            margin: 0;
            font-size: 1.7em;
            text-align: center;
        }
        .form-section {
            padding: 40px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-control {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
        }
        .btn {
            width: 100%;
            padding: 10px;
            background-color: #3D9B1C;
            color: white;
            border: none;
            cursor: pointer;
        }
        .logo-section img {
            width: 420px; /* Adjust the width as needed */
        }
        .text-center {
            text-align:left;
            color: #000000;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="logo-section">
            <div class="text-center">
               <img src="${pageContext.request.contextPath}/images/background.png" alt="Background">
                <h1>CÂU LẠC BỘ TIN HỌC</h1>
            </div>
        </div>
        <div class="form-section">
            <form action="${pageContext.request.contextPath}/signupServ" method="post">
            	
                <div class="form-group">
	                <c:if test="${not empty mess1}">
					    <div style="color:red;">${mess1}</div>
					</c:if>
                    <label for="studentId">Mã Sinh viên</label>
                    <input type="text" class="form-control" id="studentId" name="studentId" required>
                </div>
                
                <div class="form-group">
                    <label for="name">Tên sinh viên</label>
                    <input type="text" class="form-control" id="name" name="name" required>
                </div>
                
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" id="email" name="email" required>
                </div>
                
                <div class="form-group">
                    <label for="phone">Số Điện Thoại</label>
                    <input type="tel" class="form-control" id="phone" name="phone" required>
                </div>
                
                <div class="form-group">
                    <label for="dateOfBirth">Ngày Sinh</label>
                    <input type="date" class="form-control" id="dateOfBirth" name="dateOfBirth" required>
                </div>
                
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password" required>
                </div>
                
                <button type="submit" class="btn">Đăng ký</button>
                
                <p class="text-center">
                    Đã có tài khoản? <a href="${pageContext.request.contextPath}/login.jsp">Đăng nhập</a>
                </p>
            </form>
        </div>
    </div>
</body>
</html>