<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="../include/header.jsp"/>
<jsp:include page="../include/header-nav.jsp"/>

<link rel="stylesheet" href="/pub/css/login.css">
<section id="login" class="login-container">
  <div class="login-box">
    <img id="logo-login" class="logo-login" src="/pub/images/gin-logo.png"/>
    <div class="welcome-login" >Welcome <br> <span>Login in to continue Job Tracker</span></div>
    <form action="/login/loginSubmit" id="form-login" class="form-login" method="post">
      <div class="form-login-item">
        <input name="username" class="form-login-input" id="form-login-username" placeholder=" ">
        <label for="form-login-username" class="form-login-label">Email Address*</label>
      </div>
      <span id="form-login-username-alert" class="form-login-alert"></span>
      <div class="form-login-item">
        <input name="password" class="form-login-input" id="form-login-password" type="password" placeholder=" ">
        <label  for="form-login-password" class="form-login-label">Password*</label>
        <span class="form-login-password-toggle" id="form-login-password-toggle-btn">show</span>
      </div>
      <span id="form-login-password-alert" class="form-login-alert"></span>
      <button class="form-login-submit-btn" type="submit">Continue to login</button>
    </form>
    <div class="form-login-signup-switch-btn">Don't have an account? <a href="/login/signup">Sign Up</a> </div>
    <div class="form-login-separator">
      <span class="form-login-separator-span"></span>
      <span>OR</span>
      <span class="form-login-separator-span"></span>
    </div>
    <button class="form-login-google-btn">
      <span class="fa-brands fa-google"></span>
      Continue with Google
    </button>
    <button class="form-login-linkedin-btn">
      <span class="fa-brands fa-linkedin"></span>
      Continue with LinkedIn
    </button>
  </div>
</section>
<script src="/pub/js/login.js"></script>

<jsp:include page="../include/header.jsp"/>