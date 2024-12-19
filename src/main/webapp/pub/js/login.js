
const passwordInput = document.getElementById('password-input');
const togglePassword = document.getElementById('togglePassword');

togglePassword.addEventListener('click', () => {
    let type = passwordInput.type === 'password';
    passwordInput.type = type ? 'text' : 'password';
    togglePassword.textContent = type ? 'hide' : 'show';
});

const loginForm = document.getElementById("login-form");
const email = document.getElementById("email-input");
const password = document.getElementById("password-input");
const emailLoginAlert = document.getElementById("email-login-alert");
const passwordLoginAlert = document.getElementById("password-login-alert");

loginForm.addEventListener('submit', function(event) {

    const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
    if (emailRegex.test(email.value.trim())) {
        emailLoginAlert.innerHTML = "";
        emailLoginAlert.style.display = "none";
    } else {
        event.preventDefault();
        emailLoginAlert.style.display = "block";
        if (email.value.trim() === "") emailLoginAlert.innerHTML = "Email Address is required.";
        else emailLoginAlert.innerHTML = "Invalid Email.";
    }

    const passwordRegex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,}$/;
    if (passwordRegex.test(password.value)) {
        passwordLoginAlert.innerHTML = "";
        passwordLoginAlert.style.display = "none";
    } else {
        event.preventDefault();
        passwordLoginAlert.style.display = "block";
        if (password.value.trim() === "") passwordLoginAlert.innerHTML = "Password is required.";
        else passwordLoginAlert.innerHTML =  "Invalid Password."
    }
});

const companyLogo = document.getElementById('company-logo');
companyLogo.addEventListener('click', () => {
    window.location.href = companyLogo.getAttribute('data-href');
});
