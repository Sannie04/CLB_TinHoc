<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CÂU LẠC BỘ TIN HỌC - Đăng nhập</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/login.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #F5F5F5;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .login-container {
            display: flex;
            justify-content: center;
            align-items: center;
            width: 100%;
            max-width: 1200px;
            height: 80%;
        }

        .logo-container {
            flex: 1;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .logo {
            width: 500px; /* Điều chỉnh kích thước logo */
        }

        .form-container {
            flex: 1;
            background-color: #fff;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            text-align: center;
            max-width: 500px;
            width: 100%;
        }

        h1 {
            font-size: 24px;
            color: #333;
            margin-bottom: 20px;
        }

        .form-group {
            margin-bottom: 15px;
            text-align: left;
        }

        label {
            display: block;
            font-size: 14px;
            color: #333;
            margin-bottom: 5px;
        }

        input {
            width: 100%;
            padding: 10px;
            font-size: 14px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input::placeholder {
            color: #aaa;
        }

        .login-button {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            border: none;
            border-radius: 5px;
            color: white;
            font-size: 16px;
            cursor: pointer;
        }

        .login-button:hover {
            background-color: #45a049;
        }

        p {
            margin-top: 10px;
            font-size: 14px;
            color: #000;
        }

        a {
            color: #4CAF50;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        /* Responsive Design */
        @media (max-width: 768px) {
            .login-container {
                flex-direction: column;
                height: auto;
            }

            .logo-container {
                margin-bottom: 20px;
            }

            .form-container {
                padding: 20px;
            }
        }
    </style>
</head>
<body>
    <div class="login-container">
        <!-- Logo phần bên trái -->
        <div class="logo-container">
            <img src="${pageContext.request.contextPath}/images/background.png" alt="Logo" class="logo">
        </div>

        <!-- Form Đăng Nhập phần bên phải -->
        <div class="form-container">
            <h1>CÂU LẠC BỘ TIN HỌC</h1>
            <form action="${pageContext.request.contextPath}/loginServ" method="post">
                <div class="form-group">
                <c:if test="${not empty mess}">
				    <div style="color:red;">${mess}</div>
				</c:if>
                
                    <label >Tên tài khoản</label>
                    <input type="text" id="studentId" name="studentId"  placeholder="Nhập tài khoản" required>
                </div>

                <div class="form-group">
                    <label>Password</label>
                    <input type="password" id="password" name="password" placeholder="Nhập mật khẩu" required>
                </div>

                <button type="submit" class="login-button">Đăng Nhập</button>
                
                <p>
                    Chưa có tài khoản? <a href="${pageContext.request.contextPath}/register.jsp">Đăng ký</a>
                </p>
            </form>
        </div>
    </div>
</body>
</html>