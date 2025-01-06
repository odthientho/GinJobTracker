<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="../include/header.jsp"/>
<jsp:include page="../include/header-nav.jsp"/>

<link rel="stylesheet" href="/pub/css/signup.css">
<section id="signup" class="signup-container">
    <div class="signup-box">
        <img id="logo-signup" class="logo-signup" src="/pub/images/gin-logo.png"/>
        <div class="welcome-signup" >Welcome <br> <span>Sign Up for New Account With Gin Job Tracker</span></div>
        <form action="/login/signupSubmit" id="form-signup" class="form-signup" method="post">
            <div class="form-signup-item">
                <input name="username" class="form-signup-input" id="form-signup-username" placeholder=" " value="${formUser.username}">
                <label for="form-signup-username" class="form-signup-label">Name/Username*</label>
            </div>
            <div class="form-signup-item">
                <input name="email" class="form-signup-input" id="form-signup-email" placeholder=" " value="${formUser.email}">
                <label for="form-signup-email" class="form-signup-label">Email Address*</label>
            </div>
            <div class="form-signup-item">
                <input name="password" class="form-signup-input" id="form-signup-password" type="password" placeholder=" " value="${formUser.password}">
                <label  for="form-signup-password" class="form-signup-label">Password*</label>
                <span class="form-signup-password-toggle" id="form-signup-password-toggle-btn">show</span>
            </div>
            <button class="form-signup-submit-btn" type="submit">Continue to sign up</button>
        </form>
        <div class="form-login-signup-switch-btn">Already have an account? <a href="/login/login">Log In</a> </div>
        <div class="form-signup-alert">
            <p id="form-signup-alert">
                <c:if test="${not empty error}">
                    ${error}
                    <script>
                        document.getElementById("form-signup-alert").style.display = "block";
                    </script>
                </c:if>
            </p>
        </div>
    </div>
</section>
<script src="/pub/js/signup.js"></script>

<jsp:include page="../include/header.jsp"/>