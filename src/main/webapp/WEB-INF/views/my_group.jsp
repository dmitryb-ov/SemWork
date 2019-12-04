<%@ page import="com.company.model.MyUser" %>
<%@ page import="com.company.service.MyUserService" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/header_inc.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>Моя группа</title>
<%@include file="includes/close_header_inc.jsp" %>
<body>
<%@include file="includes/page_header_inc.jsp" %>
<form method="post" id="sort_by_value">
    <div class="form-check">
        <input class="form-check-input" type="radio" name="sortSelect" id="sort_email" value="sort_name_value">
        <label class="form-check-label" for="sort_email">
            Сортировка имени
        </label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="radio" name="sortSelect" id="sort_password" value="sort_secondName_value">
        <label class="form-check-label" for="sort_password">
            Сортировка по фамилии
        </label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="radio" name="sortSelect" id="sort_point" value="sort_points_value">
        <label class="form-check-label" for="sort_point">
            Сортировка по баллам
        </label>
    </div>
    <input type="submit" class="btn btn-primary" value="Ok">
    <table class="table">
        <thead>
        <tr>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Группа</th>
            <th>Баллы</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${myGroups}" var="myG">
            <tr>
                <td>${myG.name}
                </td>
                <td>${myG.secondName}
                </td>
                <td>${myG.groupId}
                </td>
                <td>${myG.points}
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</form>
</body>
<%@include file="includes/footer_inc.jsp" %>
