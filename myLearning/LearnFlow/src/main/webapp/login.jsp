<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login | Learn Flow</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        :root {
            --primary-color: #6A0DAD;
            --gray-bg: #f4f4f4;
            --white: #ffffff;
            --text-dark: #333;
        }

        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        body {
            background-color: var(--gray-bg);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .login-container {
            background-color: var(--white);
            padding: 30px 40px;
            border-radius: 12px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
        }

        .login-container h2 {
            color: var(--primary-color);
            text-align: center;
            margin-bottom: 25px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group label {
            color: var(--text-dark);
            display: block;
            margin-bottom: 5px;
        }

        .form-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 8px;
            outline: none;
            font-size: 16px;
        }

        .form-group input:focus {
            border-color: var(--primary-color);
        }

        .submit-btn {
            width: 100%;
            background-color: var(--primary-color);
            color: var(--white);
            padding: 12px;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .submit-btn:hover {
            background-color: #580a9e;
        }

        .register-link {
            margin-top: 15px;
            text-align: center;
        }

        .register-link a {
            color: var(--primary-color);
            text-decoration: none;
        }

        .register-link a:hover {
            text-decoration: underline;
        }

        @media (max-width: 480px) {
            .login-container {
                padding: 20px;
            }

            .submit-btn {
                font-size: 14px;
            }
        }
    </style>
</head>
<body>
<div class="login-container">
    <h2>Welcome Back!</h2>
    <form action="auth" method="post">
        <div class="form-group">
            <label for="username">Username or Email</label>
            <input type="text" id="username" name="loginEmail" required/>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" name="loginPassword" required/>
        </div>
        <button type="submit" class="submit-btn">Login</button>
        <div class="register-link">
            <p>Don’t have an account? <a href="register.jsp">Register here</a></p>
        </div>
    </form>
</div>
</body>
</html>
