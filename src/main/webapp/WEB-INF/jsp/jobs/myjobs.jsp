<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="../include/header.jsp"/>
<jsp:include page="../include/header-nav.jsp"/>
<link rel="stylesheet" href="/pub/css/body-content.css">

<!-- data (jobs, people, todos) -->
<section id="body" class="body-content">
    <div class="body-content-list">
        <h1 class="body-content-title">My Jobs</h1>
        <ul class="body-content-filter-list">
            <li class="body-content-filter">
                <button class="body-content-filter-button body-content-filter-button-active"><i class="fa-solid fa-globe"></i></button>
            </li>
            <li class="body-content-filter">
                <button class="body-content-filter-button" >Applied</button>
            </li>
            <li class="body-content-filter">
                <button class="body-content-filter-button">Interview</button>
            </li>
            <li class="body-content-filter">
                <button class="body-content-filter-button">Offered</button>
            </li>
            <li class="body-content-filter">
                <button class="body-content-filter-button">Rejected</button>
            </li>
            <li id="body-content-new-button" class="body-content-filter">
                <button class="body-content-filter-button"><i class="fa-solid fa-plus"></i></button>
            </li>
        </ul>
        <hr class="body-content-separator"/>
        <ul class="body-content-item-list">
            <li class="body-content-item">
                <div class="body-content-item-logo">
                    <img src="/pub/images/gin-logo.png"/>
                </div>
                <div class="body-content-item-main">
                    <h2>Software Engineer (Frontend)</h2>
                    <h3>Company Name</h3>
                    <h3>Location, USA (<span>Remote</span>)</h3>
                </div>
                <div class="body-content-item-buttons">
                    <button><i class="fa-solid fa-pencil"></i></button>
                    <button><i class="fa-solid fa-x"></i></button>
                    <button><i class="fa-solid fa-ellipsis-vertical"></i></button>
                </div>
            </li>

            <li class="body-content-item">
                <div class="body-content-item-logo">
                    <img src="/pub/images/gin-logo.png"/>
                </div>
                <div class="body-content-item-main">
                    <h2>Software Engineer (Frontend)</h2>
                    <h3>Company Name</h3>
                    <h3>Location, USA (<span>Remote</span>)</h3>
                </div>
                <div class="body-content-item-buttons">
                    <button><i class="fa-solid fa-pencil"></i></button>
                    <button><i class="fa-solid fa-x"></i></button>
                    <button><i class="fa-solid fa-ellipsis-vertical"></i></button>
                </div>
            </li>
        </ul>
<%--        <c:forEach var="job" items="${data}">--%>
<%--        this is to make the list of data ready--%>
<%--        </c:forEach>--%>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>