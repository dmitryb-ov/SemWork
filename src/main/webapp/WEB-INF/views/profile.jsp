<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="includes/header_inc.jsp" %>
<link rel="stylesheet" type="text\css" href="<c:url value="/profile.css"/>">
<style>
    .user-image img {
        width: 250px;
        height: 250px;
    }

    .button-section {
        margin-left: 60px;
    }

    .margin-ava {
        margin-top: 10px;
        margin-bottom: 10px;
    }

    .margin-info {
        margin-top: 100px;
    }

    span.tags {
        background: #1abc9c;
        border-radius: 2px;
        color: #f5f5f5;
        font-weight: bold;
        padding: 2px 4px;
    }
</style>
<title>Профиль</title>
<%@include file="includes/close_header_inc.jsp" %>
<body>
<%@include file="includes/page_header_inc.jsp" %>
<div class="row">
    <div class="col-sm-2">
        <img src="https://i.pinimg.com/originals/c0/b7/7f/c0b77faeb2cb3e67fd1b423c4535f6c3.jpg"
             class="rounded-circle button-section margin-ava" width="200" height="200   " alt="image-profile">
        <form action="<%=request.getServletContext().getContextPath()+"/upload"%>" method="post"
              enctype="multipart/form-data">
            <button class="btn btn-info btn-block button-section" type="submit">Загрузить фото</button>
        </form>

        <form action="<%=request.getServletContext().getContextPath()+"/editprofile"%>" method="get">
            <button class="btn btn-success btn-block button-section" data-toggle="modal" type="submit">Редактировать</button>
        </form>
    </div>
    <div class="col-sm-10">
        <h2 class="button-section">${userNameAll}</h2>
        <h5 class="button-section tags">${userType}</h5>
        <div class="tab-content">
            <div role="tabpanel" class="tab-pane fade show active button-section margin-info" id="profileInfo">
                <div class="row">
                    <div class="col-md-2">
                        <label>Имя</label>
                    </div>
                    <div class="col-md-6">
                        <p>${userName}</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-2">
                        <label>Фамилия</label>
                    </div>
                    <div class="col-md-6">
                        <p>${userSecondName}</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-2">
                        <label>Группа</label>
                    </div>
                    <div class="col-md-6">
                        <p>${userGroup}</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-2">
                        <label>Баллы</label>
                    </div>
                    <div class="col-md-6">
                        <p>${userPoints}</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<%@include file="includes/footer_inc.jsp" %>
