const quoteSection = document.getElementById('quote-section');
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

            // const href = button.getAttribute('data-href');
            // if (href) {
            //     window.location.href = href; // Redirect to the URL
            // }
        }
    });
});