<%--
  Created by IntelliJ IDEA.
  User: odthi
  Date: 12/18/2024
  Time: 1:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Login</title>
  <link rel="stylesheet" href="/pub/css/reset.css">
  <link rel="stylesheet" href="/pub/css/login.css">
  <link href="https://fonts.googleapis.com/css2?family=League+Spartan:wght@400;700&display=swap" rel="stylesheet">
  <script src="https://kit.fontawesome.com/84b1575519.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
  <div class="login-box">
    <img id="company-logo" class="company-logo" data-href="/" src="/pub/images/gin-logo.png"/>
    <div class="welcome" >Welcome <br> <span>Login in to continue Job Tracker</span></div>
    <form action="/login/submit" id="login-form" class="input-form" method="post">
      <div class="form-group">
        <input name="username" class="input" id="email-input" placeholder=" ">
        <label id="email-label" class="username">Email Address*</label>
      </div>
      <span id="email-login-alert" class="login-alert"></span>
      <div class="form-group">
        <input name="password" class="input" id="password-input" type="password" placeholder=" ">
        <label  id="password-label" class="password">Password*</label>
        <span class="password-eye" id="togglePassword">show</span>
      </div>
      <span id="password-login-alert" class="login-alert"></span>
      <button class="submitBtn" type="submit">Continue to login</button>
    </form>
    <div class="signupBtn">Don't have an account? <a href="/login/signup">Sign Up</a> </div>
    <div class="separator">
      <span class="spanBefore"></span>
      <span>OR</span>
      <span class="spanAfter"></span>
    </div>
    <button class="googleBtn" type="submit">
      <span class="fa-brands fa-google"></span>
      Continue with Google
    </button>
    <button class="linkedinBtn" type="submit">
      <span class="fa-brands fa-linkedin"></span>
      Continue with LinkedIn
    </button>
  </div>
</div>
<script src="/pub/js/login.js"></script>
</body>
</html>