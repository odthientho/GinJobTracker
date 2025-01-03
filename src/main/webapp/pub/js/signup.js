const email = document.getElementById("form-signup-username");
const password = document.getElementById("form-signup-password");
const togglePassword = document.getElementById('form-signup-password-toggle-btn');
const signupForm = document.getElementById("form-signup");
const emailSignupAlert = document.getElementById("form-signup-username-alert");
const passwordSignupAlert = document.getElementById("form-signup-password-alert");

togglePassword.addEventListener('click', () => {
    let type = password.type === 'password';
    password.type = type ? 'text' : 'password';
    togglePassword.textContent = type ? 'hide' : 'show';
});

signupForm.addEventListener('submit', function(event) {
    event.preventDefault();

    const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
    if (emailRegex.test(email.value.trim())) {
        emailSignupAlert.innerHTML = "";
        emailSignupAlert.style.display = "none";
    } else {
        emailSignupAlert.style.display = "block";
        if (email.value.trim() === "") emailSignupAlert.innerHTML = "Email Address is required.";
        else emailSignupAlert.innerHTML = "Invalid Email.";
    }

    const passwordRegex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,}$/;
    if (passwordRegex.test(password.value)) {
        passwordSignupAlert.innerHTML = "";
        passwordSignupAlert.style.display = "none";
        event.target.submit();
    } else {
        passwordSignupAlert.style.display = "block";
        if (password.value.trim() === "") passwordSignupAlert.innerHTML = "Password is required.";
        else passwordSignupAlert.innerHTML =  "Invalid Password."
    }
});