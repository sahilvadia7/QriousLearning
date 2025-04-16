<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>404 - Page Not Found</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            background: #f2f2f2;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            color: #333;
        }

        .error-container {
            text-align: center;
            max-width: 500px;
            padding: 40px;
            background: #fff;
            border-radius: 12px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
        }

        .error-container h1 {
            font-size: 100px;
            margin: 0;
            color: #007BFF;
        }

        .error-container h2 {
            font-size: 28px;
            margin-bottom: 20px;
        }

        .error-container p {
            font-size: 16px;
            margin-bottom: 30px;
            color: #666;
        }

        .error-container a {
            padding: 10px 20px;
            text-decoration: none;
            background-color: #007BFF;
            color: white;
            border-radius: 8px;
            font-weight: bold;
            transition: background-color 0.3s ease;
        }

        .error-container a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

    <div class="error-container">
        <h1>405</h1>
        <h2>Oops! Method Not Allowed</h2>
        <p>The method received in the request-line is known by the origin server but not supported by the target resource.</p>
        <a href="home.jsp">Go to Home</a>
    </div>

</body>
</html>
