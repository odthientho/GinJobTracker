const buttons = document.querySelectorAll('.global-nav-item');
const quoteMeNav = document.getElementById('quote-me-nav');

document.addEventListener('click', (event) => {
    if (!event.target.closest('.me-nav')) {
        quoteMeNav.style.display = 'none';
    }
});

buttons.forEach(button => {
    button.addEventListener('click', () => {
        if (button.classList.contains('me-nav')) {
            const isDisplayed = quoteMeNav.style.display === 'block';
            quoteMeNav.style.display = isDisplayed ? 'none' : 'block';
        } else {
            buttons.forEach(btn => btn.classList.remove('global-nav-item-active'));
            button.classList.add('global-nav-item-active');

            const href = button.getAttribute('data-href');
            if (href) {
                window.location.href = href; // Redirect to the URL
            }
        }
    });
});

const uploadButton = document.getElementById('uploadProfilePictureButton');
const fileInput = document.getElementById('uploadProfilePictureInput');

uploadButton.addEventListener('click', () => {
    fileInput.click();
})

fileInput.addEventListener('change', () => {
    const file = fileInput.files[0];
    if (file) {
        const formData = new FormData();
        formData.append('file', file);
        fetch('/login/updateProfilePicture', {
            method: 'POST',
            body: formData,
        })
            .then(response => {
                if (response.ok) {
                    return response.text(); // Get response text
                } else {
                    throw new Error('Failed to upload file');
                }
            })
            .then(data => {
                alert('File uploaded successfully!');
                location.reload();
            })
            .catch(error => {
                alert('Failed to upload file.');
            });
    } else {
        alert('No file selected.');
    }
});