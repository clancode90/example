<%-- 
    Document   : recoverPassword
    Created on : 09.04.2015, 14:56:09
    Author     : Юрий
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="/WEB-INF/jsp/css_js.jsp" %>
        <title>Восстановление пароля</title>
    </head>
    <body class="container">
     
        <%@include file="/WEB-INF/jsp/error.jsp" %> <%@include file="/WEB-INF/jsp/message.jsp" %> 
        
        <form action="<c:url value="/User/recoverPassword" />" style="margin-top: 58px;" method="post">

            
            <div class="form-group">
                <label class="control-label col-xs-3" for="inputPassword">Новый пароль:</label>
                <div class="col-xs-9">
                    <input type="password" class="form-control" name="newPassword" id="newPassword" placeholder="Введите новый пароль">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-3" for="confirmPassword">Подтвердите новый пароль:</label>
                <div class="col-xs-9">
                    <input type="password" class="form-control" name="confirmPassword"  id="confirmPassword" placeholder="Введите новый пароль ещё раз">
                </div>
            </div>

            <div class="form-group">
                <div class="col-xs-offset-3 col-xs-9">
                    <input type="hidden" name="hash" value=${hash}>
                    <input type="submit" name="submit"  class="btn btn-primary" value="Изменить">
                  
                     
                </div>
            </div>
        </form>
        
    </body>
</html>
