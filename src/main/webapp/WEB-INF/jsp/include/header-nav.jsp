<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

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
            <button class="global-nav-item home-nav" data-href="/home">
                <i class="global-nav-icon fa-solid fa-house"></i>
                <span>Home</span>
            </button>
            <button class="global-nav-item global-nav-item-active jobs-nav" data-href="/jobs">
                <i class="global-nav-icon fa-solid fa-briefcase"></i>
                <span>My Jobs</span>
            </button>
            <button class="global-nav-item people-nav" data-href="/people">
                <i class="global-nav-icon fa-solid fa-user-group"></i>
                <span>My People</span>
            </button>
            <button class="global-nav-item task-nav" data-href="/tasks">
                <i class="global-nav-icon fa-solid fa-list-check"></i>
                <span>My To-do</span>
            </button>
            <button class="global-nav-item me-nav">
                <img class="global-nav-icon" src="/pub/images/gin-logo.png"/>
                <span>Me <i class="fa-solid fa-caret-down"></i></span>
            </button>
            <div id="quote-me-nav">
                <a href="/login/logout">Sign Out</a>
                <a href="/login/login">Login</a>
            </div>
        </nav>
    </div>
</section>
<script src="/pub/js/header-nav.js"></script>