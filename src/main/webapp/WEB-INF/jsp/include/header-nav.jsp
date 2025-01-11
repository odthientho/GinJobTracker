<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<link rel="stylesheet" href="/pub/css/header-nav.css">
<section id="header-nav" class="nav">
    <div class="header-nav">
        <div class="logo-nav">
            <img class="img-fit-container" src="/pub/images/gin-logo.png"/>
        </div>
        <div class="search-nav">
            <input type="text" placeholder="Search"/>
            <div>
                <i class="fa-solid fa-magnifying-glass"></i>
            </div>
        </div>
        <nav class="global-nav">
            <button class="global-nav-item home-nav <c:if test="${title eq 'Home - Dashboard'}">global-nav-item-active</c:if>" data-href="/home">
                <i class="global-nav-icon fa-solid fa-house"></i>
                <span>Home</span>
            </button>

            <sec:authorize access="isAuthenticated()">
            <button class="global-nav-item <c:if test="${title eq 'My Jobs'}">global-nav-item-active</c:if> jobs-nav" data-href="/jobs/myjobs">
                <i class="global-nav-icon fa-solid fa-briefcase"></i>
                <span>My Jobs</span>
            </button>
            <button class="global-nav-item <c:if test="${title eq 'My People'}">global-nav-item-active</c:if> people-nav" data-href="/people/mypeople">
                <i class="global-nav-icon fa-solid fa-user-group"></i>
                <span>My People</span>
            </button>
            <button class="global-nav-item <c:if test="${title eq 'My Todos'}">global-nav-item-active</c:if> task-nav" data-href="/todos/mytodos">
                <i class="global-nav-icon fa-solid fa-list-check"></i>
                <span>My To-do</span>
            </button>
            </sec:authorize>

            <button class="global-nav-item me-nav">
                <img class="global-nav-icon" src="<c:if test="${empty userPhoto}">/pub/images/user_photo/default_photo.png</c:if><c:if test="${not empty userPhoto}">${userPhoto}</c:if>"/>
                <span>Me <i class="fa-solid fa-caret-down"></i></span>
            </button>
            <div id="quote-me-nav">
                <sec:authorize access="!isAuthenticated()">
                    <a href="/login/login"><i class="fa-solid fa-right-to-bracket"></i>Log In</a>
                    <a href="/login/signup"><i class="fa-solid fa-user-plus"></i>Sign Up</a>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <a id="uploadProfilePictureButton"><i class="fa-regular fa-images"></i>Profile Picture</a>
                    <input type="file" id="uploadProfilePictureInput" accept="image/*" style="display: none">
                    <a href="/login/logout"><i class="fa-solid fa-right-from-bracket"></i>Log Out</a>
                </sec:authorize>
            </div>
        </nav>
    </div>
</section>
<script src="/pub/js/header-nav.js"></script>