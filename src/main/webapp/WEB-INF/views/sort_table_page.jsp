<%@ page import="com.company.service.UserService" %>
<%@ page import="com.company.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.Comparator" %><%--
  Created by IntelliJ IDEA.
  User: dima2
  Date: 12.11.2019
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="../../css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="../../css/bootstrap-grid.css" type="text/css">
    <link rel="stylesheet" href="../../css/bootstrap-reboot.css" type="text/css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"
          type="text/css">
    <title>Таблица пользователей</title>
</head>
<body>
<form method="post" id="sort_by_value">
    <div class="form-check">
        <input class="form-check-input" type="radio" name="sort" id="sort_email" value="sort_email_value">
        <label class="form-check-label" for="sort_email">
            Sort Email
        </label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="radio" name="sort" id="sort_password" value="sort_password_value">
        <label class="form-check-label" for="sort_password">
            Sort Password
        </label>
    </div>
    <input type="submit" class="btn btn-primary" value="Ok">
    <table class="table">
        <thead>
        <tr>
            <th>Email</th>
            <th>Password</th>
            <th>Name</th>
            <th>Points</th>
            <th>Role</th>
        </tr>
        </thead>
        <tbody>
        <%
            UserService userService = new UserService();
            List<User> userList = userService.getAll();
            Integer atr = (Integer)request.getAttribute("myval");
            if(atr != null) {
                if (atr.compareTo(1) == 0) {
                    userList.sort((o1, o2) -> {
                        int res = String.CASE_INSENSITIVE_ORDER.compare(o1.getEmail(), o2.getEmail());
                        if (res == 0) {
                            res = o1.getEmail().compareTo(o2.getEmail());
                        }
                        return res;
                    });
                }
                if (atr.compareTo(0) == 0) {
                    userList.sort((o1, o2) -> {
                        int res = String.CASE_INSENSITIVE_ORDER.compare(o1.getPassword(), o2.getPassword());
                        if (res == 0) {
                            res = o1.getPassword().compareTo(o2.getPassword());
                        }
                        return res;
                    });
                }
            }

            for (User user : userList) {
        %>
        <tr>
            <th scope="row"><%=user.getEmail()%>
            </th>
            <td><%=user.getPassword()%>
            </td>
            <td><%=user.getName()%>
            </td>
            <td><%=user.getPoints()%>
            </td>
            <td><%=user.getRole()%>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</form>
</body>
</html>
