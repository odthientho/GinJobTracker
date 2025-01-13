<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="../include/header.jsp"/>
<jsp:include page="../include/header-nav.jsp"/>
<link rel="stylesheet" href="/pub/css/error.css">

<section class="error-body-content">
    <div class="error-body-content-container">
        <h1>Oops! Internal Server Error.</h1>
        <h2>Sorry, something went wrong... we are fixing... !</h2>
        <img src="/pub/images/500.png">
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>