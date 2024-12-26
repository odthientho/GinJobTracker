<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="../include/header.jsp"/>
<jsp:include page="../include/header-nav.jsp"/>

<link rel="stylesheet" href="/pub/css/signup.css">
<section id="signup" class="signup-container">
    <div class="signup-box">
        <img id="logo-signup" class="logo-signup" data-href="/index" src="/pub/images/gin-logo.png"/>
        <div class="welcome-signup" >Welcome <br> <span>Sign Up for New Account With Gin Job Tracker</span></div>
        <form action="/login/signupSubmit" id="form-signup" class="form-signup" method="post">
            <div class="form-signup-item">
                <input name="username" class="form-signup-input" id="form-signup-username" placeholder=" ">
                <label for="form-signup-username" class="form-signup-label">Email Address*</label>
            </div>
            <span id="form-signup-username-alert" class="form-signup-alert"></span>
            <div class="form-signup-item">
                <input name="password" class="form-signup-input" id="form-signup-password" type="password" placeholder=" ">
                <label  for="form-signup-password" class="form-signup-label">Password*</label>
                <span class="form-signup-password-toggle" id="form-signup-password-toggle-btn">show</span>
            </div>
            <div class="form-signup-item">
                <input name="password" class="form-signup-input" id="form-signup-confirmed-password" type="password" placeholder=" ">
                <label  for="form-signup-confirmed-password" class="form-signup-label">Confirmed Password*</label>
                <span class="form-signup-password-toggle" id="form-signup-confirmed-password-toggle-btn">show</span>
            </div>
            <span id="form-signup-password-alert" class="form-signup-alert"></span>
            <button class="form-signup-submit-btn" type="submit">Continue to login</button>
        </form>
        <div class="form-login-signup-switch-btn">Don't have an account? <a href="/login/login">Log In</a> </div>
    </div>
</section>
<script src="/pub/js/signup.js"></script>

<jsp:include page="../include/header.jsp"/>