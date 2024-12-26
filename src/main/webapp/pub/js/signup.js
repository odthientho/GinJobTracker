const password = document.getElementById("form-signup-password");
const togglePassword = document.getElementById('form-signup-password-toggle-btn');
const toggleConfirmedPassword = document.getElementById('form-signup-confirmed-password-toggle-btn');
const confirmedPassword = document.getElementById("form-signup-confirmed-password");

togglePassword.addEventListener('click', () => {
    let type = password.type === 'password';
    password.type = type ? 'text' : 'password';
    togglePassword.textContent = type ? 'hide' : 'show';
});

toggleConfirmedPassword.addEventListener('click', () => {
    let type = confirmedPassword.type === 'password';
    confirmedPassword.type = type ? 'text' : 'password';
    toggleConfirmedPassword.textContent = type ? 'hide' : 'show';
});