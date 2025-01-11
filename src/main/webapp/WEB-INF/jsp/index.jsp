<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="include/header.jsp"/>
<jsp:include page="include/header-nav.jsp"/>
<link rel="stylesheet" href="/pub/css/home.css">

<section class="home-body-content">
    <div class="home-body-content-first">
        <div class="information-left-column">
            <h2>Gin Job Tracker</h2>
            <h1>Track & Organize Your Job Search</h1>
            <h3>The leading tool for organizing, tracking and managing of your job applications in one place.</h3>
            <ul class="information-left-column-bullet-points">
                <li class="information-left-column-bullet-points-item">
                    <div class="information-left-column-bullet-points-image-container">
                        <i class="fa-solid fa-bookmark"></i>
                    </div>
                    <div class="information-left-column-bullet-points-info-container">
                        <strong>Save jobs throughout your search</strong>
                        <p>A fast, convenient way to bookmark jobs</p>
                    </div>
                </li>
                <li class="information-left-column-bullet-points-item">
                    <div class="information-left-column-bullet-points-image-container">
                        <i class="fa-solid fa-chart-column"></i>
                    </div>
                    <div class="information-left-column-bullet-points-info-container">
                        <strong>Track & organize job opportunities by stage</strong>
                        <p>Keep a high level view of your job search pipeline</p>
                    </div>
                </li>
                <li class="information-left-column-bullet-points-item">
                    <div class="information-left-column-bullet-points-image-container">
                        <i class="fa-solid fa-lightbulb"></i>
                    </div>
                    <div class="information-left-column-bullet-points-info-container">
                        <strong>Get job description insights</strong>
                        <p>View rich keyword & skill insights for every job</p>
                    </div>
                </li>
            </ul>
            <a class="information-left-column-signup-button" href="/login/signup">Sign Up - It is 100% Free!</a>
        </div>
        <div class="picture-right-column">
            <img src="/pub/images/homepage.png"/>
        </div>
    </div>
    <div class="home-body-content-second">
        <h1 class="home-body-content-second-title">How to use Gin Job Tracker</h1>
        <ul class="home-body-content-support-steps">
            <li class="home-body-content-support-each-step">
                <h2>1</h2>
                <div class="home-body-content-support-img-container">
                    <img src="/pub/images/myjobs.png"/>
                </div>
                <h3>Tracking Jobs</h3>
                <p>With Gin Tracker App, you can keep track all of your jobs application and their progress in one place.</p>
            </li>
            <li class="home-body-content-support-each-step">
                <h2>2</h2>
                <div class="home-body-content-support-img-container">
                    <img src="/pub/images/mypeople.png"/>
                </div>
                <h3>Connecting People</h3>
                <p>Those who help us to get a job in this market should be always remembered and connected.</p>
            </li>
            <li class="home-body-content-support-each-step">
                <h2>3</h2>
                <div class="home-body-content-support-img-container">
                    <img src="/pub/images/mytodos.png"/>
                </div>
                <h3>Prioritize Works</h3>
                <p>A simple to-do list to help you to stay focused on applying and reviewing applications.</p>
            </li>
            <li class="home-body-content-support-each-step">
                <h2>4</h2>
                <div class="home-body-content-support-img-container">
                    <img src="/pub/images/login.png"/>
                </div>
                <h3>Always Free!</h3>
                <p>Always commit to provide the best but free tool for those who are in need of jobs.</p>
            </li>
        </ul>
        <a class="information-left-column-signup-button" href="/login/signup">Sign Up - It is 100% Free!</a>
    </div>
</section>

<jsp:include page="./include/footer.jsp"/>