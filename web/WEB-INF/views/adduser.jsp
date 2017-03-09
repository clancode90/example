<%-- 
    Document   : AddUser
    Created on : 23.03.2015, 11:54:39
    Author     : Юрий
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Добавление пользователя</title>
        <%@include file="/WEB-INF/jsp/css_js.jsp" %>
    </head>
    <body class="container" >
        <%@include file="/WEB-INF/jsp/menu.jsp" %>

       
        <%@include file="/WEB-INF/jsp/error.jsp" %> <%@include file="/WEB-INF/jsp/message.jsp" %> 


        <form action="<c:url value="/User/adduser" />"  method="post">

            <div class="form-group">
                <a href="<c:url value="/User/listUser"/>" class="btn btn-large" role="button">Список пользователей</a>
                <a href="<c:url value="/User/adduser"/>" class="btn btn-large" role="button">Добавить пользователя</a>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-3" for="lastName">Фамилия:</label>
                <div class="col-xs-9">
                    <input type="text" class="form-control" name="surname" id="lastName" placeholder="Введите фамилию">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-3" for="firstName">Имя:</label>
                <div class="col-xs-9">
                    <input type="text" class="form-control" name="name" id="firstName" placeholder="Введите имя">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-3" for="firstName">Отчество:</label>
                <div class="col-xs-9">
                    <input type="text" class="form-control" name="patronymic" id="firstName" placeholder="Введите отчество">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-3"  for="inputEmail">Email:</label>
                <div class="col-xs-9">
                    <input type="email" class="form-control" name="email" id="inputEmail" placeholder="Email">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-3" for="selectRole">Выбрать роль:</label>
                <div class="col-xs-9">
                    <select name="role">
                        <option value="user">user</option>
                        <option value="admin">admin</option>
                    </select>
                </div>
            </div>     
            <div class="form-group">
                <centr> <label class="control-label col-xs-9" >Стандартный пароль:&nbsp 0000</label> </centr>

            </div>          
            <div class="form-group">
                <div class="col-xs-offset-3 col-xs-9">
                    <input type="submit" name="submit"  class="btn btn-primary" value="Добавить">

                </div>
            </div>

        </form>

    </body>
</html>
