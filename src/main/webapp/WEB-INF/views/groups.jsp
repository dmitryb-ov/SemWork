<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="includes/header_inc.jsp" %>
    <title>Title</title>
<%@include file="includes/close_header_inc.jsp" %>
<body>
<%@include file="includes/page_header_inc.jsp" %>
<form method="post" class="form-inline" action="<%=request.getServletContext().getContextPath()+"/groups"%>">
    <div class="form-group mx-sm-3 mb-2">
        <label for="inputGroup" class="sr-only">Password</label>
        <input type="text" class="form-control" id="inputGroup" name="inputGroup" placeholder="Введите номер группы">
    </div>
    <button type="submit" class="btn btn-success mb-2">Добавить</button>
</form>
<table class="table">
    <thead>
    <tr>
        <th>Id</th>
        <th>Группа</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${groups}" var="group">
        <tr>
            <td>${group.id}
            </td>
            <td>${group.groupNumber}
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
<%@include file="includes/footer_inc.jsp" %>
