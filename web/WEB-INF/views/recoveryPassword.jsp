<%-- 
    Document   : recoveryPassword
    Created on : 07.04.2015, 11:21:55
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

        <div style="margin-top: 59px; margin-left:310px;"> <h2>Форма восстановления пароля </h2> </div>

        <form action="<c:url value="/User/recoveryPassword" />"  method="post">

            
           
            <div class="form-group">
                <label class="control-label col-xs-3"  for="inputEmail">Email:</label>
                <div class="col-xs-9">
                    <input type="email" class="form-control" name="email" id="inputEmail" placeholder="Email">
                </div>
            </div>
            <div class="form-group">
                <div class="col-xs-offset-3 col-xs-9">
                    <input type="submit" name="submit"  class="btn btn-primary" value="Отправить">
                  
                </div>
            </div>

        </form>

    </body>

</html>