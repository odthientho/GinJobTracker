const formLogin = document.getElementById("form-login");
const email = document.getElementById("form-login-username");
const password = document.getElementById("form-login-password");
const togglePassword = document.getElementById('form-login-password-toggle-btn');
const formLoginAlert = document.getElementById("form-login-alert");

togglePassword.addEventListener('click', () => {
    let type = password.type === 'password';
    password.type = type ? 'text' : 'password';
    togglePassword.textContent = type ? 'hide' : 'show';
});

formLogin.addEventListener('submit', function(event) {
    event.preventDefault();
    const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
    if (emailRegex.test(email.value.trim()) && password.value.trim() !== "") event.target.submit();
    else {
        formLoginAlert.style.display = "block";
        if (password.value.trim() === "") formLoginAlert.innerHTML = "Password is required.";
        if (email.value.trim() === "") formLoginAlert.innerHTML = "Email Address is required.";
    }
});