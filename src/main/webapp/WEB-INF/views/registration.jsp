<%@ page import="com.company.model.Group" %>
<%@ page import="com.company.service.GroupService" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="includes/header_inc.jsp"%>
    <script>
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
    </script>
    <title>Registration</title>
<%@include file="includes/close_header_inc.jsp"%>
<body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

<div class="row">
    <div class="col-sm-12">
        <nav class="navbar navbar-light bg-light">
            <a class="navbar-brand" href="registration">Регистрация</a>
            <form action="<%=request.getServletContext().getContextPath()+"/login"%>" method="get">
                <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Вход</button>
            </form>
        </nav>
    </div>
    <div class="col-sm-12">
        <div class="text-center">
            <h1>Заполните ниже требуемые поля</h1>
            <form action="<%=request.getServletContext().getContextPath()+"/registration"%>" method="post" id="registrateUser">
                <div class="form-row" style="display: grid; grid-template-columns: 1fr 1fr 1fr">
                    <div></div>
                    <div class="col-sm-12">
                        <div class="form-group">
                            <label for="inputEmail">Email адрес</label>
                            <input type="email" class="form-control" name="inputEmail" id="inputEmail"
                                   aria-describedby="emailHelp" value="<%=request.getAttribute("inputEmail")%>"
                                   placeholder="Введите вашу почту" onkeyup="checkFields()">
                            <div>
                                <span id="checkMail" aria-required="true" style="color: red">${checkEmail}</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword">Пароль</label>
                            <input type="password" class="form-control" name="inputPassword" id="inputPassword"
                                   placeholder="Введите пароль">
                        </div>
                        <div class="form-group">
                            <label for="confirmPassword">Повторите пароль</label>
                            <input type="password" class="form-control" name="confirmPassword" id="confirmPassword"
                                   placeholder="Повторите пароль" onkeyup="checkFields()">
                            <div>
                                <span id="check" aria-required="true" style="color: red;">${checkPassword}</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputName">Имя</label>
                            <input type="text" class="form-control" name="inputName" id="inputName" placeholder="Введите имя">
                        </div>
                        <div class="form-group">
                            <label for="inputSecondName">Фамилия</label>
                            <input type="text" class="form-control" name="inputSecondName" id="inputSecondName" placeholder="Введите фамилию">
                        </div>
                        <div class="col-auto my-1">
                            <label class="mr-sm-2" for="groupSelect">Группа</label>
                            <select class="custom-select mr-sm-2" id="groupSelect" name="groupSelect">
                                <%
                                    GroupService groupService = new GroupService();
                                    List<Group> groupList = groupService.getAll();
                                    for (Group group : groupList) {
                                %>
                                <option value="<%=group.getGroupNumber()%>"><%=group.getGroupNumber()%>
                                </option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                        <input type="submit" class="btn btn-primary" id="registrButton" value="Зарегестрироваться">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<%@include file="includes/footer_inc.jsp"%>