document.querySelectorAll('.body-content-item-button-edit').forEach(button => {
    button.addEventListener("click", (event) => {
        event.stopPropagation();
        window.location.href = "/jobs/edit/" + button.getAttribute("data-id");
    })
})

document.querySelectorAll('.body-content-item-button-delete').forEach(button => {
    button.addEventListener("click", (event) => {
        event.stopPropagation();
        window.location.href = "/jobs/delete/" + button.getAttribute("data-id");
    })
})

document.querySelectorAll('.body-content-item-button-switch').forEach(button => {
    button.addEventListener("click", (event) => {
        event.stopPropagation();
        window.location.href = "/jobs/switch/" + button.getAttribute("data-id");
    })
})

document.querySelectorAll('.body-content-item').forEach(eachItem => {
    eachItem.addEventListener("click", () => {
        window.location.href = "/jobs/view/" + eachItem.getAttribute("data-id");
    })
})

document.querySelectorAll('.body-content-filter-button').forEach(button => {
    button.addEventListener("click", () => {
        if (button.getAttribute("data-url") === "ALL") window.location.href = "/jobs/myjobs";
        else if (button.getAttribute("data-url") === "NEW") {
        } else window.location.href = "/jobs/myjobs?query=" + button.getAttribute("data-url");
    })
})

const attachedResume = document.getElementById('body-view-job-info-attached-resume');
attachedResume.addEventListener('click', async () => {
    const fileUrl =  attachedResume.getAttribute("data-resume");
    const fileName = 'resume.pdf';
    const link = document.createElement('a');
    link.href = fileUrl;
    link.download = fileName;
    document.body.appendChild(link);
    link.click();
    document.body.removeChild(link);
});


const attachedCoverLetter = document.getElementById('body-view-job-info-attached-cover-letter');
attachedCoverLetter.addEventListener('click', async () => {
    const fileUrl =  attachedCoverLetter.getAttribute("data-coverLetter");
    const fileName = 'coverLetter.pdf';
    const link = document.createElement('a');
    link.href = fileUrl;
    link.download = fileName;
    document.body.appendChild(link);
    link.click();
    document.body.removeChild(link);
});