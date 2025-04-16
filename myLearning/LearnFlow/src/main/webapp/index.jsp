<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Learn Flow | Home</title>
    <style>
        :root {
            --purple: #6A0DAD;
            --light-purple: #f4e9ff;
            --gray: #f5f5f5;
            --white: #ffffff;
            --text: #333333;
        }

        body {
            margin: 0;
            font-family: 'Segoe UI', sans-serif;
            background-color: var(--gray);
        }

        .header {
            background-color: var(--white);
            padding: 20px 40px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.05);
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .logo {
            font-size: 28px;
            font-weight: bold;
            color: var(--purple);
        }

        .hero {
            text-align: center;
            padding: 60px 20px 30px 20px;
        }

        .hero h1 {
            font-size: 40px;
            color: var(--purple);
            margin-bottom: 10px;
        }

        .hero p {
            font-size: 18px;
            color: var(--text);
        }

        .card-container {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
            gap: 25px;
            padding: 40px;
        }

        .feature-card {
            background-color: var(--white);
            border: 2px solid var(--purple);
            border-radius: 15px;
            padding: 30px 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.03);
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            transition: transform 0.3s ease;
        }

        .feature-card:hover {
            transform: translateY(-5px);
        }

        .card-title {
            font-size: 28px;
            color: var(--purple);
            font-weight: bold;
            text-align: center;
            margin-bottom: 15px;
        }

        .card-desc {
            font-size: 16px;
            color: #555;
            text-align: center;
            margin-bottom: 20px;
        }

        .card-btn {
            align-self: center;
            background-color: var(--purple);
            color: white;
            border: none;
            padding: 10px 25px;
            font-size: 15px;
            border-radius: 25px;
            cursor: pointer;
            transition: background 0.3s ease;
            text-decoration: none;
        }

        .card-btn:hover {
            background-color: #540f94;
        }

        @media (max-width: 600px) {
            .hero h1 {
                font-size: 30px;
            }

            .card-title {
                font-size: 22px;
            }
        }
    </style>
</head>
<body>

<div class="header">
    <div class="logo">Learn Flow</div>
</div>

<div class="hero">
    <h1>Empower Your Learning Journey</h1>
    <p>Discover courses, track progress, and enhance your knowledge – all in one place.</p>
</div>

<div class="card-container">
    <div class="feature-card">
        <div class="card-title">Upskill</div>
        <div class="card-desc">Advance your knowledge with structured courses designed by top instructors.</div>
        <a href="explore.jsp" class="card-btn">Start Exploring</a>
    </div>

    <div class="feature-card">
        <div class="card-title">Master</div>
        <div class="card-desc">Master new skills with practical exercises and real-world examples.</div>
        <a href="explore.jsp" class="card-btn">View All Courses</a>
    </div>

    <div class="feature-card">
        <div class="card-title">Grow</div>
        <div class="card-desc">Grow your career and stand out with industry-focused knowledge.</div>
        <a href="register.jsp" class="card-btn">Join Now</a>
    </div>

    <div class="feature-card">
        <div class="card-title">Learn</div>
        <div class="card-desc">Flexible learning options that fit your schedule and goals.</div>
        <a href="login.jsp" class="card-btn">Log In & Learn</a>
    </div>

    <div class="feature-card">
        <div class="card-title">Achieve</div>
        <div class="card-desc">Track your progress and earn recognition as you complete courses.</div>
        <a href="dashboard.jsp" class="card-btn">Go to Dashboard</a>
    </div>
</div>

</body>
</html>
