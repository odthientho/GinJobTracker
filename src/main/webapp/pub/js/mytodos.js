document.querySelectorAll('.body-content-filter-button').forEach(button => {
    button.addEventListener("click", () => {
        if (button.getAttribute("data-url") === "ALL") window.location.href = "/todos/mytodos";
        else if (button.getAttribute("data-url") === "NEW") {
        } else window.location.href = "/todos/mytodos?query=" + button.getAttribute("data-url");
    })
})