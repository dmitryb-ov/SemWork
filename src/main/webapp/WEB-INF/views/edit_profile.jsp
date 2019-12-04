<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/header_inc.jsp" %>
<style>
    .user-image img {
        width: 250px;
        height: 250px;
    }

    .button-section {
        margin-left: 60px;
    }

    .button-left-margin {
        margin-left: 100%;
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
<title>Title</title>
<%@include file="includes/close_header_inc.jsp" %>
<body>
<%@include file="includes/page_header_inc.jsp" %>
<div class="row">
    <div class="col-sm-2">
        <img src="https://i.pinimg.com/originals/c0/b7/7f/c0b77faeb2cb3e67fd1b423c4535f6c3.jpg"
             class="rounded-circle button-section margin-ava" width="200" height="200   " alt="image-profile">
    </div>
    <div class="col-sm-10">
        <h2 class="button-section">${userNameAll}</h2>
        <h5 class="button-section tags">${userType}</h5>
        <div class="tab-content">
            <div role="tabpanel" class="tab-pane fade show active button-section margin-info" id="profileInfo">
                <form action="<%=request.getServletContext().getContextPath()+"/editprofile"%>" method="post">
                    <div class="row">
                        <div class="col-md-2">
                            <label>Имя</label>
                        </div>
                        <div class="col-md-6">
                            <input type="text" class="form-control margin-ava" id="userNewName" name="userNewName"
                                   value="${userOldName}"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-2">
                            <label>Фамилия</label>
                        </div>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="userNewSecondName" name="userNewSecondName"
                                   value="${userOldSecondName}"/>
                        </div>
                    </div>
                    <div class="btn-group" role="group" aria-label="Basic example">
                        <button type="submit" class="btn btn-success">Сохранить</button>
                        <form action="<%=request.getServletContext().getContextPath()+"/profile"%>" method="get">
                            <button type="submit" class="btn btn-secondary">Отмена</button>
                        </form>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
<%@include file="includes/footer_inc.jsp" %>
