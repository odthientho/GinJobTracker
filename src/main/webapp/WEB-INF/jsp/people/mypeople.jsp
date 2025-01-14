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
            <c:if test="${empty people}">
                Not Found
            </c:if>
            <c:forEach var="person" items="${people}">
                <li class="body-content-item" data-id="${person.id}">
                    <div class="body-content-item-logo">
                        <img src="${person.photo}"/>
                    </div>
                    <div class="body-content-item-main">
                        <h2>${person.name}</h2>
                        <h3>${person.email}</h3>
                        <h4>${person.phone} (<a target="_blank" href="https://${person.linkedin}">${person.linkedin}</a>)</h4>
                    </div>
                    <div class="body-content-item-buttons">
                        <button data-id="${person.id}" class="body-content-item-button-edit"><i class="fa-solid fa-pencil"></i></button>
                        <button data-id="${person.id}" class="body-content-item-button-delete"><i class="fa-solid fa-x"></i></button>
                        <button data-id="${person.id}" class="body-content-item-button-switch"><i class="fa-solid fa-ellipsis-vertical"></i></button>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</section>

<script src="/pub/js/mypeople.js"></script>
<jsp:include page="../include/footer.jsp"/>