<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%@include file="includes/header_inc.jsp"%>
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
            <a class="navbar-brand" href="<%=request.getServletContext().getContextPath()+"/login"%>">Вход</a>
            <form action="<%=request.getServletContext().getContextPath()+"/registration"%>" method="get">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Регистрация</button>
            </form>
        </nav>
    </div>
    <div class="col-sm-12">
        <div class="text-center">
            <h1>Вход</h1>
            <div>
                <span id="infoAboutLogin" aria-required="true" style="color: red;">${info}</span>
            </div>
            <form method="post" id="logInUser">
                <div class="form-row" style="display: grid; grid-template-columns: 1fr 1fr 1fr">
                    <div></div>
                    <div class="col-sm-12">
                        <div class="form-group">
                            <label for="inputEmailForEnter">Email адрес</label>
                            <input type="email" class="form-control" name="inputEmailForEnter" value="<%=request.getAttribute("loginEmail")%>" id="inputEmailForEnter"
                                   aria-describedby="emailHelp"
                                   placeholder="Введите вашу почту">
                        </div>
                        <div class="form-group">
                            <label for="inputPasswordForEnter">Пароль</label>
                            <input type="password" class="form-control" name="inputPasswordForEnter" id="inputPasswordForEnter"
                                   placeholder="Введите пароль">
                        </div>
                        <div class="form-check">
                            <input type="checkbox" class="form-check-input" id="saveData" name="saveData">
                            <label class="form-check-label" for="saveData">Запомнить меня</label>
                        </div>
                        <input type="submit" class="btn btn-primary" id="registrButton" value="Войти">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<%@include file="includes/footer_inc.jsp"%>>