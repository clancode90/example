<%-- 
    Document   : login
    Created on : 16.03.2015, 19:17:08
    Author     : Юрий
--%>
<%@ page session="true" import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <link rel="stylesheet" type="text/css" href=<c:url value='css/style.css'/> >
        <title>Вход в систему</title>
    </head>
    <body>
     
       
      
        <form method="post" action="j_spring_security_check" class="login">
            <p>
                <label for="login">Логин:</label>
                <input placeholder="Введите логин" name="j_username" id="login"  type="text">
            </p>

            <p>
                <label for="password">Пароль:</label>
                <input placeholder="Введите пароль" name="j_password" id="password"  type="password">
            </p>

            <p class="login-submit">
                <button type="submit" class="login-button">Войти</button>
            </p>

            <p class="forgot-password"><a href="<c:url value="/User/recoveryPassword" />">Забыл пароль?</a>   
            <a href="<c:url value="/Registration/registration" />">Регистрация!!</a></p>
        </form>


    </body>
</html>
