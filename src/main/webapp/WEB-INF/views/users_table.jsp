<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="includes/header_inc.jsp" %>
<title>Title</title>
<%@include file="includes/close_header_inc.jsp" %>
<body>
<%@include file="includes/page_header_inc.jsp" %>
<form method="post" class="form-inline" action="<%=request.getServletContext().getContextPath()+"/users"%>">
    <div class="form-group mx-sm-3 mb-2">
        <label for="inputNumber" class="sr-only">Password</label>
        <input type="number" class="form-control" id="inputNumber" name="inputNumber" placeholder="Введите id для удаления">
    </div>
    <button type="submit" class="btn btn-danger mb-2">Удалить</button>
</form>
<div>${error}</div>
<table class="table">
    <thead>
    <tr>
        <th>#</th>
        <th>Почта</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Группа</th>
        <th>Баллы</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <%
        MyUserService userService = new MyUserService();
        List<MyUser> users = userService.getAll();
        for (MyUser user : users) {
    %>
    <tr>
        <th scope="row"><%=user.getId()%>
        </th>
        <td><input type="text" readonly class="form-control-plaintext" id="email" name="email"
                   value="<%=user.getEmail()%>">
        </td>
        <td><%=user.getName()%>
        </td>
        <td><%=user.getSecondName()%>
        </td>
        <td><%=user.getGroupId()%>
        </td>
        <td><%=user.getPoints()%>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
<%@include file="includes/footer_inc.jsp" %>
