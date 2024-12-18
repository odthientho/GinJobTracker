<%--
  Created by IntelliJ IDEA.
  User: odthi
  Date: 12/18/2024
  Time: 12:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link rel="stylesheet" href="/pub/css/reset.css">
    <link rel="stylesheet" href="/pub/css/styles.css">
    <link href="https://fonts.googleapis.com/css2?family=League+Spartan:wght@400;700&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/84b1575519.js" crossorigin="anonymous"></script>
</head>
<body>
<section id="header" class="nav">
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
                <a href="/signout">Sign Out</a>
            </div>
        </nav>
    </div>
</section>