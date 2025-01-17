<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../include/header.jsp"/>
<jsp:include page="../include/header-nav.jsp"/>
<link href="https://cdn.jsdelivr.net/npm/quill@2.0.3/dist/quill.snow.css" rel="stylesheet" />
<link rel="stylesheet" href="/pub/css/createjobs.css">

<section id="body" class="body-create-job">
    <div class="body-create-job-content">
        <h1 class="body-create-job-content-title">Job Details:</h1>
        <h2>* indicates required</h2>
        <form action="/jobs/createSubmit" class="body-create-job-content-form" method="post">
            <div class="body-create-job-content-form-items">
                <div class="body-create-job-content-item">
                    <label for="body-create-job-content-form-title" class="body-create-job-content-form-label">Job title</label>
                    <input name="title" id="body-create-job-content-form-title" class="body-create-job-content-form-input" placeholder="Add Title" type="text"/>
                </div>
                <div class="body-create-job-content-item">
                    <label for="body-create-job-content-form-copmpany" class="body-create-job-content-form-label">Company</label>
                    <input name="companyName" id="body-create-job-content-form-copmpany" class="body-create-job-content-form-input" placeholder="Add Company Name" type="text"/>
                </div>
                <div class="body-create-job-content-item">
                    <label for="body-create-job-content-form-location" class="body-create-job-content-form-label">Job location</label>
                    <input name="companyName" id="body-create-job-content-form-location" class="body-create-job-content-form-input" placeholder="Add Location" type="text"/>
                </div>
                <div class="body-create-job-content-item">
                    <label for="body-create-job-content-form-role" class="body-create-job-content-form-label">Role type</label>
                    <input name="companyName" id="body-create-job-content-form-role" class="body-create-job-content-form-input" placeholder="Add Role Type" type="text"/>
                </div>
                <div class="body-create-job-content-item">
                    <label for="body-create-job-content-form-office" class="body-create-job-content-form-label">Office Type</label>
                    <input name="companyName" id="body-create-job-content-form-office" class="body-create-job-content-form-input" placeholder="Add Office Type" type="text"/>
                </div>
                <div class="body-create-job-content-item">
                    <label for="body-create-job-content-form-salary" class="body-create-job-content-form-label">Salary: ($ per year)</label>
                    <input name="companyName" id="body-create-job-content-form-salary" class="body-create-job-content-form-input" placeholder="Add Expected Salary" type="number"/>
                </div>
            </div>
            <div class="body-create-job-content-description-container">
                <div id="body-create-job-content-form-editor">
                </div>
            </div>
            <button class="body-create-job-content-form-button" type="submit">Submit</button>
        </form>
    </div>
</section>

<script src="https://cdn.jsdelivr.net/npm/quill@2.0.3/dist/quill.js"></script>
<script src="/pub/js/createjobs.js"></script>
<jsp:include page="../include/footer.jsp"/>