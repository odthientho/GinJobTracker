const email = document.getElementById("form-signup-email");
const password = document.getElementById("form-signup-password");
const togglePasswordBtn = document.getElementById('form-signup-password-toggle-btn');
const formSignup = document.getElementById("form-signup");
const formSignupAlert = document.getElementById("form-signup-alert");

togglePasswordBtn.addEventListener('click', () => {
    let type = password.type === 'password';
    password.type = type ? 'text' : 'password';
    togglePasswordBtn.textContent = type ? 'hide' : 'show';
});

formSignup.addEventListener('submit', function(event) {
    event.preventDefault();
    const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
    const passwordRegex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,}$/;
    if (emailRegex.test(email.value.trim())) {
        if (passwordRegex.test(password.value)) {
            formSignupAlert.innerHTML = "";
            formSignupAlert.style.display = "none";
            event.target.submit();
        } else {
            formSignupAlert.style.display = "block";
            if (password.value.trim() === "") formSignupAlert.innerHTML = "Password is required.";
            else formSignupAlert.innerHTML =  "Password must be strong."
        }
    } else {
        formSignupAlert.style.display = "block";
        if (email.value.trim() === "") formSignupAlert.innerHTML = "Email Address is required.";
        else formSignupAlert.innerHTML = "Email does not match its format.";
    }
});