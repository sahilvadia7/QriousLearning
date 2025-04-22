<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register | Learn Flow</title>
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
        font-size: 14px;
    }

    body {
        background-color: var(--gray-bg);
        display: flex;
        justify-content: center;
        /* Removed align-items: center and height */
        padding: 60px 20px; /* Adds top and bottom space */
    }

    .register-container {
        background-color: var(--white);
        padding: 30px 40px;
        border-radius: 12px;
        box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
        width: 100%;
        max-width: 400px;
        margin: auto; /* centers horizontally */
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

    .form-group input,
    .form-group textarea {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 8px;
        outline: none;
    }

    .form-group input:focus,
    .form-group textarea:focus {
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
    
    .form-row {
    display: flex;
    gap: 20px;
}

.form-group.half {
    flex: 1;
}

.error {
    color: red;
    font-size: 12px;
    display: block;
    margin-top: 5px;
}
    
</style>

</head>
<body>
<%
    String firstname = (String) request.getAttribute("firstname");
    String lastname = (String) request.getAttribute("lastname");
    String username = (String) request.getAttribute("username");
    String email = (String) request.getAttribute("email");
    String password = (String) request.getAttribute("password");
    String bio = (String) request.getAttribute("bio");

    String firstnameError = (String) request.getAttribute("firstnameError");
    String lastnameError = (String) request.getAttribute("lastnameError");
    String usernameError = (String) request.getAttribute("usernameError");
    String emailError = (String) request.getAttribute("emailError");
    String passwordError = (String) request.getAttribute("passwordError");
%>

<div class="register-container">
    <h2>Create Your Account</h2>
   <form action="auth" method="post" onsubmit="return validateForm()">
    <div class="form-row">
        <div class="form-group half">
            <label for="firstname">First Name</label>
            <input type="text" id="firstname" name="firstname" value="<%= firstname != null ? firstname : "" %>" required />
            <% if (firstnameError != null) { %>
                <span class="error"><%= firstnameError %></span>
            <% } %>
        </div>
        <div class="form-group half">
            <label for="lastname">Last Name</label>
            <input type="text" id="lastname" name="lastname" value="<%= lastname != null ? lastname : "" %>" required />
            <% if (lastnameError != null) { %>
                <span class="error"><%= lastnameError %></span>
            <% } %>
        </div>
    </div>

    <div class="form-group">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" value="<%= username != null ? username : "" %>" required />
        <% if (usernameError != null) { %>
            <span class="error"><%= usernameError %></span>
        <% } %>
    </div>

    <div class="form-group">
        <label for="email">Email Address</label>
        <input type="email" id="email" name="email" value="<%= email != null ? email : "" %>" required />
        <% if (emailError != null) { %>
            <span class="error"><%= emailError %></span>
        <% } %>
    </div>

    <div class="form-row">
        <div class="form-group half">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" value="<%= password != null ? password : "" %>" required />
            <% if (passwordError != null) { %>
                <span class="error"><%= passwordError %></span>
            <% } %>
        </div>
        <div class="form-group half">
            <label for="confirmPassword">Confirm Password</label>
            <input type="password" id="confirmPassword" name="confirmPassword" required />
        </div>
    </div>

    <div class="form-group">
        <label for="bio">Bio</label>
        <textarea id="bio" name="bio" rows="4"><%= bio != null ? bio : "" %></textarea>
    </div>

    <button type="submit" class="submit-btn">Register</button>

    <div class="login-link">
        <p>Already have an account? <a href="login.jsp">Login here</a></p>
        <p>Go Without Register? <a href="explore.jsp">Explore Now</a></p>
    </div>
</form>



</div>
</body>

<script>
    function validateForm() {
        const password = document.getElementById("password").value;
        const confirm = document.getElementById("confirmPassword").value;

        if (password !== confirm) {
            alert("Passwords do not match!");
            return false;
        }
        return true;
    }
</script>

</html>
