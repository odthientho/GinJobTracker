const loginForm = document.getElementById("form-login");
const email = document.getElementById("form-login-username");
const password = document.getElementById("form-login-password");
const togglePassword = document.getElementById('form-login-password-toggle-btn');
const emailLoginAlert = document.getElementById("form-login-username-alert");
const passwordLoginAlert = document.getElementById("form-login-password-alert");

togglePassword.addEventListener('click', () => {
    let type = password.type === 'password';
    password.type = type ? 'text' : 'password';
    togglePassword.textContent = type ? 'hide' : 'show';
});

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