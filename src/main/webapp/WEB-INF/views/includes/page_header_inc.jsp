<%@ page import="com.company.service.MyUserService" %>
<%@ page import="com.company.model.MyUser" %>
<%@ page import="com.company.role.MyRoleEnum" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="col-sm-12">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="<%=request.getServletContext().getContextPath()+"/"%>">Главная страница</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <%
                    if (session.getAttribute("userState") == "auth") {
                %>
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getServletContext().getContextPath()+"/profile"%>">Профиль
                        <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getServletContext().getContextPath()+"/homework"%>">Домашнее задание</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getServletContext().getContextPath()+"/mygroup"%>">Моя группа</a>
                </li>
                <%
                    String email = (String) session.getAttribute("userLogin");
                    MyUserService userService = new MyUserService();
                    MyUser user = userService.get(email);
                    if(user.getRole().equals(MyRoleEnum.ADMIN)){
                %>
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getServletContext().getContextPath()+"/users"%>">Пользователи</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getServletContext().getContextPath()+"/groups"%>">Группы</a>
                </li>
                <%
                        }
                    }
                %>
            </ul>
            <%
                if (session.getAttribute("userState") != "auth") {
            %>
            <form action="<%=request.getServletContext().getContextPath()+"/login"%>" method="get">
                <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Вход</button>
            </form>
            <form action="<%=request.getServletContext().getContextPath()+"/registration"%>" method="get">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Регистрация</button>
            </form>
            <%
            } else {
            %>
            <form action="<%=request.getServletContext().getContextPath()+"/logout"%>" method="post">
                <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Выход</button>
            </form>
            <%
                }
            %>
        </div>
    </nav>
</div>