<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../include/header.jsp"/>
<jsp:include page="../include/header-nav.jsp"/>
<link rel="stylesheet" href="/pub/css/viewjobs.css">

<section id="body" class="body-view-job">
    <div class="body-view-job-info">
        <div class="body-view-job-head-top">
            <div class="body-view-job-info-company">
                <div class="body-view-job-info-company-logo">
                    <img src="${job.companyLogo}"/>
                </div>
                <h4>${job.companyName}</h4>
            </div>
            <div class="body-view-job-info-job">
                <h1><a target="_blank" href="${job.link}">${job.title}<a/></h1>
                <h2>${job.roleType} - ${job.location} (${job.officeType}) - <fmt:formatNumber value="${job.salary}" type="number" groupingUsed="true"/>/yr</h2>
                <div>
                    <a class="body-view-job-info-attachment" id="body-view-job-info-attached-resume" data-resume="${job.resume}"><i class="fa-solid fa-file"></i>  Attached Resume</a>
                    <a class="body-view-job-info-attachment" id="body-view-job-info-attached-cover-letter" data-coverLetter="${job.coverLetter}"><i class="fa-solid fa-file"></i>  Attached Cover Letter</a>
                </div>
            </div>
            <a href="/jobs/myjobs" class="body-view-job-back-button"><i class="fa-solid fa-circle-arrow-left"></i></a>
        </div>
        <hr class="body-view-job-info-job-separator"/>
        <div class="body-view-job-head-bottom">
            <div class="body-view-job-info-job-relationships">
                <h1><i class="fa-solid fa-check"></i> Networking:</h1>
                <c:forEach var="relationship" items="${job.relationships}">
                    <a target="_blank" href="https://${relationship.people.linkedin}" class="body-view-job-info-job-relationships-each">
                        <div class="body-view-job-info-job-relationships-img-container">
                            <img src="${relationship.people.photo}" />
                        </div>
                        <h1>${relationship.people.name}</h1>
                    </a>
                </c:forEach>
            </div>
            <div class="body-view-job-info-job-activities">
                <h1><i class="fa-solid fa-check"></i> Job Activity:</h1>
                <table>
                <c:forEach var="todo" items="${job.todos}" varStatus="num">
                    <tr>
                        <td>${num.index + 1}</td>
                        <td>${todo.title}</td>
                        <td>${todo.details}</td>
                        <td>${todo.dueDate}</td>
                    </tr>
                </c:forEach>
                </table>
            </div>
        </div>
    </div>
    <div class="body-view-job-info body-view-job-content">
        <h1>About the job</h1>
        ${job.description}
    </div>
</section>

<script src="/pub/js/myjobs.js"></script>
<jsp:include page="../include/footer.jsp"/>