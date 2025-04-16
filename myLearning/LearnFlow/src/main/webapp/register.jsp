<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register | Learn Flow</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        :root {
            --primary-color: #6A0DAD;  /* Purple */
            --gray-bg: #f4f4f4;
            --white: #ffffff;
            --text-dark: #333;
        }

        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            font-size: 14px;
        }

        body {
            background-color: var(--gray-bg);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .register-container {
            background-color: var(--white);
            padding: 30px 40px;
            border-radius: 12px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
        }

        .register-container h2 {
            color: var(--primary-color);
            text-align: center;
            margin-bottom: 25px;
            font-size: 16px;
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

        .login-link {
            margin-top: 15px;
            text-align: center;
        }

        .login-link a {
            color: var(--primary-color);
            text-decoration: none;
        }

        .login-link a:hover {
            text-decoration: underline;
        }

        @media (max-width: 480px) {
            .register-container {
                padding: 20px;
            }

            .submit-btn {
                font-size: 14px;
            }
        }
    </style>
</head>
<body>
<div class="register-container">
    <h2>Register to Learn Flow</h2>
    <form action="auth" method="post">
        <div class="form-group">
            <label for="fullName">First Name</label>
            <input type="text" id="firstname" name="firstname" required/>
        </div>
         <div class="form-group">
            <label for="lastname">Last Name</label>
            <input type="text" id="lastname" name="lastname" required/>
        </div>
          <div class="form-group">
            <label for="username">Username</label>
            <input type="text" id="username" name="username" required/>
        </div>
        <div class="form-group">
            <label for="email">Email Address</label>
            <input type="email" id="email" name="email" required/>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" required/>
        </div>
        
        <div class="form-group">
            <label for="bio">Bio</label>
            <textarea  id="bio" name="bio" rows="4" cols="53"> </textarea>
        </div>
        <button type="submit" class="submit-btn">Register</button>
        <div class="login-link">
            <p>Already have an account? <a href="login.jsp">Login here</a></p>
        </div>
    </form>
</div>
</body>
</html>
