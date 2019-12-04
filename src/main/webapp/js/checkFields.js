let p = false;
let checkFields = function () {
    if ((document.getElementById('inputPassword').value !== "") && (document.getElementById('confirmPassword').value !== "")) {
        if (document.getElementById('inputPassword').value === document.getElementById('confirmPassword').value) {
            document.getElementById('check').style.color = 'green';
            document.getElementById('check').innerHTML = 'Пароли совпадают';
            document.getElementById('registrButton').removeAttribute("disabled")
        } else {
            document.getElementById('check').style.color = 'red';
            document.getElementById('check').innerHTML = 'Пароли не совпадают';
            document.getElementById('registrButton').setAttribute('disabled', '')
        }
    }
    if (!p) {
        if (!/.+@.+\..+/.test(document.getElementById('inputEmail').value)) {
            document.getElementById('checkMail').style.color = 'red';
            document.getElementById('checkMail').innerHTML = 'Некорректная почта';
            document.getElementById('registrButton').setAttribute("disabled", '')
        } else {
            document.getElementById('checkMail').style.color = 'green';
            document.getElementById('checkMail').innerHTML = 'Корректная почта';
            document.getElementById('registrButton').removeAttribute("disabled");
            p = true
        }
    }
    $(document).ready(function () {
        $().onkeyup(checkFields)
    });
};