<%-- 
    Document   : successRegistration
    Created on : 10.03.2015, 10:43:41
    Author     : Юрий
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="/WEB-INF/jsp/css_js.jsp" %>
        <title>Страница подтверждения успешной регистрации посетителя</title>

    </head>

    <body class="container">


    <center style="margin-top: 114px;">
        <form>
            <h2 >Регистрация посетителя успешно завершена</h2> <br>

            <a href="<c:url value="/login"/>" class="btn btn-primary" role="button">Войти</a>
        </form>
    </center>


</html>
