<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="../include/header.jsp"/>
<jsp:include page="../include/header-nav.jsp"/>
<link rel="stylesheet" href="/pub/css/body-content.css">

<section id="body" class="body-content">
    <div class="body-content-list">
        <h1 class="body-content-title">${title}</h1>
        <ul class="body-content-filter-list">
            <li class="body-content-filter">
                <button data-url="ALL" class="body-content-filter-button
                    <c:if test="${empty param.query}">body-content-filter-button-active</c:if>">
                    <i class="fa-solid fa-globe"></i>
                </button>
            </li>
            <c:forEach var="option" items="${options}">
                <li class="body-content-filter">
                    <button class="body-content-filter-button <c:if test="${param.query eq option}">body-content-filter-button-active</c:if>" data-url="${option}">${option}</button>
                </li>
            </c:forEach>
            <li id="body-content-new-button" class="body-content-filter">
                <button class="body-content-filter-button" data-url="NEW"><i class="fa-solid fa-plus"></i></button>
            </li>
        </ul>
        <hr class="body-content-separator"/>
        <ul class="body-content-item-list">
            <c:if test="${empty jobs}">
                Not Found
            </c:if>
            <c:forEach var="job" items="${jobs}">
                <li class="body-content-item" >
                    <div class="body-content-item-logo">
                        <img src="${job.companyLogo}"/>
                    </div>
                    <div data-id="${job.id}" class="body-content-item-main">
                        <h2>${job.title}</h2>
                        <h3>${job.companyName}</h3>
                        <h4>${job.location} (<span>${job.officeType}</span>)</h4>
                    </div>
                    <div class="body-content-item-buttons">
                        <button data-id="${job.id}" class="body-content-item-button-edit"><i class="fa-solid fa-pencil"></i></button>
                        <button data-id="${job.id}" class="body-content-item-button-delete"><i class="fa-solid fa-x"></i></button>
                        <button data-id="${job.id}" class="body-content-item-button-switch"><i class="fa-solid fa-ellipsis-vertical"></i></button>
                        <div class="body-content-item-options">
                            <a href="/jobs/edit/${job.id}?stage=${options[0]}">${options[0]}</a>
                            <a href="/jobs/edit/${job.id}?stage=${options[1]}">${options[1]}</a>
                            <a href="/jobs/edit/${job.id}?stage=${options[2]}">${options[2]}</a>
                            <a href="/jobs/edit/${job.id}?stage=${options[3]}">${options[3]}</a>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</section>

<script src="/pub/js/myjobs.js"></script>
<jsp:include page="../include/footer.jsp"/>