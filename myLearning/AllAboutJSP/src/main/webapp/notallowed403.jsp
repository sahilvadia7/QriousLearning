<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>403 - Access Denied</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            background: #ffe5e5;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            color: #b30000;
        }

        .error-container {
            text-align: center;
            max-width: 500px;
            padding: 40px;
            background: #fff0f0;
            border-radius: 12px;
            box-shadow: 0 4px 20px rgba(179, 0, 0, 0.2);
        }

        .error-container h1 {
            font-size: 100px;
            margin: 0;
            color: #ff1a1a;
        }

        .error-container h2 {
            font-size: 28px;
            margin-bottom: 20px;
        }

        .error-container p {
            font-size: 16px;
            margin-bottom: 30px;
            color: #800000;
        }

        .error-container a {
            padding: 10px 20px;
            text-decoration: none;
            background-color: #ff1a1a;
            color: white;
            border-radius: 8px;
            font-weight: bold;
            transition: background-color 0.3s ease;
        }

        .error-container a:hover {
            background-color: #b30000;
        }
    </style>
</head>
<body>

    <div class="error-container">
        <h1>403</h1>
        <h2>Access Denied</h2>
        <p>You are not allowed to access this page.</p>
        <a href="home.jsp">Back to Home</a>
    </div>

</body>
</html>
