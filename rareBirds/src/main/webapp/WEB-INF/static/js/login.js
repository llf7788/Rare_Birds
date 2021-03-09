window.addEventListener("load", function () {
    let value = document.getElementById("hidden");
    if (value.innerText.length > 0) {
        value.style.display = "initial";
    }

    document.getElementById("button_login").addEventListener("click", login);
});

function login() {
    if (checkFormLogin()) {
        document.getElementById("form_login").submit();
        document.getElementById("hidden").innerText = "";
    }
}

function checkFormLogin() {
    let elements = ["username", "password"];
    for (i = 0; i < elements.length; i++) {
        let element = document.getElementById("input_" + elements[i]);
        if (element.value.length === 0) {
            alert("Please input " + elements[i]);
            return false;
        }
    }
    return true;
}


