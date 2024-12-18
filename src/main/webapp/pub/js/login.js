
const passwordInput = document.getElementById('password-input');
const togglePassword = document.getElementById('togglePassword');

togglePassword.addEventListener('click', () => {
    const type = passwordInput.type === 'password' ? 'text' : 'password';
    passwordInput.type = type;
    togglePassword.textContent = type === 'password' ? 'show' : 'hide';
});

const loginForm = document.getElementById("login-form");
const email = document.getElementById("email-input");
const password = document.getElementById("password-input");
const emailLoginAlert = document.getElementById("email-login-alert");
const passwordLoginAlert = document.getElementById("password-login-alert");

loginForm.addEventListener('submit', function(event) {
    event.preventDefault();

    const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
    if (emailRegex.test(email.value.trim())) {
        emailLoginAlert.innerHTML = "";
        emailLoginAlert.style.display = "none";
    } else {
        emailLoginAlert.style.display = "block";
        if (email.value.trim() === "") emailLoginAlert.innerHTML = "Alert: Email Address is required.";
        else emailLoginAlert.innerHTML = "Alert: Invalid Email.";

        setTimeout(()=> {
            emailLoginAlert.style.display = "none";
        }, 1200);
        return;
    }

    const passwordRegex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,}$/;
    if (passwordRegex.test(password.value)) {
        passwordLoginAlert.innerHTML = "";
        passwordLoginAlert.style.display = "none";
    } else {
        passwordLoginAlert.style.display = "block";
        if (password.value.trim() === "") passwordLoginAlert.innerHTML = "Alert: Password is required.";
        else passwordLoginAlert.innerHTML =  "Alert: Invalid Password."

        setTimeout(()=> {
            passwordLoginAlert.style.display = "none";
        }, 1200);
    }
});
const companyLogo = document.getElementById('company-logo');
companyLogo.addEventListener('click', () => {
    window.location.href = companyLogo.getAttribute('data-href');
});
