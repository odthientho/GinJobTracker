document.querySelectorAll('.body-content-item-button-edit').forEach(button => {
    button.addEventListener("click", (event) => {
        event.stopPropagation();
        window.location.href = "/jobs/edit/" + button.getAttribute("data-id");
    })
})

document.querySelectorAll('.body-content-item-button-delete').forEach(button => {
    button.addEventListener("click", (event) => {
        event.stopPropagation();
        if (confirm("Are you sure you want to delete this data?")) {
            fetch('/jobs/delete/' + button.getAttribute("data-id"), {
                method: 'POST',
            })
                .then(response => {
                    if (response.ok) {
                        return response.text(); // Get response text
                    } else {
                        throw new Error('Failed to delete record.');
                    }
                })
                .then(data => {
                    location.reload();
                })
                .catch(error => {
                    alert('Failed to delete record.');
                });
        }
    })
})

document.querySelectorAll('.body-content-item-button-switch').forEach(button => {
    button.addEventListener("click", (event) => {
        const nextOptions = event.target.nextElementSibling;
        if (nextOptions) {
            if (nextOptions.style.display === "flex") nextOptions.style.display = "none";
            else nextOptions.style.display = "flex";
        }
    })
})

document.querySelectorAll('.body-content-item-main').forEach(eachItem => {
    eachItem.addEventListener("click", () => {
        window.location.href = "/jobs/view/" + eachItem.getAttribute("data-id");
    })
})

document.querySelectorAll('.body-content-filter-button').forEach(button => {
    button.addEventListener("click", () => {
        if (button.getAttribute("data-url") === "ALL") window.location.href = "/jobs/myjobs";
        else if (button.getAttribute("data-url") === "NEW") {
            window.location.href = "/jobs/create";
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
